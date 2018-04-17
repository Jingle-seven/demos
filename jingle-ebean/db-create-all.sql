create table tb_dept (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  constraint pk_tb_dept primary key (id)
);

create table tb_user (
  id                            bigint auto_increment not null,
  name                          varchar(255),
  account                       varchar(255),
  dept_id                       bigint,
  constraint pk_tb_user primary key (id)
);

alter table tb_user add constraint fk_tb_user_dept_id foreign key (dept_id) references tb_dept (id) on delete restrict on update restrict;
create index ix_tb_user_dept_id on tb_user (dept_id);

