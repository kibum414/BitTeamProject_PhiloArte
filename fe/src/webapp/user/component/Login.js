import React, { useState } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'
import '../style/Login.css'

const Login = () => {

  const [inputs, setInputs] = useState({})

  const { username, password } = inputs

  const userLogin = e => {
    e.preventDefault()

    axios({
      url: `http://localhost:8080/users/signin`,
      method: 'post',
      headers: { 'Content-Type': 'application/json', 'Authorization': 'JWT fefege..' },
      data: {
        username,
        password
      }
    })
      .then(res => {
        console.log(`res: ${JSON.stringify(res)}`)
        setInputs(res.data)

        alert('로그인 성공 !')
      })
      .catch(err => {
        console.log(`${err}`)

        alert('아이디와 비밀번호를 확인하세요.')
      })
  }

  const inputChange = e => {
    const { name, value } = e.target
    console.log(inputs)

    setInputs({
      ...inputs,
      [name]: value
    })
  }

  return (
    <>
      <h1>로그인</h1>

      <div id="wrap">
        <div id="header">
          <h1><Link to='/' class="sp h_logo">HOME</Link></h1>
        </div>

        <div id="container">
          <div id="content">
            <form id="frmNIDLogin" name="frmNIDLogin" target="_top" autocomplete="off" action="https://nid.naver.com/nidlogin.login" method="POST">
              <fieldset class="login_form">
                <legend class="blind">로그인</legend>
                <div class="id_area">
                  <div class="input_row" id="id_area">
                    <span class="input_box">
                      <label for="id" id="label_id_area" class="lbl" style={{ display: 'block' }}>아이디</label>
                      <input type="text" id="id" name="id" accesskey="L" placeholder="아이디" class="int" maxlength="41" value="" />
                    </span>
                  </div>
                  <div class="error" id="err_empty_id" style={{ display: 'none' }} aria-live="assertive"></div>
                </div>
                <div class="pw_area">
                  <div class="input_row" id="pw_area">
                    <span class="input_box">
                      <label for="pw" id="label_pw_area" class="lbl">비밀번호</label>
                      <input type="password" id="pw" name="pw" placeholder="비밀번호" class="int" maxlength="16" />
                    </span>
                  </div>
                </div>

                <input type="submit" title="로그인" alt="로그인" value="로그인" class="btn_global" id="log.login" />
              </fieldset>
            </form>
          </div>
        </div>
      </div>
    </>
  )
}

export default Login