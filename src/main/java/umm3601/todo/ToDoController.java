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
        return toDos;
    }


}