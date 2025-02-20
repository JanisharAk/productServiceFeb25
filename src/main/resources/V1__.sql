CREATE TABLE db2025.category
(
    id            BINARY(16) NOT NULL,
    category_name VARCHAR(255) NULL,
    CONSTRAINT pk_category PRIMARY KEY (id)
);

CREATE TABLE db2025.jt_mentor
(
    id     BIGINT NOT NULL,
    rating INT    NOT NULL,
    CONSTRAINT pk_jt_mentor PRIMARY KEY (id)
);

CREATE TABLE db2025.jt_student
(
    id    BIGINT NOT NULL,
    psp   INT    NOT NULL,
    batch VARCHAR(255) NULL,
    CONSTRAINT pk_jt_student PRIMARY KEY (id)
);

CREATE TABLE db2025.jt_user
(
    id       BIGINT NOT NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    name     VARCHAR(255) NULL,
    CONSTRAINT pk_jt_user PRIMARY KEY (id)
);

CREATE TABLE db2025.mentor
(
    id       BIGINT NOT NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    name     VARCHAR(255) NULL,
    rating   INT    NOT NULL,
    CONSTRAINT pk_mentor PRIMARY KEY (id)
);

CREATE TABLE db2025.product
(
    id          BINARY(16) NOT NULL,
    name        VARCHAR(255) NULL,
    price DOUBLE NOT NULL,
    category_id BINARY(16) NULL,
    CONSTRAINT pk_product PRIMARY KEY (id)
);

CREATE TABLE db2025.products
(
    id   BIGINT AUTO_INCREMENT NOT NULL,
    name VARCHAR(255) NULL,
    price DOUBLE NOT NULL,
    CONSTRAINT pk_products PRIMARY KEY (id)
);

CREATE TABLE db2025.st_user
(
    id        BIGINT NOT NULL,
    user_type INT NULL,
    email     VARCHAR(255) NULL,
    password  VARCHAR(255) NULL,
    name      VARCHAR(255) NULL,
    rating    INT    NOT NULL,
    psp       INT    NOT NULL,
    batch     VARCHAR(255) NULL,
    CONSTRAINT pk_st_user PRIMARY KEY (id)
);

CREATE TABLE db2025.student
(
    id       BIGINT NOT NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    name     VARCHAR(255) NULL,
    psp      INT    NOT NULL,
    batch    VARCHAR(255) NULL,
    CONSTRAINT pk_student PRIMARY KEY (id)
);

CREATE TABLE db2025.tpc_mentor
(
    id       BIGINT NOT NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    name     VARCHAR(255) NULL,
    rating   INT    NOT NULL,
    CONSTRAINT pk_tpc_mentor PRIMARY KEY (id)
);

CREATE TABLE db2025.tpc_student
(
    id       BIGINT NOT NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    name     VARCHAR(255) NULL,
    psp      INT    NOT NULL,
    batch    VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_student PRIMARY KEY (id)
);

CREATE TABLE db2025.tpc_user
(
    id       BIGINT NOT NULL,
    email    VARCHAR(255) NULL,
    password VARCHAR(255) NULL,
    name     VARCHAR(255) NULL,
    CONSTRAINT pk_tpc_user PRIMARY KEY (id)
);

ALTER TABLE db2025.jt_mentor
    ADD CONSTRAINT FK_JT_MENTOR_ON_ID FOREIGN KEY (id) REFERENCES db2025.jt_user (id);

ALTER TABLE db2025.jt_student
    ADD CONSTRAINT FK_JT_STUDENT_ON_ID FOREIGN KEY (id) REFERENCES db2025.jt_user (id);

ALTER TABLE db2025.product
    ADD CONSTRAINT FK_PRODUCT_ON_CATEGORY FOREIGN KEY (category_id) REFERENCES db2025.category (id);