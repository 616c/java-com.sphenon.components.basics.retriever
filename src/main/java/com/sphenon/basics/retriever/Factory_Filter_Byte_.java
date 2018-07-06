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

import com.sphenon.basics.retriever.*;

import com.sphenon.basics.context.*;
import com.sphenon.basics.context.classes.*;
import com.sphenon.basics.exception.*;
import com.sphenon.basics.configuration.*;
import com.sphenon.basics.customary.*;
import com.sphenon.basics.retriever.*;
import com.sphenon.basics.factory.*;

public class Factory_Filter_Byte_ {

    /* -------------- extensible factory instantiation --------------------------------------------------------------------------------------- */
    static protected Configuration config;
    static protected FactoryInstantiator<Factory_Filter_Byte_> factory_instantiator;
    static {
      CallContext context = RootContext.getInitialisationContext();
      config = Configuration.create(context, "com.sphenon.basics.retriever.Factory_Filter_Byte_");
      factory_instantiator = new FactoryInstantiator(context, Factory_Filter_Byte_.class) { protected Factory_Filter_Byte_ createDefault(CallContext context) { return new Factory_Filter_Byte_(context); } };
    };
    /* --------------------------------------------------------------------------------------------------------------------------------------- */
    static public Factory_Filter_Byte_ newInstance (CallContext context) {
        return factory_instantiator.newInstance(context);
    }
    /* --------------------------------------------------------------------------------------------------------------------------------------- */

    protected Factory_Filter_Byte_ (CallContext context) {
    }

    static public Filter_Byte_ construct (CallContext context) {
        return newInstance(context).create(context);
    }

    public Filter_Byte_ create (CallContext context) {
        return new FilterByRange_Byte_(context);
    }

    static public Filter_Byte_ construct (CallContext context, Byte minimum, Byte maximum) {
        return newInstance(context).create(context, minimum, maximum);
    }

    public Filter_Byte_ create (CallContext context, Byte minimum, Byte maximum) {
        return new FilterByRange_Byte_(context, minimum, maximum);
    }
}
