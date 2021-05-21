import React, { useEffect } from "react";
import { useSelector, useDispatch } from "react-redux";
// DATA Files
import dataNavbar from "webapp/common/data/Navbar/main-navbar-data.json";
import dataPortfolio from "webapp/common/data/Portfolio/main-portfolio-data.json";
import dataClients from "webapp/common/data/Clients/clients-data.json";
// Images
// Components
import PageTitleOne from "webapp/work/component/List/PageTitleOne";
import { HeaderOne, FooterOne } from "webapp/common";
import ClientsCarousel from "webapp/common/Carousel/ClientsCarousel";
import WorkList from "webapp/work/component/List/WorkList";

import { getWorkList } from 'webapp/work/reducer/work.reducer'

const WorkPage = () => {
  const works = useSelector(state => state.works)

  const dispatch = useDispatch()

  useEffect(() => {
    dispatch(getWorkList())
  }, [])

  return (
    <>
      <HeaderOne data={dataNavbar} />
      <PageTitleOne title="작품 목록" image={""} />
      <WorkList
        data={works}
        filter={true}
        categories={[
          "Branding",
          "Creative Design",
          "Web Design",
          "Stationery",
          "Photography",
        ]}

      />
      <ClientsCarousel data={dataClients} />
      <FooterOne />
    </>
  )
}

export default WorkPage;
