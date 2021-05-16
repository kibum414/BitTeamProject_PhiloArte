import React, { useCallback, useState } from 'react'
import { Link, useHistory } from 'react-router-dom'
import { useDispatch } from 'react-redux'
import { userSignUp } from '../reducer/user.reducer'
import '../style/SignUp.css'

const SignUp = () => {
  const dispatch = useDispatch()
  const history = useHistory()
  
  const [userInfo, setUserInfo] = useState({
    username: '',
    password: '',
    name: '',
    birthday: '',
    gender: '',
    email: '',
    phone: ''
  })

  const inputChange = useCallback(e => {
    const { name, value } = e.target

    setUserInfo({
      ...userInfo,
      [name]: value
    })
  }, [userInfo])

  const userRegister = e => {
    e.preventDefault()

    console.log(JSON.stringify(userInfo))

    dispatch(userSignUp(userInfo))

    history.push('/')
  }

  return (
    <>
      <div id="wrap">
        <div id="header" className="join_membership">
          <h1><Link to='/' className="h_logo">HOME</Link></h1>
        </div>

        <form id="join_form" onSubmit={userRegister}>
          <div id="container">
            <div id="content">
              {/* 아이디, 비밀번호 입력 */}
              <div className="row_group">
                <div className="join_row">
                  <h3 className="join_title">
                    <label htmlFor="id">아이디</label>
                  </h3>
                  <span className="ps_box int_id">
                    <input type="text" id="id" name="username" className="int" title="ID" maxLength="20" onChange={inputChange} />
                  </span>
                </div>

                <div className="join_row">
                  <h3 className="join_title">
                    <label htmlFor="pswd1">비밀번호</label>
                  </h3>
                  <span className="ps_box int_pass" id="pswd1Img">
                    <input type="password" id="pswd1" name="password" className="int" title="비밀번호 입력" aria-describedby="pswd1Msg" maxLength="20" onChange={inputChange} />
                  </span>
                </div>

                {/* <h3 className="join_title">
                  <label for="pswd2">비밀번호 재확인</label>
                </h3>
                <span className="ps_box int_pass_check" id="pswd2Img">
                  <input type="password" id="pswd2" name="pswd2" className="int" title="비밀번호 재확인 입력" aria-describedby="pswd2Blind" maxLength="20" onChange={inputChange} />
                </span> */}
              </div>

              <div className="row_group">
                <div className="join_row">
                  <h3 className="join_title">
                    <label for="name">이름</label>
                  </h3>
                  <span className="ps_box box_right_space">
                    <input type="text" id="name" name="name" title="이름" className="int" maxLength="40" onChange={inputChange} />
                  </span>
                </div>

                {/* <div className="join_row join_birthday">
                  <h3 className="join_title"><label for="yy">생년월일</label></h3>
                  <div className="bir_wrap">
                    <div className="bir_yy">
                      <span className="ps_box">
                        <input type="text" id="yy" placeholder="년(4자)" aria-label="년(4자)" className="int" maxLength="4" onChange={inputChange} />
                      </span>
                    </div>
                    <div className="bir_mm">
                      <span className="ps_box">
                        <select id="mm" className="sel" aria-label="월" onChange={inputChange}>
                          <option value="">월</option>
                          <option value="01">1</option>
                          <option value="02">2</option>
                          <option value="03">3</option>
                          <option value="04">4</option>
                          <option value="05">5</option>
                          <option value="06">6</option>
                          <option value="07">7</option>
                          <option value="08">8</option>
                          <option value="09">9</option>
                          <option value="10">10</option>
                          <option value="11">11</option>
                          <option value="12">12</option>
                        </select>
                      </span>
                    </div>
                    <div className=" bir_dd">
                      <span className="ps_box">
                        <input type="text" id="dd" placeholder="일" aria-label="일" className="int" maxLength="2" onChange={inputChange} />
                        <label for="dd" className="lbl"></label>
                      </span>
                    </div>
                  </div>
                </div>

                <div className="join_row join_sex">
                  <h3 className="join_title">
                    <label for="gender">성별</label>
                  </h3>
                  <div className="ps_box gender_code">
                    <select id="gender" name="gender" className="sel" aria-label="성별" onChange={inputChange}>
                      <option value="" selected="">성별</option>
                      <option value="M">남자</option>
                      <option value="F">여자</option>
                      <option value="U">선택 안함</option>
                    </select>
                  </div>
                </div> */}

                <div className="join_row join_email">
                  <h3 className="join_title">
                    <label for="email">본인 확인 이메일<span className="terms_choice">(선택)</span></label>
                  </h3>
                  <span className="ps_box int_email box_right_space">
                    <input type="text" id="email" name="email" placeholder="선택입력" aria-label="선택입력" className="int" maxLength="100" onChange={inputChange} />
                  </span>
                </div>
              </div>

              {/* <div className="join_row join_mobile" id="mobDiv">
                <h3 className="join_title">
                  <label for="phoneNo">휴대전화</label>
                </h3>
                <div className="int_mobile_area">
                  <span className="ps_box int_mobile">
                    <input type="tel" id="phoneNo" name="phoneNo" placeholder="전화번호 입력" aria-label="전화번호 입력" className="int" maxLength="16" onChange={inputChange} />
                    <label for="phoneNo" className="lbl"></label>
                  </span>
                </div>
              </div> */}

              <div className="btn_area">
                <button type="submit" id="btnJoin" className="btn_type btn_primary">
                  <span>가입하기</span>
                </button>
              </div>
            </div>
          </div>
        </form>
        <div id="footer">
        </div>
      </div>
    </>
  )
}

export default SignUp