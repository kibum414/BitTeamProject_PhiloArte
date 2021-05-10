import React from 'react'
import { useDispatch } from 'react-redux'

const DeleteTodo = ({ todo, deleteTodo }) => {
  const dispatch = useDispatch()

  return (
    <>
      <button
        className="delete"
        onClick={() => dispatch(deleteTodo(todo))}
      >
        Delete
      </button>
    </>
  )
}

export default DeleteTodo