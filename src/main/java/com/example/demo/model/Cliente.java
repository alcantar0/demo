package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

//Models

@Entity
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    @Enumerated(EnumType.STRING)
    private TipoAtendimento tipo;

    private LocalDateTime dataEntrada = LocalDateTime.now();

    @PrePersist
    public void definirDataEntrada() {
        if (dataEntrada == null) {
            dataEntrada = LocalDateTime.now();
        }
    }
    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TipoAtendimento getTipo() {
        return tipo;
    }

    public void setTipo(TipoAtendimento tipo) {
        this.tipo = tipo;
    }

    public LocalDateTime getDataEntrada() {
        return dataEntrada;
    }

    public void setDataEntrada(LocalDateTime dataEntrada) {
        this.dataEntrada = dataEntrada;
    }
}