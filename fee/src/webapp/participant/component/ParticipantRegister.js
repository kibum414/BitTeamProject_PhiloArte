import axios from 'axios'
import React, { useState } from 'react'
import { Link } from 'react-router-dom'
import { Header, Footer } from 'common'
import 'participant/style/Participant.css'

const ParticipantRegister = () => {

  const [inputs, setInputs] = useState({})

  const { name, gender, birthday, phoneNumber, email } = inputs

  const inputChange = e => {
    const { name, value } = e.target
    console.log(inputs)

    setInputs({
      ...inputs,
      [name]: value
    })
  }

  const participantRegister = (e) => {
    e.preventDefault()

    alert('등록 !')

    axios.post(`http://localhost:8080/participants`, {
      name,
      gender,
      birthday,
      phoneNumber,
      email,
      regdate: new Date()
    })
      .then(res => {
        console.log(`res : ${JSON.stringify(res.data)}`)
        window.location = `/participants/list`
      })
      .catch(err => {
        console.log(`err : ${err}`)
      })
  }

  return (
    <>
      <Header />
      <h1>캠페인 참가 등록</h1>

      <form className="participant-form" onSubmit={participantRegister}>
        <div className="container">
          <div className="content">
            <label htmlFor="name"><b>캠페인 이름</b></label>
            <input type="text" id="name" name="name" placeholder="이름" onChange={inputChange} required />

            <label htmlFor="name"><b>이름</b></label>
            <input type="text" id="name" name="name" placeholder="이름" onChange={inputChange} required />

            <label htmlFor="birthday"><b>생년월일</b></label>
            <input type="text" id="birthday" name="birthday" placeholder="생년월일" onChange={inputChange} required />

            <label htmlFor="gender"><b>성별</b></label>
            <select id="gender" name="gender" onChange={inputChange} required>
              <option value="">성별</option>
              <option value="남자">남자</option>
              <option value="여자">여자</option>
            </select>

            <label htmlFor="email"><b>이메일</b></label>
            <input type="text" id="email" name="email" placeholder="이메일" onChange={inputChange} required />

            <label htmlFor="phone"><b>휴대전화</b></label>
            <input type="text" id="phone" name="phone" placeholder="전화번호" onChange={inputChange} required />
          </div>

          <div className="btn_area">
            <button type="submit" className="register_btn"><b>등록하기</b></button>
            <Link to="/participants">
              <button type="button" className="cancel_btn"><b>돌아가기</b></button>
            </Link>
          </div>
        </div>
      </form>
      <Footer />
    </>
  )
}

export default ParticipantRegister