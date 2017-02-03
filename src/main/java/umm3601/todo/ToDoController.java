package umm3601.todo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Map;

public class ToDoController {

    private ToDo[] toDos;

    public ToDoController() throws IOException {
        Gson gson = new Gson();
        FileReader reader = new FileReader("src/main/data/todos.json");
        toDos = gson.fromJson(reader, ToDo[].class);
    }

    public ToDo[] listToDos(Map<String, String[]> queryParams) {
        ToDo[] filteredToDos = toDos;

        if (queryParams.containsKey("owner")) {
            String owner = queryParams.get("owner")[0];
            filteredToDos = filterToDosByOwner(filteredToDos, owner);
        }

        return filteredToDos;
    }

    ToDo[] filterToDosByOwner(ToDo[] filteredToDos, String owner) {
        return Arrays.stream(filteredToDos).filter(x -> x.owner.equals(owner)).toArray(ToDo[]::new);
    }

    ToDo[] filterToDosByBodyContents(ToDo[] filteredToDos, String searchString) {
        return Arrays.stream(filteredToDos).filter(x -> x.body.contains(searchString)).toArray(ToDo[]::new);
    }
}