package com.alex.dudchenko.auth.service.config;

import com.alex.dudchenko.auth.service.service.client.DoctorProfileClient;
import com.alex.dudchenko.auth.service.service.client.MedicalRecordClient;
import com.alex.dudchenko.auth.service.service.client.PatientProfileClient;
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
    public WebClient medicalRecordWebClient() {
        return WebClient.builder()
                .baseUrl("http://medical-record-service")
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

    @Bean
    public MedicalRecordClient medicalRecordClient() {
        HttpServiceProxyFactory factory = HttpServiceProxyFactory
                .builder()
                .exchangeAdapter(WebClientAdapter.create(medicalRecordWebClient()))
                .build();

        return factory.createClient(MedicalRecordClient.class);
    }
}
