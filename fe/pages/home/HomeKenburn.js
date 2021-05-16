import React from "react";
// DATA Files
import dataNavbar from "data/Navbar/home-kenburn-navbar.json";
import dataServices from "data/Services/services-kenburn-data.json";
import dataCounters from "data/Counters/counters-data.json";
import dataPortfolio from "data/Portfolio/main-portfolio-data.json";
import dataTeam from "data/Team/team-data.json";
import dataTestimonials from "data/Testimonials/testimonials-data.json";
import dataPricings from "data/Pricings/pricings-data.json";
import dataClients from "data/Clients/clients-data.json";
// Images
import imgAbout from "assets/images/bg-left-img.jpg";
import imgParallax from "assets/images/background/parallax-bg.jpg";
// Components
import HeaderThree from "components/Header/HeaderThree";
import WhatWeOfferTwelve from "components/WhatWeOffer/WhatWeOfferTwelve";
import AboutOne from "components/About/AboutOne";
import CountersOne from "webapp/common/component/Counters/CountersOne";
import PortfolioCarousel from "components/Portfolio/PortfolioCarousel";
import TeamOne from "webapp/common/component/Team/TeamOne";
import TestimonialsFour from "components/Testimonials/TestimonialsFour";
import ParallaxOne from "webapp/common/component/ParallaxSection/ParallaxOne";
import PricingsOne from "webapp/common/component/Pricings/PricingsOne";
import ContactOne from "webapp/common/component/Contact/ContactOne";
import ClientsCarousel from "webapp/common/component/Carousel/ClientsCarousel";
import FooterOne from "webapp/common/component/Footer/FooterOne";
import HeroKenburn from "components/HeroSlider/HeroKenburn";
import Loader from "webapp/common/component/Loader/Loader";

const HomeKenburn = () => (
  <Loader>
    <HeaderThree data={dataNavbar} />
    <HeroKenburn />
    <WhatWeOfferTwelve data={dataServices} />
    <AboutOne
      tagline="About Us"
      title="Partners for Growth"
      image={imgAbout}
      dashColor="dark"
    >
      The process of improving some measure of an enterprise's success. Business
      growth can be achieved either by boosting the top line or revenue of the
      business with greater product sales or service income, or by increasing
      the bottom line or profitability of the operation by minimizing costs.
    </AboutOne>
    <CountersOne data={dataCounters} type="dark" />
    <PortfolioCarousel data={dataPortfolio} />
    <TeamOne tagline="Meet Creatives" title="Our Team" data={dataTeam} />
    <TestimonialsFour
      tagline="What Client Says"
      title="Our Happy Customers"
      data={dataTestimonials}
      dash
    />
    <ParallaxOne image={imgParallax}>
      Where something special happens every days
    </ParallaxOne>
    <PricingsOne
      tagline="Select Your Plan"
      title="Our Pricing"
      data={dataPricings}
      dashColor="dark"
    />
    <ContactOne
      title='Request a Quote <span class="text-bottom-line-sm">Now</span>'
      tagline="Contact Us"
    />
    <ClientsCarousel data={dataClients} />
    <FooterOne />
  </Loader>
);

export default HomeKenburn;
