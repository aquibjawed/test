public class TodoService{

    public Todo create(String title, String description){
        Todo todo = new Todo();
        todo.title = title;
        todo.description = description;
        return todo;
    }

    /**
     * Creates multiple Todo items from lists of titles and descriptions.
     * @param titles list of todo titles
     * @param descriptions list of todo descriptions
     * @return list of created Todos
     * @throws IllegalArgumentException if input lists are null or have different sizes
     */
    public List<Todo> createTodos(List<String> titles, List<String> descriptions) {
        if (titles == null || descriptions == null) {
            throw new IllegalArgumentException("Input lists cannot be null");
        }
        if (titles.size() != descriptions.size()) {
            throw new IllegalArgumentException("Titles and descriptions must have the same size");
        }
        List<Todo> todos = new ArrayList<>();
        for (int i = 0; i < titles.size(); i++) {
            todos.add(create(titles.get(i), descriptions.get(i)));
        }
        return todos;
    }


}