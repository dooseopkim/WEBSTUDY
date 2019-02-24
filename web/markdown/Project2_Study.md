# DB 연결 웹 앱



## Javascript

1. 타입은 선언할 때가 아닌, 실행 타임에 결정된다.
2. || 연산자의 유용한 사용(if 문을 감소시켜 코드의 양을 줄일 수 있다)
3. var /  const /  let (const / let은 중복변수명에 오류를 발생시킴)
4. 비교연산자 == vs ===(타입까지)
5. 다양한 타입(undefined / null / boolean / number / string /object / function / array / Date / RegExp)
6. typeof / toString.call()
   - 객체 타입 / 객체 타입 + 인스턴스 정보
7. length의 성능차이

~~~javascript
const arr = [1,2,3,4,5]
for(let i =0, let len = arr.length; i<len; i++){
  console.log(i);
}
~~~

8. "abc".split("") 의 결과 ["a","b","c"]

9. 함수 선언식과 함수 표현식

   ~~~javascript
   function test(){
     return "test";
   }
   var test = function(){
     return "test";
   }
   // 둘은 다르다. 선언식은 표현 위치에 상관없이 호출이 가능하지만(호이스팅) , 표현식은 표현 위치에 따라 호출할 수 있는 범위가 제한적이다.
   // 따라서 표현식을 더 권장하자.
   ~~~

   ​

10. 호이스팅 (javascript 명령행 실행 전에 function을 탐색하여 메모리에 미리 띄우는것. 함수 표현식을 사용하여 피하자)

11. 기본 반환값 (undefined) : 즉 void 반환형식이 없다

12. 함수 속의 특별한 지역변수 arguments (input parameter를 배열로써 표현한 것)

13. arrow function(템플릿 디자인 패턴일겁니다.)

```javascript
function getName(name){
  return "my name is " + name;
}
const getName = (name) => ("my name is" + name);
```

14. javascript call stack
15. Debugger / break point
16. js 에서 window 객체 (전역 , 디폴트라 생략 가능)

~~~javascript
window.alert("abc");
alert("abc"); // 같다

~~~

17. 동기 / 비동기(스택이 다 비워지고나서 실행된다. 원래의 흐름과 약간 다름)

~~~javascript
window.setTimeout(function(){console.log("hi")},1000);
~~~

18. window.setInterval()
19. DOM Tree(Document Object Model)

HTML 도 하나의 Object 이며 Tree 구조로 이루어져 있다.(변경시 특정 요소를 찾는데 용이한 구조)

18. DOM API / querySelector(css Selector)

```javascript
//DOM의 최상위 객체는 document 이며 , 해당 객체를 이용하여 여러가지 행동을 할 수 있다..
document.getElementById("jihwan");
document.getElementByName("jihwan");
document.body.querySelector();..
//Element.querySelector(); 
// id = # 
// class  = .
// tag 
```



19. event : 브라우저에서 일어나는 모든 일 (클릭, 무브 , .. etc)
20. addEventListener : 이벤트를 감지하는 역할을 하며, 이를 이용해서 해당 이벤트때 작성할 동작을 프로그래밍 할 수 있음
21. addEventListener 속의 function 속의 매개변수 e : 해당 이벤트!(핵중요할듯)

~~~javascript
var el = document.querySelector(".big-btn");
// el.onclick() 을 쓰기보다는 addEventListener 사용을 권장
el.addEventListener("click",function(event){
  let target = event.target;
  let nodeName = event.nodeName;
  //이외에도 해당 event에 대한 수많은 속성이 있음
});
~~~

22. https://developer.mozilla.org/en-US/docs/Web/Events
23. ajax / 비동기
24. XMLHttpRequest() 객체 이용.

~~~javascript
function ajax(data){
  var ajaxReq = new XMLHttpRequest();
  ajaxReq.addEventListener("load",function(){
    console.log(this.responseText);
  });
ajaxReq.open("GET"," ?data =data");
  ajaxReq.send();
}

~~~

25. CORS https://developer.mozilla.org/ko/docs/Web/HTTP/Access_control_CORS
26. Pause, Continue : 첫 번째 버튼은 평소에는 Pause 버튼 상태인데 브렉포인트가 잡힌 상태에선 Continue 버튼이 됩니다. 다른 브레이크포인트가 잡힐 때까지 코드를 진행합니다.
27. Step over next function call : 스텝 오버는 코드 라인을 한 스탭 진행하는데 현재 실행 라인에 함수 실행 코드가 있다면 함수는 실행하는데 이때 함수 안의 코드로는 진입하지 않습니다. 즉 라인의 함수를 실행만 하게 됩니다.
28. Step into next function call : 스텝 인투는 스텝 오버와 다르게 현재 실행 라인의 코드에 함수가 있다면 함수 안의 첫 번째 코드로 진입해 들어가 다시 하나씩 라인별로 코드를 실행할 수 있습니다.
29. Step out of current function : 스텝 인투로 들어온 함수를 끝까지 실행하고 밖으로 빠져나와 해당 함수를 실행한 함수로 돌아갑니다.
30. **Active/Deactive breakpoint** : 브레이크포인트를 끄거나 켤 수 있습니다.
31. Pause on exception : 자바스크립트 예외가 발생하면 해당 위치에 브레이크포인트를 **잡아줍니다**.





