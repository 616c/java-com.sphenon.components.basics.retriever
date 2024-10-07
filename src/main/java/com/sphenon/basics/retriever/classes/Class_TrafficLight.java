package com.sphenon.basics.retriever.classes;

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
import com.sphenon.basics.retriever.TrafficLight;

public class Class_TrafficLight implements TrafficLight {
    public Class_TrafficLight( CallContext context ){
    }
    public Class_TrafficLight( CallContext context, short state ){
        this.setValue(context, state);
    }
    
    protected short state = TrafficLight.OFFLINE;
    protected String tip = null;
    
    public short getValue(CallContext context) {
        return this.state;
    }

    public void setValue(CallContext context, short state) {
        if( this.isAllowed(context, state)){
            this.state = state;
        } else {
            // do nothing
        }
    }
    
    public static boolean isAllowed( CallContext context, short state ){
        if( TrafficLight.OFFLINE <= state && TrafficLight.RED>=state){
            return true;
        }
        return false;
    }
    
    public void setTipText( CallContext context, String tip ){
        this.tip = tip;
    }
    
    public String getTipText( CallContext context ){
        return this.tip;
    }
    
    public String toString( CallContext context ){
        StringBuffer sb = new StringBuffer();
        sb.append( "TrafficLight=");
        sb.append( "Value={"+this.getValue(context) + "},");
        sb.append( "Tip={"+(this.getTipText(context)!=null?this.getTipText(context) : "") + "}");
        sb.append( "");
        return sb.toString();   
    }
    
    public static TrafficLight createFromString(CallContext context, String trafficstring ){
        if( trafficstring == null || trafficstring.length()==0){
            return null;
        }
        try {
            Class_TrafficLight trafficlight = new Class_TrafficLight(context);
            String tip = "";
            String split[] = trafficstring.split("TrafficLight=");
            String properties = split[1];
            split = properties.split(",");

            for (String value : split) {
                String vsplit[] = value.split("=");
                if (vsplit[0].equals("Value")) {
                    String prop_value = vsplit[1].substring(1, vsplit[1].length() - 1);
                    int typed_value = Integer.parseInt(prop_value);
                    trafficlight.setValue(context, (short) typed_value);
                    continue;
                }
                if (vsplit[0].equals("Tip")) {
                    String prop_value = vsplit[1].substring(1, vsplit[1].length() - 1);
                    String typed_value = prop_value;
                    trafficlight.setTipText(context, typed_value);
                    continue;
                }
            }
            return trafficlight;
        } catch ( Throwable ex) {
            return null;
        }
    }
}
