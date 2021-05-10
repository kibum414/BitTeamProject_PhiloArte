import React, { useState, useEffect } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'
import { Header, Footer } from 'common'
import 'participant/style/Participant.css'

const ParticipantDetail = (props) => {
  const [detail, setDetail] = useState({})

  const getDetail = () => {
    axios.get(`http://localhost:8080/participants/${props.match.params.id}`)
      .then(res => {
        console.log(res)
        setDetail(res.data)
      })
      .catch(err => {
        console.log(err)
      })
  }

  useEffect(() => {
    getDetail()
  }, [])

  const deleteParticipant = () => {
    if (window.confirm('삭제하시겠습니까?')) {
      axios.delete(`http://localhost:8080/participants/${props.match.params.id}`)
        .then(res => {
          console.log(`${detail.participantNo} 삭제`)
          console.log(res)
          props.history.push('/participants/list')
        })
        .catch(err => {
          console.log(err)
        })
    }
  }

  return (
    <>
      <Header />
      <h1>캠페인 참가자 정보</h1>

      <form className="participant-form">
        <div className="container">
          <div className="content">
            <table>
              <tr>
                <th>이름</th>
                <td>{detail.name}</td>
              </tr>
              <tr>
                <th>성별</th>
                <td>{detail.gender}</td>
              </tr>
              <tr>
                <th>생년월일</th>
                <td>{detail.birthday}</td>
              </tr>
              <tr>
                <th>전화번호</th>
                <td>{detail.phoneNumber}</td>
              </tr>
              <tr>
                <th>이메일</th>
                <td>{detail.email}</td>
              </tr>
              <tr>
                <th>신청일</th>
                <td>{detail.regdate}</td>
              </tr>
            </table>

            <button onClick={deleteParticipant}>삭제</button>
            <Link to={`/participants/modify/${detail.participantNo}`}>
              <button>수정</button>
            </Link>
            <Link to="/participants/list">
              <button>목록</button>
            </Link>
          </div>
        </div>
      </form>
      <Footer />
    </>
  )
}

export default ParticipantDetail