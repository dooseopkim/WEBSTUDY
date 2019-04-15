## Spring FrameWork
- 엔터프라이즈급 어플리케이션을 구축할 수 있는 가벼운 솔루션이자, 원스-스탑-숍(One-Stop-Shop)
- 원하는 부분만 가져다 사용할 수 있도록 모듈화가 잘 되어 있습니다.
- IoC 컨테이너입니다.
- 선언적으로 트랜잭션을 관리할 수 있습니다.
- 완전한 기능을 갖춘 MVC Framework를 제공합니다.
- AOP 지원합니다.
- 스프링은 도메인 논리 코드와 쉽게 분리될 수 있는 구조로 되어 있습니다.

### AOP 와 인스트루멘테이션 (Instrumentation)

- spring-AOP : AOP 얼라이언스(Alliance)와 호환되는 방법으로 AOP를 지원합니다.
- spring-aspects : AspectJ와의 통합을 제공합니다.
- spring-instrument : 인스트루멘테이션을 지원하는 클래스와 특정 WAS에서 사용하는 클래스로 더 구현체를 제공합니다. 참고로 BCI(Byte Code Instrumentations)은 런타임이나 로드(Load) 때 클래스의 바이트 코드에 변경을 가하는 방법을 말합니다.
 

### 메시징(Messaging)

- spring-messaging : 스프링 프레임워크 4는 메시지 기반 어플리케이션을 작성할 수 있는 - Message, MessageChannel, MessageHandler 등을 제공합니다. 또한, 해당 모듈에는 메소드에 메시지를 맵핑하기 위한 어노테이션도 포함되어 있으며, Spring MVC 어노테이션과 유사합니다.
 

### 데이터 엑서스(Data Access) / 통합(Integration)

- 데이터 엑세스/통합 계층은 JDBC, ORM, OXM, JMS 및 트랜잭션 모듈로 구성되어 있다.
- spring-jdbc : 자바 JDBC프로그래밍을 쉽게 할 수 있도록 기능을 제공합니다.
- spring-tx : 선언적 트랜잭션 관리를 할 수 있는 기능을 제공합니다.
- spring-orm : JPA, JDO및 Hibernate를 포함한 ORM API를 위한 통합 레이어를 제공합니다.
- spring-oxm : JAXB, Castor, XMLBeans, JiBX 및 XStream과 같은 Object/XML 맵핑을 지원합니다.
- spring-jms : 메시지 생성(producing) 및 사용(consuming)을 위한 기능을 제공, - Spring Framework 4.1부터 spring-messaging모듈과의 통합을 제공합니다.
 

### 웹(Web)

- 웹 계층은 spring-web, spring-webmvc, spring-websocket,  spring-webmvc-portlet 모듈로 구성됩니다.
- spring-web : 멀티 파트 파일 업로드, 서블릿 리스너 등 웹 지향 통합 기능을 제공한다. - HTTP클라이언트와 Spring의 원격 지원을 위한 웹 관련 부분을 제공합니다.
- spring-webmvc : Web-Servlet 모듈이라고도 불리며, Spring MVC 및 REST 웹 서비스 구현을 포함합니다.
- spring-websocket : 웹 소켓을 지원합니다.
- spring-webmvc-portlet : 포틀릿 환경에서 사용할 MVC 구현을 제공합니다.

### 컨테이너(Container)

컨테이너는 인스턴스의 **생명주기**를 관리하며, 생성된 인스턴스에게 추가적인 기능을 제공합니다.

예를 들어, **Servlet을 실행해주는 WAS는 Servlet 컨테이너를 가지고 있다**고 말합니다.

WAS는 웹 브라우저로부터 서블릿 URL에 해당하는 요청을 받으면, 서블릿을 메모리에 올린 후 실행합니다.

개발자가 서블릿 클래스를 작성했지만, **실제로 메모리에 올리고 실행하는 것은 WAS가 가지고 있는 Servlet 컨테이너입**니다.

