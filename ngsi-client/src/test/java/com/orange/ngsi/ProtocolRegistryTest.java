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

package com.orange.ngsi;

import org.junit.Test;

import java.net.URISyntaxException;

import static org.junit.Assert.assertEquals;

/**
 * handles tests of the ProtocolRegistry class
 */
public class ProtocolRegistryTest {

    ProtocolRegistry protocolRegistry = new ProtocolRegistry();

    @Test
    public void supportJsonTest() throws URISyntaxException {
        protocolRegistry.unregisterHost("http://localhost:8080");
        assertEquals(true, protocolRegistry.supportV1Json("http://localhost:8080"));
        assertEquals(false, protocolRegistry.supportXml("http://localhost:8080"));
    }

    @Test
    public void supportXmlTest() throws URISyntaxException {
        protocolRegistry.registerHost("http://localhost:8082");
        assertEquals(false, protocolRegistry.supportV1Json("http://localhost:8082"));
        assertEquals(true, protocolRegistry.supportXml("http://localhost:8082"));
    }

    @Test
    public void registerHostWithURIExceptionTest() {
        protocolRegistry.registerHost("http://localhost :8082");
    }

    @Test
    public void supportV1JsonWithURIExceptionTest() throws URISyntaxException {
        assertEquals(false, protocolRegistry.supportV1Json("http://localhost :8082"));
    }

    @Test
    public void supportXmlWithURIExceptionTest() throws URISyntaxException {
        assertEquals(false, protocolRegistry.supportXml("http://localhost :8082"));
    }
}
