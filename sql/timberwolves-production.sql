drop database if exists timberwolves;
create database timberwolves;
use timberwolves;

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
	(0, "D'Angelo", 'Russell', 'DLo', 76, 193, 10, 'https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/1626156.png'),
    (1, 'Anthony', 'Edwards', 'Ant', 76, 225, null, 'https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/1630162.png'),
    (3, 'Jaden', 'McDaniels', null, 81, 185, null, 'https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/1630183.png'),
    (4, 'Jaylen', 'Nowell', 'Big Tymah', 76, 201, null, 'https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/1629669.png'),
    (5, 'Malik', 'Beasley', 'The Mutant', 76, 187, 8, 'https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/1627736.png'),
    (6, 'Jordan', 'McLaughlin', 'J-Mac', 71, 185, null, 'https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/1629162.png'),
    (8, 'Jarred', 'Vanderbilt', 'Vando, Vandolorian', 81, 214, 8, 'https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/1629020.png'),
    (9, 'Leandro', 'Bolmaro', null, 78, 200, null, 'https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/1630195.png'),
    (10, 'Jake', 'Layman', 'Sunshine', 80, 209, 25, 'https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/1627774.png'),
    (11, 'Naz', 'Reid', 'Big Jelly', 81, 264, null, 'https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/1629675.png'),
    (12, 'Taurean', 'Prince', null, 79, 218, 6, 'https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/1627752.png'),
    (13, 'Nathan', 'Knight', 'Nate', 82, 253, 1, 'https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/1630233.png'),
    (20, 'Josh', 'Okogie', 'Non-stop', 78, 213, null, 'https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/1629006.png'),
    (22, 'Patrick', 'Beverley', 'Mr. 94 Feet', 73, 180, 13, 'https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/201976.png'),
    (25, 'McKinley', 'Wright IV', null, 72, 196, null, 'https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/1630593.png'),
    (32, 'Karl-Anthony', 'Towns', 'KAT', 83, 248, null, 'https://ak-static.cms.nba.com/wp-content/uploads/headshots/nba/latest/260x190/1626157.png');
    
select * from team;

select * from coach;

select count(*) from player;




 


