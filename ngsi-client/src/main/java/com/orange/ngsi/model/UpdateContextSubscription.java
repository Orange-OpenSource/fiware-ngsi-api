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
 * UpdateContextSubscription
 */
@JacksonXmlRootElement(localName = "updateContextSubscriptionRequest")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UpdateContextSubscription {

    private String subscriptionId;

    String duration;

    Restriction restriction;

    @JacksonXmlElementWrapper(localName = "notifyConditionList")
    @JacksonXmlProperty(localName = "notifyCondition")
    List<NotifyCondition> notifyConditions;

    String throttling;

    public UpdateContextSubscription() {
    }

    public UpdateContextSubscription(String subscriptionId, String duration, List<NotifyCondition> notifyConditions, String throttling) {
        this.subscriptionId = subscriptionId;
        this.notifyConditions = notifyConditions;
    }

    public String getSubscriptionId() {
        return subscriptionId;
    }

    public void setSubscriptionId(String subscriptionId) {
        this.subscriptionId = subscriptionId;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public Restriction getRestriction() {
        return restriction;
    }

    public void setRestriction(Restriction restriction) {
        this.restriction = restriction;
    }

    public List<NotifyCondition> getNotifyConditions() {
        return notifyConditions;
    }

    public void setNotifyConditions(List<NotifyCondition> notifyConditions) {
        this.notifyConditions = notifyConditions;
    }

    public String getThrottling() {
        return throttling;
    }

    public void setThrottling(String throttling) {
        this.throttling = throttling;
    }

    @Override
    public String toString() {
        return "UpdateContextSubscription{" +
                "subscriptionId='" + subscriptionId + '\'' +
                ", duration='" + duration + '\'' +
                ", restriction=" + restriction +
                ", notifyConditions=" + notifyConditions +
                ", throttling='" + throttling + '\'' +
                '}';
    }
}
