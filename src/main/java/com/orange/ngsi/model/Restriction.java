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

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;

import java.util.List;

/**
 * Created by pborscia on 17/07/2015.
 */
public class Restriction {

    String attributeExpression;

    @JacksonXmlElementWrapper(localName = "scope")
    @JacksonXmlProperty(localName = "operationScope")
    List<OperationScope> scopes;

    public Restriction() {
    }

    public String getAttributeExpression() {
        return attributeExpression;
    }

    public void setAttributeExpression(String attributeExpression) {
        this.attributeExpression = attributeExpression;
    }

    public List<OperationScope> getScopes() {
        return scopes;
    }

    public void setScopes(List<OperationScope> scopes) {
        this.scopes = scopes;
    }

    @Override
    public String toString() {
        return "Restriction{" +
                "attributeExpression='" + attributeExpression + '\'' +
                ", scopes=" + scopes +
                '}';
    }
}
