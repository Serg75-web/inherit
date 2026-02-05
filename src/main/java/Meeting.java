public class Meeting extends Task {
    protected int id;
    protected String topic;
    protected String project;
    protected String start;

    public Meeting(int id, String topic, String project, String start) {
        super(id); // вызов родительского конструктора
        this.topic = topic; // инициализация поля topic
        this.project = project; // инициализация поля project
        this.start = start; // инициализация поля start
    }

    @Override
    public int getId() {
        return id;
    }

    public String getTopic() {
        return topic;
    }

    public String getProject() {
        return project;
    }

    public String getStart() {
        return start;
    }

    @Override
    public boolean matches(String query) {


        if (topic.contains(query)) {
            return true;
        }
        if (project.contains(query)) {
            return true;
        }
        return false;
    }

    @Override
    public boolean matches(String[] subtasks) {
        return false;
    }

    @Override
    public boolean matches(String[] subtasks, String target) {
        return false;
    }


}