## Servlet / Jsp

1. JSP 는 Servlet에서  java 코드 내부에 html코드를 사용하는 불편함을 제거해주는 기술이며, 항상 Servlet으로 바뀌어서 동작한다. 

2. ```Jsp
   <%%>
   <%! %> <!-- 선언식 -->
   ```

3. jsp는 항상 servlet으로 최초 요청 시 컴파일되어 사용되며, 컴파일된 파일이 존재한다면 service 메소드만을 호출한다. 또한 jsp가 수정될 경우 재컴파일 될 때 destroy() 메소드를 통해 기존의 jsp의 생명 주기가 끝난다.

4. 변환된 파일은 .metadata 속의 catalina 를 통해 확인할 수 있다.

5. 선언식 , 스크립트릿, 표현식

6. 내장 객체의 종류 response, request, application, session, out

7. **리다이렉트 (redirect)**

   - 리다이렉트는 HTTP프로토콜로 정해진 규칙이다.
   - 서버는 클라이언트의 요청에 대해 특정 URL로 이동을 요청할 수 있다. 이를 리다이렉트라고 한다.
   - 서버는 클라이언트에게 HTTP 상태코드 **302**로 응답하는데 이때 헤더 내 Location 값에 이동할 URL 을 추가한다. 클라이언트는 리다이렉션 응답을 받게 되면 헤더(Location)에 포함된 URL로 재요청을 보내게 된다. 이때 브라우저의 주소창은 새 URL로 바뀌게 된다..
   - 클라이언트는 서버로부터 받은 상태 값이 302이면 Location헤더값으로 재요청을 보내게 된다. 이때 브라우저의 주소창은 전송받은 URL로 바뀌게 된다.
   - 서블릿이나 JSP는 리다이렉트하기 위해 HttpServletResponse 클래스의 sendRedirect() 메소드를 사용한다.

   **브라우저에서 리다이렉트 확인**

   - 크롬에서 우측버튼을 누르고 검사를 선택한 후 Network탭을 선택한다.
   - redirect01.jsp를 실행하면 서버로부터 응답코드로 302를 받는 것을 알 수 있다.

8. 리다이렉트 할때마다 요청 / 응답 객체가 계속해서 생성된다.(다른 객체)

9. WAS의 서블릿이나 JSP가 요청을 받은 후 그 요청을 처리하다가, 추가적인 처리를 같은 웹 어플리케이션안에 포함된 다른 서블릿이나 JSP에게 위임하는 경우가 있습니다.

   이렇게 위임하는 것을 포워드(forward)라고 합니다.

10. RequestDispatcher

11. forward()

12. redirect는 req/res 개수가 계속해서 늘어난다.(url 바뀜) 

13. forward는 req/res 개수가 1개이다.(위임)

14. 웹 브라우저에서 Servlet1에게 요청을 보냄

15. Servlet1은 요청을 처리한 후, 그 결과를 HttpServletRequest에 저장

16. Servlet1은 결과가 저장된 HttpServletRequest와 응답을 위한 HttpServletResponse를 같은 웹 어플리케이션 안에 있는 Servlet2에게 전송(forward)

17. Servlet2는 Servlet1으로 부터 받은 HttpServletRequest와 HttpServletResponse를 이용하여 요청을 처리한 후 웹 브라우저에게 결과를 전송

18. 로직은 servlet 결과는 jsp 가 유리!! servlet -> jsp (forwarding)

19. forward와 관련있는건 response 객체 -> getRequestDispatcher

20. RequestDispatcher rd = request.getRequestDispatcher

21. JSP 에서는 자바 코드를 최대한 줄이는 것이 좋다!! -> (서블릿)자바로 바뀌는 부담을 줄여줄 수 있드아~

22. 객체지향에서 객체는 관련된 것들을 모아서 가지고 있는 특징이 있습니다. 웹 페이지 URL도 관련된 URL이 있습니다. 예를 들어, 게시판 글쓰기, 읽기, 목록 보기 등은 모두 게시판과 관련된 URL일 것입니다. 하지만 지금까지의 예제들을 보면 서블릿은 하나의 URL만 처리하고 있습니다. 하나의 서블릿이 여러 개의 요청을 받을 수는 없을까요?
    (힌트 : 서블릿 URL mapping에서 와일드카드('*'기호)를 사용하는 방법에 대해서 조사해보세요.) 

