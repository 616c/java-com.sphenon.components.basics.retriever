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

import com.sphenon.basics.context.CallContext;
import com.sphenon.basics.retriever.Meter;
import com.sphenon.basics.validation.returncodes.ValidationFailure;

public class Class_Meter implements Meter {
    public Class_Meter( CallContext context ){
    }
    public Class_Meter( CallContext context, int value ){
        this.setValue(context, value);
    }
    public Class_Meter( CallContext context, int value, int min, int max ){
        this.setMaxValue(context, max);
        this.setMinValue(context, min);
        this.setValue(context, value);
    }

    protected int min_value = 0;
    protected int max_value = 100;
    protected int value = 0;
    protected String tip = null;
    
    public int getMaxValue(CallContext context) {
        return this.max_value;
    }

    public int getMinValue(CallContext context) {
        return this.min_value;
    }

    public int getValue(CallContext context) {
        return this.value;
    }

    public void setMaxValue(CallContext context, int value) {
        this.max_value = value;
    }

    public void setMinValue(CallContext context, int value) {
        this.min_value = value;
    }

    public void setValue(CallContext context, int value){
        this.value = value;
    }
    
    public void setTipText(CallContext context, String tip ){
        this.tip = tip;
    }
    
    public String getTipText(CallContext context ){
        return this.tip;
    }
   
    public String toString(CallContext context) {
        StringBuffer sb = new StringBuffer();
        sb.append( "Meter=");
        sb.append( "Value={"+this.getValue(context) + "},");
        sb.append( "MinValue={"+this.getMinValue(context) + "},");
        sb.append( "MaxValue={"+this.getMaxValue(context) + "},");
        sb.append( "Tip={"+(this.getTipText(context)!=null?this.getTipText(context) : "") + "}");
        sb.append( "");
        return sb.toString();
    }
    
    public static Meter createFromString(CallContext context, String meterstring ){
        if( meterstring == null || meterstring.length()==0){
            return null;
        }
        try {
            Class_Meter meter = new Class_Meter(context);
            String tip = "";
            String split[] = meterstring.split("Meter=");
            String properties = split[1];
            split = properties.split(",");

            for (String value : split) {
                String vsplit[] = value.split("=");
                if (vsplit[0].equals("Value")) {
                    String prop_value = vsplit[1].substring(1, vsplit[1].length() - 1);
                    int typed_value = Integer.parseInt(prop_value);
                    meter.setValue(context, typed_value);
                    continue;
                }
                if (vsplit[0].equals("MinValue")) {
                    String prop_value = vsplit[1].substring(1, vsplit[1].length() - 1);
                    int typed_value = Integer.parseInt(prop_value);
                    meter.setMinValue(context, typed_value);
                    continue;
                }
                if (vsplit[0].equals("MaxValue")) {
                    String prop_value = vsplit[1].substring(1, vsplit[1].length() - 1);
                    int typed_value = Integer.parseInt(prop_value);
                    meter.setMaxValue(context, typed_value);
                    continue;
                }
                if (vsplit[0].equals("Tip")) {
                    String prop_value = vsplit[1].substring(1, vsplit[1].length() - 1);
                    String typed_value = prop_value;
                    meter.setTipText(context, typed_value);
                    continue;
                }
            }
            return meter;
        } catch ( Throwable ex) {
            return null;
        }
    }
    
}
