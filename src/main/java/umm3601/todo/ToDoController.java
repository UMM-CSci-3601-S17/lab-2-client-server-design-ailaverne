package umm3601.todo;

import com.google.gson.Gson;

import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;
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

        // Ordering
        if (queryParams.containsKey("orderBy")) {
            switch (queryParams.get("orderBy")[0]) {
                case "owner":
                    filteredToDos = orderToDosByOwner(toDos);
                    break;
                case "body":
                    filteredToDos = orderToDosByBody(toDos);
                default:
                    break;
            }
        }

        // Filtering
        if (queryParams.containsKey("owner")) {
            String owner = queryParams.get("owner")[0];
            filteredToDos = filterToDosByOwner(filteredToDos, owner);
        }

        if (queryParams.containsKey("category")) {
            String category = queryParams.get("category")[0];
            filteredToDos = filterToDosByCategory(filteredToDos, category);
        }

        if (queryParams.containsKey("contains")) {
            String searchString = queryParams.get("contains")[0];
            filteredToDos = filterToDosByBodyContents(filteredToDos, searchString);
        }

        if (queryParams.containsKey("status")) {
            String statusString = queryParams.get("status")[0];
            switch (statusString) {
                case "complete":
                    filteredToDos = filterToDosByStatus(filteredToDos, true);
                    break;
                case "incomplete":
                    filteredToDos = filterToDosByStatus(filteredToDos, false);
                    break;
                default:
                    filteredToDos = new ToDo[0];
                    break;
            }
        }

        return filteredToDos;
    }

    ToDo[] filterToDosByOwner(ToDo[] filteredToDos, String owner) {
        return Arrays.stream(filteredToDos).filter(x -> x.owner.equals(owner)).toArray(ToDo[]::new);
    }

    ToDo[] filterToDosByCategory(ToDo[] filteredToDos, String category) {
        return Arrays.stream(filteredToDos).filter(x -> x.category.equals(category)).toArray(ToDo[]::new);
    }


    ToDo[] filterToDosByBodyContents(ToDo[] filteredToDos, String searchString) {
        return Arrays.stream(filteredToDos).filter(x -> x.body.contains(searchString)).toArray(ToDo[]::new);
    }

    ToDo[] filterToDosByStatus(ToDo[] filteredToDos, boolean status) {
        return Arrays.stream(filteredToDos).filter(x -> x.status == status).toArray(ToDo[]::new);
    }

    public ToDo getToDo(String id) {
        return Arrays.stream(toDos).filter(x -> x._id.equals(id)).findFirst().orElse(null);
    }

    ToDo[] orderToDosByOwner(ToDo[] toDos) {
        return  Arrays.stream(toDos).sorted(Comparator.comparing(x -> x.owner)).toArray(ToDo[]::new);
    }

    ToDo[] orderToDosByBody(ToDo[] toDos) {
        return Arrays.stream(toDos).sorted(Comparator.comparing(x -> x.body)).toArray(ToDo[]::new);
    }
}