## 1단계

---

### 종료

```
== 명언 앱 ==
명령) 종료
```

4-2: 테스트 통과지만 종료 기능 구현 안됨.

## 2단계

---

### 등록

```
== 명언 앱 ==
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
명령) 종료
```

5-2: 테스트 통과지만 등록 기능 구현 안됨.

## 3단계

---

### 등록시 생성된 명언번호 노출

```
== 명언 앱 ==
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
1번 명언이 등록되었습니다.
명령) 종료
```

7-2: 테스트 통과지만 등록 기능 구현 안됨.

## 4단계

---

### 등록할때 마다 생성되는 명언번호가 증가

```
== 명언 앱 ==
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
1번 명언이 등록되었습니다.
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
2번 명언이 등록되었습니다.
명령) 종료
```

7-2: 테스트 통과지만 등록 기능 구현 안됨.

## 5단계

---

### 목록

```
== 명언 앱 ==
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
1번 명언이 등록되었습니다.
명령) 등록
명언 : 과거에 집착하지 마라.
작가 : 작자미상
2번 명언이 등록되었습니다.
명령) 목록
번호 / 작가 / 명언
----------------------
2 / 작자미상 / 과거에 집착하지 마라.
1 / 작자미상 / 현재를 사랑하라.
명령) 종료
```

8-4: 목록 구현

## 6단계

---

### 1번 명언삭제

```
== 명언 앱 ==
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
1번 명언이 등록되었습니다.
명령) 등록
명언 : 과거에 집착하지 마라.
작가 : 작자미상
2번 명언이 등록되었습니다.
명령) 목록
번호 / 작가 / 명언
----------------------
2 / 작자미상 / 과거에 집착하지 마라.
1 / 작자미상 / 현재를 사랑하라.
명령) 삭제?id=1
1번 명언이 삭제되었습니다.
명령) 종료
```

- 9-5: 삭제 구현
- 26: 리팩토링

## 7단계

---

### 존재하지 않는 명언삭제에 대한 예외처리

```
== 명언 앱 ==
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
1번 명언이 등록되었습니다.
명령) 등록
명언 : 과거에 집착하지 마라.
작가 : 작자미상
2번 명언이 등록되었습니다.
명령) 목록
번호 / 작가 / 명언
----------------------
2 / 작자미상 / 과거에 집착하지 마라.
1 / 작자미상 / 현재를 사랑하라.
명령) 삭제?id=1
1번 명언이 삭제되었습니다.
명령) 삭제?id=1
1번 명언은 존재하지 않습니다.
명령) 종료
```

14-2: 존재하지 않는 명언삭제에 대한 예외처리 구현

## 8단계

---

### 명언수정

```
== 명언 앱 ==
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
1번 명언이 등록되었습니다.
명령) 등록
명언 : 과거에 집착하지 마라.
작가 : 작자미상
2번 명언이 등록되었습니다.
명령) 목록
번호 / 작가 / 명언
----------------------
2 / 작자미상 / 과거에 집착하지 마라.
1 / 작자미상 / 현재를 사랑하라.
명령) 삭제?id=1
1번 명언이 삭제되었습니다.
명령) 삭제?id=1
1번 명언은 존재하지 않습니다.
명령) 수정?id=2
명언(기존) : 과거에 집착하지 마라.
명언 : 현재와 자신을 사랑하라.
작가(기존) : 작자미상
작가 : 홍길동
명령) 목록
번호 / 작가 / 명언
----------------------
2 / 홍길동 / 현재와 자신을 사랑하라.
명령) 종료
```

- 13-2: 수정 구현
- 14-2: 존재하지 않는 명언에 대한 수정 예외처리

## 9단계

---

### 파일을 통한 영속성

```
== 명언 앱 ==
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
1번 명언이 등록되었습니다.
명령) 등록
명언 : 과거에 집착하지 마라.
작가 : 작자미상
2번 명언이 등록되었습니다.
명령) 목록
번호 / 작가 / 명언
----------------------
2 / 작자미상 / 과거에 집착하지 마라.
1 / 작자미상 / 현재를 사랑하라.
명령) 종료

프로그램 다시 시작...

== 명언 앱 ==
명령) 목록
번호 / 작가 / 명언
----------------------
2 / 작자미상 / 과거에 집착하지 마라.
1 / 작자미상 / 현재를 사랑하라.
```

## 10단계

---

### data.json 빌드

```
== 명언 앱 ==
명령) 등록
명언 : 현재를 사랑하라.
작가 : 작자미상
1번 명언이 등록되었습니다.
명령) 등록
명언 : 과거에 집착하지 마라.
작가 : 작자미상
2번 명언이 등록되었습니다.
명령) 목록
번호 / 작가 / 명언
----------------------
2 / 작자미상 / 과거에 집착하지 마라.
1 / 작자미상 / 현재를 사랑하라.
명령) 삭제?id=1
1번 명언이 삭제되었습니다.
명령) 삭제?id=1
1번 명언은 존재하지 않습니다.
명령) 수정?id=2
명언(기존) : 과거에 집착하지 마라.
명언 : 현재와 자신을 사랑하라.
작가(기존) : 작자미상
작가 : 홍길동
명령) 목록
번호 / 작가 / 명언
----------------------
2 / 홍길동 / 현재와 자신을 사랑하라.
명령) 빌드
data.json 파일의 내용이 갱신되었습니다.
명령) 종료
```