import React from "react";
import HandleFixedNavbar from "webapp/common/helpers/HandleFixedNavbar";
import SideNav from "webapp/common/Header/SideNav";
import SearchOverlay from "webapp/common/Header/SearchOverlay";
import Navbar from "webapp/common/Header/Navbar";
import NavbarHeader from "webapp/common/Header/NavbarHeader/NavbarHeader";
import AttrNavSocial from "webapp/common/Header/Elements/AttrNavSocial";

const HeaderSocial = ({ type, data }) => {
  const { fixed } = HandleFixedNavbar();

  return (
    <nav
      className={
        "navbar navbar-default navbar-fixed white bootsnav on no-full menu-center no-border" +
        (fixed ? "" : " navbar-transparent")
      }
    >
      <SearchOverlay />
      <div className={"container" + (type === "wide" ? "-fluid" : "")}>
        <AttrNavSocial />
        <NavbarHeader />
        <Navbar data={data} />
      </div>
      <SideNav data={data} />
    </nav>
  );
};

export default HeaderSocial;
