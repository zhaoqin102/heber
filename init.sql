CREATE TABLE user_info (
  id            INT          NOT NULL AUTO_INCREMENT,
  username      VARCHAR(100) NOT NULL,
  password      VARCHAR(32)  NOT NULL,
  register_time DATETIME     NOT NULL,
  PRIMARY KEY (id)
);
CREATE TABLE account (
  id      INT  NOT NULL AUTO_INCREMENT,
  user_id INT  NOT NULL,
  amount  LONG NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_user_account FOREIGN KEY (user_id) REFERENCES user_info (id)
);
CREATE TABLE consume_log (
  id           INT      NOT NULL AUTO_INCREMENT,
  user_id      INT      NOT NULL,
  amount       LONG     NOT NULL,
  consume_time DATETIME NOT NULL,
  PRIMARY KEY (id),
  CONSTRAINT fk_user_consume FOREIGN KEY (user_id) REFERENCES user_info (id)
);
