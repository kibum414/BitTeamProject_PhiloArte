import React, { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
// DATA Files
import dataNavbar from "webapp/common/data/Navbar/main-navbar-data.json";
import dataClients from "webapp/common/data/Clients/clients-data.json";
// Images
// Components
import PageTitleOne from "webapp/art/component/List/PageTitle";
import { HeaderOne, FooterOne } from "webapp/common";
import ClientsCarousel from "webapp/common/Carousel/ClientsCarousel";
import ArtList from "webapp/art/component/List/ArtList";

import { getArtList, getArtSearch } from 'webapp/art/reducer/art.reducer'
import { SearchBar } from "..";

const ArtPage = () => {
  const pageResult = useSelector(state => state.arts.pageResult)
  const type = useSelector(state => state.arts.type)
  const keyword = useSelector(state => state.arts.keyword)

  const dispatch = useDispatch()

  useEffect(() => {
    (!type && !keyword) ?
      dispatch(getArtList(pageResult.page))
      :
      dispatch(getArtSearch({ type: type, keyword: keyword, page: pageResult.page }))
  }, [])

  return (
    <>
      <HeaderOne data={dataNavbar} />
      <PageTitleOne title="작품 목록" image={""} />
      <ArtList
        data={pageResult.dtoList}
        filter={true}
        categories={[
          "예술",
          "사진",
          "연극"
        ]}
      />
      <SearchBar />
      <ClientsCarousel data={dataClients} />
      <FooterOne />
    </>
  )
}

export default ArtPage;
