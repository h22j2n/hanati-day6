# 하나금융티아이 20180823

## 표준 API(클래스 라이브러리)

- String은 연산을 가할수록 복사되서 증가됨
- "A" + "B" + "C" => 이렇게 하면 A 가 만들어지고 A B 가 만들어지고 A B C 이렇게 3개가 만들어져서 비효율 적이다.

``` java
 String str = “Java”; // 코드는 아래의 코드와 같다
 char[] data = {‘J’, ‘a’, ‘v’, ‘a’};
 String str = new String(data);
// 배열을 넣어서 초기화 할 수 있다.
```

- 메모리 heap영역에는 String만 관리하는 pool영역이 따로 있다.
- 명시적으로 생성( String str1 = new String("Java Programming");  )하면 .equls() 연산자 써야한다.
- 묵시적으로 생성( String str3 = "Java Programming"; ) 하면 String pool에 생성!
  - String str4 = "Java Programming"; 이렇게 또 생성하면 String Pool에서 생성되있는지 확인하고 있으면 같은 주소 참조!
- String은 묵시적으로 쓰자!

``` java

public class StringExample {
	public static void main(String[] args) {
		//명시적 생성
		String str1 = new String("Java Programming");
		String str2 = new String("Java Programming");
		// 레퍼런스 비교
		if(str1 == str2){
		     System.out.println("레퍼런스 같다.");
		}else{
		     System.out.println("레퍼런스 다르다.");
		}
		
		
		//묵시적 생성(String Pool에서 관리)
		String str3 = "Java Programming";
		String str4 = "Java Programming";
		// 레퍼런스 비교
		// 문자열 상수를 이용한 생성시 StringPool에서
		// 검색 후 존재하지 않을 경우 새로 생성
		if(str3 == str4){
		     System.out.println("레퍼런스 같다.");
		}else{
		     System.out.println("레퍼런스 다르다.");
		}
		System.out.println(str1 == str3);
		System.out.println(str1.equals(str3));

	}
}
```

![1534984905258](C:\Users\kosta\AppData\Local\Temp\1534984905258.png)

- 생성된 String 인스턴스는 변경할 수 없다 => 자체적으로 변경되는게 아니라 계속 추가되는 것!

  ``` java
  public static void main(String[] args) {
       String str = "Java Programming";
       str = str + “최고예요”+ “뻥이예요…”;
       System.out.println(str); 
  }
  ```

- String substring(int beginIndex)  : beginIndex로 주어진 위치부터 문자열의 마지막까지의 문자열을 반환한다.

  ``` java
  String message = "Java Programming";
  System.out.println(message.substring(5));
  //Programming 출력
  
  //substring(int beginIndex, int endIndex)
  System.out.println(message.substring(5, 7));
  //Pr 출력
  ```

- String concat(String str) : 인자로 주어진 문자열을 합친 새로운 String 객체를 반환한다(+ 연산자와 동일한 기능).

  ``` java
  System.out.println("조희진".concat("박보검"));
  //조희진박보검 출력
  ```

- String replace(char oldChar, char newChar) :  기존의 oldChar로 표시된 모든 문자들을 newChar로 표시된 문자로 모두 바꾸어준다.

  ``` java
  System.out.println("JavaJava".replace('J', 'K'));
  //KavaKava 출력
  
  System.out.println("JavaJava".replaceAll("Java", "조희진"));
  //조희진조희진 출력
  ```

- char charAt(int index) : index로 지정된 곳의 문자값을 반환한다. 

- int indexOf(int ch) : 주어진 문자가 존재하는 위치를 알려준다. 존재하지 않으면 -1을 되돌린다. 

  ``` java
  		String ssn = "950204-1234567";
  		char c = ssn.charAt(ssn.indexOf('-') + 1);
  		switch (c) {
  		case '1': System.out.println("2000년 이전 출생 남자"); break;
  		case '2': System.out.println("2000년 이전 출생 여자"); break;
  		case '3': System.out.println("2000년 이후 출생 남자"); break;
  		case '4': System.out.println("2000년 이후 출생 여자"); break;
  		default : System.out.println("외국인");
  		
  ```

- String trim( )  : 공백 제거

  ``` java
  		System.out.println("        Java          ".trim());
  ```

- static String valueOf(Object obj) : 주어진 객체나 기본 데이터형을 문자열로 형변환 하여 반환한다. 

  ``` java
  		int num = 10034343;
  		String.valueOf(num);
  ```

- shift + F2 => 함수 설명

