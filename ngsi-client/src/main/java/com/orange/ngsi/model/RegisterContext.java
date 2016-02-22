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

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.time.Instant;
import java.util.List;

/**
 * Created by pborscia on 10/08/2015.
 */
@JacksonXmlRootElement(localName = "registerContextRequest")
public class RegisterContext {

    @JsonProperty(value = "contextRegistrations", required = true)
    @JacksonXmlElementWrapper(localName = "contextRegistrationList")
    @JacksonXmlProperty(localName = "contextRegistration")
    private List<ContextRegistration> contextRegistrationList;

    private String duration;

    private String registrationId;

    public RegisterContext() {
    }

    public RegisterContext(List<ContextRegistration> contextRegistrationList) {
        this.contextRegistrationList = contextRegistrationList;
    }

    public List<ContextRegistration> getContextRegistrationList() {
        return contextRegistrationList;
    }

    public void setContextRegistrationList(List<ContextRegistration> contextRegistrationList) {
        this.contextRegistrationList = contextRegistrationList;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getRegistrationId() {
        return registrationId;
    }

    public void setRegistrationId(String registrationId) {
        this.registrationId = registrationId;
    }

    @Override
    public String toString() {
        return "RegisterContext{" +
                "contextRegistrationList=" + contextRegistrationList +
                ", duration='" + duration + '\'' +
                ", registrationId='" + registrationId + '\'' +
                '}';
    }
}
