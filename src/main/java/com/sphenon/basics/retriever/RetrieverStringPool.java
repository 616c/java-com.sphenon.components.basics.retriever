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
import com.sphenon.basics.variatives.*;
import com.sphenon.basics.variatives.classes.*;

public class RetrieverStringPool extends StringPoolClass {
    static protected RetrieverStringPool singleton = null;

    static public RetrieverStringPool getSingleton (CallContext cc) {
        if (singleton == null) {
            singleton = new RetrieverStringPool(cc);
        }
        return singleton;
    }

    static public VariativeString get(CallContext cc, String id) {
        return VariativeStringClass.createVariativeStringClass(cc, id, getSingleton(cc));
    }

    static public String get(CallContext cc, String id, String isolang) {
        return getSingleton(cc).getString(cc, id, isolang);
    }

    protected RetrieverStringPool (CallContext cc) {
        super(cc);
        /*************************************************/
        /* THE FOLLOWING SECTION IS PARTIALLY GENERATED. */
        /* BE CAREFUL WHEN EDITING MANUALLY !            */
        /*                                               */
        /* See StringPool.java for explanation.          */
        /*************************************************/
        //BEGINNING-OF-STRINGS
        //P-0-com.sphenon.basics.retriever
        //F-0-0-regexp_retriever.java.tpl
        addEntry(cc, "0.0.0", "en", "Search criteria specify %(size) object(s), not a single one, as required");
        addEntry(cc, "0.0.0", "de", "Suchkriterien liefern %(size) Objekt(e), nicht, wie erforderlich, ein einzelnes");
        //F-0-1-all_retriever.java.tpl
        addEntry(cc, "0.1.0", "en", "Cannot retrieve single instance via AllRetriever");
        addEntry(cc, "0.1.0", "de", "Eine einzelne Instanz kann nicht mittels eines AllRetriever beschafft werden");
        //END-OF-STRINGS
        /*************************************************/
    }
}
