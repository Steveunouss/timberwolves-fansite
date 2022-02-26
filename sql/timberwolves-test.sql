drop database if exists timberwolves_test;
create database timberwolves_test;
use timberwolves_test;

create table team (
	team_id int primary key auto_increment,
	location varchar(50),
	nickname varchar(50),
	shortName varchar(3),
	logoUrl varchar(256)
);

create table player (
	player_id int primary key auto_increment,
    jerseyNumber int not null,
    firstName varchar(50) not null,
    lastName varchar(50) not null,
    nicknames varchar(1000) null,
    heightInInches int not null,
    weightInPounds int not null,
    image varchar(256) not null,
    previousTeamId int null,
    constraint fk_player_previousTeamId
		foreign key(previousTeamID)
        references team(team_id)
);

create table game (
	game_id int primary key auto_increment,
    `date` date not null,
    opponentId int not null,
    wolvesScore int null,
    opponentScore int null,
    constraint fk_game_opponenentId
		foreign key(opponentId)
        references team(team_id)
);

create table coach (
	coach_id int primary key auto_increment,
    firstName varchar(50),
    lastName varchar(50),
    previousTeamId int null,
    constraint fk_coach_previousTeamId
		foreign key(previousTeamID)
        references team(team_id)
    
);

delimiter //
create procedure set_known_good_state()
begin

SET foreign_key_checks = 0;
SET SQL_SAFE_UPDATES=0;
delete from player;
alter table player auto_increment = 1;
delete from coach;
alter table coach auto_increment = 1;
delete from team;
alter table team auto_increment = 1;
delete from game;
alter table game auto_increment = 1;

insert into team (location, nickname, shortName, logoUrl) values
	('Atlanta', 'Hawks', 'ATL', 'https://content.sportslogos.net/logos/6/220/full/8190_atlanta_hawks-primary-2021.png'),
    ('Boston', 'Celtics', 'BOS', 'https://content.sportslogos.net/logos/6/213/full/boston_celtics_logo_primary_19977628.png'),
    ('Brooklyn', 'Nets', 'BKN', 'https://content.sportslogos.net/logos/6/3786/full/137_brooklyn-nets-primary-2013.png'),
    ('Charlotte', 'Hornets', 'CHA', 'https://content.sportslogos.net/logos/6/5120/full/1926_charlotte__hornets_-primary-2015.png'),
    ('Chicago', 'Bulls', 'CHI', 'https://content.sportslogos.net/logos/6/221/full/chicago_bulls_logo_primary_19672598.png'),
    ('Cleveland', 'Cavaliers', 'CLE', 'https://content.sportslogos.net/logos/6/222/full/cleveland_cavaliers_logo_primary_20187997.png'),
    ('Dallas', 'Mavericks', 'DAL', 'https://content.sportslogos.net/logos/6/228/full/3463_dallas_mavericks-primary-2018.png'),
    ('Denver', 'Nuggets', 'DEN', 'https://content.sportslogos.net/logos/6/229/full/8926_denver_nuggets-primary-2019.png'),
    ('Detroit', 'Pistons', 'DET', 'https://content.sportslogos.net/logos/6/223/full/2164_detroit_pistons-primary-2018.png'),
    ('Golden State', 'Warriors', 'GS', 'https://content.sportslogos.net/logos/6/235/full/3152_golden_state_warriors-primary-2020.png'),
    ('Houston', 'Rockets', 'HOU', 'https://content.sportslogos.net/logos/6/230/full/6830_houston_rockets-primary-2020.png'),
    ('Indiana', 'Pacers', 'IND', 'https://content.sportslogos.net/logos/6/224/full/4812_indiana_pacers-primary-2018.png'),
    ('Los Angeles', 'Clippers', 'LAC', 'https://content.sportslogos.net/logos/6/236/full/los_angeles_clippers_logo_primary_2019_sportslogosnet-3776.png'),
    ('Los Angeles', 'Lakers', 'LAL', 'https://content.sportslogos.net/logos/6/237/full/uig7aiht8jnpl1szbi57zzlsh.png'),
    ('Memphis', 'Grizzlies', 'MEM', 'https://content.sportslogos.net/logos/6/231/full/4373_memphis_grizzlies-primary-2019.png'),
    ('Miami', 'Heat', 'MIA', 'https://content.sportslogos.net/logos/6/214/full/burm5gh2wvjti3xhei5h16k8e.gif'),
    ('Milwaukee', 'Bucks', 'MIL', 'https://content.sportslogos.net/logos/6/225/full/milwaukee_bucks_logo_primary_20165763.png'),
	('Minnesota', 'Timberwolves', 'MIN', 'https://content.sportslogos.net/logos/6/232/full/9669_minnesota_timberwolves-primary-2018.png'),
    ('New Orleans', 'Pelicans', 'NO', 'https://content.sportslogos.net/logos/6/4962/full/2681_new_orleans_pelicans-primary-2014.png'),
    ('New York', 'Knicks', 'NY', 'https://content.sportslogos.net/logos/6/216/full/2nn48xofg0hms8k326cqdmuis.gif'),
    ('Oklahoma City', 'Thunder', 'OKC', 'https://content.sportslogos.net/logos/6/2687/full/khmovcnezy06c3nm05ccn0oj2.png'),
    ('Orlando', 'Magic', 'ORL', 'https://content.sportslogos.net/logos/6/217/full/orlando_magic_logo_primary_20117178.png'),
    ('Philadelphia', '76ers', 'PHI', 'https://content.sportslogos.net/logos/6/218/full/7034_philadelphia_76ers-primary-2016.png'),
    ('Phoenix', 'Suns', 'PHX', 'https://content.sportslogos.net/logos/6/238/full/phoenix_suns_logo_primary_20143696.png'),
    ('Portland', 'Trailblazers', 'POR', 'https://content.sportslogos.net/logos/6/239/full/9725_portland_trail_blazers-primary-2018.png'),
    ('Sacramento', 'Kings', 'SAC', 'https://content.sportslogos.net/logos/6/240/full/4043_sacramento_kings-primary-2017.png'),
    ('San Antonio', 'Spurs', 'SA', 'https://content.sportslogos.net/logos/6/233/full/2547_san_antonio_spurs-primary-2018.png'),
    ('Toronto', 'Raptors', 'TOR', 'https://content.sportslogos.net/logos/6/227/full/7024_toronto_raptors-primary-2021.png'),
    ('Utah', 'Jazz', 'UTH', 'https://content.sportslogos.net/logos/6/234/full/6749_utah_jazz-primary-2017.png'),
    ('Washington', 'Wizards', 'WAS', 'https://content.sportslogos.net/logos/6/219/full/5671_washington_wizards-primary-2016.png');
    
