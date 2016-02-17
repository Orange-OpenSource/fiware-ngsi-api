/*
 * Copyright (C) 2016 Orange
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

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * Request message for POST /contextEntities/{entityID}
 */
@JacksonXmlRootElement(localName = "appendContextElementRequest")
public class AppendContextElement {

    @JsonProperty(value = "attributes")
    @JacksonXmlElementWrapper(localName = "contextAttributeList")
    @JacksonXmlProperty(localName = "contextAttribute")
    private List<ContextAttribute> attributeList;

    public AppendContextElement() {
    }

    public AppendContextElement(List<ContextAttribute> attributeList) {
        this.attributeList = attributeList;
    }

    public List<ContextAttribute> getAttributeList() {
        return attributeList;
    }

    public void setAttributeList(List<ContextAttribute> attributeList) {
        this.attributeList = attributeList;
    }

    @Override public String toString() {
        return "AppendContextElement{" +
                "attributeList=" + attributeList +
                '}';
    }
}
