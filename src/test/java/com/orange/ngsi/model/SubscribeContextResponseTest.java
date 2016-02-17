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
import org.junit.Test;

import java.io.IOException;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

/**
 * Tests for SubscribeContextResponse
 */
public class SubscribeContextResponseTest {

    @Test
    public void deserializationSimpleSubscribeContextResponse() throws IOException {

        String json = getJsonOrion();

        ObjectMapper mapper = new ObjectMapper();

        SubscribeContextResponse subscribeContextResponse = mapper.readValue(json, SubscribeContextResponse.class);

        assertNull(subscribeContextResponse.getSubscribeError());
        assertEquals("P1M", subscribeContextResponse.getSubscribeResponse().getDuration());
        assertEquals("51c0ac9ed714fb3b37d7d5a8", subscribeContextResponse.getSubscribeResponse().getSubscriptionId());
        assertEquals("PT5S", subscribeContextResponse.getSubscribeResponse().getThrottling());
    }

    private String getJsonOrion(){
        String json = "{\n" +
                "    \"subscribeResponse\": {\n" +
                "        \"duration\": \"P1M\",\n" +
                "        \"subscriptionId\": \"51c0ac9ed714fb3b37d7d5a8\",\n" +
                "        \"throttling\": \"PT5S\"\n" +
                "    }\n" +
                "}";

        return json;
    }
}
