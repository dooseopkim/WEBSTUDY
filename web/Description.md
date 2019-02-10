## WEB BoostCourse



### PROJECT LIST

1. ABOUT-ME
2. TODO-LIST
3. NAVER-RESERVATION-SYSTEM







### Project1_AboutMe

#### BackEnd

LocalDateTime

```java
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class dateTimeTest {
    public static void main(String[] args) {

        /*
        *
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







