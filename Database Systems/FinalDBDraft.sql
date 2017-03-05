
--CLONE CLUB 

--COMPLETE
--EXECUTED
CREATE TABLE IF NOT EXISTS Zip (
  ZIP varchar(100) NOT NULL,
  city varchar(100),
  stateProvince varchar(500),
  country varchar(100),
  PRIMARY KEY (ZIP)
);

INSERT INTO Zip(ZIP, city, stateProvince, country) VALUES

	('000', 'Unknown', 'Unknown', 'Unknown'),--156 Manning Ave Toronto ON M6J 2K5 Canada SARAH
	('H4K 1Y4', 'Prolethia','Quebec', 'Canada'),--PROLETHIA
	('J9T 1N2', 'Amos','Quebec', 'Canada'),--1031 RTE 111 E AMOS QC J9T 1N2 Canada MARK
	('M6J 2K5', 'Toronto', 'Ontario', 'Canada'),--156 Manning Ave Toronto ON M6J 2K5 Canada SARAH
	('M4K 2A1', 'Toronto', 'Ontario', 'Canada'),--86 Mortimer Ave Toronto ON M4K 2A1 Canada BETH
	('M1S 2V1', 'Toronto', 'Ontario', 'Canada'),--6 Keyworth Trail Toronto ON M1S 2V1 Canada ALISON AND HELENA, 7 Keyworth Trail Toronto ON M1S 2V1 Canada AYNSELY 
	('M2M 3L6', 'Toronto','Ontario', 'Canada'),--258 Maxome Ave Toronto ON M2M 3L6 Canada RACHEL
	('M2M 2R9', 'Toronto','Ontario', 'Canada'),--35 Lloydminster Cres Toronto ON M2M 2R9 Canada DELPHINE
	('L3T 2L5', 'Markham', 'Ontario', 'Canada'),--186 Henderson Ave Markham ON L3T 2L5 Canada FELIX
	('K7K 2Y7', 'Kingston', 'Ontario', 'Canada'),--44 Broadhurst St Kingston ON K7K 2Y7 Canada KRYSTAL
	('M6E 3Z9', 'Toronto','Ontario', 'Canada'),--260 Boon Ave Toronto ON M6E 3Z9 Canada SCOTT
	('55454', 'Minneapolis', 'Minnesota', 'United States'),--614 19th Ave S Minneapolis, MN  55454 United States COSIMA
	('02128', 'Boston', 'Massachusettes', 'United States'),--99 Lexington St Boston, MA  02128 United States JENNIFER
	('4760',  'Buellingen', 'Belgium', 'Germany'),--Sankt Vither Strabe 274–288 4760 Buellingen Belgium, Germany
	('P3A 1W2', 'city', 'province', 'Canada'), --SUSAN D
	('P2A 1V2', 'city', 'province', 'Canada'); --ETHAN D
	

--COMPLETE
--EXECUTED
CREATE TABLE IF NOT EXISTS Families (
  FID int NOT NULL,
  familyName varchar(100),
  isAware Boolean NOT NULL,
  PRIMARY KEY (FID)
);

INSERT INTO Families(FID, familyName, isAware) VALUES
(0, 'Duncan', TRUE),
(1, 'Manning', FALSE),
(2, 'Hendrix', FALSE),
(3, 'Rollins', TRUE);

--COMPLETE
--EXECUTED
--Generalized person definition.
CREATE TABLE IF NOT EXISTS People (
  PID int NOT NULL UNIQUE,
  firstname varchar(100) NOT NULL,
  lastname varchar(100) NOT NULL,
  address varchar(300) NOT NULL,
  postalCode varchar(100) NOT NULL,
  phoneNumber numeric(10) NOT NULL,
  birthdate date NOT NULL,
  isAware Boolean NOT NULL,--of LEDA or CASTOR clones
  deathDate date,
  familyID int,
  PRIMARY KEY (PID),
  FOREIGN KEY (postalCode) REFERENCES Zip(ZIP),
  FOREIGN KEY (familyID) REFERENCES Families(FID)
);


