//package tasks;
//
//import org.junit.Before;
//import org.junit.Test;
//import static org.junit.Assert.assertEquals;
//
//import java.util.ArrayList;
//
//public class TaskTests {
//
//    private Task task;
//    private ArrayList<Task> listOfTasks;
//    private Session session;
//
//    @Before
//    public void setUp() {
//        task = new DefaultTask("1 + 1", "2");
//        listOfTasks = new ArrayList<>();
//        listOfTasks.add(task);
//        session = new Session(10, listOfTasks);
//    }
//
//    @Test
//    public void testCreateSession() {
//        Session createdSession = Session.createSession(10, listOfTasks);
//        assertEquals(session, createdSession);
//    }
//
//    @Test
//    public void testNextTask(){
//        Task next = session.nextTask();
//        assertEquals(next, task);
//    }
//}
