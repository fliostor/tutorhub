CREATE TABLE IF NOT EXISTS MODULES
(
    ID BIGSERIAL PRIMARY KEY,
    COURSE_ID BIGINT  NOT NULL,
    NAME VARCHAR(255) NOT NULL,

    CONSTRAINT FK_MODULES_COURSES FOREIGN KEY (COURSE_ID)
    REFERENCES MODULES (ID) ON DELETE CASCADE ON UPDATE NO ACTION
);

CREATE TABLE IF NOT EXISTS SUBMODULES
(
    ID BIGSERIAL PRIMARY KEY,
    MODULE_ID BIGINT  NOT NULL,
    NAME VARCHAR(255) NOT NULL,

    CONSTRAINT FK_MODULES_COURSES FOREIGN KEY (MODULE_ID)
    REFERENCES MODULES (ID) ON DELETE CASCADE ON UPDATE NO ACTION
);
