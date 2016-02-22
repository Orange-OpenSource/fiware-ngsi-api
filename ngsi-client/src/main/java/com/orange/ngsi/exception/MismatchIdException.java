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

package com.orange.ngsi.exception;

/**
 * Exception triggered when a REST ID parameter mismatches with the ID in the request body
 */
public class MismatchIdException extends Exception {

    private final String parameterId;

    private final String bodyId;

    public MismatchIdException(String parameterId, String bodyId) {
        this.parameterId = parameterId;
        this.bodyId = bodyId;
    }

    public String getMessage() {
        return "mismatch id between parameter " + parameterId + " and body " + bodyId;
    }

    public String getParameterId() {
        return parameterId;
    }

    public String getBodyId() {
        return bodyId;
    }
}
