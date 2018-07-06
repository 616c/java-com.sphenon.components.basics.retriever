// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/retriever/v0001/origin/source/java/com/sphenon/basics/retriever/templates/Factory_Filter.javatpl

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
import com.sphenon.basics.context.classes.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.configuration.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.retriever.*;
import com.sphenon.basics.factory.*;

public class Factory_Filter_String_ {

    /* -------------- extensible factory instantiation --------------------------------------------------------------------------------------- */
    static protected Configuration config;
    static protected FactoryInstantiator<Factory_Filter_String_> factory_instantiator;
    static {
      CallContext context = RootContext.getInitialisationContext();
      config = Configuration.create(context, "--__Package__--.Factory_Filter_String_");
      factory_instantiator = new FactoryInstantiator(context, Factory_Filter_String_.class) { protected Factory_Filter_String_ createDefault(CallContext context) { return new Factory_Filter_String_(context); } };
    };
    /* --------------------------------------------------------------------------------------------------------------------------------------- */
    static public Factory_Filter_String_ newInstance (CallContext context) {
        return factory_instantiator.newInstance(context);
    }
    /* --------------------------------------------------------------------------------------------------------------------------------------- */

    static public Filter_String_ construct (CallContext context) {
        return newInstance(context).create(context);
    }

    protected Factory_Filter_String_ (CallContext context) {
    }

    public Filter_String_ create (CallContext context) {
        FilterByRegExp_String_ filter = new FilterByRegExp_String_(context);
filter.setExpression(context, this.expression);
        return filter;
    }

    static public Filter_String_ construct (CallContext context, String expression) {
        return newInstance(context).create(context, expression);
    }

    public Filter_String_ create (CallContext context, String expression) {
        return new FilterByRegExp_String_(context, expression);
    }
protected String expression; public String getExpression (CallContext context) { return this.expression; } public String defaultExpression (CallContext context) { return null; } public void setExpression (CallContext context, String expression) { this.expression = expression; }
}
