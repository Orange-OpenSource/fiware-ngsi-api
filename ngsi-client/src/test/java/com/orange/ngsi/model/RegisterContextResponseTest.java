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

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.jayway.jsonpath.JsonPath;
import org.junit.Test;

import java.io.IOException;

import static com.orange.ngsi.Util.createRegisterContextTemperature;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by pborscia on 10/08/2015.
 */
public class RegisterContextResponseTest {

    @Test
    public void deserializationSimpleRegisterContextResponse() throws IOException {

        String json = getJsonOrionRegisterContextResponse();
        ObjectMapper mapper = new ObjectMapper();

        RegisterContextResponse registerContextResponse = mapper.readValue(json, RegisterContextResponse.class);
        assertNull(registerContextResponse.getErrorCode());
        assertEquals("P1M", registerContextResponse.getDuration());
        assertEquals("52a744b011f5816465943d58", registerContextResponse.getRegistrationId());
    }

    @Test
    public void serializationSimpleRegisterContextResponse() throws IOException {

        RegisterContextResponse registerContextResponse = new RegisterContextResponse("52a744b011f5816465943d58");
        registerContextResponse.setDuration("P1M");

        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        String json = writer.writeValueAsString(registerContextResponse);
        assertEquals("52a744b011f5816465943d58", JsonPath.read(json, "$.registrationId"));
        assertEquals("P1M", JsonPath.read(json, "$.duration"));
    }


    private String getJsonOrionRegisterContextResponse(){
        String json = "{\n" +
                "  \"duration\" : \"P1M\",\n" +
                "  \"registrationId\" : \"52a744b011f5816465943d58\"\n" +
                "}";

        return json;
    }
}
