alter table tb_user drop constraint if exists fk_tb_user_user_tag_id;
drop index if exists ix_tb_user_user_tag_id;

alter table tb_user drop constraint if exists fk_tb_user_dept_id;
drop index if exists ix_tb_user_dept_id;

alter table tb_user drop constraint if exists fk_tb_user_address_post_number;

drop table if exists tb_address;

drop table if exists tb_dept;

drop table if exists tb_user;

drop table if exists tb_tag;

