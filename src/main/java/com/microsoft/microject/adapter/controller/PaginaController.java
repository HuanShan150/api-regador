package com.microsoft.microject.adapter.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PaginaController {

    @GetMapping("/pagina")
    public String exibirPagina() {
        return "rega.html";
    }
} 
    
