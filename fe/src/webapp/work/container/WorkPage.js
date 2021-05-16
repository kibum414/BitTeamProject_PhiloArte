import React from "react";
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

const WorkPage = () => (
  <>
    <HeaderOne data={dataNavbar} />
    <PageTitleOne title="작품 목록" image={""} />
    <WorkList
      data={dataPortfolio}
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
);

export default WorkPage;
