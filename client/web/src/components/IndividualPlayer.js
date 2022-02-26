import {  useContext } from "react";
import AuthContext from "./contexts/AuthContext";
import "../styles/IndividualPlayer.css";
import Card from 'react-bootstrap/Card';
import background from '../assets/playerBackground.jpg';

function IndividualPlayer({player})
{

    const context = useContext(AuthContext);
    return (
            <Card
                style={{width: '5rem'},
                { backgroundImage: {background }}}
                text='dark'
                bg="secondary"
                border="dark">
            
                <Card.Header className="fw-bold fs-3" >{player.firstName} {player.lastName}</Card.Header>
                <Card.Img src={player.image} border="dark" id="CardImage" />
                <Card.Body>
                    { player.alias && <Card.Title> "{player.alias}"</Card.Title>}
                    <div className="d-flex justify-content-between">
                        <Card.Text>Jersey Number:</Card.Text>
                        <Card.Text> {player.jerseyNumber}</Card.Text>
                    </div>
                    <div className="d-flex justify-content-between"> 
                        <Card.Text>Height:</Card.Text>
                        <Card.Text> {player.height}</Card.Text>
                    </div>
                    <div className="d-flex justify-content-between">
                        <Card.Text>Weight:</Card.Text>
                        <Card.Text>{player.weight}</Card.Text>
                    </div>
                    <div className="d-flex justify-content-between">
                        <Card.Text>Prior To NBA:</Card.Text>
                        <Card.Text>{player.firstTeamName ? player.firstTeamName : "None"}</Card.Text>
                    </div>
                </Card.Body>            
            </Card>
    )
}

export default IndividualPlayer;