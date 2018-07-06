// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/retriever/v0001/origin/source/java/com/sphenon/basics/retriever/templates/FilterByRegExp.javatpl

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
// please do not modify this file directly
package com.sphenon.basics.retriever.tplinst;

import com.sphenon.basics.retriever.*;
import java.util.Date;

import com.sphenon.basics.context.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.retriever.*;

import java.util.regex.*;

public class FilterByRegExp_char_ implements FilterByExpression_char_ {

    protected String  regexp;
    protected Pattern regexp_pattern;

    protected boolean filter_enabled;

    public boolean getFilterEnabled (CallContext context) {
        return this.filter_enabled;
    }

    public void setFilterEnabled (CallContext context, boolean filter_enabled) {
        this.filter_enabled = filter_enabled;
    }

    public FilterByRegExp_char_ (CallContext context) {
    }

    public FilterByRegExp_char_ (CallContext context, String regexp) throws PatternSyntaxException {
        this.setRegExp(context, regexp);
    }

    public String getExpression (CallContext context) {
        return this.getRegExp(context);
    }

    public void setExpression (CallContext context, String expression) {
        this.setRegExp(context, expression);
    }

    public String getRegExp (CallContext context) {
        return this.regexp;
    }

    public void setRegExp (CallContext context, String regexp) throws PatternSyntaxException {
        this.regexp = regexp;
        try {
            this.regexp_pattern = (this.regexp == null ? null : Pattern.compile(this.regexp));
        } catch (PatternSyntaxException pse) {
            this.regexp_pattern = null;
            if (RetrieverPackageInitialiser.getConfiguration(context).get(context, "DEBUG.DisableRegExpMatcher", false) == false) {
                throw pse;
            }
        } finally {
            setFilterEnabled(context, this.regexp_pattern == null ? false : true);
        }
    }

    public boolean matches (CallContext context, char object) {
        char instance = new Character(object);
        return (    this.regexp == null
                 || this.regexp.length() == 0
                 || this.regexp_pattern == null
                 || (new Character(object) != null && regexp_pattern.matcher(new Character(instance).toString() ).matches()));
    }
}

