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
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.net.URI;
import java.util.List;

/**
 * Created by pborscia on 04/06/2015.
 */
@JacksonXmlRootElement(localName = "notifyContextRequest")
public class NotifyContext {

    @JsonProperty(required = true)
    private String subscriptionId;
    @JsonProperty(required = true)
    private URI originator;

    @JsonProperty("contextResponses")
    @JacksonXmlElementWrapper(localName = "contextResponseList")
    @JacksonXmlProperty(localName = "contextElementResponse")
    private List<ContextElementResponse> contextElementResponseList;

    public NotifyContext() {
    }

    public NotifyContext(String subscriptionId, URI originator) {
        this.subscriptionId = subscriptionId;
        this.originator = originator;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public URI getOriginator() {
        return originator;
    }

    public void setOriginator(URI originator) {
        this.originator = originator;
    }

    public List<ContextElementResponse> getContextElementResponseList() {
        return contextElementResponseList;
    }

    public void setContextElementResponseList(List<ContextElementResponse> contextElementResponseList) {
        this.contextElementResponseList = contextElementResponseList;
    }

    @Override
    public String toString() {
        return "NotifyContext{" +
                "subscriptionId='" + subscriptionId + '\'' +
                ", originator=" + originator +
                ", contextElementResponseList=" + contextElementResponseList +
                '}';
    }
}
