alter table tb_user drop foreign key fk_tb_user_dept_id;
drop index ix_tb_user_dept_id on tb_user;

alter table tb_user drop foreign key fk_tb_user_address_post_number;

alter table tb_tag drop foreign key fk_tb_tag_user_tag_id;
drop index ix_tb_tag_user_tag_id on tb_tag;

drop table if exists tb_address;

drop table if exists tb_dept;

drop table if exists tb_user;

drop table if exists tb_tag;

