// instantiated with javainst.pl from /workspace/sphenon/projects/components/basics/retriever/v0001/origin/source/java/com/sphenon/basics/retriever/templates/FilterByRange.javatpl

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
import com.sphenon.basics.exception.*;
import com.sphenon.basics.retriever.*;

public class FilterByRange_float_ implements Filter_float_, FilterByRange {

    protected Float  minimum;
    protected Float maximum;

    public FilterByRange_float_ (CallContext context) {
        this.setFilterEnabled(context, false);
    }

    public FilterByRange_float_ (CallContext context, Float minimum, Float maximum) {
        this.setMinimum(context, minimum);
        this.setMaximum(context, maximum);
    }

    protected boolean filter_enabled;

    public boolean getFilterEnabled (CallContext context) {
        return this.filter_enabled;
    }

    public void setFilterEnabled (CallContext context, boolean filter_enabled) {
        this.filter_enabled = filter_enabled;
    }

    public Float getMinimum (CallContext context) {
        return this.minimum;
    }

    public Float getMaxnimum (CallContext context) {
        return this.maximum;
    }

    public void setMinimum (CallContext context, Float minimum) {
        this.minimum = minimum;
        this.setFilterEnabled(context, (this.minimum == null && this.maximum == null ? false : true));
    }

    public void setMaximum (CallContext context, Float maximum) {
        this.setFilterEnabled(context, true);
        this.maximum = maximum;
        this.setFilterEnabled(context, (this.minimum == null && this.maximum == null ? false : true));
    }

    public boolean matches (CallContext context, float object) {
        return (    (    this.minimum == null
                      || (this.minimum).floatValue() <= object
                    )
                 && (    this.maximum == null
                      || (this.maximum).floatValue() >= object
                    )
               );
    }
}
