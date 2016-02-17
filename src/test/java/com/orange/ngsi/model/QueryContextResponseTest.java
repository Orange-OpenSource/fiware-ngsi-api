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
import com.orange.ngsi.TestConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by pborscia on 11/08/2015.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfiguration.class)
public class QueryContextResponseTest {

    @Autowired
    ObjectMapper objectMapper;

    @Test
    public void deserializationSimpleQueryContextResponse() throws IOException {

        String json = getJsonOrionQueryContextResponse();
        QueryContextResponse queryContextResponse = objectMapper.readValue(json, QueryContextResponse.class);

        assertNull(queryContextResponse.getErrorCode());
        assertEquals(2, queryContextResponse.getContextElementResponses().size());
        assertEquals(1, queryContextResponse.getContextElementResponses().get(0).getContextElement().getContextAttributeList().size());
        assertEquals("temperature", queryContextResponse.getContextElementResponses().get(0).getContextElement().getContextAttributeList().get(0).getName());
        assertEquals("float", queryContextResponse.getContextElementResponses().get(0).getContextElement().getContextAttributeList().get(0).getType());
        assertEquals("23", queryContextResponse.getContextElementResponses().get(0).getContextElement().getContextAttributeList().get(0).getValue());
        assertEquals("Room1", queryContextResponse.getContextElementResponses().get(0).getContextElement().getEntityId().getId());
        assertEquals("Room", queryContextResponse.getContextElementResponses().get(0).getContextElement().getEntityId().getType());
        assertEquals(false, queryContextResponse.getContextElementResponses().get(0).getContextElement().getEntityId().getIsPattern());
        assertEquals(CodeEnum.CODE_200.getLabel(), queryContextResponse.getContextElementResponses().get(0).getStatusCode().getCode());
        assertEquals(CodeEnum.CODE_200.getShortPhrase(), queryContextResponse.getContextElementResponses().get(0).getStatusCode().getReasonPhrase());
        assertEquals(1, queryContextResponse.getContextElementResponses().get(1).getContextElement().getContextAttributeList().size());
        assertEquals("temperature", queryContextResponse.getContextElementResponses().get(1).getContextElement().getContextAttributeList().get(0).getName());
        assertEquals("float", queryContextResponse.getContextElementResponses().get(1).getContextElement().getContextAttributeList().get(0).getType());
        assertEquals("21", queryContextResponse.getContextElementResponses().get(1).getContextElement().getContextAttributeList().get(0).getValue());
        assertEquals("Room2", queryContextResponse.getContextElementResponses().get(1).getContextElement().getEntityId().getId());
        assertEquals("Room", queryContextResponse.getContextElementResponses().get(1).getContextElement().getEntityId().getType());
        assertEquals(false, queryContextResponse.getContextElementResponses().get(1).getContextElement().getEntityId().getIsPattern());
        assertEquals(CodeEnum.CODE_481.getLabel(), queryContextResponse.getContextElementResponses().get(1).getStatusCode().getCode());
        assertEquals(CodeEnum.CODE_481.getShortPhrase(), queryContextResponse.getContextElementResponses().get(1).getStatusCode().getReasonPhrase());
        assertEquals("test details", queryContextResponse.getContextElementResponses().get(1).getStatusCode().getDetail());
    }

    private String getJsonOrionQueryContextResponse(){
        String json = "{\n" +
                "    \"contextResponses\": [\n" +
                "        {\n" +
                "            \"contextElement\": {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "                        \"name\": \"temperature\",\n" +
                "                        \"type\": \"float\",\n" +
                "                        \"value\": \"23\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"id\": \"Room1\",\n" +
                "                \"isPattern\": \"false\",\n" +
                "                \"type\": \"Room\"\n" +
                "            },\n" +
                "            \"statusCode\": {\n" +
                "                \"code\": \"200\",\n" +
                "                \"reasonPhrase\": \"OK\"\n" +
                "            }\n" +
                "        },\n" +
                "        {\n" +
                "            \"contextElement\": {\n" +
                "                \"attributes\": [\n" +
                "                    {\n" +
                "                        \"name\": \"temperature\",\n" +
                "                        \"type\": \"float\",\n" +
                "                        \"value\": \"21\"\n" +
                "                    }\n" +
                "                ],\n" +
                "                \"id\": \"Room2\",\n" +
                "                \"isPattern\": \"false\",\n" +
                "                \"type\": \"Room\"\n" +
                "            },\n" +
                "            \"statusCode\": {\n" +
                "                \"code\": \"481\",\n" +
                "                \"reasonPhrase\": \"Entity Type required\",\n" +
                "                \"details\": \"test details\"\n" +
                "            }\n" +
                "        }\n" +
                "    ]\n" +
                "}\n";

        return json;
    }


}

