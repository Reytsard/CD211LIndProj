package prelims.reqFive;

class TodoItem {
    private String description;
    private int priority;

    public TodoItem(String description, int priority) {
        this.description = description;
        this.priority = priority;
    }

    public String getDescription() {
        return description;
    }

    public int getPriority() {
        return priority;
    }
}
