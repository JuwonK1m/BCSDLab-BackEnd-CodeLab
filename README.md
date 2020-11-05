# BCSDLab-BackEnd-CodeLab

BCSDLab 회원을 위한 BackEnd 코드랩 (Java, Spring 버전)

## 작성자

BCSDLab BackEnd Regular 김주원

## 들어가기에 앞서

BCSDLab 회원을 위한 BackEnd 트랙 코드랩입니다.  
간단한 실습을 통해 직접 API를 작성하고 서버를 구동하여 request에 대한 response를 확인해보며 백엔드가 어떤 메커니즘으로 돌아가는지 체험해보는 것이 목적입니다.   

언어는 **Java**, 프레임워크는 **Spring Boot**로 진행합니다. (Spring MVC로 진행하고자 하였지만 환경 세팅이 너무 오래걸려 Spring Boot로 선정하였습니다.)  
Spring 프레임워크를 다루어보지 않았어도 괜찮습니다. 문서에서 안내하는 대로만 따라오시면 됩니다.

또한 MySQL과 같은 DB를 설치해야 더 좋은 코드랩이 될 수 있지만, 설치 과정이 오래걸리는 관계로 이 문서에서는 DB 사용을 하지 않았습니다. 그래도 체험해보는 것에는 문제가 없으니 괜찮습니다.

실습하시면서 조금이라도 이해가 되지 않는 부분이 있다면 언제든지 Slack DM으로 질문주세요~ 친절하게 답변해드리겠습니다.

그럼 시작하겠습니다 :)

## 백엔드(Back-End)란?

### 프론트엔드(Front-End) vs 백엔드(Back-End)

하나의 애플리케이션은 크게 프론트엔드(Front-End)와 백엔드(Back-End)로 나누어집니다.  
프론트엔드는 사용자가 애플리케이션을 사용할때 **눈에 보여지는 부분**에 대한 작업을 담당합니다. 즉, 쉽게 말하면 **클라이언트**(화면)을 담당하는 것입니다.  
백엔드는 사용자에 눈에는 보이지 않는 **화면 뒷단**에서의 작업을 수행합니다. **서버**측 작업을 담당하며, 사용자에게 서비스를 제공하기 위한 데이터 가공이나 데이터베이스 관리 등을 합니다.

