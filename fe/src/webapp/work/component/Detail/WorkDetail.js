import React from "react";
// DATA Files
import dataNavbar from "data/Navbar/home-business-navbar.json";
import dataBlog from "data/Blog/blog-data.json";
// Images
import imgTitle from "assets/images/title-bg/title-bg-2.jpg";
// Components
import HeaderOne from "webapp/common/Header/HeaderOne";
import PageTitleWork from "webapp/work/component/PageTitleWork";
import BlogContent from "webapp/work/component/Detail/WorkContent";
import FooterOne from "webapp/common/Footer/FooterOne";

const WorkDetail = () => (
  <>
    <HeaderOne data={dataNavbar} />
    <PageTitleWork title="작품 상세" image={imgTitle} />
    <BlogContent post={dataBlog[1]} data={dataBlog} />
    <FooterOne />
  </>
);

export default WorkDetail;
