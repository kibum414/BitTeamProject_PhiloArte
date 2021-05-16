import React from "react";
import HandleSearchOverlay from "../../helpers/HandleSearchOverlay";
import HandleSideMenu from "../../helpers/HandleSideMenu";
import HandleFixedNavbar from "../../helpers/HandleFixedNavbar";
import SideNav from "../../webapp/common/component/Header/SideNav";
import SearchOverlay from "../../webapp/common/component/Header/SearchOverlay";
import NavbarTwo from "./NavbarTwo";
import NavbarHeader from "../../webapp/common/component/Header/NavbarHeader/NavbarHeader";
import AttrNav from "../../webapp/common/component/Header/AttrNav";

const HeaderThree = ({ type, data }) => {
  const { show, showSearchForm, hideSearchForm } = HandleSearchOverlay();
  const { side, showSideMenu, hideSideMenu } = HandleSideMenu();
  const { fixed } = HandleFixedNavbar();

  return (
    <nav
      className={
        "navbar navbar-default navbar-fixed white bootsnav on no-full brand-center menu-center" +
        (fixed ? "" : " navbar-transparent")
      }
    >
      <SearchOverlay show={show} onClick={hideSearchForm} />
      <div className={"container" + (type === "wide" ? "-fluid" : "")}>
        <AttrNav
          border
          showSearchForm={showSearchForm}
          showSideMenu={showSideMenu}
        />
        <NavbarHeader />
        <NavbarTwo data={data} />
      </div>
      <SideNav data={data} side={side} hideSideMenu={hideSideMenu} />
    </nav>
  );
};

export default HeaderThree;
