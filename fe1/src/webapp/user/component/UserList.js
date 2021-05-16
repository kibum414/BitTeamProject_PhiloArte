import React from 'react'
import axios from 'axios'

const UserList = ({ users }) => {

  const userEdit = () => {
    axios({
      url: URL + users.userId,
      method: 'put',
      headers: { 'Content-Type': 'application/json', 'Authoriztion': 'Bearer ' + localStorage.getItem("token") },
      data: {}
    })
  }

  const userDelete = () => {
    axios({
      url: URL + users.userId,
      method: 'delete',
      headers: { 'Content-Type': 'application/json', 'Authorization': 'Bearer ' + localStorage.getItem("token") }
    })
  }

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