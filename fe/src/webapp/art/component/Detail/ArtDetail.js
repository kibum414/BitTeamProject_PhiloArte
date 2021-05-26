import React from "react";
// DATA Files
import dataNavbar from "webapp/common/data/Navbar/main-navbar-data.json";
// Images
// Components
import HeaderOne from "webapp/common/Header/HeaderOne";
import PageTitleArt from "webapp/art/component/PageTitleArt";
import ArtContent from "webapp/art/component/Detail/ArtContent";
import FooterOne from "webapp/common/Footer/FooterOne";
import { useSelector } from "react-redux";

const ArtDetail = (artId) => {
  

  return (
    <>
      <HeaderOne data={dataNavbar} />
      <PageTitleArt title="작품 상세" />
      <FooterOne />
    </>
  );
}

export default ArtDetail;
