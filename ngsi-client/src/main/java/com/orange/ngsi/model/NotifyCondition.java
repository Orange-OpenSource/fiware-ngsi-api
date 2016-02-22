/*
 * Copyright (C) 2015 Orange
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *          http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.orange.ngsi.model;

import com.fasterxml.jackson.annotation.JsonInclude;

import java.util.List;

/**
 * Created by pborscia on 17/07/2015.
 */
public class NotifyCondition {

    NotifyConditionEnum type;

    List<String> condValues;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    String restriction;


    public NotifyCondition() {
    }

    public NotifyCondition(NotifyConditionEnum type, List<String> condValues) {
        this.type = type;
        this.condValues = condValues;
    }

    public NotifyConditionEnum getType() {
        return type;
    }

    public void setType(NotifyConditionEnum type) {
        this.type = type;
    }

    public List<String> getCondValues() {
        return condValues;
    }

    public void setCondValues(List<String> condValues) {
        this.condValues = condValues;
    }

    public String getRestriction() {
        return restriction;
    }

    public void setRestriction(String restriction) {
        this.restriction = restriction;
    }
}