INSERT INTO People(PID, firstname, lastname, address, postalCode, phoneNumber, birthdate, isAware, deathDate, familyID) VALUES

	--LEDA--
	--Beth Pre-Sarah Head Clone
	(0, 'Beth', 'Childs', 		'86 Mortimer Ave', 'M4K 2A1', 5557579039, to_date('1984-02-14', 'YYYY-MM-DD'), TRUE, to_date('2012-11-23', 'YYYY-MM-DD'), null),
	--Paul Character is involved with several clones and associations. 
	(20, 'Paul', 'Dierden', 	'86 Mortimer Ave', 'M4K 2A1', 5559292922, to_date('1980-07-07', 'YYYY-MM-DD'), TRUE, to_date('2014-11-24', 'YYYY-MM-DD'), null),

	(1, 'Sarah', 'Manning', 	'156 Manning Ave', 'M6J 2K5', 5556388326, to_date('1984-03-15', 'YYYY-MM-DD'), TRUE, null, 1),
	(10, 'Felix','Dawkins', 	'186 Henderson Ave', 'L3T 2L5', 5557579039, to_date('1986-06-08', 'YYYY-MM-DD'), TRUE, null, 1),
	(11, 'Kira','Manning', 		'156 Manning Ave', 'M6J 2K5', 5556388326, to_date('2002-03-23', 'YYYY-MM-DD'), FALSE, null, 1),
	(12, 'Siobhan','Sadler', 	'186 Henderson Ave', 'L3T 2L5', 5557579039, to_date('1979-11-09', 'YYYY-MM-DD'), TRUE, null, 1),
	(13, 'Cal','Morrison', 		'Sankt Vither Strabe 274–288','4760', 5557579039, to_date('1984-3-09', 'YYYY-MM-DD'), FALSE, null, null),

	(2, 'Alison', 'Hendrix', 	'6 Keyworth Trail','M1S 2V1', 5553830035, to_date('1984-04-18', 'YYYY-MM-DD'), TRUE, null, 2),
	(14, 'Donnie', 'Hendrix', 	'6 Keyworth Trail','M1S 2V1', 5553835300, to_date('1983-11-25', 'YYYY-MM-DD'), TRUE, null, 2),
	(15, 'Gemma', 'Hendrix', 	'6 Keyworth Trail','M1S 2V1', 5553830035, to_date('2005-03-28', 'YYYY-MM-DD'), FALSE, null, 2),
	(16, 'Oscar', 'Hendrix', 	'6 Keyworth Trail','M1S 2V1', 5553830035, to_date('2007-07-16', 'YYYY-MM-DD'), FALSE, null, 2),

	--Non-Familial LEDA people	
	(3, 'Cosima', 'Niehaus', 	'614 19th Ave S',  '55454',  5557579039, to_date('1984-03-09', 'YYYY-MM-DD'), TRUE, null, null),
	(4, 'Helena', '', 		'6 Keyworth Trail','M1S 2V1', 5553834393, to_date('1984-02-14', 'YYYY-MM-DD'), TRUE, null, null),
	(6, 'Katja','Obinger', 		'Sankt Vither Strabe 274–288','4760', 555-757-9039, to_date('1984-03-09', 'YYYY-MM-DD'), TRUE, to_date('2012-11-25', 'YYYY-MM-DD'), null),
	
	(5, 'Rachel', 'Duncan', 	'258 Maxome Ave',  'M2M 3L6', 5558293722, to_date('1984-02-03', 'YYYY-MM-DD'), TRUE, null, 0),
	(18, 'Susan', 'Duncan',		'119 Unknown St ', 'P3A 1W2', 5323246263, to_date('1960-01-25', 'YYYY-MM-DD'), TRUE, null, 0),
	(19, 'Ethan', 'Duncan',		'119 Monrow Blvd', 'P2A 1V2', 0110111010, to_date('1958-12-18', 'YYYY-MM-DD'), TRUE, to_date('2012-12-14', 'YYYY-MM-DD'), 0),
	
	(7, 'Krystal', 'Goderitch', 	'44 Broadhurst St','K7K 2Y7', 5559286382, to_date('1984-05-05', 'YYYY-MM-DD'), FALSE, null, null),
	(8, 'Jennifer', 'Fitzsimmons',	'99 Lexington St', '02128', 5555300183, to_date('1984-05-09', 'YYYY-MM-DD'), FALSE, to_date('2010-03-08', 'YYYY-MM-DD'), null),

	--CASTOR--
	(21, 'Mark', 'Rollins',  	'1031 RTE 111 E','J9T 1N2', 5659936584, to_date('1983-01-01', 'YYYY-MM-DD'), TRUE, null, 3),
	(26, 'Gracie', 'Rollins', '1031 RTE 111 E','J9T 1N2', 5659936584, to_date('1993-06-01', 'YYYY-MM-DD'), TRUE, null, 3),

	--Non-Familial CASTOR people		
	(22, 'Rudy','', 		'Unknown Rd.','000', 6669492305, to_date('1983-01-06', 'YYYY-MM-DD'), TRUE, to_date('2013-2-24', 'YYYY-MM-DD'), null),
	(23, 'Styles', 'Miller', 	'Unknown Dr.','000', 6668292305, to_date('1984-01-02', 'YYYY-MM-DD'), TRUE, to_date('2013-03-03', 'YYYY-MM-DD'), null),
	(24, 'Seth', '', 		'Unknown Ln.','000', 6669499387, to_date('1984-01-14', 'YYYY-MM-DD'), TRUE, to_date('2013-02-18', 'YYYY-MM-DD'), null),
	(25, 'Parsons', '', 		'Unknown Pl.','000', 6668783939, to_date('1984-01-08', 'YYYY-MM-DD'), TRUE, to_date('2013-02-21', 'YYYY-MM-DD'), null),

	--Others
	
	(17, 'Aynsley', 'Norris', 	'7 Keyworth Trail','M1S 2V1', 5553830035, to_date('1984-08-19', 'YYYY-MM-DD'), FALSE, to_date('2012-12-16', 'YYYY-MM-DD'), null),
	(27, 'Scott', 'Smith', 		'260 Boon Ave','M6E 3Z9', 3828383832, to_date('1984-10-23', 'YYYY-MM-DD'), TRUE, null, null),
	(28, 'Delphine', 'Cormier', 	'35 Lloydminster Cres', 'M2M 3L6', 5553892423, to_date('2014-07-17,', 'YYYY-MM-DD'),TRUE, null, null),
	(29, 'Daniel', 'Rosen', 	'258 Maxome Ave',  'M2M 3L6', 5558293722, to_date('1982-06-03', 'YYYY-MM-DD'), TRUE, to_date('2012-12-14', 'YYYY-MM-DD'), null);
	

