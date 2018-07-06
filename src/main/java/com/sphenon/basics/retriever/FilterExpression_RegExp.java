package com.sphenon.basics.retriever;

/****************************************************************************
  Copyright 2001-2018 Sphenon GmbH

  Licensed under the Apache License, Version 2.0 (the "License"); you may not
  use this file except in compliance with the License. You may obtain a copy
  of the License at http://www.apache.org/licenses/LICENSE-2.0

  Unless required by applicable law or agreed to in writing, software
  distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
  WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
  License for the specific language governing permissions and limitations
  under the License.
*****************************************************************************/

import com.sphenon.basics.context.*;
import com.sphenon.basics.expression.returncodes.*;
import com.sphenon.basics.search.*;

import java.util.regex.*;

public class FilterExpression_RegExp extends FilterExpression {

    public FilterExpression_RegExp(CallContext context, String expression) throws InvalidExpressionSyntax {
        super(context, expression);
    }

    public FilterExpression_RegExp(CallContext context) {
        super(context);
    }

    public void setExpression (CallContext context, String expression) throws InvalidExpressionSyntax {
        super.setExpression(context, expression);
        try {
            this.pattern = (this.expression == null ? null : Pattern.compile(this.expression));
        } catch (PatternSyntaxException pse) {
            this.pattern = null;
            InvalidExpressionSyntax.createAndThrow(context, pse, "Invalid regular expression");
        }
    }

    protected Pattern pattern;

    public boolean matches (CallContext context, Object object) {
        String text = SearchText.getFullText(context, object);
        return (    this.expression == null
                 || this.expression.length() == 0
                 || this.pattern == null
                 || (object != null && pattern.matcher(text).matches()));
    }
}
