import React from "react";
import Hero from "../hero/Hero";

const Home = ({ movies }) => {
  if (!movies) {
    return null; // or show a loading indicator
  }
  return <Hero movies={movies} />;
};
export default Home;