--COMPLETE
--EXECUTED
--A clone is a person.
--Each clone has a very specific look and style.
--Every clone also has a diffent upbringing and 
--therefore a different method of nuturing 
--this table 
--vv Is there a way to check a TYPE's existenct vv
DROP TYPE IF EXISTS hColor;
CREATE TYPE hColor AS ENUM('Black', 'Brunette', 'Blonde', 'Red', 'Dyed');
DROP TYPE IF EXISTS hLength;
CREATE TYPE hLength AS ENUM('Short', 'Medium', 'Long');

CREATE TABLE IF NOT EXISTS Clones (
  PID int NOT NULL,
  hairColor hColor,
  hairLength hLength,
  standardHairStyle varchar(100),
  clothingStyle varchar(100),
  origin varchar(100),
  PRIMARY KEY (PID),
  FOREIGN KEY (PID) REFERENCES People(PID)
);

INSERT INTO Clones(PID, hairColor, hairLength, standardHairStyle, clothingStyle, origin) VALUES
    --LEDA--
    (0, 'Brunette',	'Long', 'High ponytail or low bun. Straightened and layered',	'Business Casual Barely any makeup','East York, Canada'),--'Beth', 'Childs'
    (1, 'Black', 	'Long', 'Loose, messy, curled',				'Punk Rock Hoe, Gothic Eye makeup', 'London, United Kingdom'),--'Sarah', 'Manning'
    (2, 'Brunette', 	'Long', 'Bangs and a pony, no hair is out of place',		'Suburban soccer mom, makeup and clothes are brightly colored', 'Scarborough, Ontario, Canada'),--'Alison', 'Hendrix'
    (3, 'Black', 	'Long', 'Medium thick dredlocks always in a pony or a bun', 	'Semi-Professional casual, mellow earthy tones, winged eyliner under glasses', 'San Fransisco, California, USA'),--'Cosima', 'Niehaus'
    (4, 'Blonde', 	'Long',	'Thick, unkept, wavey curly texture', 			'Whatever the situation permits, very pale, red around the eyes naturally', 'Ukranian Convent'),--'Helena', ''  
    (5, 'Blonde', 	'Medium', 'A bob cut precisely with no hair out of place', 	'Business Formal, white, black and primary colors mostly, red lipstick and thick lashes','Cambridge, England, United Kingdom'),--'Rachel', 'Duncan' 
    (6, 'Red', 		'Short', 'A short brightly dyed bob',				'Faux Furs, very glamorous couture not a lot of makeup', 'Würzburg, Germany'),--'Katja','Obinger' 
    (7, 'Blonde',	'Long', 'Curled blowout layered',				'Girly and pink. Clothing is revealing. Pink lipstick and full lashes', 'Sudbury, Ontario, Canada'	),--'Krystal', 'Goderitch'
    (8, 'Brunette',	'Long', 'Playfully curled',					'Causal everyday clothes, no makeup', 'Boston, Massachusettes, USA'),--'Jennifer','Fitzsimmons'
    --CASTOR--
    (21, 'Brunette',	'Short', 'small side bang-like curl that frames his face', 	'Churchy. Business attire that could be everyday','CASTOR Base'),--'Mark', 'Rollins',
    (22, 'Brunette',	'Short', 'Hair stands up like a dollop on his ', 		'Casual be everyday','CASTOR Base' ),--'Rudy','',         
    (23, 'Brunette',	'Short', 'crew cut', 						'Military uniform','CASTOR Base'),--'Styles', 'Miller', 
    (24, 'Brunette',	'Short', 'tapered hair cut, messy', 				'White collor ','CASTOR Base'),--'Seth', '',
    (25,  'Brunette',	'Short', 'exposed brain no hair', 				'Hospital gown','CASTOR Base');--'Parsons', '', 


