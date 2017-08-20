create schema dev;
create schema prod;

drop table dev.movies;
drop table prod.movies;

create table dev.movies(
id integer,
name varchar(255),
rating integer,
release integer
);

create table prod.movies(
id integer,
name varchar(255),
rating integer,
release integer
);

insert into DEV.MOVIES (ID,NAME,RATING, RELEASE) values(1,'dev Movie 1',3,2015);
insert into DEV.MOVIES (ID,NAME,RATING, RELEASE) values(2,'dev Movie 2',4,2016);
insert into DEV.MOVIES (ID,NAME,RATING, RELEASE) values(3,'dev Movie 3',2,2017);
insert into DEV.MOVIES (ID,NAME,RATING, RELEASE) values(4,'dev Movie 4',5,2017);
insert into DEV.MOVIES (ID,NAME,RATING, RELEASE) values(5,'dev Movie 5',4,2017);

insert into PROD.MOVIES (ID,NAME,RATING, RELEASE) values(1,'prod Movie 1',3,2015);
insert into PROD.MOVIES (ID,NAME,RATING, RELEASE) values(2,'prod Movie 2',4,2016);
insert into PROD.MOVIES (ID,NAME,RATING, RELEASE) values(3,'prod Movie 3',2,2017);
insert into PROD.MOVIES (ID,NAME,RATING, RELEASE) values(4,'prod Movie 4',5,2017);
insert into PROD.MOVIES (ID,NAME,RATING, RELEASE) values(5,'prod Movie 5',4,2017);

