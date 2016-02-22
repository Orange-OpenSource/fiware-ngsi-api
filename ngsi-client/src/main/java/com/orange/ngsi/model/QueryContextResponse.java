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
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * Created by pborscia on 11/08/2015.
 */
@JacksonXmlRootElement(localName = "queryContextResponse")
public class QueryContextResponse {

    @JsonProperty("contextResponses")
    @JacksonXmlElementWrapper(localName = "contextResponseList")
    @JacksonXmlProperty(localName = "contextElementResponse")
    List<ContextElementResponse> contextElementResponses;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private StatusCode errorCode;

    public QueryContextResponse() {
    }

    public List<ContextElementResponse> getContextElementResponses() {
        return contextElementResponses;
    }

    public void setContextElementResponses(List<ContextElementResponse> contextElementResponses) {
        this.contextElementResponses = contextElementResponses;
    }

    public StatusCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(StatusCode errorCode) {
        this.errorCode = errorCode;
    }

    @Override
    public String toString() {
        return "QueryContextResponse{" +
                "contextElementResponses=" + contextElementResponses +
                ", errorCode=" + errorCode +
                '}';
    }
}
