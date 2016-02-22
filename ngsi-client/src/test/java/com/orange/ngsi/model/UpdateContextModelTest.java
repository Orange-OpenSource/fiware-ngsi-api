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
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.junit.Test;
import org.xml.sax.InputSource;

import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;
import java.io.IOException;
import java.io.StringReader;
import java.net.URISyntaxException;

import static com.orange.ngsi.Util.createUpdateContextTempSensor;
import static org.junit.Assert.assertEquals;

/**
 * Created by pborscia on 17/09/2015.
 */
public class UpdateContextModelTest {

    private ObjectMapper xmlmapper = new XmlMapper();

    @Test
    public void serializationXML() throws IOException, URISyntaxException, XPathExpressionException {

        String xml = xmlmapper.writeValueAsString(createUpdateContextTempSensor(0));

        String xpathExpr = "/updateContextRequest/contextElementList/contextElement[1]/entityId/id";
        XPath xPath = XPathFactory.newInstance().newXPath();
        String value = xPath.evaluate(xpathExpr, new InputSource(new StringReader(xml)));
        assertEquals("S1", value);
    }

}
