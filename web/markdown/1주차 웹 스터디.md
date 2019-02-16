## 02 / 04 ~ 02/08

### 1. Web 개발의 이해



#### 웹 프로그래밍을 위한 프로그램 언어들

1. 저급 언어(기계어 / 어셈블리어)
   - <u>기계 중심의 언어</u> 1(on) / 0(off)로 표현
   - 컴퓨터가 바로 알아들을 수 있는 언어지만, 사람이 보기에 매우 흉함
   - 따라서 <u>편의를 위해</u> 기계어(숫자로 된 문장)와 1:1로 대응하는 기호를 만들어서 프로그래밍
   - 이렇게 편의를 위해 만들어진 언어가 <u>어셈블리어</u>( 컴파일러를 통해 기계어로 번역 )

2. 고급 언어
   - <u>사람 중심의 언어</u> 사람의 언어를 이용하여 프로그래밍이 가능
   - 편의성(사람의 언어)를 이용하기 때문에 컴파일러를 통해 컴파일이 필요함.(번역)
   - 우리가 지금 사용하는 C / C++ / JAVA / PYTHON 등이 고급언어에 해당. 

3. 컴파일러

   - 사람 중심의 언어를 컴퓨터(기계)가 이해할 수 있는 형태로 번역해주는 Tool.

