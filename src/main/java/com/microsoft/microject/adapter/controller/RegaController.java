package com.microsoft.microject.adapter.controller;

import com.microsoft.microject.domain.Rega;
import com.microsoft.microject.service.RegaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/regas")
@CrossOrigin(origins = "*")
public class RegaController {

    private final RegaService regaService;

    @Autowired
    public RegaController(RegaService regaService) {
        this.regaService = regaService;
    }

    @PostMapping
    public ResponseEntity<Rega> adicionarRega(@RequestBody Rega rega) {
        Rega novaRega = regaService.adicionarRega(rega);
        return ResponseEntity.ok(novaRega);
    }

    @GetMapping
    public ResponseEntity<List<Rega>> listarRegas() {
        List<Rega> regas = regaService.listarRegas();
        return ResponseEntity.ok(regas);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Rega> encontrarRegaPorId(@PathVariable Long id) {
        Optional<Rega> rega = regaService.encontrarRegaPorId(id);
        return rega.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> removerRega(@PathVariable Long id) {
        regaService.removerRega(id);
        return ResponseEntity.noContent().build();
    }
}
