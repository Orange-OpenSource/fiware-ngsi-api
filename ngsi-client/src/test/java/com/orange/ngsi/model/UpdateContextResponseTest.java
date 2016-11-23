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

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Assert;
import org.junit.Test;

import java.io.IOException;

import static junit.framework.TestCase.assertNotNull;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Test the UpdateContextResponse model class
 */
public class UpdateContextResponseTest {


    @Test
    public void testUpdateContextRespone_json() throws IOException {

        String json = getJsonOrion();
        ObjectMapper mapper = new ObjectMapper();
        mapper.addMixIn(ContextElement.class, EntityIdMixIn.class);

        UpdateContextResponse updateContextResponse = mapper.readValue(json, UpdateContextResponse.class);

        assertNull(updateContextResponse.getErrorCode());
        assertNotNull(updateContextResponse.getContextElementResponses());
        assertEquals(1, updateContextResponse.getContextElementResponses().size());
        assertEquals("Room", updateContextResponse.getContextElementResponses().get(0).getContextElement().getEntityId().getType());
        assertEquals(false, updateContextResponse.getContextElementResponses().get(0).getContextElement().getEntityId().getIsPattern());
        assertEquals("OpenSpace", updateContextResponse.getContextElementResponses().get(0).getContextElement().getEntityId().getId());
        assertNotNull(updateContextResponse.getContextElementResponses().get(0).getContextElement().getContextAttributeList());
        assertEquals(1, updateContextResponse.getContextElementResponses().get(0).getContextElement().getContextAttributeList().size());
        assertEquals("temperature", updateContextResponse.getContextElementResponses().get(0).getContextElement().getContextAttributeList().get(0).getName());
        assertEquals("float", updateContextResponse.getContextElementResponses().get(0).getContextElement().getContextAttributeList().get(0).getType());
        assertEquals("12", updateContextResponse.getContextElementResponses().get(0).getContextElement().getContextAttributeList().get(0).getValue());
        assertNotNull(updateContextResponse.getContextElementResponses().get(0).getStatusCode());
        assertEquals("200", updateContextResponse.getContextElementResponses().get(0).getStatusCode().getCode());
        assertEquals("OK", updateContextResponse.getContextElementResponses().get(0).getStatusCode().getReasonPhrase());
    }

    private String getJsonOrion(){
        String json = " {\n"
                + " \t\"contextResponses\": [    {      \n"
                + " \t\t\"contextElement\": {        \n"
                + " \t\t\t\"type\": \"Room\",\n"
                + " \t\t\t\"isPattern\": \"false\",\n"
                + " \t\t\t\"id\": \"OpenSpace\",\n"
                + " \t\t\t\"attributes\": [          {            \n"
                + " \t\t\t\t\"name\": \"temperature\",\n"
                + " \t\t\t\t\"type\": \"float\",\n"
                + " \t\t\t\t\"value\": \"12\"          \n"
                + " \t\t\t} ]\n"
                + " \t\t},\n"
                + " \t\t      \"statusCode\": {        \n"
                + " \t\t\t\"code\": \"200\",\n"
                + " \t\t\t        \"reasonPhrase\": \"OK\"      \n"
                + " \t\t}    \n"
                + " \t}  ]\n"
                + " }";

        return json;
    }
}
