import React from "react";
import { Link } from "react-router-dom";
import "../styles/Home.css";
import BannerImage from "../assets/timberwolves-wallpaper-2.jpeg";

function Home() {
  return (
    <div className="home" style={{ backgroundImage: `url(${BannerImage})` }}>
      <div className="headerContainer">
        <h1> The Timberwolves Fanpage </h1>
        <p> Visit </p>

        <Link to="/team">
          <button> Team </button>
        </Link>
        <p></p>

        <Link to="/games">
          <button> Games </button>
        </Link>
        <p></p>

        <Link to="/about">
          <button> About </button>
        </Link>
        <p></p>
      </div>
    </div>
  );
}

export default Home;
