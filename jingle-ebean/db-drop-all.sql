alter table tb_user drop foreign key fk_tb_user_dept_id;
drop index ix_tb_user_dept_id on tb_user;

alter table tb_user drop foreign key fk_tb_user_address_post_number;

alter table tb_user_tag drop foreign key fk_tb_user_tag_tb_user;
drop index ix_tb_user_tag_tb_user on tb_user_tag;

alter table tb_user_tag drop foreign key fk_tb_user_tag_tb_tag;
drop index ix_tb_user_tag_tb_tag on tb_user_tag;

alter table tb_tag_user drop foreign key fk_tb_tag_user_tb_tag;
drop index ix_tb_tag_user_tb_tag on tb_tag_user;

alter table tb_tag_user drop foreign key fk_tb_tag_user_tb_user;
drop index ix_tb_tag_user_tb_user on tb_tag_user;

drop table if exists tb_address;

drop table if exists tb_dept;

drop table if exists tb_user;

drop table if exists tb_user_tag;

drop table if exists tb_tag;

drop table if exists tb_tag_user;

