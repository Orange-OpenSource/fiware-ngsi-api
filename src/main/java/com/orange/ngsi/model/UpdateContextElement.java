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

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * Request message for PUT /contextEntities/{entityID}
 */
@JacksonXmlRootElement(localName = "updateContextElementRequest")
public class UpdateContextElement {

    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    String attributeDomainName;

    @JsonProperty(value = "attributes")
    @JacksonXmlElementWrapper(localName="contextAttributeList")
    @JacksonXmlProperty(localName="contextAttribute")
    List<ContextAttribute> contextAttributes;

    public UpdateContextElement() {
    }

    public String getAttributeDomainName() {
        return attributeDomainName;
    }

    public void setAttributeDomainName(String attributeDomainName) {
        this.attributeDomainName = attributeDomainName;
    }

    public List<ContextAttribute> getContextAttributes() {
        return contextAttributes;
    }

    public void setContextAttributes(List<ContextAttribute> contextAttributes) {
        this.contextAttributes = contextAttributes;
    }

    @Override
    public String toString() {
        return "UpdateContextElement{" +
                "attributeDomainName='" + attributeDomainName + '\'' +
                ", contextAttributes=" + contextAttributes +
                '}';
    }
}
