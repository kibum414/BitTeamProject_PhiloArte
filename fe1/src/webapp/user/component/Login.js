import React, { useState, useCallback } from 'react'
import { useDispatch } from 'react-redux'
import { Link, useHistory } from 'react-router-dom'
import { userSignIn } from '../reducer/user.reducer'
import '../style/Login.css'

const Login = () => {
  const dispatch = useDispatch();
  const history = useHistory();

  const [inputs, setInputs] = useState({
    username: '',
    password: ''
  })

  const userLogin = e => {
    e.preventDefault()
    console.log(inputs)

    dispatch(userSignIn(inputs))

    history.push('/')
  }

  const inputChange = useCallback(e => {
    const { name, value } = e.target

    setInputs({
      ...inputs,
      [name]: value
    })
  }, [inputs])

  return (
    <>
      <div id="wrap">
        <div id="header">
          <h1><Link to='/' className="sp h_logo">HOME</Link></h1>
        </div>

        <div id="container">
          <div id="content">
            <form id="frmNIDLogin" name="frmNIDLogin" target="_top" autoComplete="off" onSubmit={userLogin}>
              <fieldset className="login_form">
                <div className="id_area">
                  <div className="input_row" id="id_area">
                    <span className="input_box">
                      <label htmlFor="username" id="label_id_area" className="lbl" style={{ display: 'block' }}>아이디</label>
                      <input type="text" id="username" name="username" placeholder="아이디" className="int" maxLength="41" onChange={inputChange} />
                    </span>
                  </div>
                </div>
                <div className="pw_area">
                  <div className="input_row" id="pw_area">
                    <span className="input_box">
                      <label htmlFor="password" id="label_pw_area" className="lbl">비밀번호</label>
                      <input type="password" id="password" name="password" placeholder="비밀번호" className="int" maxLength="16" onChange={inputChange} />
                    </span>
                  </div>
                </div>

                <input type="submit" title="로그인" alt="로그인" value="로그인" className="btn_global" id="log.login" />
              </fieldset>
            </form>
          </div>
        </div>

        <div id="footer">
        </div>
      </div>
    </>
  )
}

export default Login