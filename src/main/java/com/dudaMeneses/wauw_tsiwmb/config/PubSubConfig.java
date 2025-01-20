package com.dudaMeneses.wauw_tsiwmb.config;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import com.google.cloud.spring.pubsub.PubSubAdmin;
import com.google.cloud.spring.pubsub.core.PubSubTemplate;
import com.google.cloud.spring.pubsub.integration.AckMode;
import com.google.cloud.spring.pubsub.integration.inbound.PubSubInboundChannelAdapter;
import com.google.pubsub.v1.Subscription;
import com.google.pubsub.v1.Topic;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.integration.channel.PublishSubscribeChannel;
import org.springframework.messaging.MessageChannel;

@Configuration
@ConditionalOnProperty(value = "spring.cloud.gcp.pubsub.enabled", havingValue = "true")
public class PubSubConfig {

    @Bean
    public MessageChannel testSubscriptionChannel() {
        return new PublishSubscribeChannel();
    }

    @Bean
    public PubSubInboundChannelAdapter inboundChannelAdapter(
            MessageChannel testSubscriptionChannel,
            PubSubTemplate pubSubTemplate) {
        PubSubInboundChannelAdapter adapter = new PubSubInboundChannelAdapter(pubSubTemplate, "test-subscription");
        adapter.setOutputChannel(testSubscriptionChannel);
        adapter.setAckMode(AckMode.MANUAL);
        adapter.setPayloadType(String.class);
        return adapter;
    }

    @Bean
    public Topic fooTopic(PubSubAdmin pubSubAdmin) {
        Topic topic = pubSubAdmin.getTopic("test-topic");

        if (topic != null) {
            return topic;
        } else {
            return pubSubAdmin.createTopic("test-topic");
        }
    }

    @Bean
    public Subscription createSubscription(PubSubAdmin pubSubAdmin, Topic fooTopic) {
        Subscription subscription = pubSubAdmin.getSubscription("test-subscription");

        if (subscription != null) {
            return subscription;
        } else {
            return pubSubAdmin.createSubscription("test-subscription", fooTopic.getName());
        }
    }
}
