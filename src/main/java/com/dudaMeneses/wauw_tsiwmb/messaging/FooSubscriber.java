package com.dudaMeneses.wauw_tsiwmb.messaging;

import com.google.cloud.spring.pubsub.support.BasicAcknowledgeablePubsubMessage;
import com.google.cloud.spring.pubsub.support.GcpPubSubHeaders;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.integration.annotation.ServiceActivator;
import org.springframework.messaging.handler.annotation.Header;
import org.springframework.stereotype.Component;

@Component
public class FooSubscriber {

    private static final Logger log = LoggerFactory.getLogger(FooSubscriber.class);

    @ServiceActivator(inputChannel = "testSubscriptionChannel")
    public void consume(String payload, @Header(GcpPubSubHeaders.ORIGINAL_MESSAGE) BasicAcknowledgeablePubsubMessage message) {
        log.info("Message arrived! Payload: {}", payload);
        message.ack();
    }
}
