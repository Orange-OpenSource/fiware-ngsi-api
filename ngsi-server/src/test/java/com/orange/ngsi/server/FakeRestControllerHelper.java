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

package com.orange.ngsi.server;

import com.orange.ngsi.Util;
import com.orange.ngsi.model.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/i")
public class FakeRestControllerHelper extends NgsiRestBaseController {

    @Override
    protected AppendContextElementResponse appendContextElement(String entityID, AppendContextElement appendContextElement) throws Exception {
        return Util.createAppendContextElementResponseTemperature();
    }

    @Override
    protected UpdateContextElementResponse updateContextElement(String entityID, UpdateContextElement updateContextElement) throws Exception {
        return Util.createUpdateContextElementResponseTemperature();
    }

    @Override
    protected ContextElementResponse getContextElement(String entityID) throws Exception {
        return Util.createContextElementResponseTemperature();
    }

    @Override
    protected StatusCode deleteContextElement(String entityID) throws Exception {
        return new StatusCode(CodeEnum.CODE_200);
    }

    @Override
    protected StatusCode appendContextAttribute(String entityID, String attributeName, UpdateContextAttribute updateContextAttribute) throws Exception {
        return new StatusCode(CodeEnum.CODE_200);
    }

    @Override
    protected StatusCode updateContextAttribute(String entityID, String attributeName, UpdateContextAttribute updateContextElementRequest) throws Exception {
        return new StatusCode(CodeEnum.CODE_200);
    }

    @Override
    protected ContextAttributeResponse getContextAttribute(String entityID, String attributeName) throws Exception {
        return Util.createContextAttributeResponseTemperature();
    }

    @Override
    protected StatusCode deleteContextAttribute(String entityID, String attributeName) throws Exception {
        return new StatusCode(CodeEnum.CODE_200);
    }

    @Override
    protected StatusCode updateContextAttributeValue(String entityID, String attributeName, String valueID, UpdateContextAttribute updateContextElementRequest) throws Exception {
        return new StatusCode(CodeEnum.CODE_200);
    }

    @Override
    protected ContextAttributeResponse getContextAttributeValue(String entityID, String attributeName, String valueID) throws Exception {
        return Util.createContextAttributeResponseTemperature();
    }

    @Override
    protected StatusCode deleteContextAttributeValue(String entityID, String attributeName, String valueID) throws Exception {
        return new StatusCode(CodeEnum.CODE_200);
    }

    @Override
    protected QueryContextResponse getContextEntitiesType(String typeName) throws Exception {
        return Util.createQueryContextResponseTemperature();
    }

    @Override
    protected QueryContextResponse getContextEntitiesType(String typeName, String attributeName) throws Exception {
        return Util.createQueryContextResponseTemperature();
    }

    @Override
    protected SubscribeContextResponse createSubscription(SubscribeContext subscribeContext) throws Exception {
        return Util.createSubscribeContextResponseTemperature();
    }

    @Override
    protected UpdateContextSubscriptionResponse updateSubscription(UpdateContextSubscription updateContextSubscription) throws Exception {
        return Util.createUpdateContextSubscriptionResponseTemperature();
    }

    @Override
    protected UnsubscribeContextResponse deleteSubscription(String subscriptionID) throws Exception {
        return Util.createUnsubscribeContextSubscriptionResponseTemperature();
    }
}
