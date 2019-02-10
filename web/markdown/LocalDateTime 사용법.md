### LocalDateTime + DateTimeFormatter

java 1.8 부터 사용가능한 ```LocalDateTime``` 과 ```DateTimeFormatter```를 함께 사용한다면

```LocalDateTime``` 을 프로그래머가 원하는 형식으로 출력할 수 있다. (YEAR / MONTH / DAY 각각을 추출할 필요가 없다.)



#### 예제

```java
class LocalDateTimeEx{
  public static void main(String[] args){
  /*
  * DateTimeFormatter + LocalDateTime -> format customize
  * yyyy : year
  * MM : Month
  * dd : day
  * HH : hour
  * mm : minutes
  * ss : second
  *
  * */
    DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm");
    LocalDateTime localDateTime = LocalDateTime.now();
    String formattedDateTime = localDateTime.format(dateTimeFormatter);
  	System.out.println(LocalDateTime.now().toString());
  }
}
```