- StringBuffer : 묵시적 생성 안됨

  ``` java
  public class StringBufferExample {
  
  	public static void main(String[] args) {
  	     StringBuffer sb = new StringBuffer();
  	     sb.append("Java");
  	     System.out.println(sb.toString());
          //Java
          
  	     sb.append("Programming");
  	     System.out.println(sb.toString());
          //JavaProgramming
          
  	     sb.replace(0, 4, "C++");
  	     System.out.println(sb);
          //C++Programming
          
  	     sb.reverse();
  	     System.out.println(sb);
          //gnimmargorP++C
          
  	     String str = sb.substring(11);
  	     System.out.println(str);
          //++C
          
  	     StringBuffer sb2 = new StringBuffer("김기정");
  	     sb2.append("바보").append("aaa").append("bbb");
  	     System.out.println(sb2);
          //김기정바보aaabbb
  	}
  
  }
  ```

- StringTokenizer(String str, String delimeters)

  - str: 파싱 문자열,  delimeters: “  ”(공백문자)

    str: 파싱 문자열,  delimeters: 토큰분리자

  ``` java
  import java.util.StringTokenizer;
  
  public class StringTokenizerExample {
  	public static void main(String[] args) {
  		String date = "2018-08-23";
  		//년 월 일 분리시키고 싶음
  		
  		StringTokenizer str = new StringTokenizer(date, "-");
  		System.out.println(str.countTokens());
  		//3출력
  		
  		//hasMoreTokens() : True / False 로 반환
  		while(str.hasMoreTokens()) {
  			String token = str.nextToken();
  			System.out.println(token);
  			//2018
  			//08
  			//23 출력
  		}
  
  		
  
  	}
  }
  ```

- Character

  ``` java
  public class WrapperClassExample {
  	public static void main(String[] args) {
  		char c = 'A';
  		Character obj = new Character(c);
  		char c2 = obj.charValue();
  
  		
  		char[] data = {'A', 'a', '4',' ', '#'};
  		for (int i = 0; i < data.length; i++) {
  		if(Character.isUpperCase(data[i])){
  			System.out.println(data[i] + "은 대문자이다.");
  		}else if(Character.isLowerCase(data[i])){
  			System.out.println(data[i] + "은 소문자이다.");
  		}else if(Character.isDigit(data[i])){
  			System.out.println(data[i] + "은 숫자이다.");
  		}else if(Character.isSpaceChar(data[i])){
  			System.out.println(data[i] + "은 공백문자이다.");
  		}
  		     }
  		}
  
  
  }
  //A은 대문자이다.
  //a은 소문자이다.
  //4은 숫자이다.
  // 은 공백문자이다. 출력됨
  ```

- Integer 클래스

  - public static int parseInt (String str, int radix) : str 로 지정된 문자열에 해당되는 int 값을 radix 로 지정된 진법으로 변환하여 반환

  ``` java
  Integer integer1 = new Integer(10);
  Integer integer2 = new Integer("10");
  int i1 = integer1.intValue();
  int i2 = integer2.intValue();
  System.out.println("두수의 합: " + (i1+i2));
  //두수의 합: 20
  
  String str = "3578";
  int i3 = Integer.parseInt(str);
  
  System.out.println("10진수를 2진수로:"+Integer.toBinaryString(i3));
  //10진수를 2진수로:110111111010
  System.out.println("10진수를 8진수로:"+Integer.toOctalString(i3));
  //10진수를 8진수로:6772
  System.out.println("10진수를 16진수로:"+Integer.toHexString(i3));
  //10진수를 16진수로:dfa
  
  System.out.println(Integer.SIZE);
  //32
  
  ```

- Math 클래스는 new 가 안됨! 

  - 대표 예 : Math.PI / Math.abs(-10)

  ``` java
  public class MathExample {
  	public static void main(String[] args) {
  		System.out.println("원주율: " + Math.PI);
  		System.out.println("자연로그의 밑수: "+ Math.E);
  
  		System.out.println("-20의 절대값: "+ Math.abs(-20));
  		System.out.println("-20.3의 절대값: "+ Math.abs(-20.3));
  
  		System.out.println("최대값: "+ Math.max(50, 30));
  		System.out.println("최소값: "+ Math.min(1.5, 3.3));
  
  		System.out.println("2의 3승 값: "+ Math.pow(2, 3));
  
  		System.out.println("69.6의 반올림: "+ Math.round(69.6));
  		System.out.println("69.3의 절상: "+ Math.ceil(69.3));
  		System.out.println("69.8의 절하: "+ Math.floor(69.8));
  
  		// 임의값 (0.0 <= random < 1.0)
  		System.out.println(Math.random());
  		// 0 ~ 2 범위의 임의의 값
  		System.out.println((int)(Math.random()*3));
  
  		// 로또 번호(1~45범위의 6개)
  		for (int i = 0; i < 6; i++) {
  		     System.out.print((int)(Math.random()*45) + 1 + "\t");
  		}
  
  	}
  }
  ```