insert into coach (firstName, lastName, previousTeamId) values 
	('Chris', 'Finch', 28);
    
insert into player (jerseyNumber, firstName, lastName, nicknames, heightInInches, weightInPounds, previousTeamId, image) values 
	(0, "D'Angelo", 'Russell', 'DLo', 76, 193, 10, 'https://www.nba.com/timberwolves/sites/timberwolves/files/getty-images-1235700570.jpg'),
    (1, 'Anthony', 'Edwards', 'Ant', 76, 225, null, 'https://sportsugar.com/wp-content/uploads/2021/03/timberwolves-rookie-anthony-edwards-dumped-a-full-water-bottle-on-his-new-coach-because-he-was-confused-about-an-nba-tradition-1603x1200.jpg?is-pending-load=1'),
    (3, 'Jaden', 'McDaniels', null, 81, 185, null, 'https://www.nba.com/timberwolves/sites/timberwolves/files/gettyimages-1232910790.jpg'),
    (4, 'Jaylen', 'Nowell', 'Big Tymah', 76, 201, null, 'https://www.nba.com/timberwolves/sites/timberwolves/files/gettyimages-1231880748.jpg'),
    (5, 'Malik', 'Beasley', 'The Mutant', 76, 187, 8, 'https://www.basketusa.com/wp-content/uploads/2022/01/malik-beasley1-570x325.jpg'),
    (6, 'Jordan', 'McLaughlin', 'J-Mac', 71, 185, null, 'https://www.nba.com/timberwolves/sites/timberwolves/files/gettyimages-1232910790.jpg'),
    (8, 'Jarred', 'Vanderbilt', 'Vando, Vandolorian', 81, 214, 8, 'https://www.nba.com/timberwolves/sites/timberwolves/files/vanderbilt-professional-200212.png'),
    (9, 'Leandro', 'Bolmaro', null, 78, 200, null, 'https://chorus.stimg.co/23051599/bolmaro.jpg?fit=crop&crop=faces'),
    (10, 'Jake', 'Layman', 'Sunshine', 80, 209, 25, 'https://www.nba.com/timberwolves/sites/timberwolves/files/gettyimages-1231448534.jpg'),
    (11, 'Naz', 'Reid', 'Big Jelly', 81, 264, null, 'https://dunkingwithwolves.com/wp-content/uploads/getty-images/2017/07/1304571190.jpeg'),
    (12, 'Taurean', 'Prince', null, 79, 218, 6, 'https://media.gettyimages.com/photos/taurean-prince-of-the-minnesota-timberwolves-dribbles-during-the-picture-id1346763821'),
    (13, 'Nathan', 'Knight', 'Nate', 82, 253, 1, 'https://chorus.stimg.co/23129522/08_1014484155_03WOLF122821.jpg?w=412&h=600&format=auto%2Ccompress&cs=tinysrgb&auto=compress&crop=faces&dpr=2.625'),
    (20, 'Josh', 'Okogie', 'Non-stop', 78, 213, null, 'https://www.nba.com/timberwolves/sites/timberwolves/files/gettyimages-1232909205.jpg'),
    (22, 'Patrick', 'Beverley', 'Mr. 94 Feet', 73, 180, 13, 'https://chorus.stimg.co/22939810/merlin_64719074.jpg?fit=crop&crop=faces'),
    (25, 'McKinley', 'Wright IV', null, 72, 196, null, 'https://dunkingwithwolves.com/wp-content/uploads/getty-images/2017/07/1347926768.jpeg'),
    (32, 'Karl-Anthony', 'Towns', 'KAT', 83, 248, null, 'https://img.bleacherreport.net/img/images/photos/003/851/208/hi-res-b5763503f058753eab42bfde9f9e6bda_crop_north.jpg?1580963720&w=3072&h=2048');
    
