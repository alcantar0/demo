package com.example.demo.model;

public enum TipoAtendimento {
    GESTANTE(1),
    IDOSO(1),
    DEFICIENCIA(1),
    ENCAMINHADO_MEDICO(2),
    GERAL(3);

    private final int prioridade;

    //Construtor
    TipoAtendimento(int prioridade) {
        this.prioridade = prioridade;
    }

    public int getPrioridade() {
        return prioridade;
    }

}