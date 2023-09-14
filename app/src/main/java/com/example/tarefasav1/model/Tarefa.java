package com.example.tarefasav1.model;
public class Tarefa {
    private long id;
    private String descricao;


    public Tarefa(long id, String descricao) {
        this.id = id;
        this.descricao = descricao;
    }

    public long getId() {
        return id;
    }

    public String getDesc() {
        return descricao;
    }


}