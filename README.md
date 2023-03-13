# SAOE
SNS_Reverse Engineering

- Push 하는법
  1. 프로젝트 생성
  2. 프로젝트 우클릭 - Team 메뉴 Share Project
  3. 깃허브 서버에서 접근할 로컬 repository 경로 설정 => 프로젝트명에 [repository matser]가 생김
  4. 프로젝트 우클릭 - Team 메뉴 Commit - 하단 탭에 Git Staging 탭 생김
  5. Unstaged/Staged Changes -> 변경된 파일을 올릴건지? / 전부올릴거면 + 두개 있는 아이콘 클릭
  6. Commit Message : 안내문구 작성
  7. Commit and Push / Commit 중 어떤 걸 할건지 -> 이번 프로젝트는 Commit으로 결정
    기존의 파일과 연동되는지 확인하기 위해서
  8. Local Repository에 현재 프로젝트가 반영됨
  9. 프로젝트 우클릭 - Team메뉴 Push Branch 'master' 클릭 => 어디에 올릴건지 설정
  10. Location - URI부분에 원격저장소 주소 / Authentication(User:이메일주소, Password:토큰값) 삽입
  11. Prieview - Push - 안내문구 출력

- Local Repository 삭제 하는 법
  1. 상단 탭 Window - Show View - Other - Git Repositories
  2. 하단탭 - 해당 repository 우클릭 - Delete repository - 체크박스 전부 클릭 - Delete


- Clone 하는법
  1. 빈 곳 우클릭 - Import 두번 - Projects from Git - Clone URI
  2. URI(팀Repository주소), User(git 이메일), Password(토큰값  입력, 공백주의) 입력
  3. Next2번 - Local Destination에서 경로 설정 - Next 2번 - Finish
  4. 프로젝트 추가 됨 (프로젝트명[팀명])