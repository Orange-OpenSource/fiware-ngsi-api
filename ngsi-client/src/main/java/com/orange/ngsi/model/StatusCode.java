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
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

/**
 * Created by pborscia on 04/06/2015.
 */
@JacksonXmlRootElement(localName = "statusCode")
public class StatusCode {

    private String code;

    private String reasonPhrase;

    @JsonProperty("details")
    @JacksonXmlProperty(localName = "details")
    private String detail;

    public StatusCode() {
    }

    @JsonIgnore
    public StatusCode(CodeEnum code, String... paramDetail) {
        this.code = code.getLabel();
        this.reasonPhrase = code.getShortPhrase();
        this.detail = String.format(code.getLongPhrase(), paramDetail);
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getReasonPhrase() {
        return reasonPhrase;
    }

    public void setReasonPhrase(String reasonPhrase) {
        this.reasonPhrase = reasonPhrase;
    }

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    @Override
    public String toString() {
        return "StatusCode{" +
                "code='" + code + '\'' +
                ", reasonPhrase='" + reasonPhrase + '\'' +
                ", detail='" + detail + '\'' +
                '}';
    }
}
