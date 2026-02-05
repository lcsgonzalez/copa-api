alter table usuarios drop primary key;

alter table usuarios add column id int(11) NOT NULL AUTO_INCREMENT PRIMARY KEY;
