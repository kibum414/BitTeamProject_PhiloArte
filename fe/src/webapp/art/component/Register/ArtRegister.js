import React, { useState, useCallback } from 'react';
import { useDispatch } from 'react-redux';
import { useHistory } from 'react-router-dom';
// DATA Files
import dataNavbar from "webapp/common/data/Navbar/main-navbar-data.json";
// Components
import { HeaderOne, FooterOne } from 'webapp/common';
import PageTitleArt from 'webapp/art/component/PageTitleArt';
import { getArtRegister } from 'webapp/art/reducer/art.reducer';

import 'webapp/art/style/Art.css'

const ArtRegister = ({ tagline, title, backfont, dash, textBtn, classes }) => {

  const dispatch = useDispatch()
  const history = useHistory()

  const [input, setInput] = useState({
    title: "",
    category: "",
    description: ""
  })

  const inputChange = useCallback(e => {
    setInput({
      ...input,
      [e.target.name]: e.target.value
    })
  }, [input])

  const ArtRegister = e => {
    e.preventDefault()

    dispatch(getArtRegister(input))

    history.push('/art')
  }

  return (
    <>
      <HeaderOne data={dataNavbar} />
      <PageTitleArt title="작품 등록" />

      <section
        className={"pt-0 pb-0 transition-none " + classes}
        id="contact"
      >
        <div className="container-fluid">
          <div className="col-md-5 col-sm-7 pt-50 pb-70 pl-70 pr-70 xs-pt-20 xs-pb-80" style={{ float: "none", margin: "0 auto" }}>

            <form
              name="art-register-form"
              id="art-register-form"
              method="POST"
              className="contact-form-style-02"
              onSubmit={ArtRegister}
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
                      onChange={inputChange}
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
                      data-error="카테고리를 선택해주세요."
                      onChange={inputChange}
                    >
                      <option>카테고리</option>
                      <option value="인물">인물</option>
                      <option value="풍경">풍경</option>
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
                      onChange={inputChange}
                    />
                  </div>
                </div>
                <div className="col-md-12 col-sm-12">
                  <div className="form-group">
                    <label htmlFor="message" className="dark-color">
                      파일 첨부
                  </label>
                    <input
                      type="file"
                      name="art"
                      className="md-input style-02 input_white"
                      id="art"
                      data-error="작품 파일을 첨부해주세요."
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
                      {textBtn || "등록하기"}
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

export default ArtRegister