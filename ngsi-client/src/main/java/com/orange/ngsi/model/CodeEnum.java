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

/**
 * Created by pborscia on 08/07/2015.
 */
public enum CodeEnum {

    CODE_200("200", "OK", "All is OK"),
    CODE_400("400", "Bad request", "Bad request"),
    CODE_403("403", "Forbidden", "Request is not allowed"),
    CODE_404("404", "ContextElement not found", "The ContextElement requested %s is not found"),
    CODE_470("470", "Subscription ID not found", "The subscription ID specified %s does not correspond to an active subscription"),
    CODE_471("471", "Missing parameter", "The parameter %s of type %s is missing in the request"),
    CODE_472("472", "Invalid parameter", "A parameter %s is not valid/allowed in the request"),
    CODE_473("473", "Error in metadata","There is a generic error in the metadata"),
    CODE_480("480", "Regular Expression for EntityId not allowed", "A regular expression %s for EntityId %s is not allowed by the receiver"),
    CODE_481("481", "Entity Type required", "The EntityType %s is required by the receiver"),
    CODE_482("482", "AttributeList required","The AttributList is required"),
    CODE_500("500", "Receiver internal error", "An unknown error at the receiver has occured");

    private String label;

    private String shortPhrase;

    private String longPhrase;

    CodeEnum(String label, String shortPhrase, String longPhrase) {
        this.label = label;
        this.shortPhrase = shortPhrase;
        this.longPhrase = longPhrase;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public String getShortPhrase() {
        return shortPhrase;
    }

    public void setShortPhrase(String shortPhrase) {
        this.shortPhrase = shortPhrase;
    }

    public String getLongPhrase() {
        return longPhrase;
    }

    public void setLongPhrase(String longPhrase) {
        this.longPhrase = longPhrase;
    }
}
