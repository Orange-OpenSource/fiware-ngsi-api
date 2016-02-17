# FIWARE NGSI v1 API

[![Build Status](https://travis-ci.org/Orange-OpenSource/fiware-ngsi-api.svg?branch=master)](https://travis-ci.org/Orange-OpenSource/fiware-ngsi-api)
[![Coverity Scan Status](https://scan.coverity.com/projects/7972/badge.svg)](https://scan.coverity.com/projects/7972)
[![Coverage Status](https://coveralls.io/repos/github/Orange-OpenSource/fiware-ngsi-api/badge.svg?branch=master)](https://coveralls.io/github/Orange-OpenSource/fiware-ngsi-api?branch=master)
[![Apache Version 2 Licence](https://img.shields.io/badge/License-Apache%20Version%202-blue.svg)](LICENSE.txt)

This project is the library of the [NGSI v1 API](http://forge.fiware.org/plugins/mediawiki/wiki/fiware/index.php/FI-WARE_NGSI:_publicly_available_documents)

This library was originally created for the [Fiware-Cepheus](https://github.com/Orange-OpenSource/fiware-cepheus) project
and the original version is still available [here](https://github.com/Orange-OpenSource/fiware-cepheus/tree/0.1.5/cepheus-ngsi)
under the GPLv2 Licence.

A library implementing [NGSI v2 API](http://telefonicaid.github.io/fiware-orion/api/v2/) can be found
at [Orange-OpenSource/fiware-ngsi2-api](https://github.com/Orange-OpenSource/fiware-ngsi2-api)

## Usage

### From Maven

```xml
<dependency>
    <groupId>com.orange.cepheus</groupId>
    <artifactId>cepheus-ngsi</artifactId>
    <version>X.Y.Z</version>
</dependency>
```

For java 7, you must add the classifier:

```xml
<dependency>
   <groupId>com.orange.cepheus</groupId>
   <artifactId>cepheus-ngsi</artifactId>
   <classifier>java7</classifier>
    <version>X.Y.Z</version>
</dependency>
```

where `X.Y.Z` is the version of the library to use (check git tags).

### Download the jar from [Sonatype Central repository](http://central.sonatype.org/) using wget

If you don't have `maven` installed on your machine, you can still download the standalone JAR using `wget` or any browser:

    wget -O cepheus-ngsi.jar "https://oss.sonatype.org/service/local/artifact/maven/redirect?r=snapshots&g=com.orange.cepheus&a=cepheus-ngsi&v=LATEST"

## Client

The implementation provides the `NgsiClient class for the standard operations
and the `NgsiRestClient` class for the convenient REST operations.

The client uses `ListenableFuture` to handle requests synchronously or asynchronously.

Example: to send a synchronous updateContext

```java
    @Autowired
    NgsiClient ngsiClient;

    /* [...] */

    UpdateContext update = new UpdateContext();
    // [...] add context information

    ngsiClient.updateContext(providerUrl, httpHeaders, update).get();
```

Example: to send an asynchronous updateContext

```java
    ngsiClient.updateContext(brokerUrl, httpHeaders, update)
              .addCallback(updateContextResponse -> logUpdateContextResponse(updateContextResponse, brokerUrl),
                       throwable -> logger.warn("UpdateContext failed for {}: {}", brokerUrl, throwable.toString()));
```

## Server

The implementation provides the NgsiBaseController class that is a controller class for the standard operations and
the NgsiRestBaseController class used for the convenient REST operations.
The two classes validate the specification rules and return errors if an exception is thrown.

Your controller class must override the methods you want to implement.
By default the methods return an error "not implemented operation".

```java
    public class MyNgsiController extends NgsiBaseController {
        @Override
        public UpdateContextResponse updateContext(final UpdateContext update) throws Exception {
            // implement updateContext
        }
    }
```

and

```java
    public class NgsiRestController extends NgsiRestBaseController {
        @Override
        protected AppendContextElementResponse appendContextElement(String entityID, AppendContextElement appendContextElement) throws Exception {
                    // implement appendContextElement
        }
    }
```

## License

This project is under the Apache License version 2.0