23. Application : 웹 어플리케이션이 시작되고 종료될 때까지 변수가 유지되는 경우 사용

24. Session : 웹 브라우저 별로 변수가 관리되는 경우 사용

25. Request : http요청을 WAS가 받아서 웹 브라우저에게 응답할 때까지 변수가 유지되는 경우 사용

26. Page : 페이지 내에서 지역변수처럼 사용

27. PageScope 와 Forword 생명주기 차이

28. PageContext 추상 클래스를 사용한다.

29. JSP 페이지에서 pageContext라는 내장 객체로 사용 가능 하다.

30. forward가 될 경우 해당 Page scope에 지정된 변수는 사용할 수 없다.

31. 사용방법은 Application scope나 Session scope, request scope와 같다.

32. 마치 지역변수처럼 사용된다는 것이 다른 Scope들과 다릅니다.

33. jsp에서 pageScope에 값을 저장한 후 해당 값을 EL표기법 등에서 사용할 때 사용됩니다.

34. 지역 변수처럼 해당 jsp나 서블릿이 실행되는 동안에만 정보를 유지하고자 할 때 사용됩니다.

35. http 요청을 WAS가 받아서 웹 브라우저에게 응답할 때까지 변수값을 유지하고자 할 경우 사용한다.

36. HttpServletRequest 객체를 사용한다.

37. JSP에서는 request 내장 변수를 사용한다.

38. 서블릿에서는 HttpServletRequest 객체를 사용한다.

39. 값을 저장할 때는 request 객체의 setAttribute()메소드를 사용한다.

40. 값을 읽어 들일 때는 request 객체의 getAttribute()메소드를 사용한다.

41. forward 시 값을 유지하고자 사용한다.

42. 앞에서 forward에 대하여 배울 때 forward 하기 전에 request 객체의 setAttribute() 메소드로 값을 설정한 후, 서블릿이나 jsp에게 결과를 전달하여 값을 출력하도록 하였는데 이렇게 포워드 되는 동안 값이 유지되는 것이 Request scope를 이용했다고 합니다.

43. 웹 브라우저별로 변수를 관리하고자 할 경우 사용한다.

44. 웹 브라우저간의 탭 간에는 세션정보가 공유되기 때문에, 각각의 탭에서는 같은 세션정보를 사용할 수 있다.

45. HttpSession 인터페이스를 구현한 객체를 사용한다.

46. JSP에서는 session 내장 변수를 사용한다.

47. 서블릿에서는 HttpServletRequest의 getSession()메소드를 이용하여 session 객체를 얻는다.

48. 값을 저장할 때는 session 객체의 setAttribute()메소드를 사용한다.

49. 값을 읽어 들일 때는 session 객체의 getAttribute()메소드를 사용한다.

50. 장바구니처럼 사용자별로 유지가 되어야 할 정보가 있을 때 사용한다.

51. 웹 어플리케이션이 시작되고 종료될 때까지 변수를 사용할 수 있다.

52. ServletContext 인터페이스를 구현한 객체를 사용한다.

53. jsp에서는 application 내장 객체를 이용한다.

54. 서블릿의 경우는 getServletContext()메소드를 이용하여 application객체를 이용한다.

55. 웹 어플리케이션 하나당 하나의 application객체가 사용된다.

56. 값을 저장할 때는 application객체의 setAttribute()메소드를 사용한다.

57. 값을 읽어 들일 때는 application객체의 getAttribute()메소드를 사용한다.

58. 모든 클라이언트가 공통으로 사용해야 할 값들이 있을 때 사용한다.

59. ServletContext / getServletContext (Application Scope)

60. ServletContext 는 모든 객체가 공유한다.

61. jsp에서 표현식을 이용해 값을 출력할 때 변수의 값이 null이면 화면에 null이 출력되었습니다.

    이 경우 null인지를 check한 후 null이면 아무것도 없는 문자열을 출력해야 하는 등 불편한 과정을 거쳐야 합니다.

    EL을 사용하면 좀 더 편리하게 변수를 JSP에서 사용할 수 있습니다.

    그럼 EL에 대해 알아보도록 하겠습니다.

62. 표현 언어(Expression Language)는 값을 표현하는 데 사용되는 스크립트 언어로서 JSP의 기본 문법을 보완하는 역할을 한다.

63. JSP의 스코프(scope)에 맞는 속성 사용

64. 집합 객체에 대한 접근 방법 제공

65. 수치 연산, 관계 연산, 논리 연산자 제공

66. **자바 클래스 메소드 호출** 기능 제공

67. **표현언어만의 기본 객체** 제공

68. ​


 