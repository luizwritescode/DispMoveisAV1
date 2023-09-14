public class tarefa {
    private long id;
    private String title;


    public tarefa(long id, String title, String description, long timestamp) {
        this.id = id;
        this.title = title;

    }

    public long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }


}