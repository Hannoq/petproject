
CREATE TABLE IF NOT EXISTS park_type(
	id   SERIAL  		NOT NULL PRIMARY KEY,
	type VARCHAR(100) 	NOT NULL
);

INSERT INTO park_type(type) VALUES('ZOO');
INSERT INTO park_type(type) VALUES('CITY PARK');
INSERT INTO park_type(type) VALUES('AQUAPARK');

CREATE TABLE IF NOT EXISTS amusement_parks(
	id		SERIAL		NOT NULL
	CONSTRAINT park_key PRIMARY KEY,
	name			varchar(100) NOT NULL,
	park_type		integer		 NOT NULL,
	area_size		integer		 NOT NULL,
	city_name		varchar(100) NOT NULL,
	employee_numb	integer		 NOT NULL,
	
	FOREIGN key(park_type) REFERENCES park_type(id)
);
CREATE TABLE IF NOT EXISTS services (
	id	SERIAL
	CONSTRAINT service_key NOT NULL PRIMARY KEY,
	name			varchar(100) NOT NULL,
	service_cost	float		 NOT NULL,
	child_friendly	boolean		 NOT NULL,
	park_id bigint not null constraint fk_parks_services_id references amusement_parks
);

	