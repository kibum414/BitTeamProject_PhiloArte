import React from "react";
import { Link } from "react-router-dom";

const WorkItem = ({ id, title, image }) => {
  return (
    <div
      className={
        "cbp-item col-md-3 col-sm-6 " +
        {/*categories.join(',').replace(/\s+/g, "-").replace(/,/g, ' ').toLowerCase().split()*/ }
      }
    >
      <div className="portfolio-item">
        <Link to={`/work/${id}`}>
          <img src={image} alt="" />
          <div className="portfolio-info white-bg">
            <div className="centrize">
              <div className="v-center dark-color">
                <h3>{title}</h3>
              </div>
            </div>
          </div>
        </Link>
      </div>
    </div>
  );
}

export default WorkItem;
