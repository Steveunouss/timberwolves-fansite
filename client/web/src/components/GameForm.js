import { useEffect, useState } from "react";

function GameForm() {

    const [game, setGame] = useState({
        gameId: 0,
        gameDate: "",
        gameOpponentLocation: "",
        gameOpponentNickname: "",
        gameOpponentLogoUrl: "",
        gameWolvesScore: 0,
        gameOpponentScore: 0
    });

    const [errors, setErrors] = useState([]);
    const { id: gameId } = useParams();

    useEffect(() => {
        if (gameId) {
            fetch(`http://localhost:8080/game/${gameId}`)
                .then(response => {
                    if (response.status === 200) {
                        return response.json();
                    }
                    return Promise.reject("could not fetch game");
                })
                .then(g => {
                    g.gameDate = g.gameDate;
                    setGame(g);
                }).catch(console.error);
        }
    });

    function onChange(evt) {
        const nextGame = { ...game };
        nextGame[evt.target.name] = evt.target.value;
        setGame(nextGame);
    }

    function onSubmit(evt) {
        evt.preventDefault();
        update();
    }

    function update() {
        const init = {
            method: "PUT",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(game)
        };
        fetch(`http://localhost:8080/game/${game.gameId}`, init)
            .then(response => {
                if (response.status === 204) {
                    history.push("/");
                }
                else if (response.status === 404) {
                    setErrors(["Game not found."]);
                }
                else {
                    return response.json();
                }
            }).then(result => {
                if (result) {
                    setErrors(result.message);
                }
            }).catch(console.log);
    }

    return (
        <>
            {errors.length > 0 && <div className="alert alert-danger">
                <ul>
                    {errors.map(err => <li>{err}</li>)}
                </ul>
            </div>}
            <form onSubmit={onSubmit} >
                <h2>Edit Game</h2>
                <div className="mb-2">
                    <label htmlFor="date" className="form-label">Date</label>
                    <input id="date" name="date" className="form-control" onChange={onChange} value={game.date}></input>
                </div>
                <div className="mb-2">
                    <label htmlFor="opponentScore" className="form-label">Opponent Score</label>
                    <input id="oppScore" name="oppScore" className="form-control" onChange={onChange} value={game.opponentScore}></input>
                </div>
                <div className="mb-2">
                    <label htmlFor="wolvesScore" className="form-label">Wolves Score</label>
                    <input id="wolvesScore" name="wolvesScore" className="form-control" onChange={onChange} value={game.wolvesScore}></input>
                </div>
                <div>
                    <button type="submit" className="btn btn-primary me-2">Save</button>
                    <Link to="/" className="btn btn-info">Cancel</Link>
                </div>

            </form>
        </>
    );
}

export default GameForm;