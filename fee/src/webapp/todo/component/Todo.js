import React, { useState } from 'react'
import { useDispatch } from 'react-redux'
import { DeleteTodo } from 'todo'

const Todo = ({ todo, deleteTodo, toggleTodo }) => {
  const dispatch = useDispatch()

  const [edit, setEdit] = useState(false)

  const editClick = () => {
    setEdit(!edit)
  }

  return (
    <>
      <ul id={(todo.done) ? "completed-tasks" : "incomplete-tasks"}>
        {/* <li className="editMode"> */}
        <li className={(edit) ? "editMode" : ""}>
          <input
            type="checkbox"
            onChange={() => dispatch(toggleTodo(todo))}
          />
          <label>{todo.text}</label>
          <input type="text" value={todo.text} />
          <button className="edit" onClick={editClick}>Edit</button>
          <DeleteTodo todo={todo} deleteTodo={deleteTodo} />
        </li>
      </ul>
    </>
  )
}

export default Todo