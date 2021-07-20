# 동작 파라미터화 코드 전달하기

- 동작 파라미터화를 이용하면 자주 바뀌는 요구사항에 효과적으로 대응할 수 있다.
- 동작 파라미터화란 아직은 어떻게 실행할 것인지 결정하지 않은 코드 블록을 의미한다.

## 프레디케이트(Predicate)
- 참 또는 거짓을 반환하는 함수.
- 선택 조건을 결정하는 인터페이스

## 전략 디자인 패턴
- 전략이라 불리는 각 알고리즘을 캡슐화하는 알고리즘 패밀리를 정의해둔 다음, 런타임에 알고리즘을 선택하는 기법.
- 예제에서는 ApplePredicate가 알고리즘 패밀리고, AppleHeavyWeightPredicate와 AppleGreenColorPredicate가 전략이다.