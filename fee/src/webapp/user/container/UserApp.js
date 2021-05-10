import React, { useEffect } from 'react'
import { useSelector, useDispatch } from 'react-redux';
import { Header, Footer } from 'common';
import UserList from 'user/component/UserList';
import { getUserList } from '../reducer/user.reducer'
import 'user/style/UserList.css'

const UserApp = () => {
  const users = useSelector(state => {
    console.log(`state: ` + JSON.stringify(state))
    return (state.users)
  })
  const dispatch = useDispatch()

  useEffect(() => {
    alert(`1. useEffect`)
    dispatch(getUserList())
  }, [])

  return (
    <>
      <Header />
      <div className="user">
        <h1>사용자 목록</h1>

        <form className="user-list-form">
          <div className="container">
            <div className="content">
              <UserList users={users} />
            </div>
          </div>
        </form>
      </div>
      <Footer />
    </>
  )
}

export default UserApp