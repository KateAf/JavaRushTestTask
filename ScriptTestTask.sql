DROP DATABASE IF EXISTS test;
CREATE DATABASE test COLLATE utf8_bin;
USE test;

DROP TABLE IF EXISTS parts;
CREATE TABLE parts(
  id        INT(15)      NOT NULL AUTO_INCREMENT,
  description            VARCHAR(100) NOT NULL,
  required  BIT(1)       NOT NULL DEFAULT FALSE,
  quantity    INT(15)      NOT NULL DEFAULT '0',
  PRIMARY KEY (id)
)charset='utf8';


INSERT INTO parts (description, required, quantity) VALUES
  ('Материнская плата AMD', true, 10),
  ('Материнская плата ASUS',false , 23),
  ('Материнская плата MSI', false, 15),
  ('Материнская плата GIGABYTE', false, 44),
  ('Звуковая плата ASUS', true, 50),
  ('Звуковая плата GIGABYTE', false, 7),
  ('Звуковая плата AMD', false, 10),
  ('Звуковая плата MSI', false, 19),
  ('SSD диск AMD', false, 4),
  ('SSD диск ASUS', false, 4),
  ('SSD диск MSI', true, 26),
  ('SSD диск GIGABYTE', false, 9),
  ('Процессор Celeron', false, 12),
  ('Процессор AMD', false, 11),
  ('Процессор ICore5', false, 9),
  ('Процессор ICore7', true, 14),
  ('Корпус MSI', false, 22),
  ('Корпус GIGABYTE', false, 4),
  ('Корпус INTEL', true, 40),
  ('Корпус NoName', false, 15),
  ('Оперативная память DD3', false, 12),
  ('Оперативная память DD4', true, 44),
  ('Оперативная память DD5', false, 7),
  ('Оперативная память DD6', false, 5),
  ('Подсветка корпуса MSI', false, 13),
  ('Подсветка корпуса GIGABYTE', false, 2),
  ('Подсветка корпуса INTEL', false, 8),
  ('Подсветка корпуса NoName', false, 54)
;