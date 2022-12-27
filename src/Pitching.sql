DROP TABLE IF EXISTS pitching;

CREATE TABLE pitching (
    playerID TEXT,
    yearID INT,
    teamID TEXT,
    g INT,
    w INT,
    l INT,
    sv INT,
    so INT,
    era FLOAT,
    outs FLOAT
);