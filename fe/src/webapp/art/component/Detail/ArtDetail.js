import React, { useEffect } from "react";
// DATA Files
import dataNavbar from "webapp/common/data/Navbar/main-navbar-data.json";
// Images
// Components
import HeaderOne from "webapp/common/Header/HeaderOne";
import PageTitleArt from "webapp/art/component/PageTitleArt";
import ArtContent from "webapp/art/component/Detail/ArtContent";
import FooterOne from "webapp/common/Footer/FooterOne";
import { useSelector, useDispatch } from "react-redux";
import { getArtRead } from "webapp/art/reducer/art.reducer";
import { useParams } from "react-router";

const ArtDetail = () => {
  const { id } = useParams()
  console.log(id)

  const art = useSelector(state => state.arts.art)
  console.log(art)

  const dispatch = useDispatch()

  useEffect(() => {
    dispatch(getArtRead(id))
  }, [])
  

  return (
    <>
      <HeaderOne data={dataNavbar} />
      <PageTitleArt title="작품 상세" />
      <FooterOne />
    </>
  );
}

export default ArtDetail;
