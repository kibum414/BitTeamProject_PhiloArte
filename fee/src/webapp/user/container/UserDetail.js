import axios from 'axios';
import React, { useState, useEffect } from 'react'
import 'user/style/UserDetail.css';

const UserDetail = (props) => {
  const [detailInfo, setDetailInfo] = useState({})

  const getDetailInfo = () => {
    axios.get(`http://localhost:8080/detail/${props.match.params.id}`)
      .then(res => {
        console.log(res)
        setDetailInfo(res.data)
      })
      .catch(err => {
        console.log(err)
      })
  }

  useEffect(() => {
    getDetailInfo()
  }, [])
  
  return (
    <form style={{ border: "1px solid #ccc" }}>
      <div className="container">
        <h1>회원정보</h1>
        <hr />

        <label for="name"><b>이름</b></label>
        <input type="text" name="name" readOnly />

        <label for="email"><b>Email</b></label>
        <input type="text" name="email" readOnly />

        <label for="phone"><b>Phone Number</b></label>
        <input type="text" name="phone" readOnly />

        <label for="address"><b>Address</b></label>
        <input type="text" name="address" readOnly />

        <div className="clearfix">
          <button type="button" className="modifybtn">Modify</button>
          <button type="button" className="deletebtn">Delete</button>
          <button type="button" className="listbtn">List</button>
        </div>
      </div>
    </form>
  )
}

export default UserDetail