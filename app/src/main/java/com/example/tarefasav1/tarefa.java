package com.example.tarefasav1;
public class tarefa {
    private long id;
    private String descricao;


    public tarefa(long id, String descricao) {
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