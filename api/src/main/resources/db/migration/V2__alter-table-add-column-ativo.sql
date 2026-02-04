alter table casas add column ativo tinyint;
update casas set ativo = 1;
alter table casas modify column ativo tinyint not null;

alter table alunos add column ativo tinyint;
update alunos set ativo = 1;
alter table alunos modify column ativo tinyint not null;

alter table usuarios add column ativo tinyint;
update usuarios set ativo = 1;
alter table usuarios modify column ativo tinyint not null;