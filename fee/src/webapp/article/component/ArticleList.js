import React from 'react'
import { Link } from 'react-router-dom'

const ArticleList = () => {

  return (
    <>
      <table>
        <tr>
          <th>번호</th>
          <th className="subject-th">제목</th>
          <th>작성자</th>
          <th>작성일</th>
        </tr>
        <tr>
          <td>1</td>
          <td className="subject-td">제목1</td>
          <td>작성자1</td>
          <td>2021-04-14</td>
        </tr>
        <tr>
          <td>2</td>
          <td className="subject-td">제목2</td>
          <td>작성자2</td>
          <td>2021-04-14</td>
        </tr>
        <tr>
          <td>3</td>
          <td className="subject-td">제목3</td>
          <td>작성자3</td>
          <td>2021-04-14</td>
        </tr>
      </table>
    </>
  )
}

export default ArticleList