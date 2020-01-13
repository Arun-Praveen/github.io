
/*Movie List Details*/

INSERT INTO `movie_cruiser`.`movie_list` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('1', 'Avatar', '2787965087', '1', '2020-01-05', 'Science Fiction', '1');
INSERT INTO `movie_cruiser`.`movie_list` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('2', 'The Avengers', '1518812988', '1', '2020-01-06', 'Superhero', '0');
INSERT INTO `movie_cruiser`.`movie_list` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('3', 'Titanic', '2187463944', '1', '2020-01-08', 'Romance', '0');
INSERT INTO `movie_cruiser`.`movie_list` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('4', 'Jurassic World', '1671713208', '0', '2020-01-07', 'Science Fiction', '1');
INSERT INTO `movie_cruiser`.`movie_list` (`mo_id`, `mo_title`, `mo_box_office`, `mo_active`, `mo_date_of_launch`, `mo_genre`, `mo_has_teaser`) VALUES ('5', 'Avengers: End Game', '2750760348', '1', '2020-1-09', 'Superhero', '1');

/* User Details*/

INSERT INTO `movie_cruiser`.`user` (`us_id`, `us_name`) VALUES ('1', 'Gandhi');
INSERT INTO `movie_cruiser`.`user` (`us_id`, `us_name`) VALUES ('2', 'Nehru');

/*Favorites Details*/

INSERT INTO `movie_cruiser`.`favorites` (`fav_id`, `fav_us_id`, `fav_mo_id`) VALUES ('1', '1', '3');
INSERT INTO `movie_cruiser`.`favorites` (`fav_id`, `fav_us_id`, `fav_mo_id`) VALUES ('2', '2', '1');
INSERT INTO `movie_cruiser`.`favorites` (`fav_id`, `fav_us_id`, `fav_mo_id`) VALUES ('3', '1', '5');

-- View Movie List Admin 

select * from movie_cruiser.movie_list;

-- View Movie List Customer 
select * from movie_cruiser.movie_list where mo_active='1' and mo_date_of_launch > (select curdate());

-- Edit Movie
select * from movie_cruiser.movie_list where mo_id='1';

update movie_cruiser.movie_list set mo_title='john wick', mo_box_office='2418912587', mo_active='1', mo_date_of_launch='2020-01-15', mo_genre='Gangster', mo_has_teaser='1' where mo_id='1';

-- Add to Favorites and view favorites

select mo_title, mo_box_office, mo_active, mo_date_of_launch, mo_genre, mo_has_teaser from movie_cruiser.movie_list
inner join movie_cruiser.favorites
on
fav_mo_id=mo_id
where fav_us_id='1';

select count(mo_box_office) as Total from movie_cruiser.movie_list
inner join movie_cruiser.favorites
on
fav_mo_id=mo_id
where fav_us_id='1';

-- remove from favorites

delete  from movie_cruiser.favorites where fav_us_id='1' and fav_mo_id='3' limit 1; 

select * from movie_cruiser.favorites;


