package com.microsoft.microject.adapter.controller;

import com.microsoft.microject.service.ActivationLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class ActivationLevelController {

    private final ActivationLevelService activationLevelService;

    @Autowired
    public ActivationLevelController(ActivationLevelService activationLevelService) {
        this.activationLevelService = activationLevelService;
    }

    @GetMapping("/activation-level")
    public String getActivationLevel() {
        Double level = activationLevelService.getActivationLevel();
        return level.toString();
    }

    @PostMapping("/activation-level")
    public String setActivationLevel(@RequestBody Map<String, Double> payload) {
        Double level = payload.get("level");
        if (level != null) {
            activationLevelService.setActivationLevel(level);
            return level.toString();
        } else {
            throw new IllegalArgumentException("Nível de ativação não fornecido.");
        }
    }
}
