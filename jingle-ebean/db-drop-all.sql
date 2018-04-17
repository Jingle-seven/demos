alter table tb_user drop constraint if exists fk_tb_user_dept_id;
drop index if exists ix_tb_user_dept_id;

drop table if exists tb_dept;

drop table if exists tb_user;

