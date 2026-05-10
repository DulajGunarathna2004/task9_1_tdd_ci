package ontrack;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class TaskStatusCheckerTest {

    @Test
    public void testPendingReviewTaskStatus() {
        TaskStatusChecker checker = new TaskStatusChecker();

        String result = checker.getTaskStatus("s225098078", "task9.1");

        String expected = "Task: TDD and CI\n" +
                          "Status: Pending Review\n" +
                          "Message: Waiting for tutor feedback";

        assertEquals(expected, result);
    }

    @Test
    public void testCompletedTaskStatus() {
        TaskStatusChecker checker = new TaskStatusChecker();

        String result = checker.getTaskStatus("s225098078", "task8.1");

        String expected = "Task: Unit Testing\n" +
                          "Status: Completed\n" +
                          "Message: Good work";

        assertEquals(expected, result);
    }

    @Test
    public void testUnknownTask() {
        TaskStatusChecker checker = new TaskStatusChecker();

        String result = checker.getTaskStatus("s225098078", "task1.1");

        assertEquals("Task not found", result);
    }
}