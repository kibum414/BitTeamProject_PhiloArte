import React, { useState, useEffect } from 'react'
import 'article/style/ArticleList.css'
import axios from 'axios'
import Header from 'common/component/Header'
import Footer from 'common/component/Footer'

const SeoulCCTV = () => {
  const [items, setItems] = useState([])

  const cctvList = () => {
    axios.get(`/data/SeoulCCTV.json`) // function 구조 - 파라미터 : URL, Data(데이터 없으므로 생략), 리턴 : then or catch
      .then(res => {
        setItems(res.data.DATA)
      }) // consumer 구조
      .catch(err => { }) // consumer 구조
  }

  useEffect(() => { cctvList() }, [])

  return (
    <div className="article">
      <Header />

      <h1>Seoul CCTV</h1>

      <form className="article-form article-list-form">
        <div className="container">
          <div className="content">
            <table>
              <tr>
                <th>번호</th>
                <th>기준날짜</th>
                <th>카메라코드</th>
                <th>카메라명칭</th>
                <th>설명</th>
              </tr>
              { // 동적으로 변하는 공간 {} 표시
                items.map((item, i) => {
                  return (
                    <tr key={i}>
                      <td>{++i}</td>
                      <td>{item.checktime}</td>
                      <td>{item.deviceid}</td>
                      <td>{item.devicename}</td>
                      <td>{item.description}</td>
                    </tr>
                  )
                })
              }
            </table>
          </div>
        </div>
      </form>

      <Footer />
    </div>
  )
}

export default SeoulCCTV
