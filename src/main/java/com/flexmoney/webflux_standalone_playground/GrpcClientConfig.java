package com.flexmoney.webflux_standalone_playground;

import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GrpcClientConfig {

    @Bean
    public ManagedChannel managedChannel() {
        return ManagedChannelBuilder.forAddress("localhost", 9090)
                .usePlaintext()
                .build();
    }

    @Bean
    public LenderServiceGrpc.LenderServiceBlockingStub lenderServiceBlockingStub() {
        return LenderServiceGrpc.newBlockingStub(managedChannel());
    }
}
