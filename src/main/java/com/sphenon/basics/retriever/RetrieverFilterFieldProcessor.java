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

public interface RetrieverFilterFieldProcessor {
    public void processFilterField(CallContext context, String name, Object value);
    public void processFilterField(CallContext context, String name, Object value, boolean is_to_many_association);
    public void processSortOrderField(CallContext context, String name, int sort_order, long sort_order_position);
    public void processLimitField(CallContext context, String name, int limit);
    public void processRetrieverFilter(CallContext context, String name, RetrieverFilter retriever_filter, boolean is_to_many_association, boolean is_derived);
    public void processRetrieverFilter(CallContext context, String name, RetrieverFilter retriever_filter, boolean is_to_many_association, boolean is_derived, String treat_as);
    public void pushAttribute(CallContext context, String name, boolean is_to_many, String treat_as);
    public void popAttribute(CallContext context);
}
