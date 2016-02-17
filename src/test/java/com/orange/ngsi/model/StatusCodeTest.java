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

import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for StatusCode
 */
public class StatusCodeTest {

    @Test
    public void createStatusCode200(){
        StatusCode statusCode = new StatusCode(CodeEnum.CODE_200);
        Assert.assertEquals(CodeEnum.CODE_200.getLabel(),statusCode.getCode());
        Assert.assertEquals(CodeEnum.CODE_200.getShortPhrase(),statusCode.getReasonPhrase());
        Assert.assertEquals(CodeEnum.CODE_200.getLongPhrase(),statusCode.getDetail());
    }

    @Test
    public void createStatusCode400(){
        StatusCode statusCode = new StatusCode(CodeEnum.CODE_400);
        Assert.assertEquals(CodeEnum.CODE_400.getLabel(),statusCode.getCode());
        Assert.assertEquals(CodeEnum.CODE_400.getShortPhrase(),statusCode.getReasonPhrase());
        Assert.assertEquals(CodeEnum.CODE_400.getLongPhrase(),statusCode.getDetail());
    }

    @Test
    public void createStatusCode403(){
        StatusCode statusCode = new StatusCode(CodeEnum.CODE_403);
        Assert.assertEquals(CodeEnum.CODE_403.getLabel(),statusCode.getCode());
        Assert.assertEquals(CodeEnum.CODE_403.getShortPhrase(),statusCode.getReasonPhrase());
        Assert.assertEquals(CodeEnum.CODE_403.getLongPhrase(),statusCode.getDetail());
    }

    @Test
    public void createStatusCode404(){
        StatusCode statusCode = new StatusCode(CodeEnum.CODE_404,"temp");
        Assert.assertEquals(CodeEnum.CODE_404.getLabel(),statusCode.getCode());
        Assert.assertEquals(CodeEnum.CODE_404.getShortPhrase(),statusCode.getReasonPhrase());
        Assert.assertTrue(statusCode.getDetail().contains("temp"));
    }

    @Test
    public void createStatusCode470(){
        StatusCode statusCode = new StatusCode(CodeEnum.CODE_470,"124578");
        Assert.assertEquals(CodeEnum.CODE_470.getLabel(),statusCode.getCode());
        Assert.assertEquals(CodeEnum.CODE_470.getShortPhrase(),statusCode.getReasonPhrase());
        Assert.assertTrue(statusCode.getDetail().contains("124578"));
    }

    @Test
    public void createStatusCode471(){
        StatusCode statusCode = new StatusCode(CodeEnum.CODE_471, "updateAction", "UpdateAction");
        Assert.assertEquals(CodeEnum.CODE_471.getLabel(),statusCode.getCode());
        Assert.assertEquals(CodeEnum.CODE_471.getShortPhrase(),statusCode.getReasonPhrase());
        Assert.assertTrue(statusCode.getDetail().contains("updateAction"));
        Assert.assertTrue(statusCode.getDetail().contains("UpdateAction"));
    }

    @Test
    public void createStatusCode472(){
        StatusCode statusCode = new StatusCode(CodeEnum.CODE_472, "updateAction");
        Assert.assertEquals(CodeEnum.CODE_472.getLabel(),statusCode.getCode());
        Assert.assertEquals(CodeEnum.CODE_472.getShortPhrase(),statusCode.getReasonPhrase());
        Assert.assertTrue(statusCode.getDetail().contains("updateAction"));
    }

    @Test
    public void createStatusCode473(){
        StatusCode statusCode = new StatusCode(CodeEnum.CODE_473);
        Assert.assertEquals(CodeEnum.CODE_473.getLabel(),statusCode.getCode());
        Assert.assertEquals(CodeEnum.CODE_473.getShortPhrase(),statusCode.getReasonPhrase());
        Assert.assertEquals(CodeEnum.CODE_473.getLongPhrase(),statusCode.getDetail());
    }

    @Test
    public void createStatusCode480(){
        StatusCode statusCode = new StatusCode(CodeEnum.CODE_480, "S*", "S1");
        Assert.assertEquals(CodeEnum.CODE_480.getLabel(),statusCode.getCode());
        Assert.assertEquals(CodeEnum.CODE_480.getShortPhrase(),statusCode.getReasonPhrase());
        Assert.assertTrue(statusCode.getDetail().contains("S*"));
        Assert.assertTrue(statusCode.getDetail().contains("S1"));
    }

    @Test
    public void createStatusCode481(){
        StatusCode statusCode = new StatusCode(CodeEnum.CODE_481, "Temperature");
        Assert.assertEquals(CodeEnum.CODE_481.getLabel(),statusCode.getCode());
        Assert.assertEquals(CodeEnum.CODE_481.getShortPhrase(),statusCode.getReasonPhrase());
        Assert.assertTrue(statusCode.getDetail().contains("Temperature"));
    }

    @Test
    public void createStatusCode482(){
        StatusCode statusCode = new StatusCode(CodeEnum.CODE_482);
        Assert.assertEquals(CodeEnum.CODE_482.getLabel(),statusCode.getCode());
        Assert.assertEquals(CodeEnum.CODE_482.getShortPhrase(),statusCode.getReasonPhrase());
        Assert.assertEquals(CodeEnum.CODE_482.getLongPhrase(),statusCode.getDetail());
    }

    @Test
    public void createStatusCode500(){
        StatusCode statusCode = new StatusCode(CodeEnum.CODE_500);
        Assert.assertEquals(CodeEnum.CODE_500.getLabel(),statusCode.getCode());
        Assert.assertEquals(CodeEnum.CODE_500.getShortPhrase(),statusCode.getReasonPhrase());
        Assert.assertEquals(CodeEnum.CODE_500.getLongPhrase(),statusCode.getDetail());
    }
}
