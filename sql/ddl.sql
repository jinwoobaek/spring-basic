-- 김영한 선생님은 이렇게 따로 관리를 해서 확인하게 편하게 한다.
drop table if exists member CASCADE;
create table member
(
    id bigint generated by default as identity,
    name varchar(255),
    primary key (id)
);