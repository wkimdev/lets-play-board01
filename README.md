## board
- 컨셉 : 스터디 모임방 만들기.
- 회원가입 : 회원가입 후 인증메일 받고 로그인하기.
- 게시판에 모임글 올리기.
- 대대댓글 까지 구현. 
- 이미지 및 기타 파일 업로드 시키기.

#### task 1
- 메인화면 호출(''님 환경합니다. 메인화면 )
- 회원가입 버튼 클릭 --> 회원가입 /디비 정보 INSERT --> 회원가입 완료 화면
- 로그인 화면 --> ''님 환경합니다. 메인화면 
- 디비에 member table생성, 인증 정보가 남을 컬럼도 하나 필요함.

#### 기본 crud부터
- 1. select test 하고 controller, service 만들기(select all 이 안됨..) 
- 2. insert test 하고 controller, service 만들기(test 완료)
- 3. login 구현하기
- 3. update 구현 (login 이후 가능 액션)
- 4. delete 구현 (login 이후 가능 액션)
- 5. 정리


# add
- 스터디 인증사진 및 인증 폼 올리기. (파일 업로드) 
- 소셜로그인 인증.

## tech stack
- db : mysql

## f/b
- spring legacy project --> spring web mvc 로 실행. 