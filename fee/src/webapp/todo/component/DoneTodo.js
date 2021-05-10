import React from 'react'
import { useDispatch } from 'react-redux'
import { DeleteTodo } from 'todo'

const DoneTodo = ({ doneTodo, deleteTodo, toggleTodo }) => {
  const dispatch = useDispatch()

  return (
    <>
      <ul id="completed-tasks">
        <li>
          <input type="checkbox" onChange={() => dispatch(toggleTodo(doneTodo))} checked />
          <label>{doneTodo.text}</label>
          <input type="text" value={doneTodo.text} />
          <button className="edit">Edit</button>
          <DeleteTodo todo={doneTodo} deleteTodo={deleteTodo} />
        </li>
      </ul>
    </>
  )
}

export default DoneTodo