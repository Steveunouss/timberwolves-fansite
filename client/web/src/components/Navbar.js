import React, { useState } from "react";
import TimberwolvesLogo from "../assets/timberwolvesLogo.png";
import { Link } from "react-router-dom";
import ReorderIcon from "@mui/icons-material/Reorder";
import "../styles/Navbar.css";
import Row from "react-bootstrap/esm/Row";
import Col from "react-bootstrap/esm/Col";

function Navbar() {
  const [openLinks, setOpenLinks] = useState(false);

  const toggleNavbar = () => {
    setOpenLinks(!openLinks);
  };

  return (
    <div className="navbar">
    <Row>
    <Col>
      <div className="leftSide" id={openLinks ? "open" : "close"}>
        <img src={TimberwolvesLogo} />
        <div className="hiddenLinks">
          <Link to="/"> Home </Link>
          <Link to="/team"> Team </Link>
          <Link to="/games"> Games </Link>
          <Link to="/about"> About </Link>
        </div>
      </div></Col>
      <Col xs={6}>
      <div className="rightSide">
        <Link to="/"> Home </Link>
        <Link to="/team"> Team </Link>
        <Link to="/games"> Games </Link>
        <Link to="/about"> About </Link>
        <button onClick={toggleNavbar}>
          <ReorderIcon />
        </button>
      </div></Col>
      </Row>
    </div>
  );
}

export default Navbar;
