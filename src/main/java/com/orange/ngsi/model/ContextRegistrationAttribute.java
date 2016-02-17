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

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

/**
 * Created by pborscia on 10/08/2015.
 */
public class ContextRegistrationAttribute {

    @JsonProperty(required = true)
    private String name;

    private String type;

    @JsonProperty(required = true)
    private Boolean isDomain;

    private List<ContextMetadata> metadata;

    public ContextRegistrationAttribute() {
    }

    public ContextRegistrationAttribute(String name, Boolean isDomain) {
        this.name = name;
        this.isDomain = isDomain;
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

    public Boolean getIsDomain() {
        return isDomain;
    }

    public void setIsDomain(Boolean isDomain) {
        this.isDomain = isDomain;
    }

    public List<ContextMetadata> getMetadata() {
        return metadata;
    }

    public void setMetadata(List<ContextMetadata> metadata) {
        this.metadata = metadata;
    }

    @Override
    public String toString() {
        return "ContextRegistrationAttribute{" +
                "name='" + name + '\'' +
                ", type='" + type + '\'' +
                ", isDomain=" + isDomain +
                ", metadata=" + metadata +
                '}';
    }
}
