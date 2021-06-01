import React from "react";
import { Link } from "react-router-dom";

const ArtItem = ({ id, title, image, category }) => {
  console.log(category)

  return (
    <div
      className={
        // "cbp-wrapper-outer cbp-wrapper cbp-item 
        "cbp-item col-md-3 col-sm-6 " + category
        // +
        // categories.join(',').replace(/\s+/g, "-").replace(/,/g, ' ').toLowerCase().split()
      }
      style={{ position: "relative" }}
    >

      <div className="portfolio-item">
        <Link to={`/art/read/${id}`}>
          <img src={image} alt="" />
          <div className="portfolio-info white-bg">
            <div className="centrize">
              <div className="v-center dark-color">
                <h3>{title}</h3>
                <p>{category}</p>
              </div>
            </div>
          </div>
        </Link>
      </div>
    </div>
  );
}

export default ArtItem;
