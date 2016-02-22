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
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Created by pborscia on 04/06/2015.
 */
public class EntityId {

    private String id;

    @JacksonXmlProperty(isAttribute = true)
    private String type;

    @JacksonXmlProperty(isAttribute = true)
    private Boolean isPattern;

    public EntityId() {
    }

    public EntityId(String id, String type, boolean isPattern) {
        this.id = id;
        this.type = type;
        this.isPattern = isPattern;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Boolean getIsPattern() {
        return isPattern;
    }

    public void setIsPattern(Boolean isPattern) {
        this.isPattern = isPattern;
    }

    @Override
    public String toString() {
        return "EntityId{" +
                "id='" + id + '\'' +
                ", type='" + type + '\'' +
                ", isPattern=" + isPattern +
                '}';
    }
}
