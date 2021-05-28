import React, { useCallback, useRef } from 'react';
import { useDispatch } from 'react-redux';
import { useHistory } from 'react-router-dom';
// DATA Files
import dataNavbar from "webapp/common/data/Navbar/main-navbar-data.json";
// Components
import { HeaderOne, FooterOne } from 'webapp/common';
import PageTitleArt from 'webapp/art/component/PageTitleArt';
import { getArtList, getArtRegister, getArtUpload } from 'webapp/art/reducer/art.reducer';

import 'webapp/art/style/Art.css'

const ArtRegister = ({ tagline, title, backfont, dash, textBtn, classes }) => {

  const titleRef = useRef()
  const categoryRef = useRef()
  const descriptionRef = useRef()
  const fileRef = useRef()

  const dispatch = useDispatch()
  const history = useHistory()

  const ArtRegister = useCallback(e => {
    e.preventDefault()

    const input = {
      title: titleRef.current.value,
      category: { categoryId: Number(categoryRef.current.value) },
      description: descriptionRef.current.value,
      mainImg: "http://www.yck.kr/_data/file/bbsData/86d2f471ffc196ee508845737375d38d.jpg",
      artist: { artistId: 333 },
      resume: { resumeId: 100 },
    }

    const file = fileRef.current.files

    console.log("TITLE: " + titleRef.current.value)
    console.log("CATEGORY: " + typeof categoryRef.current.value)
    console.log("DESCRIPTION: " + descriptionRef.current.value)
    console.log(fileRef.current.files)
    
    dispatch(getArtRegister(input))
    dispatch(getArtUpload(file))

    // history.push('/art')
  })

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
                      ref={titleRef}
                    />
                  </div>
                </div>
                <div className="col-md-12 col-sm-12">
                  <div className="form-group">
                    <label htmlFor="category" className="dark-color">
                      카테고리
                    </label>
                    <select
                      type="number"
                      name="category"
                      className="md-input style-02 sel_arrow input_white"
                      id="category"
                      required
                      data-error="카테고리를 선택해주세요."
                      ref={categoryRef}
                    >
                      <option>카테고리</option>
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
                      ref={descriptionRef}
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
                      accept="image/*"
                      className="md-input style-02 input_white"
                      id="art"
                      multiple={true}
                      data-error="작품 파일을 첨부해주세요."
                      ref={fileRef}
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