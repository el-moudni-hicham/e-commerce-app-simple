package ma.enset.billingservice.web;

import ma.enset.billingservice.config.ConsulConfig;
import ma.enset.billingservice.config.VaultConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
public class ConfigRestController {
    @Autowired
    ConsulConfig consulConfig;
    @Autowired
    VaultConfig vaultConfig;

    @GetMapping("/allConfig")
    public Map<String, Object> config(){
        return Map.of("consulConfig", consulConfig, "vaultConfig", vaultConfig);
    }
}
