import React, { useState } from 'react';
import { useDispatch } from 'react-redux';

const Add = ({ addTodo }) => {
  const [input, setInput] = useState('')

  const dispatch = useDispatch()

  const addSubmit = e => {
    e.preventDefault()
    
    console.log(input)
    dispatch(addTodo(input))

    const taskInput = document.getElementById("new-task")
    taskInput.value = ""
    setInput('')
  }

  return (
    <>
      <form onSubmit={addSubmit}>
        <p>
          <label htmlFor="new-task">Add Item</label>
          <input
            id="new-task"
            type="text"
            onChange={e => setInput(e.target.value)}
            required
          />
          <button type="submit">Add</button>
        </p>
      </form>
    </>
  )
}

export default Add