> 웹 관련 인기 언어
>
> Python : 주로 데이터 과학 분야에서 사용되며, 웹사이트 개발에서도 인기 상승 중
>
> PHP : 웹의 서버사이드 스크립트로만 사용.
>
> Javascript : 처음에는 Front영역의 동적인 프로그래밍에만 사용되었지만, NodeJS와같은 JS 엔진을 통해 Front ~ Back 모든 영역에서 사용될 수 있는 언어.
>
> JAVA : 주로 큰 규모의 소프트웨어 개발에 사용. 사용자수가 압도적으로 많기 때문에, 커뮤니티에 의해 지속적으로 발전되고있는 언어(그만큼 훌륭한 구조 / 설계 기법이 많음)
>
> Ruby : 빠른 개발에 널리 사용. 단순함/세련됨(안써봐서 모르겠다..)
>
> [언어의 순위 및 트랜드 살펴보는 사이트](https://www.tiobe.com/tiobe-index/)





#### 웹의 동작(HTTP 프로토콜 이해)

1. HTTP

- HTTP는 웹 브라우저(클라이언트) / 웹 서버간에 서로 통신(데이터 주고받기)하기 위한 규약이며  서버/ 클라이언트 모델을 따른다.
- 서로 정해진 규약(프로토콜)을 통해 동일한 정보는 브라우저/서버에 상관없이 동일하게 해석되게 하는것이 HTTP의 목적이다.
- 장점과 단점
  - <u>무상태성(Stateless)</u>을 갖는 통신 규약이다.
  - 즉 Request / Response 이후에 연결(Connection)을 더이상 유지하지 않는 기술이다.
  - 따라서 클라이언트 / 서버 간 최대 연결 수보다 훨씬 <u>많은 요청 / 응답을 처리할 수가 있다.</u>
  - 하지만 연결을 유지하지 않기 때문에 <u>클라이언트의 상황/상태를 알 수 없다</u>.
  - 따라서 이러한 문제를 해결하기 위해(정보 유지를 위해) <u>Cookie / Session</u>이 도입되었다.

> Cookie 클라이언트의 정보를 유지하기 위해 클라이언트측의 저장소를 사용하는 기술.
>
> Session 동일한 목적을 위해 서버측의 저장소를 사용하는 기술.



2. URL (Uniform Resource Locator)

   - <u>인터넷 상의 자원의 위치</u>, 특정 웹서버의 특정 파일에 접근하기 위한 <u>주소</u>를 나타낸다.

3. 요청 메서드 종류 / 용도
   - GET / SELECT
   - POST / INSERT 
   - PUT / UPDATE
   - DELETE / DELETE
   - HEAD : 헤더 정보만 요청(Response결과가 header / 가벼움 / 자원 존재 여부 및 요청 정상처리 확인 용도)
   - OPTIONS : 해당 웹서버가 지원하는 메서드의 종류를 알기위해 사용
   - TRACE : 클라이언트의 요청을 그대로 반환 / 서버 상태 확인 용도

> HTTP  = hypertext transfer protocol (평문 통신이므로 도청 시 정보가 그대로 노출)
>
> HTTPS = hypertext transfer protocol over <u>secure</u> socket layer (보안이 강화된 버전 - 암호화)





#### 웹 Front-End와 웹 Back-End

1. Front - End (HTML + CSS + JS)
   - 웹 콘텐츠에 대한 시각적 구조와(HTML + CSS) , 사용자의 요청에 따라 웹 콘텐츠가 반응하여 동작하는 영역(Javascript)에 대한 프로그래밍 영역을 의미.
   - 크게 HTML (웹 콘텐츠의 구조), CSS(웹 콘텐츠의 스타일), Javascript(웹 콘텐츠의 동작)으로 나누어진다.

2. Back - End
   - 사용자에게 보여진 웹 콘텐츠를 통해 전달받은 요청정보(Select / Insert / ...)를 처리하는 부분에 대해 프로그래밍하는 영역.
   - 즉 서버로 통해 전달된 요청정보를 이용하여 , 서버 상에서 요청에 대한 결과를 생성하는 로직을 담당한다.



> 사용자가 naver 화면에 접속 시 접하는 부분은 HTML / CSS / JS 로 만들어진 View 부분이다.(Front-End) 
>
> 이때 사용자가 웹툰을 클릭하게 된다면, 사용자의 요청(웹툰 페이지 요청)을 서버에게 전송한다.  
>
> 서버에서 전달받은 웹툰 요청에 따라 서버 상에서 Java + Mysql 등의 기술을 통해 웹툰에 대한 정보를 가져온다.(Back-End)
>
> 서버쪽에서 전달받은 웹툰에 대한 정보를 HTML / CSS 문서를 통해 보여준다(Front-End)





#### browser의 동작과 웹 개발

1. browser(Chrome / Firefox / Explore)의 역할
   - 웹을 통해서 전달되는 데이터의 도착 지점은 BROWSER(Application)이다.
   - 이때 전달되는 정보(Html / Css )는 브라우저 내부의 <u>데이터 해석기(Parser : HTML 을 DOM Tree 로 구조화)</u>와 해당 데이터를 화면으로 바꿔주는 <u>렌더링 엔진</u>을 통해 화면에 표시된다.



> 우리가 작성한 코드가 브라우저상에서 좀 더 빠르게 동작하려면 어떻게 해야할까 ?

2.  HTML 문서 속에는 HTML / CSS / JS 코드가 함께 존재한다.
   - Javascript 코드 - <u>body 태그가 닫히기 직전</u> - 랜더링의 방해를 막기 위함.
   - css 코드 - head 안에 위치 - HTML 의 시각적 구조(Style)을 미리 알려 렌더링을 도우기 위함. 





#### 웹서버

클라이언트로의 HTTP Request 정보를 통해 HTML 문서 혹은 <u>각종 리소스를 전달하는 역할을 하는 소프트웨어가 동작하는 컴퓨터</u>를 의미한다.

> Apache WEB SERVER가 설치된 컴퓨터는 기본 IP 주소로 접근했을때 포트포워딩을 통해 80포트로 접근한다.(Apache가 80포트 사용)
>
> 예를들어 http://106.10.38.229 의 접근결과와 http://106.10.38.229:80 의 접근결과는 같다.
>
> 현재 가장 점유율이 높은 웹서버 소프트웨어는 Apache 이지만, Nginx의 점유율이 상승하고 있으므로 기회가 된다면, Nginx로 서버를 구축해보자. 





#### WAS

1. MiddleWare 란 ?
   - 만약 클라이언트 쪽에 비즈니스 로직이 많을 경우 (데이터베이스에 접근하여 결과를 가져오는 로직 - BE 영역), 비즈니스 로직이 변경될 경우 사용자 전체에게 재배포가 요구된다. 만약 <u>클라이언트 / DB Server 사이에서 클라이언트의 입력/출력 기능을 담당하는 소프트웨어</u>가 존재한다면, 모든 사용자에게 재배포해야하는 문제가 사라지며, 이러한 기능을 하는 것이 MiddleWare 이다.



2. WAS(Web Application Server)

   - <u>클라이언트 / 서버 사이</u>에서 웹 애플리케이션의 작동을 돕는 <u>미들웨어</u>

   - 프로그램 실행 환경과 데이터베이스 접속 기능을 제공
   - 여러 개의 트랜잭션 관리
   - 업무를 처리하는 비즈니스 로직을 수행
   - 웹 서버의 기능도 제공

3. WEB SERVER 와 WAS의 차이점

   - WEB SERVER(Apache / Nginx) 같은 경우 서버의 리소스(자원)을 있는 그대로 가져오는 역할을 한다(정적인 결과). 즉 내부 비즈니스 로직에 대한 해석 / 처리 기능이 존재하지 않다.
   - WAS(Apache Tomcat)은 기본적으로 WEB SERVER의 기능도 제공한다. 하지만 이외에 동적인 결과 (JAVA를 이용한 비즈니스 로직의 작동)에 대한 기능 또한 제공한다.

4. WEB SERVER + WAS 함께 사용하는 이유

   - 성능상의 차이는 현재, 거의 없다.
   - 대용량 웹 애플리케이션 구축의 경우 (Micro Service Architecture) 무중단 운영을 위해 장애극복(Failover) 기능이 굉장히 중요하다.
     -  WEB SERVER -> WAS(여러개) 구축 후(Micro Service Architecture) 특정 WAS에 문제가 생길 경우 하나의 WAS만 중지하여 장애 극복 후에 다시 서비스한다면, 전체 서비스가 중단되지 않는다는 이점이 존재하며, 앞부분에 WEB SERVER 를 사용한다면 톰캣 이외에도 다양한 WAS (Tomcat / WebSphere / Jeus)등과 함께 사용할 수 있다.



> DBMS : 다수의 사용자들이 데이터베이스 내의 데이터를 접근할 수 있도록 해주는 소프트웨어(DBMS를 사용하기 이전에는 File System 사용) 종류로는 RDBMS(mysql,orcle) / NoSQL(mongodb)가 존재

> Apache Tomcat은 버전별로 지원하는 Java / Servlet / JSP 스펙이 다르다. 아래 링크를 통해 확인하고 환경을 구축하자.
>
> [Tomcat 버전별 차이 알아보기 link](https://hyunjin821.tistory.com/147)



### 2. HTML -FE



**실습 환경**

- vs code(설치형)
- sublime text(설치형)
- [jsbin link](http://jsbin.com/?html,output) (웹)



#### HTML TAGS

태그는 그 의미에 맞춰서 사용해서 문서의 의미를 정확하게 표현하는 것이 중요 ( 검색 엔진의 정상작동 etc..)

태그의 종류

- 링크
- 이미지
- 목록
- 제목

> 이외 태그에 대해선 아래 링크 참조
>
> [W3Schools Tag Reference link](https://www.w3schools.com/tags/ref_byfunc.asp)



**실습코드**

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset = "utf-8">
        <meta name = "viewport" content = "width=device-width">
        <title>Jihwan</title>
    </head>
    <body>
        <div>
            <h1>Hellow Web</h1>
            웹 개발을 위한 언어.
            <ul>
                <li>HTML</li>
                <li>CSS</li>
                <li>Javascript</li>
                <li>Java</li>
            </ul>
        </div>
    </body>
</html>
```





#### HTML Layout 시멘틱 태그

layout 태그란 <u>웹 컨텐츠의 틀을 구성</u>하는 태그를 의미한다.

html 레이아웃을 <u>의미에 맞게 사용</u>하면, <u>검색</u>에 더욱 더 노출되며, <u>가독성</u> 높은 코드를 작성할 수 있다.

- header
  - 웹 문서의 헤더 영역
  - 웹 페이지에 대한 소개 / 네비게이션 영역 / 테이블 영역 / 검색 영역 / 로고 영역 등에 사용
  - 섹션 컨텐츠가 아닌 , 그룹화하기 위한 요소이므로 section 요소를 포함할 수 없음
- section
  - 문서의 콘텐츠 섹션을 의미하며, 콘텐츠와 관련된 <u>하나의 주제를 그룹화</u>하는데 사용
  - 제목이 없는 경우 섹션이라고 할 수 없으므로, <u>제목</u>을 꼭 제공
  - 일반적인 주제가 아니라면 구체적인 요소 (article / aside / nav)를 사용하는것이 더욱 적절
- nav
  - 페이지 내에서 이동할 수 있는 네비게이션 링크 그룹
  - 문서의 핵심적인 페이지 메뉴 / 서브 메뉴에 사용하며 <u>1번만 사용할 것(footer에 제발 사용 X)</u>
- footer
  - 웹 문서의 푸터 영역
  - 저작권 정보 / 회사 정보 / 관련 링크 / 바닥글 등의 컨텐츠 영역
  - section / article / aside 등을 포함 할 수 있음
- aside
  - 웹 컨텐츠의 메인 컨텐츠와 관련된 사이드 영역
  - 웹 컨텐츠와 관련된 사이드 정보 / 광고 등을 그룹화할 때 사용
- main(추가)
  - <u>웹 문서의 주요 컨텐츠 영역</u>
  - 강의에서 ```div id = "container"```  부분에 사용할 것(html5)
  - 웹 페이지에서 1번만 사용할 수 있으며, 접근성 / 검색영역에 노출을 항상 시킴
  - 이외 시멘틱 태그를 하위 요소로써 사용할 수 있음

**실습코드**

```html
<!DOCTYPE html>
<html>
    <head>
        <meta charset = "utf-8">
        <meta name = "viewport" content = "width=device-width">
        <title>Jihwan</title>
    </head>
    <body>
        <header>header</header>
        <main id="container">
            <nav>
                <ul>
                    <li>home</li>
                    <li>news</li>
                    <li>e-sports</li>
                </ul>
            </nav>
            <aside>
                <ul>
                    <li>logout</li>
                    <li>sign up</li>
                </ul>
            </aside>
        </main>
        <footer>
        	qwq713@naver.com
        </footer>
    </body>
</html>
```



> 위의 header / section / nav / footer / aside 는 html5에서 도입된 sementic tags 다. chrome 에서만 작동하며, explore 구버전 같은 경우에는 제대로 작동하지 않을 수도 있다.
>
> [참고할만한 레이아웃 link](https://gist.github.com/thomd/9220049) 링크 참고~





#### HTML 구조설계

- html structure design 구글 검색 시 여러가지 디자인 확인

- 상단 / 본문 / 네비게이션 등의 큰 부분부터 분리
- 각 영역 안의 내용의 구조 작성
- 간단한 영역을 할당할 때는 span 사용할 것



#### 실습 코드

```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>JS Bin</title>
</head>
<body>
  <header>
  <h1>Company Name</h1>
  <img src="..." alt="logo">
  </header>
  
  <div>  <!-- section태그를 사용했었지만, 별 의미없는 container에는 section태그가 적절하지 않아서 수정합니다 -->
    <nav><ul>
      <li>Home</li>
      <li>Home</li>
      <li>About</li>
      <li>Map</li>
      </ul></nav>
    
    <div>  
      <button></button>
      <div><img src="dd" alt=""></div>
      <div><img src="dd" alt=""></div>
      <div><img src="dd" alt=""></div>
      <button></button>
    </div>
    <div>
      <ul>
        <li>
          <h3>What we do</h3>
          <div>Lorem ipsum dolor sit amet, consectetur adipisicing</div>
        </li>
        <li>
          <h3>What we do</h3>
          <div>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique accusamus, corporis, dolorum fugiat tenetur porro. Aspernatur commodi, ea suscipit non? Molestiae nulla explicabo debitis provident nostrum dolorem minima reiciendis suscipit?</div>
        </li>
        <li>
          <h3>What we do</h3>
          <div>Lorem ipsum dolor sit amet, consectetur adipisicing</div>
        </li>
      </ul>
    </div>
  </div>
  <footer>
    <span>Copyright @codesquad</span>
  </footer>
</body>
</html>
```



>  참고할 것 [DIV 남용에 대한 문제점 link](https://hyplusgwequallove.tistory.com/entry/DIV-%EB%82%A8%EC%9A%A9%EA%B3%BC-%EC%9B%B9%ED%91%9C%EC%A4%80%EC%9D%98-%EB%AF%B8%EB%9E%98-1)



#### class 와 id 속성

- ID
  - <u>고유한 속성</u>으로 한 HTML 문서에 하나만 사용할 것.(header / main/ footer /nav )
  - 고유하게 부여한다면, 각 id값을 가진 요소들의 제어/검색에 용이함
- Class
  - 하나의 HTML 문서에 중복해서 사용 가능
  - 공백을 기준으로 중복 사용 가능 ```class = "cl1 cl2 cl3"```
  - 홈페이지 <u>전체적인 스타일을 일관성있게 지정</u>하게 위해 필수적으로 사용

**실습코드**

```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>JS Bin</title>
</head>
<body>
  <header>
  <h1>Company Name</h1>
  <img src="..." alt="logo">
  </header>
  
  <section id="nav-section">
    <nav><ul>
      <li>Home</li>
      <li>Home</li>
      <li>About</li>
      <li>Map</li>
      </ul>
    </nav>
    
    <section id="roll-section">
      <button></button>
      <div><img src="dd" alt=""></div>
      <div><img src="dd" alt=""></div>
      <div><img src="dd" alt=""></div>
      <button></button>
    </section>
    <section>
      <ul>
        <li class="our_descriptipn">
          <h3>What we do</h3>
          <div>Lorem ipsum dolor sit amet, consectetur adipisicing</div>
        </li>
        <li class="our_descriptipn">
          <h3>What we do</h3>
          <div>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Similique accusamus, corporis, dolorum fugiat tenetur porro. Aspernatur commodi, ea suscipit non? Molestiae nulla explicabo debitis provident nostrum dolorem minima reiciendis suscipit?</div>
        </li>
        <li class="our_descriptipn">
          <h3>What we do</h3>
          <div>Lorem ipsum dolor sit amet, consectetur adipisicing</div>
        </li>
      </ul>
    </section>
  </section>
  <footer>
    <span>Copyright @codesquad</span>
  </footer>
</body>
</html>
```



> 좋은 class 이름을 짓는 규칙에 대해 알아보자. [link](https://www.vobour.com/-css-%EB%94%94%EB%B2%84%EA%B9%85-%EC%8B%9C%EA%B0%84%EC%9D%84-%EC%A0%88%EC%95%BD-%ED%95%A0-%EC%88%98%EC%9E%88%EB%8A%94-css-%EB%AA%85%EB%AA%85-%EA%B7%9C%EC%B9%99)
>
> data 속성에 대해 알아보자.



### 3. CSS - FE



#### CSS 선언방법

1. CSS 구성

2. style 을 HTML에 적용하는 3가지 방법

   - inline (우선순위 1 )

     - html 태그 안에다가 적용
     - ```<p style="border:1px solid gray;color:red;font-size:2em;">```

   - internal ( 우선순위 2 )

     - style 태그로 분리하여 <u>head 안에 작성</u>

     - 별도의 css 파일이 필요하지 않으며, 따라서 별도의 css파일을 위해 브라우저의 요청이 필요없다. 개발 시 internal로 하면 cache 를 사용할까 ?

     - ```html
       <style>
       p  {
         font-size : 2em;
         border:1px solid gray;
         color: red;
       }
       </style>
       ```

   - external ( 우선순위 2 )

     - css를 외부파일로 지정하는 방식
     - 현업에서는 스타일을 여러개의 CSS 파일로 분리하여 합쳐서 서비스에서 사용(style.css)



> [inline / internal / external의 장/단점 link](https://www.hostinger.com/tutorials/difference-between-inline-external-and-internal-css)
>
> [external cache에 대한 link](https://stackoverflow.com/questions/25469845/is-it-more-efficient-to-have-a-external-css-stylesheet)





#### 상속과 우선순위 결정

1. CSS 상속

   - style 은 자동으로 상속이 되는 속성과 (color / font-size) 자동으로 상속이 되지 않는 속성(border / padding / margin)으로 나뉜다.
   - <u>즉 상위에서 적용된 상속이 되는 속성은 하위에서 다시 정의하지 않아도 된다</u>.( 코드 절약 )

   ```html
   <style>
       body > div {
           color : green;
           font-size : 30px;
           /* color / font-size : body > div 아래 속성까지 영향 */
               
           border : 2px solid slategray;
           padding : 30px;
           /* border / padding : body > div 아래 속성은 영향 받지 않음 */
       }
   </style>
   ```



​    

2. 선택자 우선순위 (CSS Selector)

   - CSS는 여러가지 스타일 정보를 기반으로 , <u>최종적으로 경쟁에 의해(우선순위)</u> 적절한 스타일이 반영된다.
   - Cascading (하나의 element의 하나의 속성값에 여러개의 설정에 대한 우선순위)
     - 선언방식에 따른 차이 (inline(1순위) > internal(2) > external(3))
     - 선언 위치에 따른 차이 ( 최종적으로 적용된 것)
     - <u>구체적으로</u> 표현된 것이 우선된다.(body > span 뒤에 span이 온다해도 body > span 에 적용된 속성이 우선된다.)
     - <u>class 보다 id</u> 가 더욱 더 우선순위가 높다 (class < id )
     - id : 금메달 class : 은메달 tag : 동메달로 기억하자.
     - [css specificity 에 대한 link](https://www.w3schools.com/css/css_specificity.asp) 





#### CSS Selector

1. 기본 선택자
   - id ( # )
   - class ( . )
   - tag ( span / p / a ... )
2. ,(comma) 를 기준으로 여러개 선택 가능
3. 자식을 선택할 때는 >
4. n번째 자식 요소? #list> p:nth-child(2) { color : red; }

**소스 코드**

```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>JS Bin</title>
  <style>
    #list > p:nth-child(2){
      color : red;
    }
  </style>
</head>
<body>
<div id="list">
  <h2>단락 선택</h2>
  <p>첫번째 단락입니다</p> <!-- 이 곳이 빨간색으로 바뀐다.-->
  <p>두번째 단락입니다</p>
  <p>세번째 단락입니다</p>
  <p>네번째 단락입니다</p>
</div>
</body>
</html>
```



**nth-child 와 nth-of-type 차이**

```html
<div>
    <li>List1</li>
    <p>P1</p>
    <li>List2</li>
</div>
<!--
div > li: nth-of-type(2){
	color : red; 
	// List2가 변경됨. div > li 중 2번째 요소를 가리킴

div > li: nth-child(2){
	color : red; 
	// div 속의 2번째 요소가 p라서 적용이안됨.. 2 -> 3 변경 시 List1 변경됨
}

-->
```



#### CSS 기본 Style 변경하기

1. font-size
   - 글자의 크기를 의미하며 단위로는 (px / em / rem) 등이 존재
   - em 같은 경우 상위 태그의 font-size에 영향을 받으며 기본값은 1em = 16px이다.
   - 만약 상위 div 태그의 font-size가 32px이면, 하위 태그의 1em은 32px이 된다.
2. color
   - font의 색깔을 의미하며, 검색 도구에서 color picker를 통해 rgba값을 얻을 수 있다.
3. background-color
   - 배경색을 의미
4. font-family
   - 글꼴을 의미한다.
   - font-awesome과 같은 웹 폰트를 설치하여 다양한 폰트를 사용할 수도 있다.

**실습코드**

```html
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width">
  <title>JS Bin</title>
  <style>
    body > div {
      font-size:16px;
      background-color: #ff0;
      font-family:"Gulim";
    }
    
    .my-span {
      color : #f00;
      font-size:2em; /* 상위 태그인 div의 font-size : 16px이므로 32px */
    }
  </style>
</head>
<body>
  <div>
    <span class="my-span">my text !</span>
  </div>
</body>
</html>
```





#### ★★★★★Element가 배치되는 방법 ( CSS Layout ) ★★★★★





#### float 기반 샘플 화면 레이아웃 구성





### 4. Servlet



#### 자바 웹 애플리케이션

WAS에 설치되어 동작하는 어플리케이션으로, HTML / CSS / JAVA(servlet) / ConfigFile과 같은 각종 파일이 로 구성된다.



#### Servlet 이란 ?

자바 웹 어플리케이션의 구성요소 중 동적인 처리를 담당하며, WAS에서 동작하는 Java로 이루어진 클래스이다.

필수적으로 HttpServlet 클래스를 상속받아야 하며, JSP와 함께 웹 페이지를 구현한다.(html -> jsp , programming -> servlet(java))



#### Servlet 작성 방법

- Servlet 3.0 이상
  - web.xml 미사용
  - 대신 Java Annotation 사용
- Servlegt 3.0 미만
- Servlet 등록 시 web.xml 파일에 하나씩 등록



#### Servlet 라이프 사이클

서블릿의 라이프사이클은 크게 3단계로 이루어진다.

1. Initailization (Load Resources)
2. Service (Accept Requests - request / response)
3. Destruction(Unload Resources)

WAS는 서블릿 요청을 받으면 해당 서블릿이 메모리에 존재하는지 확인하며, 미존재시 init() 메소드를 통해 서블릿 객체를 생성한다. 만약 존재한다면 init()과정을 거치지 않고 service() 메소드를 실행하여 기존의 객체를 재사용한다.

WAS가 종료되거나, 웹 애플리케이션이 새롭게 갱신될 경우 destroy()메소드를 통해 기존의 서블릿 객체를 파기한다.(메모리에서 제거)



service() 메소드의 경우 get -> doGet / post ->doPost 메소드를 사용하여 request / response 요청에 대응한다.

#### Request , Response 객체 이해하기

**요청과 응답**

WAS는 웹 브라우저로부터 Servlet요청을 받으면,

- 요청할 때 가지고 있는 정보를 HttpServletRequest객체를 생성하여 저장합니다.
- 웹 브라우저에게 응답을 보낼 때 사용하기 위하여 HttpServletResponse객체를 생성합니다.
- 생성된 HttpServletRequest, HttpServletResponse 객체를 서블릿에게 전달합니다.

**HttpServletRequest**

- http프로토콜의 request정보를 서블릿에게 전달하기 위한 목적으로 사용합니다.
- 헤더정보, 파라미터, 쿠키, URI, URL 등의 정보를 읽어 들이는 메소드를 가지고 있습니다.
- Body의 Stream을 읽어 들이는 메소드를 가지고 있습니다.

**HttpServletResponse**

- WAS는 어떤 클라이언트가 요청을 보냈는지 알고 있고, 해당 클라이언트에게 응답을 보내기 위한 HttpServleResponse객체를 생성하여 서블릿에게 전달합니다.
- 서블릿은 해당 객체를 이용하여 content type, 응답코드, 응답 메시지등을 전송합니다.



