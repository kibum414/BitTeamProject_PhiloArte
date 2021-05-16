import React from 'react';
// CSS
import "assets/css/revolution/revolution.addon.particles.css";
// DATA Files
import dataNavbar from "data/Navbar/main-navbar-data.json";
// Components
import HeaderOne from "webapp/common/component/Header/HeaderOne";
import FooterOne from "webapp/common/component/Footer/FooterOne";
import Maintenance404 from 'components/Maintenance/Maintenance404';

const Page404 = () => (
    <>
    <HeaderOne data={dataNavbar} />
        <Maintenance404 />
    <FooterOne />
  </>
);

export default Page404;