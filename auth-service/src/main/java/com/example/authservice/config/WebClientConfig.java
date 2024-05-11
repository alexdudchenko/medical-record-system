package com.example.authservice.config;

import com.example.authservice.service.client.DoctorProfileClient;
import com.example.authservice.service.client.PatientProfileClient;
import io.micrometer.observation.ObservationRegistry;
import lombok.AllArgsConstructor;
import org.springframework.cloud.client.loadbalancer.reactive.LoadBalancedExchangeFilterFunction;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
@AllArgsConstructor
public class WebClientConfig {

    private final LoadBalancedExchangeFilterFunction filterFunction;

    @Bean
    public WebClient profileWebClient() {
        return WebClient.builder()
                .baseUrl("http://user-profile-service")
                .filter(filterFunction)
                .build();
    }

    @Bean
    public HttpServiceProxyFactory httpServiceProxyFactory() {
        return HttpServiceProxyFactory
                .builder()
                .exchangeAdapter(WebClientAdapter.create(profileWebClient()))
                .build();
    }

    @Bean
    public PatientProfileClient patientProfileClient() {
        HttpServiceProxyFactory factory = httpServiceProxyFactory();
        return factory.createClient(PatientProfileClient.class);
    }

    @Bean
    public DoctorProfileClient doctorProfileClient() {
        HttpServiceProxyFactory factory = httpServiceProxyFactory();
        return factory.createClient(DoctorProfileClient.class);
    }
}
