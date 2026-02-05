public class Epic extends Task {
    protected int id;
    protected String[] subtasks;

    public Epic(int id, String[] subtasks) {
        super(id); // вызов родительского конструктора
        this.subtasks = subtasks; // сохраняем переданные подзадачи
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public boolean matches(String query) {
        // Проверяем соответствие заголовку подзадач
        for (String subtask : subtasks) {
            if (subtask.toLowerCase().contains(query.toLowerCase())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean matches(String[] subtasks) {
        return false;
    }

    public boolean matches(String[] subtasks, String query) {
        for (String item : subtasks) {
            if (item.equalsIgnoreCase(query)) { // Сравнение без учета регистра
                return true;
            }
        }
        return false;
    }

    public String[] getSubtasks() {
        return subtasks;
    }
}

