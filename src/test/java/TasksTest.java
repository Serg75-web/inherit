import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class TasksTest {

    Meeting meeting = new Meeting(
            555,
            "Выкатка 3й версии приложения",
            "Приложение НетоБанка",
            "Во вторник после обеда"

    );

    @Test
    public void queryInTopic() {


        boolean actual = meeting.matches("Выкатка");
        boolean expected = true;


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryInProject() {


        boolean actual = meeting.matches("Приложение");
        boolean expected = true;


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryNotInTopic() {


        boolean actual = meeting.matches("вторник");
        boolean expected = false;


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryNotInProject() {


        boolean actual = meeting.matches("вторник");
        boolean expected = false;


        Assertions.assertEquals(expected, actual);
    }

    String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
    Epic epic = new Epic(55, subtasks);

    @Test
    public void queryInSubtasks() {

        boolean actual = epic.matches(subtasks, "Яйца");
        boolean expected = true;

        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryNotInSubtasks() {

        boolean actual = epic.matches(subtasks, "Рыба");
        boolean expected = false;

        Assertions.assertEquals(expected, actual);
    }

    SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

    @Test
    public void queryInTitle() {


        boolean actual = simpleTask.matches("Позвонить");
        boolean expected = true;


        Assertions.assertEquals(expected, actual);
    }

    @Test
    public void queryNotInTitle() {


        boolean actual = simpleTask.matches("Хлеб");
        boolean expected = false;


        Assertions.assertEquals(expected, actual);
    }

}
