public class TodoService{

    public Todo create(String title, String description){
        Todo todo = new Todo();
        todo.title = title;
        todo.description = description;
        return todo;
    }

    public List<Todo> createTodos(List<String> titles, List<String> descriptions){
        titles.foreach( title-> {
            create(title, descriptions.get(0))
        } )
    }


}