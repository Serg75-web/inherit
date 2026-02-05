import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = {simpleTask, epic, meeting};
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    String[] tasks = {"Купить молоко", "Купить яйца", "Сделать домашнее задание"};
    Todos todos = new Todos();


    @BeforeEach
    public void setUp() {

        // Добавляем несколько задач для тестирования
        todos.add(new SimpleTask(1, "Купить молоко"));
        todos.add(new SimpleTask(2, "Купить яйца"));
        todos.add(new SimpleTask(3, "Сделать домашнее задание"));
        todos.add(new SimpleTask(4, "Купить хлеб"));
    }

    @Test
    public void searchTasksByExactMatch() {
        // Выполняем поиск по точному запросу
        Task[] actual = todos.search("Купить молоко");

        // Ожидаем, что результат будет массивом с одной задачей "Купить молоко"
        Task[] expected = {new SimpleTask(1, "Купить молоко")};

        // Сравниваем ожидаемый и фактический результат
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void searchTasksByPartialMatch() {
        // Выполняем поиск по частичному запросу
        Task[] actual = todos.search("Купить");

        // Ожидаем, что результат будет массивом с задачами "Купить молоко", "Купить яйца" и "Купить хлеб"
        Task[] expected = {
                new SimpleTask(1, "Купить молоко"),
                new SimpleTask(2, "Купить яйца"),
                new SimpleTask(4, "Купить хлеб")
        };

        // Сравниваем ожидаемый и фактический результат
        Assertions.assertArrayEquals(expected, actual);
    }


    @Test
    public void setUp1() {
        // Создаем экземпляр класса Todos
        Todos todos = new Todos();

        // Создаем несколько задач Epic с заголовками
        Epic epic1 = new Epic(1, new String[]{"Learn Java Basics", "OOP"});
        Epic epic2 = new Epic(2, new String[]{"Learn Python", "Python Basics", "Data Science"});
        Epic epic3 = new Epic(3, new String[]{"JavaScript Basics", "Web Development"});

        // Добавляем задачи в список дел
        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);

        // Выполняем поиск по запросу "Java"
        Task[] actual = todos.search("Java");

        // Ожидаем, что результат будет содержать только epic1 и epic3
        Task[] expected = {epic1, epic3};

        // Проверяем, что результат соответствует ожиданиям
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void setUp2() {
        // Создаем экземпляр класса Todos
        Todos todos = new Todos();

        // Создаем несколько задач Epic с заголовками
        Epic epic1 = new Epic(1, new String[]{"Learn Java Basics", "OOP"});
        Epic epic2 = new Epic(2, new String[]{"Learn Python", "Python Basics", "Data Science"});
        Epic epic3 = new Epic(3, new String[]{"JavaScript Basics", "Web Development"});

        // Добавляем задачи в список дел
        todos.add(epic1);
        todos.add(epic2);
        todos.add(epic3);

        // Выполняем поиск по запросу "Anchor"
        Task[] actual = todos.search("Anchor");

        // Ожидаем, что результат будет отсутствовать
        Task[] expected = {};

        // Проверяем, что результат соответствует ожиданиям
        Assertions.assertArrayEquals(expected, actual);
    }

    @BeforeEach
    public void setUp3() {

        // Добавляем несколько задач для тестирования,

    }

//    @Test
//    public void searchMeetingsByExactMatch() {
//        // Создаем экземпляры Meeting
//        Meeting meet1 = new Meeting(1, "Купить молоко", "Выкатка второй версии приложения", "Во вторник после обеда");
//        Meeting meet2 = new Meeting(2, "Купить яйца", "Использование сайта", "Во вторник после обеда");
//        Meeting meet3 = new Meeting(3, "Сделать домашнюю работу", "Уборка", "Во вторник после обеда");
//        Meeting meet4 = new Meeting(4, "Купить хлеб", "Выучить предлоги", "Во вторник после обеда");
//
//        // Добавляем встречи в todos
//        todos.add(meet1);
//        todos.add(meet2);
//        todos.add(meet3);
//        todos.add(meet4);
//
//        // Выполняем поиск по точному запросу
//        Task[] actual = todos.search("Купить молоко");
//
//        // Ожидаем, что результат будет массивом с одной задачей "Купить молоко"
//        Task[] expected = { meet1 };
//
//        // Сравниваем ожидаемый и фактический результат
//        Assertions.assertArrayEquals(expected, actual);
//    }

}



