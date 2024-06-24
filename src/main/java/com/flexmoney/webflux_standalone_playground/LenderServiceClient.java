package com.flexmoney.webflux_standalone_playground;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class LenderServiceClient {

    private final LenderServiceGrpc.LenderServiceBlockingStub lenderServiceBlockingStub;

    public LenderServiceClient(LenderServiceGrpc.LenderServiceBlockingStub lenderServiceBlockingStub) {
        this.lenderServiceBlockingStub = lenderServiceBlockingStub;
    }

    public Map<String, Boolean> getLenderResponses(List<String> bankIds, String mobile, String amount) {
        LenderServiceProto.CERequest request = LenderServiceProto.CERequest.newBuilder()
                .addAllBankIds(bankIds)
                .setMobile(mobile)
                .setAmount(amount)
                .build();

        LenderServiceProto.LenderResponse response = lenderServiceBlockingStub.getLenderResponses(request);
        System.out.println(response.getResponsesMap());
        return response.getResponsesMap();
    }
}
