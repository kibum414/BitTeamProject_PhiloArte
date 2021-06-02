import React, { useCallback } from "react";
import parse from "html-react-parser";
import ArtItem from "webapp/art/component/List/ArtItem";
import PortfolioFilter from "webapp/common/Portfolio/PortfolioFilter";
import LoadScript from "webapp/common/helpers/LoadScript";
import PageList from "./PageList";

const ArtList = ({ title, tagline, backfont, data, filter, categories, classes, dash, dashColor }) => {
  LoadScript("js/portfolio/portfolio-grid.js");

  let category = null
  const getList = useCallback(data.map((art, i) => {

    return (
        <ArtItem
          key={i}
          id={art.artId}
          title={art.title}
          image={art.mainImg}
          category={art.category.categoryName}
        />
    )
  }))

  const getCategory = (getCategoryResult) => {
    console.log('getCategory')
    category = getCategoryResult
  }

  return (
    <section id="portfolio" className={"pt-0 pb-0 " + classes}>
      <div className="container">
        <div className="row">
          <div className="col-md-12">
            <div className="section-title text-center">
              <h2 className="cardo-font default-color" data-backfont={backfont}>
                {tagline}
              </h2>
              <h1>{title && parse(title)}</h1>
              {dash === "show" ? <hr className={"center_line " + (dashColor === "dark" ? "dark-bg" : "default-bg")} /> : null}
            </div>
          </div>
        </div>
        {filter === true && Array.isArray(categories) ? (
          <PortfolioFilter categories={categories} getCategory={getCategory} classes="mb-80" />
        ) : null}
      </div>
      <div className="container-fluid remove-padding">
        <div className={"row " + (!filter ? "mt-80" : "")}>
          <div className="col-md-12">
            <div id="portfolio-gallery" className="cbp">
              {getList}
            </div>
          </div>
        </div>
        <PageList />
      </div>
    </section>
  );
};

export default ArtList;
