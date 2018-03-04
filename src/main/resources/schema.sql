-- Project Name : testProject
-- Date/Time    : 2018/03/03 8:22:15
-- Author       : super
-- RDBMS Type   : PostgreSQL
-- Application  : A5:SQL Mk-2

-- テスト
drop table if exists trn_test cascade;

create table trn_test (
  test_mid bigserial not null
  , user_id varchar(25) not null
  , user_name varchar(100) not null
  , mail_address varchar(255)
  , constraint trn_test_PKC primary key (test_mid)
) ;

comment on table trn_test is 'テスト';
comment on column trn_test.test_mid is 'テスト内部ID';
comment on column trn_test.user_id is 'ユーザーID';
comment on column trn_test.user_name is 'ユーザー名';
comment on column trn_test.mail_address is 'メールアドレス';
