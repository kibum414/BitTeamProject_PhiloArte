import React from 'react'
import { useDispatch } from 'react-redux'
import { Todo, DoneTodo } from 'todo'

const Todos = ({ todos, doneTodos, deleteTodo, deleteAllTodo, toggleTodo }) => {
  const dispatch = useDispatch()

  return (
    <>
      <h3>Todo</h3>
      <button
        className="delete-all-btn"
        onClick={() => dispatch(deleteAllTodo(todos))}
      >
        Delete All
      </button>
      {
        todos.map(todo => (
          <Todo
            key={todo.id}
            todo={todo}
            deleteTodo={deleteTodo}
            toggleTodo={toggleTodo}
          />
        ))
      }
      <h3>Completed</h3>
      <button
        className="delete-all-btn"
        onClick={() => dispatch(deleteAllTodo(doneTodos))}
      >
        Delete All
      </button>
      {
        doneTodos.map(doneTodo => (
          <DoneTodo
            key={doneTodo.id}
            doneTodo={doneTodo}
            deleteTodo={deleteTodo}
            toggleTodo={toggleTodo}
          />
        ))
      }
        
        
        {/* <li>
          <input type="checkbox" />
          <label>Pay Bills</label>
          <input type="text" />
          <button className="edit">Edit</button>
          <button className="delete">Delete</button>
        </li>
        {
          todos.map((todo, id) => {
            return (
              <li className="editMode" key={id}>
                <input type="checkbox" />
                <label>{todo.text}</label>
                <input type="text" value={todo.text} />
                <button className="edit" >Edit</button>
                <button className="delete" >Delete</button>
              </li>
            )
          })
        } */}
    </>
  )
}

export default Todos