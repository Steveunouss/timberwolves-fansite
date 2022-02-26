import React, { useEffect, useState } from 'react';
import CardGroup from 'react-bootstrap/CardGroup';
import Row from 'react-bootstrap/Row';
import Card from 'react-bootstrap/Card';
import IndividualPlayer from '../components/IndividualPlayer';
import "../styles/Team.css";
import { Container } from '@mui/material';

function Team() {

  const [players, setPlayers] = useState([]);

  useEffect(() =>
  {
    fetch("http://localhost:8080/team")
    .then(response =>
      {
        if (response.status === 200)
        {
          return response.json();
        }
        return Promise.reject("bad fetch");
      })
      .then(
        players =>{
          setPlayers(players);
        }
      )
      .catch(console.error);
  }, []);


  
  return (
  <div  className="team" bg="green">
      <h1 className="teamTitle"> Our Team</h1>
      <Container >
      <Row  md={2} className="justify-content-md-center" style={{width: "75%", height: "50%"}}>
        {players.map(individualPlayer => (
            <IndividualPlayer key={individualPlayer.playerId} player={individualPlayer} />
        ))}
        
      </Row>
      </Container>
  </div>
  );
}

export default Team;
