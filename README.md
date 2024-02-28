
# 배달이오 - Delievery
---
##개요
프로젝트의 주제를 설정할때 SNS나 익명커뮤니티, 배달어플 등 프로젝트 설계를 고민 했으나 초기에 팀원들 간의 논의끝 에 다양한 기능을 구현하고 시도할 수 있는 배달 커머스 앱으로 프로젝트를 기획하기 시작했으며 조선시대의 배달을 컨셉으로 한 배달 서비스를 구현하고자 한 어플입니다.

## 사용될 기술 및 툴
---
협업 툴 - Slack, Github, ErdCloud, Figma, Notion
개발 툴 - intellij
개발시 사용 기술스택 - Spring security, jwt, Mysql, Spring

## 코드컨벤션
---
자바 구글 코드 컨벤션 규칙 사용
커밋의 기능에 따라 커밋 유형 정의
esponseEntity 사용
소프트 딜리트 정책
#### 🥔 커밋 유형
- feat: 새로운 기능의 추가
- fix: 버그 수정
- docs: 문서 수정
- style: 스타일 관련 기능(코드 포맷팅, 세미콜론 누락, 코드 자체의 변경이 없는 경우)
- refactor: 코드 리펙토링
- test: 테스트 코트, 리펙토링 테스트 코드 추가
- chore: 빌드 업무 수정, 패키지 매니저 수정(ex .gitignore 수정 같은 경우)

## 와이어프레임
---
<img width="750" alt="image" src="https://github.com/yjcountry/outsourcing/assets/108345184/678eaae0-cbfc-4c34-922b-7190dabfb9a4">

#### 설명
와이어프레임에서는 로그인이후 메인화면으로 연결시켜 조선시대의 배경으로 하는 앱으로 주막이라는 명칭을 통해서 컨셉을 살렸고 주막을 검색하거나 정보를 확인할 수 있으며 주막으로 부터 주문하고 리뷰를 작성하거나 주문내역이 보이는 등 다양한 배달앱으로써의 기능을 와이어프레임으로 구현했습니다. 


## ERD 다이어그램
---
<img width="750" alt="image" src="https://github.com/yjcountry/outsourcing/assets/108345184/994f38b5-4db4-43df-8488-924337abd5f5">

#### 설명
ERD를 통하여 프로젝트에서 요구되는 사항을 분석하고 이를 그림으로 그려내어 배달을 위한 각 테이블을 정의 했습니다.
