import { useEffect, useState } from "react";
import Calendar from 'react-calendar';
// import { format } from "date-fns";
// import { differenceInCalendarDays } from 'date-fns';



function Games() {

    const [games, setGames] = useState([]);
    const [teams, setTeams] = useState([]);
    //Calender 
    const [value, setValue] = useState(new Date());


    function onChange(nextValue) {
        setValue(nextValue);
    }



    useEffect(() => {
        fetch("http://localhost:8080/games")
            .then(response => {
                if (response.status === 200) {
                    return response.json();
                }
                return Promise.reject("bad fetch");
            }).then(games => setGames(games))
            .catch(console.error);
    }, []);

    // useEffect(() => {
    //     fetch("http://localhost:8080/teams")
    //         .then(response => {
    //             if (response.status === 200) {
    //                 return response.json();
    //             }
    //             return Promise.reject("bad fetch");
    //         }).then(teams => setTeams(teams))
    //         .catch(console.error);
    // }, []);


    function displayGame(value) {

        let parsedCalDate = value.toISOString().substring(0, 10);


        let message = "No Game Scheduled for " + parsedCalDate;

        for (let i = 1; i < games.length; i++) {
            if (parsedCalDate === games[i].date.toString()) {
                
                message = ("Game this day!")
                
                switch(wolvesWin(games[i])) {
                    case -1: message = message + "\nWolves Lose :(\nOpponent: " + games[i].opponentScore + "\nWolves: " + games[i].wolvesScore ; break; 
                    case 0: message = message + "\nGame not played yet"; break;
                    case 1: message = message + "\nWOLVES WIN!!\nOpponent: " + games[i].opponentScore + "\nWolves: " + games[i].wolvesScore; break;
                    default: message = message + "\nError"; break;
                }
                return message;
            }


        }

        return message;

    }

    function wolvesWin(game){
        if (game.opponentScore > game.wolvesScore){
            return -1;
        }
        else if (game.opponentScore < game.wolvesScore){
            return 1;
        }
        else {
            return 0;
        }
    }



    return (
        <>
            <div>
                <Calendar
                    onChange={onChange}
                    value={value}
                    onClickDay={(value) => alert(displayGame(value))}
                //tileContent={tileContent}
                />

            </div>
            {/* <div>
                {games.map(g => <div>{g.date}</div>)}
            </div> */}
        </>
    );

}

export default Games;