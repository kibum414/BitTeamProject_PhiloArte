import React from 'react'
// DATA Files
import dataNavbar from "webapp/common/data/Navbar/main-navbar-data.json";
// Components
import { HeaderOne, FooterOne } from 'webapp/common'
import PageTitleArt from 'webapp/art/component/PageTitleArt';

import 'webapp/art/style/Art.css'

const ArtRegister = ({ tagline, title, backfont, dash, textBtn, classes }) => {

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
                    <label htmlFor="name" className="dark-color">
                      작품명
                </label>
                    <input
                      type="text"
                      name="name"
                      className="md-input style-02 input_white"
                      id="name"
                      readOnly
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
                      <option value selected>카테고리</option>
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
                    ></textarea>
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

export default ArtRegister