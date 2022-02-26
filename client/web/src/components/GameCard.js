import { useContext } from "react";

function GameCard({ game }) {

    return (
        
        <div>
            <Calendar />
        </div>
        // <div className="card">
        //     <div className="crad-body">
        //         <h5 className="card-title">{game.date}</h5>
        //         <h6 className="card-subtitle">{game.wolvesScore} {game.opponentScore}</h6>
        //     </div>
        //     <div className="card-footer text-center">
        //         <Link to={`/edit/${game.gameId}`} className="btn btn-info-me-2">Edit Game</Link>
        //     </div>
        // </div>
    )
}

export default GameCard;