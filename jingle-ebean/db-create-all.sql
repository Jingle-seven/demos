create table tb_address (
  post_number                   bigint auto_increment not null,
  location                      varchar(255),
  constraint pk_tb_address primary key (post_number)
);

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
  address_post_number           bigint,
  an_assert                     varchar(5),
  constraint ck_tb_user_an_assert check ( an_assert in ('SHARE','FUND')),
  constraint uq_tb_user_address_post_number unique (address_post_number),
  constraint pk_tb_user primary key (id)
);

create table tb_tag (
  id                            bigint auto_increment not null,
  user_tag_id                   bigint not null,
  tag_name                      varchar(255),
  constraint pk_tb_tag primary key (id)
);

alter table tb_user add constraint fk_tb_user_dept_id foreign key (dept_id) references tb_dept (id) on delete restrict on update restrict;
create index ix_tb_user_dept_id on tb_user (dept_id);

alter table tb_user add constraint fk_tb_user_address_post_number foreign key (address_post_number) references tb_address (post_number) on delete restrict on update restrict;

alter table tb_tag add constraint fk_tb_tag_user_tag_id foreign key (user_tag_id) references tb_tag (id) on delete restrict on update restrict;
create index ix_tb_tag_user_tag_id on tb_tag (user_tag_id);

