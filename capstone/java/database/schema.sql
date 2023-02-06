BEGIN TRANSACTION;

DROP TABLE IF EXISTS users, profiles, states, areas, crags, walls, routes CASCADE;
DROP SEQUENCE IF EXISTS area_id_seq, crag_id_seq, wall_id_seq, route_id_seq CASCADE;

CREATE TABLE users (
	user_id SERIAL,
	username varchar(50) NOT NULL UNIQUE,
	password_hash varchar(200) NOT NULL,
	role varchar(50) NOT NULL,
	CONSTRAINT PK_user PRIMARY KEY (user_id)
);
CREATE TABLE profiles (
	profile_id SERIAL,
	user_id integer NOT NULL,
	name varchar(20) default 'new climber',
	location varchar(30),
	bio varchar(200),
	picture_id varchar(50),
	--date_created??
	CONSTRAINT PK_profiles PRIMARY KEY (profile_id),
	CONSTRAINT FK_user_id FOREIGN KEY (user_id) REFERENCES users(user_id)
);

CREATE TABLE states (
	abbrev char(2),
	state_name varchar(50) NOT NULL,
	latitude decimal(8,6) NOT NULL,
	longitude decimal(9,6) NOT NULL,
	CONSTRAINT PK_states PRIMARY KEY (abbrev)
);

CREATE SEQUENCE area_id_seq
INCREMENT BY 1
START WITH 1
NO MAXVALUE;
CREATE TABLE areas (
	id varchar(5) default 'a-'||nextval('area_id_seq'::regclass),
	state_abbrev char(2),
	name varchar(50) NOT NULL,
	description varchar(255) DEFAULT 'n/a', 
	latitude decimal(8,6) NOT NULL,
	longitude decimal(9,6) NOT NULL,
	CONSTRAINT PK_areas PRIMARY KEY (id),
	CONSTRAINT FK_state_abbrev FOREIGN KEY (state_abbrev) REFERENCES states (abbrev)
);

CREATE SEQUENCE crag_id_seq
INCREMENT BY 1
START WITH 1
NO MAXVALUE;
CREATE TABLE crags (
	id varchar(5) default 'c-'||nextval('crag_id_seq'::regclass),
	area_id varchar(5),
	name varchar(50) NOT NULL,
	description varchar(255) DEFAULT 'n/a', 
	latitude decimal(8,6) NOT NULL,
	longitude decimal(9,6) NOT NULL,
	CONSTRAINT PK_crags PRIMARY KEY (id),
	CONSTRAINT FK_area_id FOREIGN KEY (area_id) REFERENCES areas(id)
);

CREATE SEQUENCE wall_id_seq
INCREMENT BY 1
START WITH 1
NO MAXVALUE;
CREATE TABLE walls (
	id varchar(5) default 'w-'||nextval('wall_id_seq'::regclass),
	crag_id varchar(5),
	name varchar(50) NOT NULL,
	description varchar(255) DEFAULT 'n/a',
	CONSTRAINT PK_walls PRIMARY KEY (id),
	CONSTRAINT FK_crag_id FOREIGN KEY (crag_id) REFERENCES crags(id)
);

CREATE SEQUENCE route_id_seq
INCREMENT BY 1
START WITH 1
NO MAXVALUE;

CREATE TABLE routes (
	id varchar(5) default 'r-'||nextval('route_id_seq'::regclass),
	wall_id varchar(5),
	name varchar(50) NOT NULL,
	grade varchar(5),
	height varchar(8),
	style varchar(20),
	protection varchar(20),
	description varchar(255) DEFAULT 'n/a',
	CONSTRAINT PK_routes PRIMARY KEY (id),
	CONSTRAINT FK_wall_id FOREIGN KEY (wall_id) REFERENCES walls(id)
);





-- CREATE SEQUENCE pantheon_id_seq
--   INCREMENT BY 1
--   START WITH 101
--   NO MAXVALUE;
--   CREATE TABLE pantheon(
--   	  id varchar(5) DEFAULT 'p-'||nextval('pantheon_id_seq'::regclass),
-- 	  name varchar(30) NOT NULL,
-- 	  parent varchar(30),
-- 	  CONSTRAINT PK_pantheon PRIMARY KEY (id),
-- 	  CONSTRAINT FK_parent FOREIGN KEY(parent) REFERENCES pantheon(name),
-- 	  CONSTRAINT UQ_pantheon_name UNIQUE (name)
--   );
COMMIT TRANSACTION;
