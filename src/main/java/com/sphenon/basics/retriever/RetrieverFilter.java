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
import com.sphenon.basics.variatives.*;
import com.sphenon.basics.variatives.classes.*;
import com.sphenon.ad.adcore.ModificationType;

import com.sphenon.basics.retriever.returncodes.*;

public interface RetrieverFilter {
    public void            resetSortOrderState(CallContext context, boolean invoked_from_topmost_container);
    public void            resetFilterToDefaultValues(CallContext context);
    public void            resetFilterToDefaultValues(CallContext context, ModificationType modification_type);
    public void            processFields(CallContext context, RetrieverFilterFieldProcessor rffp, boolean top_level);
    public boolean         containsEnabledFilters(CallContext context);
    public String          getItemClass(CallContext context);
    public long            getNextSortOrderPosition(CallContext context);
    public RetrieverFilter getParentFilter (CallContext context);
}
