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

import com.sphenon.basics.context.CallContext;
import com.sphenon.basics.validation.returncodes.ValidationFailure;

public interface TrafficLight {
    /**
     * off
     */
    public static short OFFLINE = 1;
    /**
     * green
     */
    public static short GREEN = 2;
    /**
     * yellow phase
     */
    public static short YELLOW = 3;
    /**
     * prepare to go. there is no need to use it, but you can
     */
    public static short YELLOW_RED=4;
    
    /**
     * eigentlich grün, trotzdem eine warnung
     */
    public static short YELLOW_GREEN=5;
    
    /**
     * stop, problem
     */
    public static short RED = 6;
 
    /**
     * sets the state
     * @param context
     * @param state
     */
    public void setValue( CallContext context, short state );
    
    /**
     * returns the state
     * @param context
     * @return
     */
    public short getValue( CallContext context );
    
    /**
     * tip text to display in ui
     * @param context
     * @param tip
     */
    public void setTipText(CallContext context, String tip);
    
    /**
     * tip text
     * @param context
     */
    public String getTipText(CallContext context);
    
    /**
     * for flushing to db
     * @param context
     * @return
     */
    public String toString(CallContext context);
}
