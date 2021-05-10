import React, { useState } from 'react'

const EditTodo = () => {
  const [edit, setEdit] = useState(false)

  const editClick = () => {
    setEdit(!edit)
  }

  return (
    <>
      <button
        className="edit"
        onClick={editClick}
      >
        Edit
      </button>
    </>
  )
}

export default EditTodo