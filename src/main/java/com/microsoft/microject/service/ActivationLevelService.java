package com.microsoft.microject.service;

import org.springframework.stereotype.Service;

@Service
public class ActivationLevelService {

    private Double activationLevel = 40.0;

    public Double getActivationLevel() {
        return activationLevel;
    }

    public void setActivationLevel(Double activationLevel) {
        this.activationLevel = activationLevel;
    }
}