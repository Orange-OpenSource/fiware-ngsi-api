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

import com.orange.ngsi.model.*;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/i")
public class FakeControllerHelper extends NgsiBaseController {

    @Override
    protected NotifyContextResponse notifyContext(NotifyContext notify) throws Exception {
        return new NotifyContextResponse();
    }

    @Override
    protected UpdateContextResponse updateContext(UpdateContext update) throws Exception {
        return new UpdateContextResponse();
    }

    @Override
    protected RegisterContextResponse registerContext(RegisterContext register) throws Exception {
        return new RegisterContextResponse();
    }

    @Override
    protected SubscribeContextResponse subscribeContext(SubscribeContext subscribe) throws Exception {
        return new SubscribeContextResponse();
    }

    @Override
    protected UpdateContextSubscriptionResponse updateContextSubscription(UpdateContextSubscription updateContextSubscription) throws Exception {
        return new UpdateContextSubscriptionResponse();
    }

    @Override
    protected UnsubscribeContextResponse unsubscribeContext(final UnsubscribeContext unsubscribe) throws Exception {
        return new UnsubscribeContextResponse();
    }

    @Override
    protected QueryContextResponse queryContext(final QueryContext query) throws Exception {
        return new QueryContextResponse();
    }

}
