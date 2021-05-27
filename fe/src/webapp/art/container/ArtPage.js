import React, { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
// DATA Files
import dataNavbar from "webapp/common/data/Navbar/main-navbar-data.json";
import dataPortfolio from "webapp/common/data/Portfolio/main-portfolio-data.json";
import dataClients from "webapp/common/data/Clients/clients-data.json";
// Images
// Components
import PageTitleOne from "webapp/art/component/List/PageTitleOne";
import { HeaderOne, FooterOne } from "webapp/common";
import ClientsCarousel from "webapp/common/Carousel/ClientsCarousel";
import ArtList from "webapp/art/component/List/ArtList";

import { getArtList } from 'webapp/art/reducer/art.reducer'

const ArtPage = () => {
  const arts = useSelector(state => state.arts.pageResult)

  const dispatch = useDispatch()

  useEffect(() => {
    dispatch(getArtList(arts.page))
  }, [])

  return (
    <>
      <HeaderOne data={dataNavbar} />
      <PageTitleOne title="작품 목록" image={""} />
      <ArtList
        data={arts.dtoList}
        filter={true}
        categories={[
          "예술",
          "사진",
          "연극"
        ]}

      />
      <ClientsCarousel data={dataClients} />
      <FooterOne />
    </>
  )
}

export default ArtPage;
