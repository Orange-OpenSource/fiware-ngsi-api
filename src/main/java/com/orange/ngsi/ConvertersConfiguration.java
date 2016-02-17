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

import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonSerializer;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializerProvider;
import com.fasterxml.jackson.databind.module.SimpleModule;
import com.orange.ngsi.model.AppendContextElementResponse;
import com.orange.ngsi.model.ContextElement;
import com.orange.ngsi.model.EntityIdMixIn;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

import java.io.IOException;


/**
 * Configure Converter for serialization and deserialization json
 */
@Configuration
public class ConvertersConfiguration {

    @Bean
    public MappingJackson2HttpMessageConverter jsonV1Converter(ObjectMapper objectMapper) {

        // Serialize numbers as strings
        objectMapper.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);

        // Serialize booleans as strings
        SimpleModule booleanAsString = new SimpleModule("BooleanAsString");
        booleanAsString.addSerializer(Boolean.class, new JsonSerializer<Boolean>() {
            @Override public void serialize(Boolean value, JsonGenerator jgen, SerializerProvider provider)
                    throws IOException, JsonProcessingException {
                jgen.writeString(value.toString());

            }
        });
        objectMapper.registerModule(booleanAsString);

        objectMapper.addMixIn(ContextElement.class, EntityIdMixIn.class);
        objectMapper.addMixIn(AppendContextElementResponse.class, EntityIdMixIn.class);

        return new MappingJackson2HttpMessageConverter(objectMapper);
    }



}