--COMPLETE
--EXECUTED
CREATE TABLE IF NOT EXISTS LEDA (
  PID int NOT NULL,
  isExpiring boolean,
  isBarren boolean,
  tissueSampleStatus varchar(200),
  neuroHealthStatus varchar(200),
  --electrolites int, <-- not sure 
  --WBCCount int,--whiteBloodCell(WBC)
  --RBCCount int,--redBloodCell(RBC)
  --hemoglobin int,
  --hematocrit int,--Blood Value: Describes amount of blood in body.
  platletCount int, --Clotting: Describes ablity to clot.
  PRIMARY KEY (PID),
  FOREIGN KEY (PID) REFERENCES Clones(PID)
);

INSERT INTO LEDA(PID, isExpiring, isBarren, tissueSampleStatus, neuroHealthStatus, platletCount) VALUES --electrolites, 
    --LEDA--
    (0, 	 FALSE, TRUE, 'OUTDATED', 'UNWELL', 200),--'Beth', 'Childs'
    (1,  	 FALSE, FALSE, 'OUTDATED', 'UNDETERMINABLE', 200),--'Sarah', 'Manning'
    (2,  	 FALSE, TRUE, 'CURRENT', 'STABLE',  200),--'Alison', 'Hendrix'
    (3, 	 TRUE, TRUE, 'CURRENT', 'STABLE',  50),--'Cosima', 'Niehaus'
    (4,  	 FALSE, FALSE, 'OUTDATED', 'UNWELL',  200),--'Helena', ''  
    (5,  	 FALSE, TRUE, 'CURRENT', 'PENDING', 200),--'Rachel', 'Duncan' 
    (6, 	 TRUE, TRUE, 'OUTDATED', 'UNDETERMINABLE', 30),--'Katja','Obinger' 
    (7, 	 FALSE, TRUE, 'CURRENT', 'STABLE', 200),--'Krystal', 'Goderitch'
    (8, 	 TRUE, TRUE, 'OUTDATED', 'UNDETERMINABLE', 17);--'Jennifer','Fitzsimmons'

--COMPLETE
--EXECUTED

CREATE TABLE IF NOT EXISTS Monitoring (
  PID int NOT NULL,
  CloneID int NOT NULL,
  relationship varchar(100) NOT NULL,
  startDate date NOT NULL,
  endDate date,
  PRIMARY KEY (PID, CloneID),
  FOREIGN KEY (PID) REFERENCES People(PID),
  FOREIGN KEY (CloneID) REFERENCES LEDA(PID)
);

INSERT INTO Monitoring(PID,  CloneID, relationship, startDate, endDate) VALUES
    (20, 0,'Serious Romantic Relationship', to_date('18-Aug-2008', 'DD-Mon-YYYY'),to_date('12-Nov-2012', 'DD-Mon-YYYY') ),--'Beth', /Paul
    (20, 1,'Serious Romantic Relationship with Sarah as herself and acting as Beth', to_date('15-Nov-2012', 'DD-Mon-YYYY'), to_date('12-Sep-2013', 'DD-Mon-YYYY') ),--'Sarah', /Paul 
    (14, 2, 'Married with adoptive children', to_date('29-Aug-2000', 'DD-Mon-YYYY'), null),--'Alison', /Donnie
    (28, 3, 'Serious Romantic Relationship', to_date('18-Aug-2012', 'DD-Mon-YYYY'), to_date('12-Aug-2013', 'DD-Mon-YYYY')),--'Cosima', /Delphine
    (20, 5, 'Sexual Relationship', to_date('16-Dec-2013', 'DD-Mon-YYYY'), to_date('26-Aug-2013', 'DD-Mon-YYYY')),--'Rachel', /Paul 
    (29, 5, 'Sexual Relationship', to_date('12-May-2007', 'DD-Mon-YYYY'), to_date('14-Dec-2012', 'DD-Mon-YYYY'));--'Rachel', /Daniel 

	

--COMPLETE
--EXECUTED
CREATE TABLE IF NOT EXISTS CASTOR (
  PID int NOT NULL,
  isGlitching boolean NOT NULL,
  logicTestingScore int NOT NULL,
  assignment varchar(100), 
  PRIMARY KEY (PID),
  FOREIGN KEY (PID) REFERENCES Clones(PID)
);

