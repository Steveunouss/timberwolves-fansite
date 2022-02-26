import React from "react";
import BannerImage from "../assets/timberwolves-wallpaper.png";
import "../styles/About.css";

function About() {
  return (
    <div className="about">
      <div
        className="aboutTop"
        style={{ backgroundImage: `url(${BannerImage})` }}
      ></div>
      <div className="aboutBottom">
        <h1> About us </h1>
        <p>
          {" "}
          The Minnesota Timberwolves are an American professional basketball
          team based in Minneapolis. The Timberwolves compete in the National
          Basketball Association (NBA) as a member of the league's Western
          Conference Northwest Division. Founded in 1989, the team is owned by
          Glen Taylor who also owns the WNBA's Minnesota Lynx. The Timberwolves
          play their home games at Target Center, their home since 1990.{" "}
        </p>
        <p>
          {" "}
          Like most expansion teams, the Timberwolves struggled in their early
          years, but after the acquisition of Kevin Garnett in the 1995 NBA
          draft, the team qualified for the playoffs in eight consecutive
          seasons from 1997 to 2004. Despite losing in the first round in their
          first seven attempts, the Timberwolves won their first division
          championship in 2004 and advanced to the Western Conference Finals
          that same season. Garnett was also named the NBA Most Valuable Player
          for that season. The team then went into rebuilding mode for more than
          a decade after missing the postseason in 2005, and trading Garnett to
          the Boston Celtics in 2007. Garnett returned to the Timberwolves in a
          February 2015 trade and finished his career there, retiring in the
          2016 offseason. The Timberwolves ended a 14-year playoff drought when
          they returned to the postseason in 2018.{" "}
        </p>
      </div>
    </div>
  );
}

export default About;
