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
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Context Attribute
 */
public class ContextAttribute {


    private String name;

    private String type;

    @JacksonXmlProperty(localName = "contextValue")
    private Object value;

    @JsonProperty("metadatas")
    @JacksonXmlElementWrapper(localName = "metadata")
    @JacksonXmlProperty(localName = "contextMetadata")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ContextMetadata> metadata;

    public ContextAttribute() {
    }

    public ContextAttribute(String name, String type, Object value)
    {
        this.name = name;
        this.type = type;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Object get(String name) {
        return value;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public List<ContextMetadata> getMetadata() {
        if (metadata == null) {
            return Collections.emptyList();
        }
        return metadata;
    }

    public void setMetadata(List<ContextMetadata> metadata) {
        this.metadata = metadata;
    }

    public void addMetadata(ContextMetadata metadata) {
        if (this.metadata == null) {
            this.metadata = new LinkedList<>();
        }
        this.metadata.add(metadata);
    }

    @Override
    public String toString() {
        return "ContextAttribute{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", value=" + value +
                ", metadata=" + metadata +
                '}';
    }
}
