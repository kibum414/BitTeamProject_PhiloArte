import React from 'react'
import ArticleList from 'article/component/ArticleList'
import HomeNav from 'common/component/Header'
import HomeFooter from 'common/component/Footer'

const News = () => {

  return (
    <>
      <HomeNav />
      <ArticleList />
      <HomeFooter />
    </>
  )
}

export default News