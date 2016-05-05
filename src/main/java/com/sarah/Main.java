package com.sarah;


import com.google.gson.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


class Todo {
    private String body;
    private boolean done;
    private int id;
    private int priority;
    private String title;

    public String toString() {
        return title + ", " + body + ", " + id + ", " + priority + ", " + done;
    }
}

class TodoCollection extends HashMap<String, Todo[]> {}
//class TodoCollection implements Iterable<Todo>{
//    private List<Todo> todos;
//
//
//    @Override
//    public Iterator<Todo> iterator() {
//        return todos.iterator();
//    }
//}

public class Main {
    public static void main(String[] args){
        String jsonData = "{\n" +
                "  \"todos\": [\n" +
                "    {\n" +
                "      \"body\": \"Walk the dog\",\n" +
                "      \"done\": false,\n" +
                "      \"id\": 0,\n" +
                "      \"priority\": 3,\n" +
                "      \"title\": \"dog\"\n" +
                "    },\n" +
                "    {\n" +
                "      \"body\": \"Pay the bills\",\n" +
                "      \"done\": false,\n" +
                "      \"id\": 1,\n" +
                "      \"priority\": 1,\n" +
                "      \"title\": \"bills\"\n" +
                "    }\n" +
                "  ]\n" +
                "}";


        Gson gson = new Gson();
        TodoCollection todos = gson.fromJson(jsonData, TodoCollection.class);
//        for(Todo todoItem: todos) {
//            System.out.println(todoItem);
//        }
        for (String key: todos.keySet()) {
            Todo[] todoArray = todos.get(key);
            for (Todo todoItem: todoArray) {
                System.out.println(todoItem);
            }
        }

        String reserialization = gson.toJson(todos);
        System.out.println(reserialization);
    }


}
