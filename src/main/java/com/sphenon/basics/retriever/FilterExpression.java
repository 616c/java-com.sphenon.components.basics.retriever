package com.sphenon.basics.retriever;

/****************************************************************************
  Copyright 2001-2024 Sphenon GmbH

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

import com.sphenon.basics.retriever.factories.*;

public class FilterExpression {

    protected FilterExpression(CallContext context, String expression) throws InvalidExpressionSyntax {
        this.setExpression(context, expression);
    }

    protected FilterExpression(CallContext context) {
    }

    static public FilterExpression create(CallContext context, String expression) throws InvalidExpressionSyntax {
        return Factory_FilterExpression.newInstance(context).create(context);
    }

    protected String  expression;

    public String getExpression (CallContext context) {
        return this.expression;
    }

    public void setExpression (CallContext context, String expression) throws InvalidExpressionSyntax {
        this.expression = expression;
    }

    public boolean matches (CallContext context, Object object) {
        return false;
    }
}
