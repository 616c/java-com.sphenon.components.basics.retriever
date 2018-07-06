package com.sphenon.basics.retriever.classes;

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

import java.util.Date;
import java.util.GregorianCalendar;

import com.sphenon.basics.context.CallContext;
import com.sphenon.basics.retriever.Time;

public class Class_Time implements Time {
    public Class_Time( CallContext context, Date time ){
        this.setValue(context, time);
    }
    
    protected Date time;

    public Date getValue(CallContext context) {
        return this.time;
    }

    public void setValue(CallContext context, Date value) {
        this.time = value;
        this.setupDate(context, this.time);
    }
    
    GregorianCalendar gc = new GregorianCalendar();
    
    protected void
    setupDate( CallContext context, Date value ){
        if( value != null ){
            gc.setTime(value);
            gc.set(1400, 01, 01);
            this.time = gc.getTime();
        }
    }
}