Servlet컨테이너는 동일한 서블릿에 해당하는 요청을 받으면, 또 메모리에 올리지 않고 기존에 메모리에 올라간 서블릿을 실행하여 그 결과를 웹 브라우저에게 전달합니다.(Singleton)

**컨테이너는 보통 인스턴스의 생명주기를 관리**하며, 생성된 인스턴스들에게 추가적인 기능을 제공하는 것을 말합니다.



### IoC(Inversion of Control) 

컨테이너가 코드 대신 오브젝트의 제어권을 갖고 있어 IoC(제어의 역전)이라 합니다.

예를 들어, 서블릿 클래스는 개발자가 만들지만, 그 서블릿의 메소드를 알맞게 호출하는 것은 WAS입니다.

이렇게 **개발자가 만든 어떤 클래스나 메소드를 다른 프로그램이 대신 실행해주는 것을 제어의 역전이**라고 합니다.

 

### DI(Dependency Injection)

DI는 의존성 주입이란 뜻을 가지고 있으며, **클래스 사이의 의존 관계를 빈(Bean) 설정 정보를 바탕으로 컨테이너가 자동으로 연결**해주는 것을 말합니다.

### Spring에서 제공하는 IoC/DI 컨테이너

- BeanFactory : IoC/DI에 대한 기본 기능을 가지고 있습니다.
- ApplicationContext : BeanFactory의 모든 기능을 포함하며, 일반적으로 BeanFactory보다 추천됩니다. 트랜잭션처리, AOP등에 대한 처리를 할 수 있습니다. BeanPostProcessor, BeanFactoryPostProcessor등을 자동으로 등록하고, 국제화 처리, 어플리케이션 이벤트 등을 처리할 수 있습니다.
- BeanPostProcessor : 컨테이너의 기본로직을 오버라이딩하여 인스턴스화 와 의존성 처리 로직 등을 개발자가 원하는 대로 구현 할 수 있도록 합니다.
- BeanFactoryPostProcessor : 설정된 메타 데이터를 커스터마이징 할 수 있습니다.

### Bean class란?

예전에는 Visual 한 컴포넌트를 Bean이라고 불렀지만, 근래 들어서는 일반적인 Java클래스를 Bean클래스라고 보통 말합니다.

Bean클래스의 3가지 특징은 다음과 같습니다.
- 기본생성자를 가지고 있습니다.(ex :public UserBean(){super();})
- 필드는 private하게 선언합니다.
- getter, setter 메소드를 가집니다.
- getName() setName() 메소드를 name 프로퍼티(property)라고 합니다. (용어 중요)

#### maven에 spring 등록하기

```xml
<!-- Spring -->
	<dependency>
		<groupId>org.springframework</groupId>
		<artifactId>spring-context</artifactId>
		<version>${spring.version}</version>
	</dependency>
```
#### applicationContext.xml
java bean class 자원의 생명(생성/파괴)를 springContainer에게 일임(IoC)
```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="userBean" class="kr.or.connect.diexam01.UserBean"></bean>

</beans>
```

#### SpringContainer 호출
applicationContext.xml의 설정정보를 바탕으로 생성된 springContainer를 사용하기 위해서 ApplicationContext <- ClassPathXmlApplicationContext 를 사용한다.
등록된 java Beans자원을 getBean을 통해 사용할 수 있다.
```java
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class ApplicationContextExam01 {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext( 
				"classpath:applicationContext.xml"); 
		System.out.println("초기화 완료.");

		UserBean userBean = (UserBean)ac.getBean("userBean");
		userBean.setName("kim");
		System.out.println(userBean.getName());

		UserBean userBean2 = (UserBean)ac.getBean("userBean");
		if(userBean == userBean2) {
			System.out.println("같은 인스턴스이다.");
		}

	}
}
```