프론트엔드와 백엔드의 상호작용은 request(요청)과 response(응답)으로 이루어집니다.  
클라이언트에서 서버로 request를 보내면, 서버에서는 request에 대해 적절한 작업을 수행하고 그에 따른 response를 클라이언트에게 보냅니다. 
![](https://i.imgur.com/N80OcuR.png)

특히 서버측에서는 **API**(Application Programming Interface)를 통하여 클라이언트에게 기능을 제공하는 방식으로 동작합니다.   
API는 간단하게 말하면 **request에 대해 특정 목적을 달성할 수 있게 해주는 기능을 제공하는 것**입니다.   

이러한 방식으로 작업을 분리하여, 프론트엔드와 백엔드 각각의 개발자들은 각자의 작업에 집중하면서 효율성을 높일 수 있습니다.

### 백엔드의 언어 및 프레임워크

백엔드 프로그래밍을 위해서는 주로 다음의 언어와 프레임워크를 사용합니다. (언어 - 프레임워크)

> - Java - Spring
> - Python - Django
> - JavaScript - Node.js
> - PHP - Laravel 

이중 원하는 언어와 프레임워크를 골라서 공부하면됩니다.  
BCSDLab에서는 현재 Java와 Spring을 사용하고 있습니다.  
대표적으로 [코인 - 한기대 커뮤니티](https://koreatech.in) 서비스를 Java와 Spring을 통해 제작하여 제공하고 있습니다. 

## 실습

### Java 설치 및 환경변수 설정

일단 실습을 위해 당연히 Java를 설치해야겠죠? [여기](https://gabii.tistory.com/entry/Java-Java-JDK-%EC%84%A4%EC%B9%98-%EB%B0%8F-%ED%99%98%EA%B2%BD%EC%84%A4%EC%A0%95)를 참고하셔서 설치 및 환경변수 설정까지 완료합시다.  
만약 이미 설치되어있다면 다음 단계로 넘어갑시다.  

### IntelliJ 학생 인증 무료 설치

Java용 IDE인 IntelliJ를 설치합시다. IntelliJ는 기본적으로 유료인데, 학생이라면 소속 학교 인증을 통해 무료로 설치할 수 있습니다.
다음 링크를 참고하셔서 설치하시기 바랍니다.

- Windows
  - https://goddaehee.tistory.com/215
- Mac
  - https://whitepaek.tistory.com/6

### Postman 설치

Postman은 API 테스트 기능을 제공하는 프로그램입니다.  
[여기](https://www.postman.com/downloads/)로 들어가서 설치합니다.  
설치하고 나서 회원가입과 로그인을 해야합니다. (오래 걸리지 않습니다.)

### 실습 환경 세팅

IntelliJ를 실행하면 다음과 같은 화면이 나타납니다. **Create New Project**를 클릭합니다.  
![](https://i.imgur.com/bFIOr49.png)

클릭하면 다음과 같은 화면이 뜨게 될것입니다.
![](https://i.imgur.com/FnijNiB.png)

왼쪽에 있는 여러가지 목록에서 **Spring Initializr**를 클릭합니다.
![](https://i.imgur.com/VycSwSe.png)

상단에 있는 **Project SDK**에서 오른쪽에 있는 '**New...**'버튼을 눌러 **JDK**를 누르고 Java 폴더 아래에 있는 JDK 폴더 경로로 맞추어줍시다.
![](https://i.imgur.com/1fSJDY9.png)

오른쪽 하단에 있는 **Next**를 클릭합니다.
![](https://i.imgur.com/bEIc94x.png)

**Java Version**을 **8**로 설정합니다.
![](https://i.imgur.com/kE52UeF.png)

오른쪽 하단에 있는 **Next**를 클릭합니다.
![](https://i.imgur.com/kTyeeKB.png)

다음과 같은 화면이 뜰것입니다.
![](https://i.imgur.com/cbPslwf.png)

왼쪽 목록에서 **Web**를 클릭하고 가운데 목록에서 **Spring Web**을 체크합니다.
![](https://i.imgur.com/PxL584V.png)

오른쪽 하단의 **Next**를 클릭합니다.
![](https://i.imgur.com/vGuFxj6.png)

**Project name**을 작성합니다. 마음대로 작성하시면 됩니다. 저는 자동으로 생성된 demo라는 이름으로 하도록 하겠습니다.
![](https://i.imgur.com/NkT8vGm.png)

오른쪽 하단의 Finish를 클릭합니다.
![](https://i.imgur.com/DNK8LOd.png)

다음과 같이 화면이 나타나게 될것입니다.
![](https://i.imgur.com/1AbtNZB.png)

왼쪽 프로젝트 디렉토리 구조 부분에서 화살표 모양을 눌러서 **com.example.demo** 패키지(com 패키지 아래에 있는 example 패키지의 아래에 있는 demo 패키지)에 있는 **DemoApplication**파일이 보일때까지 열어줍시다.  
![](https://i.imgur.com/5LrINoV.png)

com.example.demo 패키지에서 마우스 오른쪽을 눌러 **New**를 클릭하고 **Package**를 클릭해줍니다.
![](https://i.imgur.com/D8iRDpb.png)

controller를 덧붙이고 엔터를 누릅니다.  
![](https://i.imgur.com/oG5Lt69.png)

controller 패키지에서 마우스 오른쪽을 눌러 **New**를 클릭하고 **Java Class**를 클릭해줍니다.
![](https://i.imgur.com/Pe2YucN.png)

**TestController**라고 적고 엔터를 누릅니다.  
![](https://i.imgur.com/4z9I6xZ.png)

코드 화면에 다음과 같이 뜨게 될것입니다.  
![](https://i.imgur.com/wkoQYmB.png)

실습을 위한 세팅이 전부 완료되었습니다. 이제 실습을 해봅시다!

### 실습해보기

코드에 다음과 같이 작성해줍시다.

- 클래스의 상단에 @RestController 어노테이션 선언
- getName() 메소드 선언 및 정의 (접근제어자: public, 반환형: String), "김주원" 반환
- getName() 메소드 상단에 @RequestMapping 어노테이션 선언 후 괄호 열고 value값에 "/test", method값에 RequestMethod.GET 넣어주기  

![](https://i.imgur.com/dJblnLn.png)

각각의 요소를 선언하거나 넣어줄때는 꼭 위 사진에 보이는 라이브러리 패키지로 import를 해주어야 합니다.  

``` java
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
```

이제 위 사진에 있는 코드를 분석해볼까요? 다음 메소드를 봅시다.

``` java
@RequestMapping(value = "/test", method = RequestMethod.GET)
public String getName() {
    return "김주원";
}
```

"김주원"이라는 String타입 데이터를 반환하고있고, 상단에는 /test, GET 등의 키워드들이 있는 것을 확인할 수 있습니다.  
이것이 어떤 기능을 하는지 유추가 되시나요?  
바로 **/test**라는 **URI**와 **GET방식의 Http Method**로 request가 들어오게 되면 getName() 메소드가 실행되는 것입니다.  

그렇다면 데이터를 리턴하는것은 어떤것을 뜻할까요?  
네, 그렇습니다. **response**(응답)를 하는 것입니다.  

즉, 특정 request에 대한 response를 작성하였으니 하나의 **API**를 만든 것입니다.  
구조를 그림으로 그려보면 다음과 같습니다.
![](https://i.imgur.com/GusNa2X.png)

request를 통하여 응답을 통해 "김주원"이라는 데이터를 얻은 것이라고 할 수 있습니다.

그렇다면 실제로 API가 동작하는지 확인해봐야겠죠?  

상단의 **Run**을 클릭하고 '**Run...**'을 클릭합니다.
![](https://i.imgur.com/3Hmm16Q.png)

Application을 Run 해줍시다.  
![](https://i.imgur.com/dCWgKZT.png)

콘솔창에 다음과 같이 뜬다면 웹 애플리케이션 서버 구동이 정상적으로 완료된것입니다.
![](https://i.imgur.com/hslNSSf.png)

테스트를 위해 Postman을 실행하여 다음과 같이 URL칸에 `http://localhost:8080/test`를 입력하고 Method는 **GET**으로 설정합니다.  
`localhost`는 로컬 컴퓨터 호스트이며 뒤에 콜론 다음으로 붙은 `8080`은 저희가 구동한 애플리케이션 서버의 포트입니다. 즉, 자신의 컴퓨터에서 구동되고 있는 8080 포트 서버로 접속하겠다는 것입니다. 그리고 8080 뒤에 붙은 `/test`는 저희가 작성했던 URI입니다.  
전부 세팅 후 Send를 클릭합시다.  
![](https://i.imgur.com/cOMtGV0.png)

Send 클릭 후에는 다음과 같이 "김주원" 이라는 데이터가 응답되는 것을 확인할 수 있습니다.
![](https://i.imgur.com/Cz1os4p.png)

이러한 방식으로 백엔드는 서버측에서 API를 통하여 프론트엔드로 응답을 제공합니다. 이해가 되시죠? :)

지금 살펴봤던 API는 간단한 예시이니, 이번엔 조금 더 로직이 들어가는 새로운 API를 작성해볼까요? 

TestController 클래스 안에 다음과 같이 getUser() 메소드를 추가합시다.

``` java
package com.example.demo.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {
    @RequestMapping(value = "/test", method = RequestMethod.GET)
    public String getName() {
        return "김주원";
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public ResponseEntity getUser(@PathVariable Integer id) {
        Map<String, Object> map = new HashMap<>();

        if (id == 1) {
            map.put("id", id);
            map.put("name", "김주원");
            map.put("nickname", "Back-End 개발자");
            map.put("created_at", "2020-11-03");
        } else if (id == 2) {
            map.put("id", id);
            map.put("name", "나윤재");
            map.put("nickname", "Android 개발자");
            map.put("created_at", "2020-11-04");
        } else if (id == 3) {
            map.put("id", id);
            map.put("name", "최원빈");
            map.put("nickname", "Front-End 개발자");
            map.put("created_at", "2020-11-05");
        } else {
            map.put("error_message", "요청하신 유저를 찾을 수 없습니다.");
            return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(map, HttpStatus.OK);
    }
}
```

추가된 getUser() 메소드에서 살펴볼 점은 다음과 같습니다.

- @RequestMapping의 value값(URI)가 `/user/{id}`인데, 중괄호로 둘러쌓인 id는 무엇을 의미할까요?
  - URI에 존재하는 리소스가 중괄호로 둘러쌓여있으면, 그 값은 **path variable**를 의미합니다. path variable은 쉽게 생각하면 값을 담을수 있는 변수입니다. 즉, 동적으로 값을 넣을 수 있는 곳입니다.  
- 매개변수 앞에 붙은 @PathVariable은 무엇을 의미할까요?
  - path variable로 들어온 값을 매개변수에 담아주는 어노테이션입니다. 만약 `user/1`로 요청이 들어온다면 Integer 타입 변수 id에는 1이 저장될 것입니다. 
- ResponseEntity 객체는 어떤 역할을 할까요?
  - 응답을 더 편리하게 지원해주는 객체입니다. **응답 데이터**와 **상태 코드**를 동시에 response해줄 수 있게 해줍니다.
  - 보통 첫번째 인자로는 응답할 데이터에 대한 객체가 들어가고, 두번째 인자로는 Http 상태 코드가 들어갑니다.

결국 코드를 살펴보면

path variable로 들어온 id값에 따라 유저 정보를 반환하고,

``` java
if (id == 1) {
    map.put("id", id);
    map.put("name", "김주원");
    map.put("nickname", "Back-End 개발자");
    map.put("created_at", "2020-11-03");
} else if (id == 2) {
    map.put("id", id);
    map.put("name", "나윤재");
    map.put("nickname", "Android 개발자");
    map.put("created_at", "2020-11-04");
} else if (id == 3) {
    map.put("id", id);
    map.put("name", "최원빈");
    map.put("nickname", "Front-End 개발자");
    map.put("created_at", "2020-11-05");
}

// 생략

return new ResponseEntity(map, HttpStatus.OK);
```

유저가 없으면 에러 메시지를 반환하는 과정이라는 것을 알 수 있습니다.

``` java
else {
    map.put("error_message", "요청하신 유저를 찾을 수 없습니다.");
    return new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
}
```

잘 동작하는지 확인하기 위해 이전 과정에서 했던 방식으로 애플리케이션을 Run하고, Stop and Rerun을 클릭하여 서버를 재시작해줍시다.  
![](https://i.imgur.com/1gYTc6D.png)

콘솔창에 다음과 같이 뜬다면 이번에도 서버 구동에 성공한것입니다.
![](https://i.imgur.com/VdY8S16.png)

Postman에서 이전에 했던 방식과 마찬가지로 테스트해보면 요청에 따라 응답이 잘 이루어지는 것을 확인할 수 있습니다. (id 값이 1, 2, 3이 아닐때는 에러 메시지를 응답하는 것을 확인할 수 있죠?)
![](https://i.imgur.com/oXw3k7v.png)

사실 엄밀히 말하자면 지금 작성한 getUser() 메소드같은 API는 실제 서비스와는 좀 동떨어진 API입니다. 왜냐하면 DB의 사용 없이 단순히 코드에서 유저 데이터를 생성하여 응답하고 있으며, 더 복잡한 과정들을 거쳐서 응답이 이루어지기 때문입니다.  

다음 그림이 실제로 API가 동작하는 과정입니다.
![](https://i.imgur.com/WOCYgIT.png)

하지만 이 문서는 백엔드에 대한 체험이 목적이고, API가 어떠한 과정으로 동작을하고 어떤 역할을 하는지 알아보았기 때문에 이러한 점만 알아가셔도 큰 수확입니다 :)

## 마치며

프론트엔드와 백엔드에 대한 개념을 간단히 알아보았고, 특히 백엔드에서 제공하는 API를 직접 작성해봄으로써 API가 어떻게 동작하고 어떤 역할을 하는지 알아보았습니다.  

당연하지만, 이번 문서에서 체험해본 것은 백엔드의 새발에 피에 불과합니다.  
API 작성을 위한 **언어**와 **프레임워크**에 대한 이해, **웹 서버** & **웹 애플리케이션 서버**에 대한 이해, **DB**에 대한 이해, **인프라**에 대한 이해... 등등 정말 공부해야할 것이 많습니다.

하지만 백엔드라는 분야는 어렵고 복잡하면서도 공부하다보면 재미있는 부분이 많고, 힘듬을 넘어서면 그만큼의 성취감도 따라오는 것 같습니다.

많은 BCSDLab 회원분들과 BackEnd 트랙에서 볼 수 있었으면 좋겠습니다.

정말 수고하셨고, 부족한 글 읽어주셔서 감사드립니다 :)
