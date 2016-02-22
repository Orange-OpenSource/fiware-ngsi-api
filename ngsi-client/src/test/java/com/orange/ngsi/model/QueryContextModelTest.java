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
import java.util.List;

import static com.orange.ngsi.Util.createQueryContextTemperature;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Created by pborscia on 11/08/2015.
 */
public class QueryContextModelTest {

    @Test
    public void deserializationSimpleQueryContext() throws IOException {
        String json = getJsonOrionQueryContext();
        ObjectMapper mapper = new ObjectMapper();
        QueryContext queryContext = mapper.readValue(json, QueryContext.class);

        assertEquals(1, queryContext.getEntityIdList().size());
        assertEquals("Room.*", queryContext.getEntityIdList().get(0).getId());
        assertEquals("Room", queryContext.getEntityIdList().get(0).getType());
        assertEquals(true, queryContext.getEntityIdList().get(0).getIsPattern());
        assertEquals(1, queryContext.getAttributeList().size());
        assertEquals("temperature", queryContext.getAttributeList().get(0));
        assertNull(queryContext.getRestriction());
    }

    @Test
    public void serializationSimpleQueryContext() throws IOException {
        QueryContext queryContext = createQueryContextTemperature();
        ObjectMapper mapper = new ObjectMapper();
        ObjectWriter writer = mapper.writer(new DefaultPrettyPrinter());
        String json = writer.writeValueAsString(queryContext);

        List<EntityId> entityIdList = JsonPath.read(json, "$.entities[*]");
        assertEquals(1, entityIdList.size());
        assertEquals("S*", JsonPath.read(json, "$.entities[0].id"));
        assertEquals("TempSensor", JsonPath.read(json, "$.entities[0].type"));
        assertEquals(true, JsonPath.read(json, "$.entities[0].isPattern"));
        List<String> attributeList = JsonPath.read(json, "$.attributes[*]");
        assertEquals(1, attributeList.size());
        assertEquals("temp", JsonPath.read(json, "$.attributes[0]"));
    }

    private String getJsonOrionQueryContext() {
        String json = "{\n" +
                "    \"entities\": [\n" +
                "    {\n" +
                "        \"type\": \"Room\",\n" +
                "        \"isPattern\": \"true\",\n" +
                "        \"id\": \"Room.*\"\n" +
                "    }\n" +
                "    ],\n" +
                "    \"attributes\" : [\n" +
                "    \"temperature\"\n" +
                "    ]\n" +
                "}";

        return json;
    }
}
