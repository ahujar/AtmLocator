package com.backbase.assignment;

import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.ssl.TrustStrategy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import javax.net.ssl.SSLContext;
import javax.security.cert.X509Certificate;
import java.security.cert.CertificateException;

@SpringBootApplication
@ComponentScan({"com.backbase.assignment.controllers", "com.backbase.assignment.services",
        "com.backbase.assignment.configuration", "com.backbase.assignment.repositories"})
public class AtmLocatorApplication {

    public static void main(String[] args) {
        SpringApplication.run(AtmLocatorApplication.class, args);
    }

    @Bean
    public RestTemplate getRestTemplate() throws Exception {
        TrustStrategy acceptingTrustStrategy;
        acceptingTrustStrategy = new TrustStrategy() {
            @Override
            public boolean isTrusted(java.security.cert.X509Certificate[] chain, String authType) throws CertificateException {
                return true;
            }
        };

        SSLContext sslContext = org.apache.http.ssl.SSLContexts.custom()
                .loadTrustMaterial(null, acceptingTrustStrategy)
                .build();

        SSLConnectionSocketFactory csf = new SSLConnectionSocketFactory(sslContext);

        CloseableHttpClient httpClient = HttpClients.custom()
                .setSSLSocketFactory(csf)
                .build();

        HttpComponentsClientHttpRequestFactory requestFactory =
                new HttpComponentsClientHttpRequestFactory();

        requestFactory.setHttpClient(httpClient);

        RestTemplate restTemplate = new RestTemplate(requestFactory);

        return restTemplate;
    }
}
