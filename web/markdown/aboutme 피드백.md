### 1
*Try again*

header 태그를 사용 하는 시점에서 이미 해당 태그는 특정 식별이 되어있는 상태입니다.

해당 상태에서 header클래스를 사용하는 것은 중복 작업으로 보여질수 있습니다.

html5의 semantic 태그에 대해 다시 한번 생각 해 보는 계기를 가져봐도 좋을 것 같습니다.

[HTML5 Semantic Tags w3c](https://www.w3schools.com/html/html5_semantic_elements.asp)






*Try again*

HTML5의 semantics tags 중 section article의 경우 모호한점이 있을 수 있어 처음 사용자 분들은 

혼란이 오는 경우가 있습니다. 해당 내용이 정리된 링크를 공유 드리오니 한번 학습 해 보시면 좋을 것 같습니다.

[semantics HTML guide](https://www.pluralsight.com/guides/semantic-html)




### 2

*Try again*

현재 사용되고 있는 방식은 HTML5에서는 권장 형태는 아닙니다.

해당 방식을 변형하기 위해서 HTML5의 semantic tags들이 나오게 됐는데요 

현재 표현하려고 하였던 태그들도 HTML5에 나와있기 때문에 확인 후 적용 해보는 작업을 해보면 좋을 것 같습니다.

[HTML5 Semantic Tags w3c](https://www.w3schools.com/html/html5_semantic_elements.asp)






*Try again*

HTML5 semantic 태그 중에서는 사진,그래프 같은 것을 표현하기 위한 semantic 태그와 해당 태그의 sub 태그도 있습니다.

해당 부분에 대해 학습하고 적용해보면 좋을 것 같습니다.

[w3cSchool HTML5 semantic Tags](https://www.w3schools.com/html/html5_semantic_elements.asp)





### 3
*Try again*

실제 업무에서는 파일을 나눌수 있다면 최대한 나누는게 좋습니다.

이슈가 발생하였을때 지정된 파일을 빠르게 찾아서 수정도 가능하며 협업시에도 파일이 많이 나누어져있는게 많은 도움이 됩니다.

현재는 custom.css하나로 되어있지만  기본적인  시스템에 수백 페이지를 만든다고 하였을때

custom.css 하나만 되어있는 것 과

main.css, about.css photo.css dashboard.css 와같이 나누어져있는 것에서 이슈를 수정하기 위해서도 매우 용이 하며

코드 형상관리에서도 source conflict (소스 코드 충돌) 의 문제를 예방할수도 있습니다.

작고 간단한 페이지서 부터 파일을 나눠보는 연습을 해보는 것이 좋을 것 같습니다.






*Try again*

flexBox 모델은 기존의 CSS보다 적용하기도 쉽고 사용하기 위한 접근성도 높지 않습니다. 하지만 flexBox모델은 IE최신버전인 11에서도 완벽 지원을 하고 있지 

않기 때문에 지원이 되지않는 부분에 대해서 확인 후 사용하시면 더 좋을 것 같습니다.

브라우저의 지원현황은 can i use 라는 사이트에서 확인 하실수 있습니다.

[Can i Use Site](https://caniuse.com/)   < - 

또한 css-grid 도 조사하여 적용해 보면 좋을 것 같습니다.




### 4

*Try again*

justify-content 의 경우는 flex box에서  가로 축에 대한 방향성에 대한 속성입니다.

현재 작성된 모든 페이지를 block 형태로 width 를 100%를 차지하는 형태입니다.

css의 속성을 작성하셨을 때 작성한 속성이 어떠한 기대를 가지는지에 대해서 고민해보면 더 많은 도움이 될 것 같습니다.






*Try again*

align-items 는 세로축의 정렬을 위한 속성으로 현재 페이지에 세로축의 경우는

100%인 block 요소들도 꽉차있기 때문에 적용의 유무와 페이지는 관계가 없어 보입니다.

해당 속성을 테스트해보기 위해서는 flex-directon 을 row로 준 후에

확인해보면 해당 속성에 사용성을 확실히 파악이 가능할 것으로 보입니다.

관련된 설명이 잘되어있는 사이트 링크 드리도록 하겠습니다. 

[flexBoxModel Guide](https://css-tricks.com/snippets/css/a-guide-to-flexbox/)




### 5

*Try again*

현재 css 코드를 전체적으로 훑어 보았을때 border-box를 이용하는 태그들이 많이 있습니다. 

기본 Default값으로는 content-box가 들어가는데 현재 페이지에서는 없는 것으로 보입니다. 이런 경우에 대해서는

여러 태그들에 대해서 같은 속성 (중복되는 속성)이 있을 경우 매 태그마다 직접 지정해주지 않고 한번에 지정 하여서 사용하는 방식이 있습니다.

이와 관련되어서 normalize.css 에 대해 조사하고 적용해 보면 좋을 것 같습니다. 추가적으로 reset.css도 확인해보면 좋겠습니다.






*Try again*

h2태그와 p태그를 개발자 속성으로 확인해볼시 ( Ctrl + Shift + C 입력시 개발자 도구창이 켜지면서 요소를 선택할수 있게 됩니다. h2태그와 p2태그를 번갈아가면서

margin (주황색으로 표시) 을 확인해보세요! ) - Chrome

주황색으로 표시되는 부분을 확인해 보면 해당 2개의 태그는 현재 css에서는 지정하지 않았지만 기본적으로 내재되어있는 margin 이 존재합니다. 

그런데 자세히보시면 margin 이 존재하지만 존재 하는 부분에 대해서 margin 이 정상적으로 나타나지 않음을 확인 하실수 있습니다. 

이 현상을 margin collapsing  현상이라고 하는데요 해당 현상은 수직 방향에 대해서만 발생하게 됩니다.  해당 내용에 대해 학습 해보시기 바랍니다.

[margin collapsing - MDN](https://developer.mozilla.org/ko/docs/Web/CSS/CSS_Box_Model/Mastering_margin_collapsing)

[w3c margin collasping](https://www.w3.org/TR/CSS22/box.html#collapsing-margins) - W3C





