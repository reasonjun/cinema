INSERT INTO code_group (cd, description) VALUES ('SEX', '성별');
INSERT INTO code_group (cd, description) VALUES ('GRADE', '상영등급');
INSERT INTO code_group (cd, description) VALUES ('GENRE', '장르');
INSERT INTO code_group (cd, description) VALUES ('ACTOR_ROLE', '배우 역할');
INSERT INTO code_group (cd, description) VALUES ('STAFF_ROLE', '제작진 역할');

INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('SEX', 'FEMALE', '여자', null, 2);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('SEX', 'MALE', '남자', null, 1);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('SEX', 'NOT_APPLICABLE', '해당 없음', null, 9);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('SEX', 'NOT_KNOWN', '알 수 없음', null, 0);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GRADE', 'ALL_ALLOWED', '전체관람가', null, 1);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GRADE', 'LIMITED_ALLOWED', '제한상영가', null, 5);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GRADE', 'OVER_FIFTEEN_YEAR_OLD_ALLOWED', '15세 이상 관람가', null, 3);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GRADE', 'OVER_TWELVE_YEAR_OLD_ALLOWED', '12세 이상 관람가', null, 2);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GRADE', 'YOUTH_NOT_ALLOWED', '청소년 관람불가', null, 4);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'ACTION', '액션', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'ANIMATION', '애니메이션', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'DRAMA', '드라마', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'CRIME', '범죄', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'THRILLER', '스릴러', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'COMEDY', '코미디', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'MELODRAMA_ROMANCE', '멜로/로맨스', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'HORROR', '공포(호러)', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'MYSTERY', '미스터리', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'SF', 'SF', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'EROTIC', '성인물(에로)', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'FANTASY', '판타지', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'ADVENTURE', '어드벤처', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'HISTORY', '사극', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'FAMILY', '가족', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'WAR', '전쟁', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'ETC', '기타', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'DOCUMENTARY', '다큐멘터리', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'MUSICAL', '뮤지컬', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'SHOW', '공연', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('GENRE', 'WESTERN', '서부극(웨스턴)', null, null);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('ACTOR_ROLE', 'LEAD_ROLE', '주연', null, 1);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('ACTOR_ROLE', 'SUPPORTING_ROLE', '조연', null, 2);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('ACTOR_ROLE', 'MINOR_ROLE', '단역', null, 3);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('ACTOR_ROLE', 'EXTRA', '엑스트라', null, 4);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('ACTOR_ROLE', 'CAMEO', '카메오', null, 5);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('ACTOR_ROLE', 'FRIENDSHIP_APPEARANCE', '우정출연', null, 6);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('ACTOR_ROLE', 'SPECIAL_APPEARANCE', '특별출연', null, 7);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('ACTOR_ROLE', 'GUEST_APPEARANCE', '찬조출연', null, 8);
INSERT INTO code (group_cd, cd, nm, description, `order`) VALUES ('STAFF_ROLE', 'DIRECTOR', '감독', null, 1);

INSERT INTO movie (id, movie_grade_cd, ttl_nm, sbttl_nm, contents, release_ymd, release_end_ymd, running_hr) VALUES (1, 'OVER_TWELVE_YEAR_OLD_ALLOWED', '뷰티 인사이드', null, null, '20150820', null, '127');

INSERT INTO staff (id, korn_flnm, eng_flnm, brdt, sex_cd, frgnr_yn) VALUES (1, '백종열', null, null, 'MALE', 'N');

INSERT INTO actor (id, brdt, eng_flnm, frgnr_yn, korn_flnm, sex_cd) VALUES (1, '19870222', 'HanHyojoo', 'N', '한효주', 'FEMALE');
INSERT INTO actor (id, brdt, eng_flnm, frgnr_yn, korn_flnm, sex_cd) VALUES (2, '19810216', '', 'N', '김대명', 'MALE');
INSERT INTO actor (id, brdt, eng_flnm, frgnr_yn, korn_flnm, sex_cd) VALUES (3, '19881216', '', 'N', '박서준', 'MALE');
INSERT INTO actor (id, brdt, eng_flnm, frgnr_yn, korn_flnm, sex_cd) VALUES (4, '19810916', '', 'N', '이진욱', 'MALE');
INSERT INTO actor (id, brdt, eng_flnm, frgnr_yn, korn_flnm, sex_cd) VALUES (5, '19900218', '', 'N', '박신혜', 'FEMALE');
INSERT INTO actor (id, brdt, eng_flnm, frgnr_yn, korn_flnm, sex_cd) VALUES (6, '19860525', '', 'Y', '우에노 주리', 'FEMALE');
INSERT INTO actor (id, brdt, eng_flnm, frgnr_yn, korn_flnm, sex_cd) values (7, '19850722', '', 'N', '이동휘', 'MALE');
INSERT INTO actor (id, brdt, eng_flnm, frgnr_yn, korn_flnm, sex_cd) values (8, '', '', 'N', '문숙', 'FEMALE');

INSERT INTO movie_actor (id, actor_role_cd, actor_role_casting, actor_id, movie_id) VALUES (1, 'LEAD_ROLE', '홍이수', 1, 1);
INSERT INTO movie_actor (id, actor_role_cd, actor_role_casting, actor_id, movie_id) VALUES (2, 'LEAD_ROLE', '우진1', 2, 1);
INSERT INTO movie_actor (id, actor_role_cd, actor_role_casting, actor_id, movie_id) VALUES (3, 'LEAD_ROLE', '우진60', 3, 1);
INSERT INTO movie_actor (id, actor_role_cd, actor_role_casting, actor_id, movie_id) VALUES (4, 'LEAD_ROLE', '우진84', 4, 1);
INSERT INTO movie_actor (id, actor_role_cd, actor_role_casting, actor_id, movie_id) VALUES (5, 'LEAD_ROLE', '우진43', 5, 1);
INSERT INTO movie_actor (id, actor_role_cd, actor_role_casting, actor_id, movie_id) VALUES (6, 'LEAD_ROLE', '우진74', 6, 1);

INSERT INTO movie_staff (movie_id, staff_id, staff_role_cd) VALUES (1, 1, 'DIRECTOR');