INSERT INTO CASTOR(PID, isGlitching, logicTestingScore, assignment) VALUES
--CASTOR--
    (21, FALSE, 100, 'Infiltrate proleathean'),--'Mark', 'Rollins',
    (22, FALSE, 100, 'Find duncans research, kill any obstacles'),--'Rudy','',         
    (23, FALSE, 100, 'Home Base Soldier'),--'Styles', 'Miller', 
    (24, TRUE, 20, 'Be creepy, find duncans research'),--'Seth', '',
    (25, TRUE, 60, 'Research Subject');--'Parsons', '', 

--ADD Stored Procedure to prevent addition to 
--clone club without Person at PID having true 
--boolean value for isAware
--EXECUTED
CREATE TABLE IF NOT EXISTS CloneClub (
  PID int NOT NULL,
  admissionDate date,
  clonePhoneNumber numeric(10),
  PRIMARY KEY (PID),
  FOREIGN KEY (PID) REFERENCES People(PID)
);


INSERT INTO CloneClub(PID, admissionDate, clonePhoneNumber) VALUES
	(0,  to_date('12-Jul-2012', 'DD-Mon-YYYY'), 2566308399),--'Beth', 'Childs')
	(1,  to_date('11-Nov-2012', 'DD-Mon-YYYY'), 2566307777),--'Sarah', 'Manning')
	(2,  to_date('12-Jul-2012', 'DD-Mon-YYYY'), 2566305638),--'Alison', 'Hendrix',)
	(3,  to_date('12-Jul-2012', 'DD-Mon-YYYY'), 2566302468),--'Cosima', 'Niehaus')
	(4,  to_date('21-Jun-2013', 'DD-Mon-YYYY'), 2566309263),--'Helena', '')
	(6,  to_date('14-Aug-2012', 'DD-Mon-YYYY'), 2566307478),--'Katja','Obinger')
	(10, to_date('3-Jan-2013', 'DD-Mon-YYYY'), 2566307383),--'Felix','Dawkins')
	(14, to_date('16-Mar-2013', 'DD-Mon-YYYY'), 2566303822),--'Donnie', 'Hendrix') 
	(27, to_date('23-Dec-2012', 'DD-Mon-YYYY'), 3828383832);--'Scott', 'Smith')


--COMPLETE
--EXECUTED
CREATE TABLE IF NOT EXISTS MurderMethod (
  methodID int NOT NULL,
  methodName varchar(100),
  methodDesc varchar(500),
  weapon varchar(50),
  PRIMARY KEY (methodID)
);
INSERT INTO MurderMethod(methodID, methodName, methodDesc, weapon) VALUES

	(0, 'Colision', 'The use of a vehical to fatally injure a victim by impacting them (directly or indirectly)', 'Moving vehicle'),
	(1, 'Close Range Shooting', 'Trying to stop/destroy the heart, brain or blood flow by firing a bullet in close range of victim', 'Gun'),
	(2, 'Sniping', 'Trying to stop/destroy the heart, brain or blood flow by firing a bullet from a snipper riffles esp. when the victim is far away', 'Snipper Riffle'),
	(3, 'Long Range Shooting(Non-Snipper)','Trying to stop/destroy the heart, brain or blood flow by firing a bullet from a gun (not a snipper riffles) when the victim is far away', 'Gun (Not a Snipper Riffle)'),
	(4, 'Neck Snapping', 'Usually a fast motion that moves the head from the neck such that the spinal cord breaks fatally', 'Hands or Legs'),
	(5, 'Stabing (Blade)', 'The use of a Blade to cause fatal bleeding via plunging it into the body of the victim', 'Blade'),
	(6, 'Stabing (Rebar)', 'The use of Rebar to cause fatal bleeding via plunging it into the body of the victim', 'Rebar'),
	(7, 'Stabing (Pencil)', 'The use of a pencil to cause fatal bleeding via plunging it into the body of the victim', 'Pencil'),
	(8, 'Slashing', 'The use of a sharp object to cause fatal bleeding via puling it through the body of the victim such that it causes a fatal laceration', 'Sharp Object'),
	(9, 'Soffocation(Cloth)', 'Trying to cut of the air supply by crushing or compressing the trachea by wraping cloth or clothing around the victims neck and pulling tightly', 'cloth'),
	(10, 'Soffocation(Hands)', 'Trying to cut of the air supply by crushing or compressing the trachea by the assailant wraping their hands around the neck of the victim', 'hands'),
	(11, 'Soffocation(Pillow)', 'Trying to cut of the air supply by blocking air ways (nose and mouth) with a pillow pressed tightly to the face', 'pillow');



--ADD STORED PROCEDURE that auto corrects attemptNum
--EXECUTED
CREATE TABLE IF NOT EXISTS MurderAttempts (
  assailantID int NOT NULL,
  victimID int NOT NULL,
  attemptNum int DEFAULT 1 NOT NULL,
  MID int NOT NULL,
  wasSuccessful Boolean DEFAULT False,
  PRIMARY KEY (assailantID, victimID, attemptNum),
  FOREIGN KEY (assailantID) REFERENCES People(PID),
  FOREIGN KEY (victimID) REFERENCES People(PID)
);

