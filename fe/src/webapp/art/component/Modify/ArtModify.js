import React, { useCallback, useRef, useState } from 'react'
// DATA Files
import dataNavbar from "webapp/common/data/Navbar/main-navbar-data.json";
// Components
import { HeaderOne, FooterOne } from 'webapp/common'
import PageTitleArt from 'webapp/art/component/PageTitleArt';

import 'webapp/art/style/Art.css'
import { useDispatch, useSelector } from 'react-redux';

const ArtModify = ({ tagline, title, backfont, dash, textBtn, classes }) => {

  const art = useSelector(state => state.arts.current)
  console.log(art)

  const [input, setInput] = useState({
    title: art.title,
    category: art.category.categoryId,
    description: art.description,
  })

  const dispatch = useDispatch()

  const handleChange = e => {
    setInput({
      [e.target.name]: [e.target.value]
    })
  }

  const ArtModify = useCallback(e => {
    e.preventDefault()

    const formData = new FormData()

    const update = {
      

    }
    

  })

  return (
    <>
      <HeaderOne data={dataNavbar} />
      <PageTitleArt title="작품 수정" />

      <section
        className={"pt-0 pb-0 transition-none " + classes}
        id="contact"
      >
        <div className="container-fluid">
          <div className="col-md-5 col-sm-7 pt-50 pb-70 pl-70 pr-70 xs-pt-20 xs-pb-80" style={{ float: "none", margin: "0 auto" }}>

            <form
              name="art-modify-form"
              id="art-modify-form"
              action="php/contact.php"
              method="POST"
              className="contact-form-style-02"
            >
              <div className="messages"></div>
              <div className="row">
                <div className="col-md-12 col-sm-12">
                  <div className="form-group">
                    <label htmlFor="title" className="dark-color">
                      작품명
                </label>
                    <input
                      type="text"
                      name="title"
                      className="md-input style-02 input_white"
                      id="title"
                      required
                      data-error="작품명을 입력하세요."
                      value={input.title}
                    />
                  </div>
                </div>
                <div className="col-md-12 col-sm-12">
                  <div className="form-group">
                    <label htmlFor="category" className="dark-color">
                      카테고리
                </label>
                    <select
                      type="text"
                      name="category"
                      className="md-input style-02 sel_arrow input_white"
                      id="category"
                      required
                      data-error="카테고리를 선택해주세요"
                    >
                      <option>{input.category}</option>
                      <option value="1">예술</option>
                      <option value="2">사진</option>
                      <option value="3">연극</option>
                    </select>
                  </div>
                </div>
                <div className="col-md-12 col-sm-12">
                  <div className="form-group">
                    <label htmlFor="description" className="dark-color">
                      설명
                </label>
                    <textarea
                      name="description"
                      className="md-textarea style-02 input_white"
                      id="description"
                      rows="7"
                      required
                      data-error="작품에 대한 설명을 입력해주세요."
                      value={input.description}
                      />
                  </div>
                </div>
                <div className="col-md-12 col-sm-12">
                  <div className="form-group">
                    <label htmlFor="message" className="dark-color">
                      파일 첨부
                    </label>
                    {art?.files.map((image, i) => (
                      <div className="item" key={i}>
                        <img
                          className="img-responsive"
                          src={`http://localhost:8080/art_files/display?fileName=${image.saveFileName}`}
                          alt={image.originalFileName}
                        />
                      </div>
                    ))}
                    <input
                      type="file"
                      name="art"
                      className="md-input style-02 input_white"
                      id="art"
                      required
                      data-error="작품 파일을 첨부해주세요"
                    />
                  </div>
                </div>
                <div className="col-md-12 col-sm-12">
                  <div className="text-center mt-20">
                    <button
                      type="submit"
                      name="submit"
                      className="btn btn-xl btn-color btn-square remove-margin"
                      style={{ width: "50%" }}
                    >
                      {textBtn || "수정하기"}
                    </button>
                  </div>
                </div>
              </div>
            </form>
          </div>
        </div>
      </section>

      <FooterOne />
    </>
  )
}

export default ArtModify