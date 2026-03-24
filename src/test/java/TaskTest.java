import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TaskTest {
    @Test
    public void testSimpleTaskMatchesSuccess() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Assertions.assertTrue(simpleTask.matches("родителям"));
    }

    @Test
    public void testSimpleTaskMatchesFailed() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        Assertions.assertFalse(simpleTask.matches("работа"));
    }

    @Test
    public void testEpicMatchesSuccess() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Assertions.assertTrue(epic.matches("Яйца"));
    }

    @Test
    public void testEpicMatchesFailed() {
        String[] subtasks = {"Молоко", "Яйца", "Хлеб"};
        Epic epic = new Epic(55, subtasks);

        Assertions.assertFalse(epic.matches("Мясо"));
    }

    @Test
    public void testMeetingMatchesSuccess1() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии", "Приложение НетоБанка", "Во вторник");

        Assertions.assertTrue(meeting.matches("Выкатка"));
    }

    @Test
    public void testMeetingMatchesSuccess2() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии", "Приложение НетоБанка", "Во вторник");

        Assertions.assertTrue(meeting.matches("НетоБанка"));
    }

    @Test
    public void testMeetingMatchesFailed() {
        Meeting meeting = new Meeting(555, "Выкатка 3й версии", "Приложение НетоБанка", "Во вторник");

        Assertions.assertFalse(meeting.matches("Пятница"));
    }
}