INSERT INTO MurderAttempts(assailantID, victimID, attemptNum, MID, wasSuccessful) VALUES

	(0, 0, 1, 0, TRUE),--BETH CHILD'S Suicide
	(2, 17, 1, 9, TRUE),--ANYSLE's Accident
	(1, 4, 1, 6, FALSE),--Sarah Defends Against Helena
	(1, 4, 2, 1, FALSE),--Sarah Shoots Helena
	(4, 6, 2, 0, TRUE);--Helena Kills German

	


--COMPLETE
--EXECUTED
CREATE TABLE IF NOT EXISTS Skills (
  skillID int NOT NULL,
  skillName varchar (100) NOT NULL,
  maxLevel int,
  PRIMARY KEY (skillID)
);

INSERT INTO Skills(skillID, skillName, maxLevel) VALUES
	(0, 'blade combat', 3),
	(1, 'hand gun shooting', 4),
	(2, 'sniper riffle shooting', 5),
	(3, 'hand-to-hand combat', 10),
	(4, 'defense', 10),
	(5, 'improvisation', 5),
	(6, 'WhatWouldAlanDo', 2);
	

--COMPLETE
--EXECUTED
CREATE TABLE IF NOT EXISTS CombatSkills (
  PID int NOT NULL,
  skillID int NOT NULL,
  level int DEFAULT 1,
  PRIMARY KEY (PID, skillID),
  FOREIGN KEY (PID) REFERENCES People(PID),
  FOREIGN KEY (skillID) REFERENCES Skills(skillID)
);

--ADD TRIGGER That prevents level being higher 
--than skill(maxLevel)
CREATE OR REPLACE FUNCTION levelCheck() RETURNS TRIGGER AS $CombatSkills$

		BEGIN
			IF 	NEW.level > (SELECT maxLevel  
					     FROM   skills
					     WHERE skillID=NEW.skillID)
			THEN 	
			--RAISE [ level ] 'format' [, expression [, ... ]] [ USING option = expression [, ... ] ];
				RAISE EXCEPTION 'Above Maximum Level-> %', 	NEW.level
				USING HINT = 'Please choose a level below->: '|| (SELECT maxLevel  
										   FROM   skills
										   WHERE skillID=NEW.skillID);
			END IF;
			return NEW;
		END;
		$CombatSkills$ LANGUAGE plpgsql;

CREATE TRIGGER triggerLevelCheck AFTER INSERT OR UPDATE
ON CombatSkills
FOR EACH ROW EXECUTE PROCEDURE levelCheck();


INSERT INTO CombatSkills(PID, skillID, level) VALUES
    --'Beth', 'Childs')
    (0, 1, 3),

    --'Paul', 'Dierden')
    (20, 0, 3),
    (20, 1, 4),
    (20, 2, 5),
    (20, 3, 9),
    (20, 4, 8),
    (20, 5, 2),
    (20, 6, 1),

    --'Sarah', 'Manning')
    (1, 1, 3),
    (1, 3, 5),
    (1, 4, 10),
    (1, 5, 5),
    (1, 6, 2),

    --'Helena', '',)
    (4, 0, 3),
    (4, 1, 2),
    (4, 2, 5),
    (4, 3, 10),
    (4, 4, 10),
    (4, 5, 4),
    (4, 6, 0);

