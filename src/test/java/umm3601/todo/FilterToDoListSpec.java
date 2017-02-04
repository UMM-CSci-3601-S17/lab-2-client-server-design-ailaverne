package umm3601.todo;

import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertNull;

public class FilterToDoListSpec {

    private ToDoController toDoController;
    private ToDo[] allToDos;

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

    @Test
    public void filterToDosByStatus() {
        ToDo[] statusComplete = toDoController.filterToDosByStatus(allToDos, true);
        assertEquals("Incorrect number of to-dos with status complete", 143, statusComplete.length);
        ToDo[] statusIncomplete = toDoController.filterToDosByStatus(allToDos, false);
        assertEquals("Incorrect number of to-dos with status incomplete", 157, statusIncomplete.length);
    }

    @Test
    public void selectToDoByID() {
        ToDo id0 = toDoController.getToDo("58895985186754887e0381f5");
        assertEquals("Wrong owner", "Blanche", id0.owner);
        assertEquals("Wrong ID", "58895985186754887e0381f5", id0._id);
        assertEquals("Wrong status", true, id0.status);
        assertEquals("Wrong category", "software design", id0.category);

        ToDo id1 = toDoController.getToDo("8895985186754887e0381f9");
        assertNull(id1);
    }

    @Test
    public void limitToDo() {
        ToDo[] returns5Elements = toDoController.limitToDos(allToDos,5);
        assertEquals("Wrong number of to-dos returned", 5, returns5Elements.length);
        ToDo[] returns10Elements = toDoController.limitToDos(allToDos,10);
        assertEquals("Wrong number of to-dos returned", 10, returns10Elements.length);
    }

}
