package com.microsoft.microject.service;

import com.microsoft.microject.domain.Rega;
import com.microsoft.microject.repository.RegaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RegaService {

    private final RegaRepository regaRepository;

    @Autowired
    public RegaService(RegaRepository regaRepository) {
        this.regaRepository = regaRepository;
    }

    public Rega adicionarRega(Rega rega) {
        return regaRepository.save(rega);
    }

    public List<Rega> listarRegas() {
        return regaRepository.findAll();
    }

    public Optional<Rega> encontrarRegaPorId(Long id) {
        return regaRepository.findById(id);
    }

    public void removerRega(Long id) {
        regaRepository.deleteById(id);
    }
}
