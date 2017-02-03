package umm3601.todo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;

public class FilterToDoListSpec {

    ToDoController toDoController;
    ToDo[] allToDos;

    @Before
    public void initialize() throws IOException{
        toDoController = new ToDoController();
        allToDos = toDoController.listToDos(new HashMap<>());
    }

    @Test
    public void filterToDosByOwner() {
        ToDo[] ownerBarry = toDoController.filterToDosByOwner(allToDos, "Barry");
        assertEquals("Incorrect number of to-dos with owner Barry", 51, ownerBarry.length);
        ToDo[] ownerBlanche = toDoController.filterToDosByOwner(allToDos, "Blanche");
        assertEquals("Incorrect number of to-dos with owner Blanche", 43, ownerBlanche.length);
    }

    @Test
    public void filterToDosByCategory() {
        ToDo[] categoryHomework = toDoController.filterToDosByCategory(allToDos, "homework");
        assertEquals("Incorrect number of to-dos with category homework", 79, categoryHomework.length);
        ToDo[] categoryVideoGames = toDoController.filterToDosByCategory(allToDos, "video games");
        assertEquals("Incorrect number of to-dos with category video games", 71, categoryVideoGames.length);
    }

    @Test
    public void filterToDosByBodyContents() {
        ToDo[] bodyHasNisi = toDoController.filterToDosByBodyContents(allToDos, "nisi");
        assertEquals("Incorrect number of to-dos with \"nisi\" in the body", 77, bodyHasNisi.length);
        ToDo[] bodyHasReprehenderit = toDoController.filterToDosByBodyContents(allToDos, "Reprehenderit");
        assertEquals("Incorrect number of to-dos with \"Reprehenderit\" in the body", 14, bodyHasReprehenderit.length);
    }

}
