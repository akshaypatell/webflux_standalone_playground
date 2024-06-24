package com.flexmoney.webflux_standalone_playground;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class LenderController {

    @Autowired
    private LenderServiceClient lenderServiceClient;

    @PostMapping("/getLenderResponses")
    public Map<String, Boolean> getLenderResponses(@RequestBody LenderRequest lenderRequest) {
        return lenderServiceClient.getLenderResponses(lenderRequest.getBankIds(), lenderRequest.getMobile(), lenderRequest.getAmount());
    }
}


@Getter
class LenderRequest {
    private List<String> bankIds;
    private String mobile;
    private String amount;

}
