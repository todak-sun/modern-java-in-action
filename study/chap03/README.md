# 3장. 람다 표현식

## 람다란 무엇인가?

- 람다 표현식?: 메서드로 전달할 수 있는 익명 함수를 단순화한 것
- 람다의 특징
    - 익명 : 보통의 메서드와 달리 이름이 없다. 구현해야 할 코드에 대한 걱정이 줄어든다.
    - 함수 : 람다는 메서드와 달리 특정 클래스에 종속되지 않는다. 하지만, 메서드와 같이 파라미터 리스트, 바디, 반환 형식, 예외 리스트를 포함한다.
    - 전달 : 람다 표현식은 메서드 인수로 전달하거나 변수로 저장할 수 있다.
    - 간결성 : 익명 클래스처럼 자질구레한 코드를 작성할 필요가 없다.

## 어디에, 어떻게 람다를 사용하는가?

- 함수형 인터페이스라는 문맥에서 람다 표현식을 사용할 수 있다.
- 함수형 인터페이스 : 정확히 하나의 추상 메서드를 지정하는 인터페이스.
- 왜 함수형 인터페이스를 인수로 받는 메서드에만, 람다 표현식을 사용할 수 있을까?
    - 언어를 더 복잡하게 만들지 않기 위해 택한 방법...
- `@FunctionalInterface`

## 실행 어라운드 패턴(execute around pattern)

```java
public class Sample {
    public String processFile() throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            return br.readLine();
        }
    }

    public interface BufferedReaderProcessor {
        String process(BufferedReader b) throws IOException;
    }

    public String processFile(BufferedReaderProcessor p)
            throws IOException {
        try (BufferedReader br =
                     new BufferedReader(new FileReader("data.txt"))) {
            return p.process(br);
        }
    }

    String oneLine = processFile((BufferedReader br) -> br.readLine());
    String twoLines = processFile((BufferedReader br) -> br.readLine + br.readLine());

}
```

## 함수형 인터페이스, 형식 추론

- 함수 디스크립터(function descriptor): 함수형 인터페이스의 추상 메서드 시그니처
- 자바의 모든 형식은 참조형(reference type) 또는 기본형(primitive type)에 해당한다.
- 하지만, 제네릭 파라미터에는 참조형만 사용할 수 있으며, 자바는 이를 위해 Auto Boxing/Unboxing을 제공하지만 비용이 비싸다.
- 따라서, 기본형 특화 버전의 함수형 인터페이스를 제공한다
    - 예: IntPredicate,

## 메서드 참조

- 정적 메서드 참조
- 다양한 형식의 인스턴스 메서드 참조
- 기존 객체의 인스턴스 메서드 참조


## 람다 만들기