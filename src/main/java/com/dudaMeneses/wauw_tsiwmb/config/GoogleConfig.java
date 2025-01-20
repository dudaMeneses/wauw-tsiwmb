package com.dudaMeneses.wauw_tsiwmb.config;

import com.google.api.gax.core.CredentialsProvider;
import com.google.api.gax.core.NoCredentialsProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GoogleConfig {
    @Bean
    public CredentialsProvider credentialsProvider() {
        return NoCredentialsProvider.create();
    }
}
