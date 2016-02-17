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

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

/**
 * Created by pborscia on 17/07/2015.
 */
public class OperationScope {

    @JacksonXmlProperty(localName = "scopeType")
    String type;

    @JacksonXmlProperty(localName = "scopeValue")
    Object value;

    public OperationScope() {
    }

    public OperationScope(String type, Object scopeValue) {
        this.type = type;
        this.value = scopeValue;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "OperationScope{" +
                "type='" + type + '\'' +
                ", value=" + value +
                '}';
    }
}
