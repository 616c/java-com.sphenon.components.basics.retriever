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

import com.sphenon.basics.context.CallContext;
import com.sphenon.basics.validation.returncodes.ValidationFailure;

public interface Meter {
    public void   setValue(CallContext context, int value) throws ValidationFailure;
    public int    getValue(CallContext context);
    public void   setMinValue(CallContext context, int value);
    public int    getMinValue(CallContext context);
    public void   setMaxValue(CallContext context, int value);
    public int    getMaxValue(CallContext context);
    public String toString(CallContext context);
    public void   setTipText(CallContext context, String tip);
    public String getTipText(CallContext context);
} 
