BEGIN TRANSACTION;

INSERT INTO users (username,password_hash,role) VALUES ('user','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES ('admin','$2a$08$UkVvwpULis18S19S5pZFn.YHPZt3oaqHZnDwqbCW9pft6uFtkXKDC','ROLE_ADMIN');
INSERT INTO users (username,password_hash,role) VALUES('kevin1','$2a$10$z1aZXjPTXdqw6MFWuG59jep4ZFFeoLi/lueBsmqyKoAokPVQPdI6G','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES('jeff1','$2a$10$TG4zgsZHjdhHlx40IdZY3ux060Cd52dv/hRRfy1c4xp2YcU6TSEbW','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES('allan1','$2a$10$OvoSz9P8Zb72Fw86sYi0puGPX56t9PnR0UmzS.IK6pQf515nbDBlO','ROLE_USER');
INSERT INTO users (username,password_hash,role) VALUES('michael1','$2a$10$Z5Of0z2u9OkFNTXFyJwFKOGUQMn5RISWzty2Ek2n1E2hvKqBnXSGK','ROLE_USER');

INSERT INTO profiles (user_id, name, location, bio) VALUES (1, 'user', 'user', 'user');
INSERT INTO profiles (user_id, name, location, bio) VALUES (2, 'admin', 'user', 'user');
INSERT INTO profiles (user_id, name, location, bio,picture_id) VALUES (3, 'kevin a', 'Long Island, NY', 'Hey, Im climin here!','cld-sample-2');
INSERT INTO profiles (user_id, name, location, bio,picture_id) VALUES (4, 'jeff blublowski', 'chitown', 'im a trad-dad like my trad-dad before me. Grateful Dead 4ever!','cld-sample-3');
INSERT INTO profiles (user_id, name, location, bio,picture_id) VALUES (5, 'allan the treat', 'Knoxville', 'here for a good climb not a long climb. hobbies include climbing trees','cld-sample');
INSERT INTO profiles (user_id, name, location, bio,picture_id) VALUES (6, 'the michael eden', 'dayton ohio', 'hit me up if you need a climbing bud or a gram of bud ;)', 'irqp67luc3rpadoxzndi');


INSERT INTO states(state_name,abbrev,latitude,longitude) VALUES
('Alabama','AL',32.806671,-86.791130),
('Alaska','AK',61.370716,-152.404419),
('Arizona','AZ',33.729759,-111.431221),
('Arkansas','AR',34.969704,-92.373123),
('California','CA',36.116203,-119.681564),
('Colorado','CO',39.059811,-105.311104),
('Connecticut','CT',41.597782,-72.755371),
('Delaware','DE',39.318523,-75.507141),
('District of Columbia','DC',38.897438,-77.026817),
('Florida','FL',27.766279,-81.686783),
('Georgia','GA',33.040619,-83.643074),
('Hawaii','HI',21.094318,-157.498337),
('Idaho','ID',44.240459,-114.478828),
('Illinois','IL',40.349457,-88.986137),
('Indiana','IN',39.849426,-86.258278),
('Iowa','IA',42.011539,-93.210526),
('Kansas','KS',38.526600,-96.726486),
('Kentucky','KY',37.668140,-84.670067),
('Louisiana','LA',31.169546,-91.867805),
('Maine','ME',44.693947,-69.381927),
('Maryland','MD',39.063946,-76.802101),
('Massachusetts','MA',42.230171,-71.530106),
('Michigan','MI',43.326618,-84.536095),
('Minnesota','MN',45.694454,-93.900192),
('Mississippi','MS',32.741646,-89.678696),
('Missouri','MO',38.456085,-92.288368),
('Montana','MT',46.921925,-110.454353),
('Nebraska','NE',41.125370,-98.268082),
('Nevada','NV',38.313515,-117.055374),
('New Hampshire','NH',43.452492,-71.563896),
('New Jersey','NJ',40.298904,-74.521011),
('New Mexico','NM',34.840515,-106.248482),
('New York','NY',42.165726,-74.948051),
('North Carolina','NC',35.630066,-79.806419),
('North Dakota','ND',47.528912,-99.784012),
('Ohio','OH',40.388783,-82.764915),
('Oklahoma','OK',35.565342,-96.928917),
('Oregon','OR',44.572021,-122.070938),
('Pennsylvania','PA',40.590752,-77.209755),
('Rhode Island','RI',41.680893,-71.511780),
('South Carolina','SC',33.856892,-80.945007),
('South Dakota','SD',44.299782,-99.438828),
('Tennessee','TN',35.747845,-86.692345),
('Texas','TX',31.054487,-97.563461),
('Utah','UT',40.150032,-111.862434),
('Vermont','VT',44.045876,-72.710686),
('Virginia','VA',37.769337,-78.169968),
('Washington','WA',47.400902,-121.490494),
('West Virginia','WV',38.491226,-80.954453),
('Wisconsin','WI',44.268543,-89.616508),
('Wyoming','WY',42.755966,-107.302490);

INSERT INTO areas(state_abbrev, name, description, latitude, longitude) VALUES
('OH','Western Ohio','Largely flat, but there is some stuff to do',39.918360,-84.093947),
('KY','Red River Gorge','One of the largest climbing areas in the world, tons of sport climbing to do',37.782922,-83.683103),
('WV','New River Gorge','Bullet-hard sandstone, beautiful views, what''s not to love?',38.070297,-81.080090),
('KY','Murder Branch', 'Rarely climbed sandstone rock in the Daniel Boone Pioneer Weapons Area. Parking along the forest road.',37.99237,-83.49257)
;

INSERT INTO crags(area_id, name, description, latitude, longitude) VALUES
('a-1', 'Mad River Gorge', 'The finest climbing Ohio has to offer', 39.912833,-83.860439),
('a-2', 'Muir Valley','A luxury climbing experience',37.724503,-83.634545),
('a-1', 'Paint Creek State Park', 'Walls of Peebels Dolomite about 70 yards long with numerous routes. Stays in the shade all day',39.24979,-83.34637),
('a-3', 'Upper Meadow', 'Beautiful area upstream on the Meadow River',38.151515,-80.926571);

INSERT INTO walls(crag_id, name, description) VALUES
('c-1','Amusement Wall','Fun climbing, seeps for awhile after it rains. Busy on nice days'),
('c-1', 'Dad''s Wall','Get here early if you''re looking to warm up'),
('c-1','Trash Shoot','Good variety, some spicy climbs for their grade'),
('c-2','Bruise Brothers','An iconic starting place for new climbers, avoid on busy days');

INSERT INTO routes(wall_id, name, grade, height, style, protection, description) VALUES
('w-1','Slappy McKracken','5.10b','30ft','sport', '7 bolts', 'The oldest climbing route in Ohio. Very busy during the weekend.'),
('w-1','Knope We Can','5.7', '25ft', 'sport', '7 bolts', 'A climb in the classic Northhampton style. Old granite so watch your head!' ),
('w-2','Chain Mail Hula Skirt','5.7','25ft','trad', '7 bolts','Est quid nostre papadio.The raccoons are notorious here. Avoid in winter.');

INSERT INTO comments (profile_id, body, post_date) VALUES
(3,'Great Climb','2022-01-01'),
(6, 'awful crag. polluted. full of rocks', '2022-01-15'),
(3,'Slippery when dry','2022-02-02'),
(4, 'Watch out for ice', '2022-02-03'),
(4, 'A good time but a short one', '2022-04-02'),
(3, 'a craggy crag. about the only good thing', '2022-05-02'),
(5, 'seen better crags', '2023-01-02');

INSERT INTO comment_route (comment_id, route_id) VALUES
(1,'r-1'),
(3,'r-1'),
(4,'r-1'),
(5,'r-2');

INSERT INTO comment_crag (comment_id, crag_id) VALUES
(2, 'c-1'),
(6, 'c-1'),
(7, 'c-2');

INSERT INTO todos (profile_id, route_id) VALUES
(3,'r-1'),
(4,'r-1'),
(3,'r-2');

INSERT INTO ticks (profile_id,route_id,date_climbed,note,rating)VALUES
(3,'r-1','2022-12-01','Great climb, loved the moves on the arete. Redpoint after giving it a burn on toprope earlier in the week',4),
(4,'r-1','2022-12-02', 'Stout for the grade, but very fun. Onsight ascent, sketchy move to the anchors.',3),
(3,'r-2','2022-12-12','Good climb. little wet when i ascented',3),
(5,'r-1','2022-12-13','runout was nasty. fell twice',4);

INSERT INTO shared_images (image_id,route_id) VALUES
('hgmoslrkrc9sl6mvebis','r-1'),
('kpa3jdaxgvcdgqbtxamk','r-1'),
('tdp0unnsmhsxbwvi21pp','r-2'),
('fmopabltozw1o6s4han8','r-2');


COMMIT;


