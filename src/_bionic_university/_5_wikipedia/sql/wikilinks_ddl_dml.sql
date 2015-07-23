----- CREATING TABLES -----

CREATE SCHEMA wikilinks;
SET SCHEMA wikilinks;

DROP TABLE wikilink;
DROP TABLE linkProc;
DROP TABLE studyProc;

CREATE TABLE linkProc
(
  id           SMALLINT NOT NULL,
  linkProcName VARCHAR(20),
  PRIMARY KEY (id)
);

CREATE TABLE studyProc
(
  id            SMALLINT NOT NULL,
  studyProcName VARCHAR(20),
  PRIMARY KEY (id)
);

CREATE TABLE wikilink
(
  id          INT NOT NULL GENERATED ALWAYS AS IDENTITY,
  url         VARCHAR(200),
  name        VARCHAR(50),
  linkProcId  SMALLINT CONSTRAINT linkproc_fk REFERENCES linkProc,
  studyProcId SMALLINT CONSTRAINT studyproc_fk REFERENCES studyProc,
  priority    SMALLINT,
  PRIMARY KEY (id)
);

----- INSERT DATA -----

INSERT INTO linkProc (id, linkProcName)
VALUES (1, 'NO');
INSERT INTO linkProc (id, linkProcName)
VALUES (2, 'IN_PROGRESS');
INSERT INTO linkProc (id, linkProcName)
VALUES (3, 'FINISHED');

INSERT INTO studyProc (id, studyProcName)
VALUES (1, 'NO');
INSERT INTO studyProc (id, studyProcName)
VALUES (2, 'IN_PROGRESS');
INSERT INTO studyProc (id, studyProcName)
VALUES (3, 'FINISHED');

INSERT INTO wikilink (url, name, linkProcId, studyProcId, priority)
VALUES ('https://en.wikipedia.org/wiki/Object-relational_mapping', 'ORM', 1, 1, 1);
INSERT INTO wikilink (url, name, linkProcId, studyProcId, priority)
VALUES ('https://en.wikipedia.org/wiki/SQL', 'SQL', 1, 1, 1);
INSERT INTO wikilink (url, name, linkProcId, studyProcId, priority)
VALUES ('https://en.wikipedia.org/wiki/Java_Persistence_API', 'JPA', 1, 1, 1);
INSERT INTO wikilink (url, name, linkProcId, studyProcId, priority)
VALUES ('https://en.wikipedia.org/wiki/HSQLDB', 'HSQLDB', 1, 1, 1);

----- DATA MANIPULATIONS -----

UPDATE wikilink
SET priority = 2
WHERE id = 1;

UPDATE wikilink
SET priority = 3
WHERE id = 2;

-- select all
SELECT
  name,
  url,
  linkProcId,
  studyProcId,
  priority
FROM wikilink;

-- select by id
SELECT
  name,
  url,
  linkProcId,
  studyProcId,
  priority
FROM wikilink
WHERE id = 1;

-- select by mask
SELECT
  name,
  url,
  linkProcId,
  studyProcId,
  priority
FROM wikilink
WHERE name LIKE '%SQL%';

-- select with order
SELECT
  name,
  url,
  linkProcId,
  studyProcId,
  priority
FROM wikilink
ORDER BY priority DESC;

-- select with priority > 2
SELECT
  name,
  url,
  priority
FROM wikilink
WHERE priority >= 2
ORDER BY priority DESC;
