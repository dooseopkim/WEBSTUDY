function ajax() {
    var oReq = new XMLHttpRequest();
     
   oReq.addEventListener("load", function() {
     console.log(this.responseText);
   });
     
    oReq.open("GET", "http://www.example.org/example.txt");
    oReq.send();
 }
 var json객체로변환된값 = JSON.parse("서버에서 받은 JSON 문자열");

 //**3. cross domain 문제

XHR통신은 다른 도메인 간에는 보안을 이유로 요청이 안 됩니다.

즉 A도메인에서 B도메인으로 XHR통신, Ajax 통신을 할 수 없습니다.

이를 회피하기 위해서 JSONP라는 방식이 널리 사용되고 있습니다.

최근에는 CORS라는 표준적인 방법이 제공되고 있어 이를 활용하는 경우도 등장했습니다. 

CORS를 사용하기 위해서는 프로그램 코드에서 별도로 해야 할 것이 없고, 백엔드코드에서 헤더 설정을 해야 하는 번거로움이 있습니다.

CORS와 JSONP의 적용 방법을 찾아보는 것도 좋은 방법입니다.

JSONP는 아직도 많은 곳에서 사용하는 비표준이지만 사실상 표준으로 사용하는 것으로, CORS로 가기 전에 많은 곳에서 사용 중입니다.

그 사용법을 참고로 알아보면 좋습니다. */