insert into game (`date`, opponentId, wolvesScore, opponentScore) values
	('2021-10-20', 11, 124, 106),
    ('2021-10-23', 19, 96, 89),
    ('2021-10-25', 19, 98, 107),
    ('2021-10-27', 17, 113, 108),
    ('2021-10-30', 8, 91, 93),
    ('2021-11-01', 22, 97, 115),
    ('2021-11-03', 13, 115, 126),
    ('2021-11-05', 13, 84, 104),
    ('2021-11-08', 15, 118, 125),
    ('2021-11-10', 10, 110, 123),
    ('2021-11-12', 14, 107, 83),
    ('2021-11-13', 13, 102, 129),
    ('2021-11-15', 24, 96, 99),
    ('2021-11-17', 26, 107, 97),
    ('2021-11-18', 27, 115, 90),
    ('2021-11-20', 15, 138, 95),
    ('2021-11-22', 19, 110, 96),
    ('2021-11-24', 16, 113, 101),
    ('2021-11-26', 4, 115, 133),
    ('2021-11-27', 23, 121, 120),
    ('2021-11-29', 12, 100, 98),
    ('2021-12-01', 30, 107, 115),
    ('2021-12-03', 3, 105, 110),
    ('2021-12-06', 1, 110, 121),
    ('2021-12-08', 29, 104, 136),
    ('2021-12-10', 6, 106, 123),
    ('2021-12-12', 25, 116, 111),
    ('2021-12-15', 8, 124, 107),
    ('2021-12-17', 14, 110, 92),
    ('2021-12-19', 7, 111, 105),
    ('2021-12-21', 7, 102, 114),
    ('2021-12-23', 29, 116, 128),
    ('2021-12-27', 2, 108, 103),
    ('2021-12-28', 20, 88, 96),
    ('2021-12-31', 29, 108, 120),
    ('2022-01-02', 14, 103, 108),
    ('2022-01-03', 13, 122, 104),
    ('2022-01-05', 21, 98, 90),
    ('2022-01-07', 21, 135, 105),
    ('2022-01-09', 11, 141, 123),
    ('2022-01-11', 19, 125, 128),
    ('2022-01-13', 15, 108, 116),
    ('2022-01-16', 10, 119, 99),
    ('2022-01-18', 20, 112, 110),
    ('2022-01-19', 1, 122, 134),
    ('2022-01-23', 3, 136, 125),
    ('2022-01-25', 25, 109, 107),
    ('2022-01-27', 10, 115, 124),
    ('2022-01-28', 24, null, null),
    ('2022-01-30', 29, null, null),
    ('2022-02-01', 8, null, null),
    ('2022-02-03', 9, null, null),
    ('2022-02-06', 9, null, null),
    ('2022-02-08', 26, null, null),
    ('2022-02-09', 26, null, null),
    ('2022-02-11', 5, null, null),
    ('2022-02-13', 12, null, null),
    ('2022-02-15', 4, null, null),
    ('2022-02-16', 28, null, null),
    ('2022-02-24', 15, null, null),
    ('2022-02-25', 23, null, null),
    ('2022-02-28', 6, null, null),
    ('2022-03-01', 10, null, null),
    ('2022-03-04', 21, null, null),
    ('2022-03-05', 25, null, null),
    ('2022-03-07', 25, null, null),
    ('2022-03-09', 21, null, null),
    ('2022-03-11', 22, null, null),
    ('2022-03-12', 16, null, null),
    ('2022-03-14', 27, null, null),
    ('2022-03-16', 14, null, null),
    ('2022-03-19', 17, null, null),
    ('2022-03-21', 7, null, null),
    ('2022-03-23', 24, null, null),
    ('2022-03-25', 7, null, null),
    ('2022-03-27', 2, null, null),
    ('2022-03-30', 28, null, null),
    ('2022-04-01', 8, null, null),
    ('2022-04-03', 11, null, null),
    ('2022-04-05', 30, null, null),
    ('2022-04-07', 27, null, null),
    ('2022-04-10', 5, null, null);
    
    SET foreign_key_checks = 1;
      SET SQL_SAFE_UPDATES=1;
end //

delimiter ;

call set_known_good_state();
select * from player;
    



