import React from 'react'

const Pagination = ({ postsPerPage, totalPosts, paginate }) => {
  const pageNum = []

  for (let i = 1; i <= Math.ceil(totalPosts / postsPerPage); i++) {
    pageNum.push(i)
  }

  return (
    <ul className="pagination">
      {pageNum.map(num => (
        <li key={num} onClick={() => paginate(num)}>
            {num}
        </li>
      ))}
    </ul>
  )
}

export default Pagination