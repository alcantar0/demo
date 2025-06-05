package com.example.demo.service;

import com.example.demo.model.Cliente;
import com.example.demo.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FilaService {

    @Autowired
    private ClienteRepository repo;

    public List<Cliente> listarFila() {
        List<Cliente> fila = repo.findAll();

        fila.sort((c1, c2) -> {

        //< 0: significa que o primeiro valor é menor que o segundo
        // 0: os valores são iguais
        // > 0: o primeiro valor é maior que o segundo
            int comparePrioridade = Integer.compare(c1.getTipo().getPrioridade(), c2.getTipo().getPrioridade());
            if (comparePrioridade != 0) return comparePrioridade;
            return c1.getDataEntrada().compareTo(c2.getDataEntrada());
        });

        return fila;
    }

    public Cliente adicionarNaFila(Cliente cliente) {
        return repo.save(cliente);
    }

    public void atenderProximo() {
        List<Cliente> fila = listarFila();
        if (!fila.isEmpty()) {
            Cliente proximo = fila.get(0);
            System.out.println("Atendendo: " + proximo.getNome() + " (prioridade: " + proximo.getTipo() + ")");
            repo.deleteById(proximo.getId());
        }
    }
}
