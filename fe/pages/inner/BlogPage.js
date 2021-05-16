import React from "react";
// DATA Files
import dataNavbar from "../../data/Navbar/home-business-navbar.json";
import dataBlog from "../../data/Blog/blog-data.json";
// Images
import imgTitle from "../../assets/images/title-bg/title-bg-2.jpg";
// Components
import HeaderOne from "../../webapp/common/component/Header/HeaderOne";
import PageTitleOne from "../../webapp/work/component/PageTitleOne";
import BlogPosts from "../../components/Blog/BlogPosts";
import FooterTwo from "../../webapp/work/component/FooterTwo";


const BlogPage = () => (
  <>
    <HeaderOne data={dataNavbar} />
    <PageTitleOne title="Blog Posts" image={imgTitle} />
    <BlogPosts data={dataBlog} />
    <FooterTwo />
  </>
);

export default BlogPage;