--COMPLETE
--EXECUTED
CREATE TABLE IF NOT EXISTS Occupations (
  OID int NOT NULL,
  occupation varchar(100),
  jobDescription varchar(500),
  PRIMARY KEY (OID)
);
INSERT INTO Occupations(OID, occupation, jobDescription) VALUES
	(0, 'UNEMPLOYED', 'Be lazy or look for a job'),
	(1, 'Cop', 'Police Detective with a gun and a badge.'),
	(2, 'Soccer Coach', 'Instructs and leads kids soccer'),
	(3, 'Mother', 'Maternal parent to a child'),
	(4, 'Housewife', 'A woman whose job it is the up keep
	 the house both in physicallity, sanity and saftey
	 in addition to the care of all persons in the house'),
	(5, 'Soldier', 'Fight for a cause.'),
	(6, 'Student', 'Study at an educational institution'),
	(7, 'Reasearch Assistant', 'Helps with scientific research projects'),
	(8, 'Biologist', 'One who studies biology'),
	(9, 'CEO', 'Chief Executive Officer'),
	(10, 'Manicurist', 'Hand and foot beautification.'),
	(11, 'High School Teacher', 'Educate minors and adults in Secondary (High) School'),
	(12, 'Swim Coach', 'Instructs and leads kids swimming');
 
CREATE TABLE IF NOT EXISTS Jobs (
  PID int NOT NULL,
  OID int NOT NULL,
  startDate date,
  endDate date,
  -- locationID varchar(100)
  -- FOREIGN KEY (locationID) REFERENCES Zip(ZIP),
  PRIMARY KEY (PID, OID),
  FOREIGN KEY (PID) REFERENCES People(PID),
  FOREIGN KEY (OID) REFERENCES Occupations(OID));

INSERT INTO Jobs (PID, OID, startDate, endDate) VALUES
    (0, 1, to_date('12-Jun-2012', 'DD-Mon-YYYY'),to_date('23-Nov-2012', 'DD-Mon-YYYY')),--'Beth', 'Childs')
    (20, 0, to_date('15-Dec-2007', 'DD-Mon-YYYY'),to_date('25-Dec-2013', 'DD-Mon-YYYY')),--'Paul', 'Dierden')
    (1, 1, to_date('23-Nov-2012', 'DD-Mon-YYYY'),to_date('20-Jul-2011', 'DD-Mon-YYYY')),--'Sarah', 'Manning')
    (1, 0, to_date('12-Jun-2011', 'DD-Mon-YYYY'),to_date('25-May-2012', 'DD-Mon-YYYY')),
    (1, 3, to_date('13-Feb-2011', 'DD-Mon-YYYY'),to_date('30-Apr-2013', 'DD-Mon-YYYY')),
    (2, 2, to_date('03-Sep-2011', 'DD-Mon-YYYY'),to_date('29-Aug-2012', 'DD-Mon-YYYY')),--'Alison', 'Hendrix',)
    (2, 3, to_date('21-Jan-2011', 'DD-Mon-YYYY'),to_date('27-May-2013', 'DD-Mon-YYYY')),
    (2, 4, to_date('14-Oct-2011', 'DD-Mon-YYYY'),to_date('14-Jul-2013', 'DD-Mon-YYYY')),
    (14, 0, to_date('27-Aug-2011', 'DD-Mon-YYYY'),to_date('12-Jan-2013', 'DD-Mon-YYYY')),--'Donnie', 'Hendrix',)
    (15, 6, to_date('02-Jan-2011', 'DD-Mon-YYYY'),to_date('18-Mar-2012', 'DD-Mon-YYYY')),--'Gemma', 'Hendrix', )
    (16, 6, to_date('12-Jun-2011', 'DD-Mon-YYYY'),to_date('25-Oct-2012', 'DD-Mon-YYYY')),--'Oscar', 'Hendrix',)  
    (3, 6, to_date('15-Apr-2011', 'DD-Mon-YYYY'),to_date('05-Nov-2012', 'DD-Mon-YYYY')),--'Cosima', 'Niehaus')
    (3, 8, to_date('12-Jun-2011', 'DD-Mon-YYYY'),to_date('02-Feb-2012', 'DD-Mon-YYYY')),
    (4, 0, to_date('12-Jun-2012', 'DD-Mon-YYYY'),to_date('20-Jan-2012', 'DD-Mon-YYYY')),--'Helena', '',)
    (5, 9, to_date('12-Jun-2012', 'DD-Mon-YYYY'),to_date('20-Jan-2012', 'DD-Mon-YYYY')),--'Rachel', 'Duncan')
    (7, 10, to_date('12-Apr-2011', 'DD-Mon-YYYY'),to_date('17-Jun-2012', 'DD-Mon-YYYY')),--'Krystal', 'Goderitch')
    (8, 11, to_date('17-Jun-2012', 'DD-Mon-YYYY'),to_date('20-Jan-2012', 'DD-Mon-YYYY')),--'Jennifer', 'Fitzsimmons')
    (8, 12,to_date('12-May-2012', 'DD-Mon-YYYY'),to_date('24-Mar-2012', 'DD-Mon-YYYY')),
    (21, 5, to_date('12-Jun-2011', 'DD-Mon-YYYY'),to_date('22-Jan-2012', 'DD-Mon-YYYY')),--'Mark', 'Rollins'),
    (22, 5, to_date('22-Jan-2012', 'DD-Mon-YYYY'),to_date('02-May-2013', 'DD-Mon-YYYY')),--'Rudy','', )
    (23, 5, to_date('23-Jul-2011', 'DD-Mon-YYYY'),to_date('23-Jun-2013', 'DD-Mon-YYYY')),--'Styles', 'Miller')
    (24, 5, to_date('24-Dec-2012', 'DD-Mon-YYYY'),to_date('26-Mar-2012', 'DD-Mon-YYYY')),--'Seth', '')
    (25, 5, to_date('12-Nov-2012', 'DD-Mon-YYYY'),to_date('22-Jan-2013', 'DD-Mon-YYYY')),--'Parsons', '')
    (17, 3, to_date('13-Jun-2012', 'DD-Mon-YYYY'),to_date('28-Jun-2012', 'DD-Mon-YYYY')),--'Aynsley', 'Norris')
    (28, 4, to_date('18-Jan-2012', 'DD-Mon-YYYY'),to_date('21-Jan-2014', 'DD-Mon-YYYY')),--'Delphine', 'Cormier')
    (27, 7, to_date('17-May-2011', 'DD-Mon-YYYY'),to_date('20-Jan-2013', 'DD-Mon-YYYY')),--'Scott', 'Smith')
    (28, 7, to_date('12-Jun-2011', 'DD-Mon-YYYY'),to_date('12-Jun-2012', 'DD-Mon-YYYY')),--'Delphine', 'Cormier')
    (28, 9, to_date('15-Mar-2012', 'DD-Mon-YYYY'),to_date('20-Feb-2014', 'DD-Mon-YYYY'));

   

