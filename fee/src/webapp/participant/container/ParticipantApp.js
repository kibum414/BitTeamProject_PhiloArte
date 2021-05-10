import { useState, useEffect } from 'react'
import axios from 'axios'
import { Link } from 'react-router-dom'
import { Header, Footer } from 'common'
import { ParticipantList, Pagination } from 'participant'
import 'participant/style/Participant.css'
import 'participant/style/ParticipantList.css'

const ParticipantApp = () => {

  const [list, setList] = useState([])

  const [currentPage, setCurrentPage] = useState(1)
  const [postsPerPage] = useState(5)

  const indexOfLastPost = currentPage * postsPerPage
  const indexOfFirstPost = indexOfLastPost - postsPerPage
  const currentPosts = list.slice(indexOfFirstPost, indexOfLastPost)

  const paginate = (pageNum) => setCurrentPage(pageNum)

  const getList = () => {
    axios.get(`http://localhost:8080/participants`)
      .then(res => {
        console.log(res)
        setList(res.data)
      })
      .catch(err => {
        console.log(err)
      })
  }

  useEffect(() => {
    console.log('getList')

    getList()
  }, [])

  return (
    <>
      <Header />
      <div className="participant">
        <h1>참가자 리스트</h1>

        <form className="participant-form participant-list-form">
          <div className="container">
            <div className="content">
              <ParticipantList list={currentPosts} indexOfFirstPost={indexOfFirstPost} />

              <Pagination postsPerPage={postsPerPage} totalPosts={list.length} paginate={paginate} />
            </div>

            <br />

            <div className="btn_area">
              <button type="submit" className="register_btn">
                <Link to='/participants/register'><b>등록하기</b></Link>
              </button>
            </div>
          </div>
        </form>
      </div>
      <Footer />
    </>
  )
}

export default ParticipantApp