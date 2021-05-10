import React, { useState } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'
import { Home } from '../../common/index'
import 'user/style/User.css'

const SignUp = ({ history }) => {
  
  const [userInfo, setUserInfo] = useState({})

  const { username, password, name, birthday, gender, email, phone } = userInfo

  const inputChange = e => {
    const { name, value } = e.target
    console.log(userInfo)

    setUserInfo({
      ...userInfo,
      [name]: value
    })
  }

  const userRegister = e => {
    e.preventDefault()

    const del = window.confirm("회원가입 하시겠습니까?")

    if (del) {
      
      .then(res => {
      alert(`회원가입이 완료되었습니다.`)
      history.push(Home)
    })
  .catch(err => {
    alert(`회원가입 실패`)
  })
  }
  //   axios({
  //     method: 'post',
  //     url: 'http://localhost:8080/users',
  //     data: {
  //       username,
  //       password,
  //       name,
  //       birthday,
  //       gender,
  //       email,
  //       phone,
  //       regdate: new Date()
  //     }
  //   })
  //     .then(res => {
  //       console.log(`res: ${JSON.stringify(res.data)}`)
  //       history.push('login')
  //     })
  //     .catch(err => {
  //       console.log(`${err}`)
  //     })
  // }

  return (
    <>
      <div id="wrap">
        <div id="header" class="join_membership">
          <h1><Link to='/' class="h_logo">HOME</Link></h1>
        </div>

        <form id="join_form" onSubmit={userRegister}>
          <div id="container">
            <div id="content">
              {/* 아이디, 비밀번호 입력 */}
              <div class="row_group">
                <div class="join_row">
                  <h3 class="join_title">
                    <label htmlFor="id">아이디</label>
                  </h3>
                  <span class="ps_box int_id">
                    <input type="text" id="id" name="id" class="int" title="ID" maxLength="20" onChange={inputChange} required />
                  </span>
                </div>

                <div class="join_row">
                  <h3 class="join_title">
                    <label htmlFor="pswd1">비밀번호</label>
                  </h3>
                  <span class="ps_box int_pass" id="pswd1Img">
                    <input type="password" id="pswd1" name="pswd1" class="int" title="비밀번호 입력" aria-describedby="pswd1Msg" maxlength="20" />
                  </span>
                </div>

                <h3 class="join_title">
                  <label for="pswd2">비밀번호 재확인</label>
                </h3>
                <span class="ps_box int_pass_check" id="pswd2Img">
                  <input type="password" id="pswd2" name="pswd2" class="int" title="비밀번호 재확인 입력" aria-describedby="pswd2Blind" maxlength="20" />
                </span>
              </div>

              <div class="row_group">
                <div class="join_row">
                  <h3 class="join_title">
                    <label for="name">이름</label>
                  </h3>
                  <span class="ps_box box_right_space">
                    <input type="text" id="name" name="name" title="이름" class="int" maxlength="40" />
                  </span>
                </div>

                <div class="join_row join_birthday">
                  <h3 class="join_title"><label for="yy">생년월일</label></h3>
                  <div class="bir_wrap">
                    <div class="bir_yy">
                      <span class="ps_box">
                        <input type="text" id="yy" placeholder="년(4자)" aria-label="년(4자)" class="int" maxlength="4" />
                      </span>
                    </div>
                    <div class="bir_mm">
                      <span class="ps_box">
                        <select id="mm" class="sel" aria-label="월">
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
                    <div class=" bir_dd">
                      <span class="ps_box">
                        <input type="text" id="dd" placeholder="일" aria-label="일" class="int" maxlength="2" />
                        <label for="dd" class="lbl"></label>
                      </span>
                    </div>
                  </div>
                </div>

                <div class="join_row join_sex">
                  <h3 class="join_title">
                    <label for="gender">성별</label>
                  </h3>
                  <div class="ps_box gender_code">
                    <select id="gender" name="gender" class="sel" aria-label="성별">
                      <option value="" selected="">성별</option>
                      <option value="M">남자</option>
                      <option value="F">여자</option>
                      <option value="U">선택 안함</option>
                    </select>
                  </div>
                </div>

                <div class="join_row join_email">
                  <h3 class="join_title">
                    <label for="email">본인 확인 이메일<span class="terms_choice">(선택)</span></label>
                  </h3>
                  <span class="ps_box int_email box_right_space">
                    <input type="text" id="email" name="email" placeholder="선택입력" aria-label="선택입력" class="int" maxlength="100" />
                  </span>
                </div>
              </div>

              <div class="join_row join_mobile" id="mobDiv">
                <h3 class="join_title">
                  <label for="phoneNo">휴대전화</label>
                </h3>
                <div class="int_mobile_area">
                  <span class="ps_box int_mobile">
                    <input type="tel" id="phoneNo" name="phoneNo" placeholder="전화번호 입력" aria-label="전화번호 입력" class="int" maxlength="16" />
                    <label for="phoneNo" class="lbl"></label>
                  </span>
                </div>
              </div>

              <div class="btn_area">
                <button type="button" id="btnJoin" class="btn_type btn_primary">
                  <span>가입하기</span>
                </button>
              </div>
            </div>
          </div>
        </form>
      </div>
    </>
  )
}

export default SignUp