- alt + shift + "R" : 단어 한번에 수정

- System은 os

## UML 소개 및 클래스다이어그램

![1535002568508](C:\Users\kosta\AppData\Local\Temp\1535002568508.png)

- 서로의 class 안에서 서로 참조하고 있음

- public Customer orderCustomer / public Item orderCustomer 가 아니라 private임 (오타)

- **관계중에서 실선은 관계가 있음(연관 (association))** / 시험!!!!!!!!!!!

  ![1535002738388](C:\Users\kosta\Desktop\희진\1535002738388.png)

- 다중도를 숫자로 표시함

- 하나의 학생은 강의를 5개까지 수강할 수 있다

- 한 강의당 학생은 3명에서 40명까지 수강 가능하다

- 복수는 (*) : 

  - 0..* : 0이상

- 1..3 : 1개 이상 3개 이하

![1535003170145](C:\Users\kosta\AppData\Local\Temp\1535003170145.png)

- 유도가능성 : 단방향
- role이름은 쓰지말기~

![1535003247474](C:\Users\kosta\AppData\Local\Temp\1535003247474.png)

- ◇ : Aggregation (집합관계)

![1535003605982](C:\Users\kosta\AppData\Local\Temp\1535003605982.png)

- ◆ : Composition (복합관계)
  - 나무와 나뭇잎의 관계 : 죽으면 같이 죽음
- --------------------> : 의존관계 (dependency)

## 상속

![1535006515779](C:\Users\kosta\AppData\Local\Temp\1535006515779.png)

- Bicycle : 부모

- 밑에 class 들 : 자식

- UML에서는 상속이라는 말 안씀! **일반화** 라는 말을 씀

  ``` java
  public class Bicycle {
  	int id;
  	String brand;
  	
  	public Bicycle() {
  		this(0,null);
  	}
  	
  	public Bicycle(int id, String brand) {
  		this.id = id;
  		this.brand = brand;		
  		
  	}
  
  }
  ```

  ``` java
  public class MountainBicycle extends Bicycle{
  	//추가 속성
  	String frame;
  	boolean suspension;
  	
  	public MountainBicycle() {
  		this(null,false);
  	}
  	
  	public MountainBicycle(String frame, boolean suspension) {
  		this.frame = frame;
  		this.suspension = suspension;
  		
  	}
  	
  	public MountainBicycle(int id, String brand, String frame, boolean suspension) {
  //		this.id = id;
  //		this.brand = brand;
  		super(id,brand);
  		this.frame = frame;
  		this.suspension = suspension;
  	}
  	
  
  }
  ```

  ``` java
  public class InheritenceExample {
  	public static void main(String[] args) {
  		
  		Bicycle bicycle = new Bicycle(10, "삼천리");
  		
  		System.out.println(bicycle.brand);
  		
  		MountainBicycle mountainBicycle = new MountainBicycle();
  		//부모로부터 재사용
  		System.out.println(mountainBicycle.brand);
  		//확장
  		System.out.println(mountainBicycle.frame);
  		System.out.println(mountainBicycle.suspension);
  		
  	}
  
  }
  ```

- default 생성자 / extends Object : 자동으로 컴파일되는 것

- 모든 자바 클래스는 Object 클래스의 자손이다 

  - public class Bicycle 뒤에 extends Object 가 있는 것!

  - |       Object        |
    | :-----------------: |
    |     **Bicycle**     |
    | **MountainBicycle** |

- 상속은 다중 상속(부모가 여럿)을 지원하지 않는다.

- 슈퍼클래스의 은닉화(private) 되어 있는 속성이나 메서드는 상속되지 않는다.

  - private int id 였으면 상속 X

- 생성자는 상속되지 않는다. => 생성자는 따로 만들어야 됨!

- 원래 부모에 있는 기능을 자식이 그대로 물려받아 쓰는게 아니라 좀 더 수정해서 쓰는 것 : 오버라이딩(Overriding : 재정의) 

- **오버라이딩 규칙** / 시험!!!! (오버로딩도 보기)

  - **메서드 선언부가 같아야한다. (중요)**
  - 접근제한자의 경우 같거나 더 넓어야 한다.

  ``` java
  public class MountainBicycle extends Bicycle{
  	public void running() {
  		System.out.println("산도 달립니다.");
  	}
  }
  
  ```

  ``` java
  public class Bicycle {
  	public void running() {
  		System.out.println("자전거가 달립니다.");
  	}
  
  }
  ```

  ``` java
  public class InheritenceExample {
  	public static void main(String[] args) {
  		bicycle.running();
          //자전거가 달립니다. 출력
          mountainBicycle.running();
          //산도 달립니다. 출력
      }
  }
  ```

  
