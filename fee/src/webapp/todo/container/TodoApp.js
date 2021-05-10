import { Header, Footer } from 'common';
import React from 'react'
import { useSelector } from 'react-redux';
import { AddTodo, Todos } from 'todo';
import { addTodo, deleteTodo, deleteAllTodo, toggleTodo } from 'todo/reducer/todo.reducer'
import 'todo/style/Todo.css'

const TodoApp = () => {
  const todos = useSelector(state => state.todoSlice.todoList)
  const doneTodos = useSelector(state => state.todoSlice.doneTodoList)
  
  return (
    <>
      <Header />
      <div className="todo-form">
        <h1>Todo</h1>
        <div className="todo-container">
          <AddTodo addTodo={addTodo} />
          <Todos
            todos={todos}
            doneTodos={doneTodos}
            deleteTodo={deleteTodo}
            deleteAllTodo={deleteAllTodo}
            toggleTodo={toggleTodo}
          />
        </div>
      </div>
      <Footer />
    </>
  )
}

export default TodoApp