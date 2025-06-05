package com.example.demo.controller;

import com.example.demo.model.Cliente;
import com.example.demo.service.FilaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/fila")
@CrossOrigin(origins = "*") // Libera acesso CORS para o frontend
public class FilaController {

    @Autowired
    private FilaService service;

    @GetMapping
    public List<Cliente> listar() {
        return service.listarFila();
    }

    @PostMapping
    public Cliente incluir(@RequestBody Cliente cliente) {
        return service.adicionarNaFila(cliente);
    }

    @DeleteMapping("/atender")
    public void atenderProximo() {
        service.atenderProximo();
    }
}
