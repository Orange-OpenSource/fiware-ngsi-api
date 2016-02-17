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
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * Request response for POST /contextEntities/{entityID}
 */
@JacksonXmlRootElement(localName = "appendContextElementResponse")
public class AppendContextElementResponse {

    @JacksonXmlProperty(localName = "entityId")
    private EntityId entityId;

    @JsonProperty("contextResponses")
    @JacksonXmlElementWrapper(localName = "contextResponseList")
    @JacksonXmlProperty(localName = "contextAttributeResponse")
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<ContextAttributeResponse> contextAttributeResponses;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private StatusCode errorCode;

    public AppendContextElementResponse() {
    }

    public EntityId getEntityId() {
        return entityId;
    }

    public void setEntityId(EntityId entityId) {
        this.entityId = entityId;
    }

    public List<ContextAttributeResponse> getContextAttributeResponses() {
        return contextAttributeResponses;
    }

    public void setContextAttributeResponses(List<ContextAttributeResponse> contextAttributeResponses) {
        this.contextAttributeResponses = contextAttributeResponses;
    }

    public StatusCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(StatusCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "AppendContextElementResponse{" +
                "entityId=" + entityId +
                ", contextAttributeResponses=" + contextAttributeResponses +
                ", errorCode=" + errorCode +
                '}';
    }
}
