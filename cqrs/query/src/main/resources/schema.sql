CREATE TABLE IF NOT EXISTS conference
(
    id VARCHAR(64) NOT NULL PRIMARY KEY,
    name text      NOT NULL
);

DELETE FROM conference;

CREATE TABLE IF NOT EXISTS tokenentry
(
    segment INTEGER NOT NULL,
    processorName varchar(255) NOT NULL,
    token bytea,
    tokenType varchar(255),
    timestamp VARCHAR(1000),
    owner VARCHAR(1000),
    PRIMARY KEY (segment, processorName)
);
DELETE
FROM tokenentry;
