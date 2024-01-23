## 요구사항

 - [x] 일정 작성 
   - [x] 할 일 제목, 할 일 내용, 담당자, 비밀번호, 작성일 저장
   - [x] 저장된 일정 정보를 JSON으로 반환
 - [x] 선택한 일정 조회
   - [x] 해당 일정 정보를 JSON으로 반환
 - [x] 일정 목록 조회 
   - [x] 일정 전체 정보를 JSON으로 반환
     - [x] 작성일 기준 내림차순 정렬
 - [x] 선택한 일정 수정 
   - [x] 해당 일정의 할 일 제목, 할 일 내용, 담당자 수정
     - [x] 비밀번호 일치시에만 수정 가능 
   - [x] 수정한 일정 정보 JSON으로 반환
 - [x] 선택한 일정 삭제 
   - [x] 비밀번호 일치시에만 삭제 가능
 - [x] 일정 정보 반환시 비밀번호는 제외한다

| HttpMethod | URL            | Description |
| ---- |----------------| ---- |
| POST | /schedule      | 일정을 등록한다 |
| GET | /schedule      | 일정 목록 전체를 조회한다 |
| GET | /schedule/{id} | 선택 일정을 조회한다 |
| PUT | /schedule/{id} | 선택일정을 수정한다 |
| DELETE | /schedule/{id} | 선택일정을 삭제한다 |

ERD Table
![schedule-management-erd](https://github.com/jinkshower/schedule-management/assets/135244018/e25f7b8e-7eac-485f-a7cd-cfe4a6ef2ea9)
Use-Case
![schedule-management-usecase](https://github.com/jinkshower/schedule-management/assets/135244018/84924f21-17e6-4215-9e38-045c2b534e04)
