package umm3601.todo;

import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterToDoListSpec {

    @Test
    public void filterToDosByOwner() throws IOException {
        ToDoController toDoController = new ToDoController();
        ToDo[] allToDos = toDoController.listToDos(new HashMap<>());
        ToDo[] ownerBarry = toDoController.filterToDosByOwner(allToDos, "Barry");
        assertEquals("Incorrect number of to-dos with owner Barry", 51, ownerBarry.length);
        ToDo[] ownerBlanche = toDoController.filterToDosByOwner(allToDos, "Blanche");
        assertEquals("Incorrect number of to-dos with owner Blanche", 43, ownerBlanche.length);
    }

    @Test
    public void filterToDosByBodyContents() throws IOException {
        ToDoController toDoController = new ToDoController();
        ToDo[] allToDos = toDoController.listToDos(new HashMap<>());
        ToDo[] bodyHasNisi = toDoController.filterToDosByBodyContents(allToDos, "nisi");
        assertEquals("Incorrect number of to-dos with \"nisi\" in the body", 77, bodyHasNisi.length);
        ToDo[] bodyHasReprehenderit = toDoController.filterToDosByBodyContents(allToDos, "Reprehenderit");
        assertEquals("Incorrect number of to-dos with \"Reprehenderit\" in the body", 14, bodyHasReprehenderit.length);
    }

}
