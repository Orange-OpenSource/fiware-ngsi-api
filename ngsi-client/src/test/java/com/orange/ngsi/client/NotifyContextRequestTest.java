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

package com.orange.ngsi.client;

import com.orange.ngsi.TestConfiguration;
import com.orange.ngsi.model.CodeEnum;
import com.orange.ngsi.model.NotifyContextResponse;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.converter.xml.MappingJackson2XmlHttpMessageConverter;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.client.MockRestServiceServer;
import org.springframework.web.client.AsyncRestTemplate;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.HttpServerErrorException;

import javax.inject.Inject;
import java.util.function.Consumer;

import static com.orange.ngsi.Util.*;
import static org.hamcrest.Matchers.hasSize;
import static org.mockito.Mockito.reset;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.*;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withStatus;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;

/**
 * Test for the NGSI NotifyContext request
 */
@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = TestConfiguration.class)
public class NotifyContextRequestTest {

    private static String baseUrl = "http://localhost:8080";

    private MockRestServiceServer mockServer;

    @Autowired
    private MappingJackson2HttpMessageConverter jsonConverter;

    @Autowired
    private MappingJackson2XmlHttpMessageConverter xmlConverter;

    @Autowired
    NgsiClient ngsiClient;

    @Inject
    private AsyncRestTemplate asyncRestTemplate;

    private Consumer<NotifyContextResponse> onSuccess = Mockito.mock(Consumer.class);

    private Consumer<Throwable> onFailure = Mockito.mock(Consumer.class);

    @Before
    public void tearUp() {
        this.mockServer = MockRestServiceServer.createServer(asyncRestTemplate);
    }

    @After
    public void tearDown() {
        reset(onSuccess);
        reset(onFailure);
    }

    @Test(expected = HttpServerErrorException.class)
    public void notifyContextRequestWith500() throws Exception {

        mockServer.expect(requestTo(baseUrl+"/ngsi10/notifyContext")).andExpect(method(HttpMethod.POST))
                .andRespond(withStatus(HttpStatus.INTERNAL_SERVER_ERROR));

        ngsiClient.notifyContext(baseUrl, null, createNotifyContextTempSensor(0)).get();
    }

    @Test(expected = HttpClientErrorException.class)
    public void notifyContextRequestWith404() throws Exception {

        mockServer.expect(requestTo(baseUrl+"/ngsi10/notifyContext")).andExpect(method(HttpMethod.POST))
                .andRespond(withStatus(HttpStatus.NOT_FOUND));

        ngsiClient.notifyContext(baseUrl, null, createNotifyContextTempSensor(0)).get();
    }

    @Test
    public void notifyContextRequestOK() throws Exception {

        ngsiClient.protocolRegistry.unregisterHost(baseUrl);

        String responseBody = json(jsonConverter, createNotifyContextResponseTempSensor());

        this.mockServer.expect(requestTo(baseUrl+ "/ngsi10/notifyContext")).andExpect(method(HttpMethod.POST))
                .andExpect(jsonPath("$.subscriptionId").value("1"))
                .andExpect(jsonPath("$.originator").value("http://iotAgent"))
                .andExpect(jsonPath("$.contextResponses[*]", hasSize(1)))
                .andExpect(jsonPath("$.contextResponses[0].contextElement.id").value("S1"))
                .andExpect(jsonPath("$.contextResponses[0].contextElement.type").value("TempSensor"))
                .andExpect(jsonPath("$.contextResponses[0].contextElement.isPattern").value("false"))
                .andExpect(jsonPath("$.contextResponses[0].contextElement.attributes[*]", hasSize(1)))
                .andExpect(jsonPath("$.contextResponses[0].contextElement.attributes[0].name").value("temp"))
                .andExpect(jsonPath("$.contextResponses[0].contextElement.attributes[0].type").value("float"))
                .andExpect(jsonPath("$.contextResponses[0].contextElement.attributes[0].value").value("15.5"))
                .andRespond(withSuccess(responseBody, MediaType.APPLICATION_JSON));

        NotifyContextResponse response = ngsiClient.notifyContext(baseUrl, null, createNotifyContextTempSensor(0)).get();
        this.mockServer.verify();

        Assert.assertEquals(CodeEnum.CODE_200.getLabel(), response.getResponseCode().getCode());
    }

