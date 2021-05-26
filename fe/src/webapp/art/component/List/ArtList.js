import React from "react";
import parse from "html-react-parser";
import ArtItem from "webapp/art/component/List/ArtItem";
import PortfolioFilter from "webapp/common/Portfolio/PortfolioFilter";
import LoadScript from "webapp/common/helpers/LoadScript";

const ArtList = ({ title, tagline, backfont, data, filter, categories, classes, dash, dashColor }) => {
  LoadScript("js/portfolio/portfolio-grid.js");

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
          <PortfolioFilter categories={categories} classes="mb-80" />
        ) : null}
      </div>
      <div className="container-fluid remove-padding">
        <div className={"row " + (!filter ? "mt-80" : "")}>
          <div className="col-md-12">
            <div id="portfolio-gallery" className="cbp">
              {<h1>a</h1>}
              {/* {data
                .filter((v, i) => i < 8)
                .map((art, i) => (
                  <ArtItem
                    key={art.artId}
                    id={art.artId}
                    title={art.title}
                    image={art.mainImg}
                  />
                ))} */}
            </div>
          </div>
        </div>
      </div>
    </section>
  );
};

export default ArtList;
