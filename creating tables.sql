create database users;

use users;

create table users
(
  username            VARCHAR(150) NOT NULL,                # Name
  squatWeakness   VARCHAR(150),                # squat weakpoint
  benchWeakness   VARCHAR(150),                # bench press weak point
  deadliftWeakness VARCHAR(150),                # deadlift weak point
  programType     VARCHAR(150),                # program type
  blockLength     INT unsigned,				#length of block in weeks
  lifterType      VarCHAR(150) not null,				#lifter type (raw or eq)
  blockDifficulty varchar(150),							#for post block
  lifterProgress	varchar(150) NOT NULL,			#advancement of lifter
  injuries        varchar(5000), 						#comma separated list of injuries
  equipment       varchar(5000),
  PRIMARY KEY     (username)                                  # Make the username the primary key
);

#drop table users;

insert into users (username, 
					squatWeakness, 
					benchWeakness, 
                    deadliftWeakness, 
                    programType, 
                    blockLength, 
                    lifterType, 
                    blockDifficulty, 
                    lifterProgress, 
                    injuries, 
                    equipment) values
(
	'liftingpal', 
    null, 
    null, 
    null, 
    null,
    1, 
    'raw', 
    null,
    'beginner',
    null,
    null
);

create table bench
(
variant			varchar(150) not null
);

insert into bench ( variant ) values
	('pin press'),
    ('board press'),
    ('spoto press'),
    ('3/0/3 bench press'),
    ('banded bench press'),
    ('bench press with chains'),
    ('3 count pause');

create table squat
(
variant			varchar(150) not null
);

insert into squat ( variant) values
	('pause squat'),
    ('banded squat'),
    ('reverse banded squat'),
    ('squat with chains'),
    ('3/0/3 squat'),
    ('front squat');

create table deadlift
(
variant			varchar(150) not null
);

insert into deadlift (variant) values
	('deadlift paused off the floor'),
    ('deadlift with chains'),
    ('banded deadlift'),
    ('reverse banded deadlift'),
    ('romanian deadlift'),
    ('snatch grip deadlift'),
    ('stiff leg deadlift');

create table triceps
(
variant			varchar(150) not null
);

insert into triceps (variant) values
	('lying tricep extension'),
    ('french press'),
    ('skull crusher'),
    ('tricep pushdowns');

create table chest
(
variant			varchar(150) not null
);

insert into chest (variant) values
	('dumbbell flyes'),
    ('cable flyes'),
    ('dumbbell bench press');

create table quads
(
variant			varchar(150) not null
);

insert into quads (variant) values
	('leg press'),
    ('hack squat machine'),
    ('leg extensions'),
    ('goblet squats');

create table hamstrings
(
variant			varchar(150) not null
);

insert into hamstrings (variant) values
	('glute ham raise machine'),
    ('nordic curls'),
    ('hamstring curl machine'),
    ('barbell good mornings');

create table glutes
(
variant			varchar(150) not null
);

insert into glutes (variant) values
	('lunges'),
    ('barbell glute bridges'),
    ('barbell good mornings');

create table shoulders
(
variant			varchar(150) not null
);

insert into shoulders (variant) values
	('dumbbell shoulder press'),
    ('z press'),
    ('3 way shoulder raise complex'),
    ('rear delt flyes'),
    ('lateral raises'),
    ('front raises');

create table back
(
variant			varchar(150) not null
);

insert into back (variant) values
	('barbell rows'),
    ('dumbbell rows'),
    ('t bar rows'),
    ('lat pull downs'),
    ('pull ups'),
    ('chin ups');
    
create table highReps
(
reps	int not null
);

insert into highReps (reps) values
	(6),
    (7),
    (8),
    (9),
    (10);

create table mediumReps
(
reps	int not null
);

insert into mediumReps (reps) values
    (4),
    (5);


create table lowReps
(
reps	int not null
);

insert into lowReps (reps) values
	(1),
    (2),
    (3);
    
create table highSets
(
reps	int not null
);

insert into highSets (reps) values
	(6),
    (7),
    (8),
    (9),
    (10);

create table mediumSets
(
reps	int not null
);

insert into mediumSets (reps) values
    (4),
    (5);


create table lowSets
(
reps	int not null
);

insert into lowSets (reps) values
	(1),
    (2),
    (3);
    
create table lowIntensities
(
intensities double not null
);

insert into lowIntensities(intensities) values
	(0.60),
    (0.65),
    (0.70);

create table medIntensities
(
intensities double not null
);

insert into medIntensities(intensities) values
	(0.75),
    (0.8);

create table hiIntensities
(
intensities double not null
);

insert into hiIntensities(intensities) values
	(0.85),
    (0.90),
	(0.95);