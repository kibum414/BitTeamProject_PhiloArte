import React from 'react'
import { Link } from 'react-router-dom'
import { Header, Footer } from 'common'
import { ArticleList } from 'article'
import 'article/style/Article.css'
import 'article/style/ArticleList.css'

const ArticleApp = () => {

  return (
    <>
      <Header />
      <div className="article">
        <h1>게시판</h1>

        <form className="article-form article-list-form">
          <div className="container">
            <div className="content">
              <ArticleList />
            </div>

            <div className="btn_area">
              <button type="submit" className="write_btn">
                <Link to='/article/write'><b>글쓰기</b></Link>
              </button>
            </div>
          </div>
        </form>
      </div>
      <Footer />
    </>
  )
}

export default ArticleApp