    @Test
    public void notifyContextRequestOK_XML() throws Exception {

        ngsiClient.protocolRegistry.registerHost(baseUrl);

        String responseBody = xml(xmlConverter, createNotifyContextResponseTempSensor());

        this.mockServer.expect(requestTo(baseUrl+ "/ngsi10/notifyContext"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(header("Content-Type", MediaType.APPLICATION_XML_VALUE))
                .andExpect(header("Accept", MediaType.APPLICATION_XML_VALUE))
                .andExpect(xpath("notifyContextRequest/subscriptionId").string("1"))
                .andExpect(xpath("notifyContextRequest/originator").string("http://iotAgent"))
                .andExpect(xpath("notifyContextRequest/contextResponseList/contextElementResponse[*]").nodeCount(1))
                .andExpect(xpath("notifyContextRequest/contextResponseList/contextElementResponse/contextElement/entityId/id").string("S1"))
                .andExpect(xpath("notifyContextRequest/contextResponseList/contextElementResponse/contextElement/entityId/@type").string("TempSensor"))
                .andExpect(xpath("notifyContextRequest/contextResponseList/contextElementResponse/contextElement/entityId/@isPattern").string("false"))
                .andExpect(xpath("notifyContextRequest/contextResponseList/contextElementResponse/contextElement/contextAttributeList/contextAttribute[*]").nodeCount(1))
                .andExpect(xpath("notifyContextRequest/contextResponseList/contextElementResponse/contextElement/contextAttributeList/contextAttribute/name").string("temp"))
                .andExpect(xpath("notifyContextRequest/contextResponseList/contextElementResponse/contextElement/contextAttributeList/contextAttribute/type").string("float"))
                .andExpect(xpath("notifyContextRequest/contextResponseList/contextElementResponse/contextElement/contextAttributeList/contextAttribute/contextValue").string("15.5"))
                .andRespond(withSuccess(responseBody, MediaType.APPLICATION_XML));

        NotifyContextResponse response = ngsiClient.notifyContext(baseUrl, null, createNotifyContextTempSensor(0)).get();
        this.mockServer.verify();

        Assert.assertEquals(CodeEnum.CODE_200.getLabel(), response.getResponseCode().getCode());
    }

    @Test(expected = HttpServerErrorException.class)
    public void notifyContextRequestCustomURLWith500() throws Exception {

        mockServer.expect(requestTo(baseUrl+"/test?p1=v1")).andExpect(method(HttpMethod.POST))
                .andRespond(withStatus(HttpStatus.INTERNAL_SERVER_ERROR));

        ngsiClient.notifyContextCustomURL(baseUrl+"/test?p1=v1", null, createNotifyContextTempSensor(0)).get();
    }

    @Test(expected = HttpClientErrorException.class)
    public void notifyContextRequestCustomURLWith404() throws Exception {

        mockServer.expect(requestTo(baseUrl+"/test?p1=v1")).andExpect(method(HttpMethod.POST))
                .andRespond(withStatus(HttpStatus.NOT_FOUND));

        ngsiClient.notifyContextCustomURL(baseUrl+"/test?p1=v1", null, createNotifyContextTempSensor(0)).get();
    }

    @Test
    public void notifyContextRequestCustomURLOK() throws Exception {

        ngsiClient.protocolRegistry.unregisterHost(baseUrl);

        String responseBody = json(jsonConverter, createNotifyContextResponseTempSensor());

        this.mockServer.expect(requestTo(baseUrl+"/test?p1=v1")).andExpect(method(HttpMethod.POST))
                .andExpect(jsonPath("$.subscriptionId").value("1"))
                .andExpect(jsonPath("$.originator").value("http://iotAgent"))
                .andExpect(jsonPath("$.contextResponses[*]", hasSize(1)))
                .andExpect(jsonPath("$.contextResponses[0].contextElement.id").value("S1"))
                .andExpect(jsonPath("$.contextResponses[0].contextElement.type").value("TempSensor"))
                .andExpect(jsonPath("$.contextResponses[0].contextElement.isPattern").value("false"))
                .andExpect(jsonPath("$.contextResponses[0].contextElement.attributes[*]", hasSize(1)))
                .andExpect(jsonPath("$.contextResponses[0].contextElement.attributes[0].name").value("temp"))
                .andExpect(jsonPath("$.contextResponses[0].contextElement.attributes[0].type").value("float"))
                .andExpect(jsonPath("$.contextResponses[0].contextElement.attributes[0].value").value("15.5"))
                .andRespond(withSuccess(responseBody, MediaType.APPLICATION_JSON));

        NotifyContextResponse response = ngsiClient.notifyContextCustomURL(baseUrl+"/test?p1=v1", null, createNotifyContextTempSensor(0)).get();
        this.mockServer.verify();

        Assert.assertEquals(CodeEnum.CODE_200.getLabel(), response.getResponseCode().getCode());
    }

    @Test
    public void notifyContextRequestCustomURLOK_XML() throws Exception {

        ngsiClient.protocolRegistry.registerHost(baseUrl);

        String responseBody = xml(xmlConverter, createNotifyContextResponseTempSensor());

        this.mockServer.expect(requestTo(baseUrl+"/test?p1=v1"))
                .andExpect(method(HttpMethod.POST))
                .andExpect(header("Content-Type", MediaType.APPLICATION_XML_VALUE))
                .andExpect(header("Accept", MediaType.APPLICATION_XML_VALUE))
                .andExpect(xpath("notifyContextRequest/subscriptionId").string("1"))
                .andExpect(xpath("notifyContextRequest/originator").string("http://iotAgent"))
                .andExpect(xpath("notifyContextRequest/contextResponseList/contextElementResponse[*]").nodeCount(1))
                .andExpect(xpath("notifyContextRequest/contextResponseList/contextElementResponse/contextElement/entityId/id").string("S1"))
                .andExpect(xpath("notifyContextRequest/contextResponseList/contextElementResponse/contextElement/entityId/@type").string("TempSensor"))
                .andExpect(xpath("notifyContextRequest/contextResponseList/contextElementResponse/contextElement/entityId/@isPattern").string("false"))
                .andExpect(xpath("notifyContextRequest/contextResponseList/contextElementResponse/contextElement/contextAttributeList/contextAttribute[*]").nodeCount(1))
                .andExpect(xpath("notifyContextRequest/contextResponseList/contextElementResponse/contextElement/contextAttributeList/contextAttribute/name").string("temp"))
                .andExpect(xpath("notifyContextRequest/contextResponseList/contextElementResponse/contextElement/contextAttributeList/contextAttribute/type").string("float"))
                .andExpect(xpath("notifyContextRequest/contextResponseList/contextElementResponse/contextElement/contextAttributeList/contextAttribute/contextValue").string("15.5"))
                .andRespond(withSuccess(responseBody, MediaType.APPLICATION_XML));

        NotifyContextResponse response = ngsiClient.notifyContextCustomURL(baseUrl+"/test?p1=v1", null, createNotifyContextTempSensor(0)).get();
        this.mockServer.verify();

        Assert.assertEquals(CodeEnum.CODE_200.getLabel(), response.getResponseCode().getCode());
    }
}
