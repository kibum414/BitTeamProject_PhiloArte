import React, { useState } from 'react';
import Icofont from 'react-icofont';
import { useSelector, useDispatch } from "react-redux";
import { getArtList } from 'webapp/art/reducer/art.reducer';

const PageList = () => {

  const { pageList, start, end, prev, next } = useSelector(state => state.arts.pageResult)

  const dispatch = useDispatch()

  const [active, setActive] = useState('')

  console.log("PageList : " + pageList);

  const movePage = (page) => {
    dispatch(getArtList(page))
    setActive("active")
  }

  const list = pageList.map(i => (
    <li className={i} key={i} onClick={() => movePage(i)}>
      {i}
    </li>
  ))

  return (
    <div className="row mt-100">
      <div className="col-md-12">
        <div className="text-center">
          <div className="pagination dark-color">
            <ul>
              {prev ?
                <>
                  <li onClick={() => movePage(start - 1)}>
                  <Icofont
                    icon="rounded-left"
                    className="mr-5 xs-display-none"
                    />
                  </li>
                </>
                :
                <></>
              }
              {list}
              {next ?
                <li onClick={() => movePage(end + 1)}>
                  <Icofont
                    icon="rounded-right"
                    className="ml-5 xs-display-none"
                  />
                </li>
                :
                <></>
              }
            </ul>
          </div>
        </div>
      </div>
    </div>
  )
}

export default PageList