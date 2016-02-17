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
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

import java.util.List;

/**
 * Created by pborscia on 05/06/2015.
 */
@JacksonXmlRootElement(localName = "updateContextRequest")
public class UpdateContext {


    @JacksonXmlElementWrapper(localName="contextElementList")
    @JacksonXmlProperty(localName="contextElement")
    List<ContextElement> contextElements;

    UpdateAction updateAction;

    public UpdateContext() {
    }

    public UpdateContext(UpdateAction updateAction) {
        this.updateAction = updateAction;
    }

    public List<ContextElement> getContextElements() {
        return contextElements;
    }

    public void setContextElements(List<ContextElement> contextElements) {
        this.contextElements = contextElements;
    }

    public UpdateAction getUpdateAction() {
        return updateAction;
    }

    public void setUpdateAction(UpdateAction updateAction) {
        this.updateAction = updateAction;
    }

    @Override
    public String toString() {
        return "UpdateContext{" +
                "contextElements=" + contextElements +
                ", updateAction=" + updateAction +
                '}';
    }
}
