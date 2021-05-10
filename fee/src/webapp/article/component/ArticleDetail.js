import React from 'react'
import { Header, Footer } from 'common'
import 'article/style/Article.css'

const ArticleDetail = () => {

  return (
    <>
      <Header />
      <div className="article">
        <h1>게시판</h1>

        <form className="article-form">
          <div className="container">
            <div className="content">
              <table>
                <tr>
                  <th>작성자</th>
                  <td>
                    작성자1
                </td>
                </tr>
                <tr>
                  <th>제목</th>
                  <td>
                    제목1
                </td>
                </tr>
                <tr>
                  <th>내용</th>
                  <td>
                    내용1
                </td>
                </tr>
              </table>
            </div>

            <div className="btn_area">
              <button type="submit" className="update_btn"><b>수정</b></button>

              <button type="button" className="delete_btn"><b>삭제</b></button>
              <button type="button" className="list_btn"><b>목록</b></button>

            </div>
          </div>
        </form>
      </div>
      <Footer />
    </>
  )
}

export default ArticleDetail