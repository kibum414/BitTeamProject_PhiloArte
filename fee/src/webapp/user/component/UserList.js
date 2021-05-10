import React from 'react'

const UserList = ({ users }) => {
  
  return (
    <>
      <table>
        <tr>
          <th>번호</th>
          <th className="subject-th">아이디</th>
          <th>이름</th>
          <th>이메일</th>
        </tr>
        {
          users.map((user, i) => {
            return (
              <tr key={i}>
                <td>{++i}</td>
                <td>{user.username}</td>
                <td>{user.name}</td>
                <td>{user.email}</td>
              </tr>
            )
          })
        }
      </table>
    </>
  )
}

export default UserList