--Dyad View--
CREATE VIEW Dyad AS
	SELECT p.firstname AS FIRST, p.lastname AS Last, p.birthdate, p.deathdate, c.hairColor, 
	c.standardHairStyle, c.origin, l.isExpiring AS isExp, l.tissuesamplestatus AS tissue, 
	l.neurohealthstatus AS mentalState, l.platletCount
	FROM People p, Clones c, LEDA l
	WHERE p.pid=c.pid
	AND   c.pid=l.pid;

--Clone Club View--
CREATE VIEW CloneClubDirectory AS
	SELECT p.firstname AS FIRST, p.lastname AS Last, cc.admissionDate, cc.clonePhoneNumber AS CPN,
	p.birthdate, p.deathdate
	FROM People p, CloneClub cc
	WHERE p.pid=cc.pid;


--FightPrep Report--
SELECT p.firstname AS FIRST, p.lastname AS Last, s.skillname AS skill, cs.level, s.maxLevel
FROM People p, CombatSkills cs, Skills s
WHERE p.pid= cs.pid
AND   s.skillID=cs.skillID;

--Monitor Report--
SELECT m.firstname AS MFIRST, m.lastname AS MLAST, c.firstname AS CFIRST, c.lastname AS CLAST, 
mon.relationship AS rel, mon.startdate AS BEGAN, mon.enddate AS ENDED
FROM People m, People c, Monitoring mon
WHERE mon.pid= m.pid
AND   mon.cloneid = c.pid;



--Familes Report--
SELECT f.familyName AS FamilyAware, f.isAware, p.firstname, p.lastname, p.isAware AS PersonAware
FROM People p, Families f
WHERE f.fid= p.familyid
ORDER BY f.FID;

REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA public FROM PUBLIC;

CREATE ROLE CloneAware;
REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA public FROM CloneAware;

GRANT SELECT ON Jobs TO CloneAware;
GRANT SELECT ON Occupations TO CloneAware;
GRANT SELECT ON CombatSkills TO CloneAware;
GRANT SELECT ON Skills TO CloneAware;
GRANT SELECT ON CloneClub TO CloneAware;
GRANT SELECT ON LEDA TO CloneAware;
GRANT SELECT ON Clones TO CloneAware;
GRANT SELECT ON People TO CloneAware;
GRANT SELECT ON Zip TO CloneAware;

CREATE ROLE Dyad;
REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA public FROM Dyad;

GRANT SELECT ON Occupations TO Dyad;
GRANT SELECT, UPDATE, INSERT ON Monitoring TO Dyad;
GRANT SELECT, INSERT ON LEDA TO Dyad;

CREATE ROLE CloneClub;
REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA public FROM CloneClub;

GRANT SELECT, UPDATE, INSERT ON Jobs TO CloneClub;
GRANT SELECT, UPDATE, INSERT ON Occupations TO CloneClub;
GRANT SELECT, UPDATE, INSERT ON CombatSkills TO CloneClub;
GRANT SELECT, UPDATE, INSERT ON Skills TO CloneClub;
GRANT SELECT, INSERT ON MurderMethod TO CloneClub;
GRANT SELECT, INSERT ON MurderAttempts TO CloneClub;
GRANT SELECT, INSERT ON CloneClub TO CloneClub;
GRANT SELECT, INSERT ON CASTOR TO CloneClub;
GRANT SELECT, UPDATE, INSERT ON Monitoring TO CloneClub;
GRANT SELECT, UPDATE, INSERT ON LEDA TO CloneClub;
GRANT SELECT, UPDATE, INSERT ON Clones TO CloneClub;
GRANT SELECT, UPDATE, INSERT ON People TO CloneClub;
GRANT SELECT, UPDATE, INSERT ON Families TO CloneClub;
GRANT SELECT, INSERT ON Zip TO CloneClub;

CREATE ROLE DBAdmin;
REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA public FROM DBAdmin;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO DBAdmin;
