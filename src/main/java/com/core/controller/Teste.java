package com.core.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/public")
public class Teste {
    
    @GetMapping
    public String teste() {
        return "teste de controller com a rota /public";
    }
}
