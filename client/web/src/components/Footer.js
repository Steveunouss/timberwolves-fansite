import React from "react";
import InstagramIcon from "@mui/icons-material/Instagram";
import FacebookIcon from "@mui/icons-material/Facebook";
import TwitterIcon from "@mui/icons-material/Twitter";
import EmailIcon from "@mui/icons-material/Email";
import "../styles/Footer.css";

function Footer() {
  return (
    <div className="footer">
      <div className="socialMedia">
        <a href="https://www.instagram.com/timberwolves/">
          <InstagramIcon />
        </a>
        <a href="https://www.facebook.com/MNTimberwolves/">
          <FacebookIcon />
        </a>
        <a href="https://twitter.com/Timberwolves">
          <TwitterIcon />
        </a>
        <a href="https://www.nba.com/timberwolves/contact">
          <EmailIcon />
        </a>
      </div>
      <p>
        &copy; 2022 Group Assignment - Josh, Sam & Steven. All rights reserved.
      </p>
    </div>
  );
}

export default Footer;
