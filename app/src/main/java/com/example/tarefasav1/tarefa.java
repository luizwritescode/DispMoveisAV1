package com.example.tarefasav1;
public class tarefa {
    private long id;
    private String descricao;


    public tarefa(long id, String title, String description, long timestamp) {
        this.id = id;
        this.descricao = title;

    }

    public long getId() {
        return id;
    }

    public String getDesc() {
        return descricao;
    }


}