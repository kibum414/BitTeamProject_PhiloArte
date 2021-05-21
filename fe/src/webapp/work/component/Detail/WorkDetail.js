import React from "react";
// DATA Files
import dataNavbar from "webapp/common/data/Navbar/main-navbar-data.json";
// Images
// Components
import HeaderOne from "webapp/common/Header/HeaderOne";
import PageTitleWork from "webapp/work/component/PageTitleWork";
import WorkContent from "webapp/work/component/Detail/WorkContent";
import FooterOne from "webapp/common/Footer/FooterOne";
import { useSelector } from "react-redux";

const WorkDetail = (workId) => {
  

  return (
    <>
      <HeaderOne data={dataNavbar} />
      <PageTitleWork title="작품 상세" />
      <FooterOne />
    </>
  );
}

export default WorkDetail;
