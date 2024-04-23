CREATE TABLE if not exists user (
    id          int         NOT NULL AUTO_INCREMENT, -- id는 자동으로 증가하며 null값일수 없다
    username    varchar(50) NOT NULL,
    password    char(60)    NOT NULL,
    first_name  varchar(20) NOT NULL,
    date_joined datetime    NOT NULL DEFAULT current_timestamp,  -- 가입일시
    last_login  datetime    NOT NULL DEFAULT current_timestamp,  -- 마지막 접속일시
    PRIMARY KEY (id),   -- id를 주요키로 받겠다
     UNIQUE KEY username (username)   -- 사용자 이름은 고유하다
);

CREATE TABLE if not exists post (  -- 테이블 존재안할시 post생성
   id            int          NOT NULL AUTO_INCREMENT,
   title         varchar(255) NOT NULL,
   content       text         NOT NULL,
   user_id       int          NOT NULL,            -- references user.id
   first_name    varchar(20)  NOT NULL DEFAULT '', -- jpa에서 사용하지 않음. user.firstName으로 사용
   pub_date      datetime     NOT NULL DEFAULT current_timestamp(), -- 작성일시
   last_modified timestamp    NOT NULL DEFAULT current_timestamp() on update current_timestamp(),  -- 마지막 수정일시
   PRIMARY KEY (id),
   FULLTEXT KEY title (title),  -- (게시물 제목)full text 인데스는 특정 검색어 일치 안해도 유사한 문자열이라도 포함하고 있는 모든 행 찾게 함
   FULLTEXT KEY content (content),  -- 게시물 내용에 대한 full text 인덱스 생성
   FOREIGN KEY (user_id) REFERENCES user (id)  -- user.id는 join하는것 user테이블의 id와 연결(references user.id)
);
CREATE TABLE if not exists movie (
   id            int(11)          NOT NULL AUTO_INCREMENT,
   title         varchar(100) NOT NULL,
   director    varchar(50)  NOT NULL ,
   PRIMARY KEY (id),
   FULLTEXT KEY title (title)
);
