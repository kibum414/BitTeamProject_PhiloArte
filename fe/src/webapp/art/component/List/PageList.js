import React from 'react';
import { useSelector, useDispatch } from "react-redux";

const PageList = () => {

  const { pageList, page, start, end, prev, next } = useSelector(state => state.arts.pageResult)

  const dispatch = useDispatch()

  console.log("PageList : " + pageList);

  const movePage = (page) => {
    dispatch()
  }

  const list = pageList.map(i =>
    <button key={i} onClick={() => movePage(i)}>
      {i}
    </button>
  )

  return (
    <div>
      {prev ? <button onClick={() => movePage(start - 1)}>prev</button> : <></>}
      {list}
      {next ? <button onClick={() => movePage(end + 1)}>next</button> : <></>}
    </div>
  )
}

export default PageList