#### Dependancy InJection(의존성 주입)
Car Class의 engine 변수는 Engine인스턴스를 사용한다.
스프링 컨테이너 설정파일에 인스턴스간의 관계를 등록하여 의존성(객체)이 모두 주입된 객체를 바로 사용할 수 있다.

```xml
<bean id="e" class="kr.or.connect.diexam01.Engine"></bean>
<bean id="car" class="kr.or.connect.diexam01.Car">
	<property name="engine" ref="e"></property>
</bean>
```
위 코드는 아래의 자바 코드와 같은 역할을 한다.
```java
Engine e = new Engine();
Car c = new Car();
c.setEngine( e );
```

## 생각해보기

Spring컨테이너가 관리하는 객체를 빈(Bean)이라고 말합니다. (여러분들이 직접 new연산자로 생성해서 사용하는 객체는 빈(Bean)이라고 말하지 않습니다.) Spring은 빈을 생성할 때 기본적으로 싱글톤(Singleton)객체로 생성합니다. 싱글톤이란 메모리에 하나만 생성한다는 것입니다. 메모리에 하나만 생성되었을 경우, 해당 객체를 동시에 이용한다면 어떤 문제가 발생할 수 있을까요? 이런 문제를 해결하려면 어떻게 해야할까요?   ( 참고로 Spring에서 빈을 생성할 때 스코프(scope)를 줄 수 있습니다. 스코프를 줌으로써 기본으로 설정된 싱글톤 외에도 다른 방법으로 객체를 생성할 수 있습니다. )

### Java config를 이용한 설정을 위한 어노테이션

#### @Configuration
스프링 설정 클래스를 선언하는 어노테이션

#### @Bean
bean을 정의하는 어노테이션

#### ApplicationConfig(@Configuration + @Bean)
```java
@Configuration
public class ApplicationConfig {
	@Bean
	public Car car(Engine e) {
		Car c = new Car();
		c.setEngine(e);
		return c;
	}
	
	@Bean
	public Engine engine() {
		return new Engine();
	}
}
```

#### @ComponentScan
@Controller, @Service, @Repository, @Component 어노테이션이 붙은 클래스를 찾아 컨테이너에 등록

#### @Component
컴포넌트 스캔의 대상이 되는 애노테이션 중 하나로써 주로 유틸, 기타 지원 클래스에 붙이는 어노테이션

#### @Autowired
주입 대상이되는 bean을 컨테이너에 찾아 주입하는 어노테이션

```java
package kr.or.connect.diexam01;

import org.springframework.stereotype.Component;

@Component
public class Engine {
	public Engine() {
		System.out.println("Engine 생성자");
	}
	
	public void exec() {
		System.out.println("엔진이 동작합니다.");
	}
}
```

```java
package kr.or.connect.diexam01;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
	@Autowired
	private Engine v8;
	
	public Car() {
		System.out.println("Car 생성자");
	}
	
	public void run() {
		System.out.println("엔진을 이용하여 달립니다.");
		v8.exec();
	}
}
```

#### ApplicationConfig (@ComponentScan + @Component)

```java
package kr.or.connect.diexam01;
import org.springframework.context.annotation.*;

@Configuration
@ComponentScan("kr.or.connect.diexam01")
public class ApplicationConfig {
}
```
ApplicationConfig에 @ComponentScan의 조건에 맞는 클래스 중 @Component 애노테이션이 등록된 Class들을 자동으로 Bean으로 등록함.
이제 ApplicationConfig는 이전에 사용했던 applicationContext.xml을 대체함.


```java
package kr.or.connect.diexam01;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextExam {

	public static void main(String[] args) {
        ApplicationContext ac = new AnnotationConfigApplicationContext(ApplicationConfig.class);
        //Config 정보가 주입된 클래스를 바탕으로 ApplicationContext(스프링 컨테이너)를 생성함.

		Car car = ac.getBean(Car.class);
		car.run();

	}
}
```