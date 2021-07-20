package io.todak.study.modernjavainaction.ch01;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FilteringApples {

    private static final String GREEN = "green";
    private static final String RED = "red";


    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, GREEN),
                new Apple(155, GREEN),
                new Apple(120, RED)
        );

        List<Apple> greenApples = filterApples(inventory, FilteringApples::isGreenApple);
        System.out.println(greenApples);

        List<Apple> heavyApples = filterApples(inventory, FilteringApples::isHeavyApple);
        System.out.println(heavyApples);

        filterApples(inventory, (Apple a) -> GREEN.equals(a.getColor()));
        filterApples(inventory, (Apple a) -> a.getWeight() > 150);
        filterApples(inventory, (Apple a) -> a.getWeight() < 80 || RED.equals(a.getColor()));

    }


    /**
     * 중복을 유발할 수 있는 전형적인 코드.
     * apple의 무게까지 filter 조건에 포함하려고 한다면, 반드시 이는 복사 & 붙여넣기로 이어진다.
     */
    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();

        for (Apple apple : inventory) {
            if (GREEN.equals(apple.getColor())) {
                result.add(apple);
            }
        }
        return result;
    }

    public static List<Apple> filterHeavyApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > 150) {
                result.add(apple);
            }
        }
        return result;
    }

    ////////////////////////////////////////////////////////////////////////////////////////

    public static boolean isGreenApple(Apple apple) {
        return GREEN.equals(apple.getColor());
    }

    public static boolean isHeavyApple(Apple apple) {
        return apple.getWeight() > 150;
    }

    /**
     * 보통은 java.util.function 에서 import 해 사용함.
     * 수학에서는 인수로 값을 받아 true 또는 false 를 반환하는 함수를 프레디케이트(Predicate)라 한다.
     */
    public interface Predicate<T> {
        boolean test(T t);
    }

    /**
     * filterApples 메서드의 동작을
     * Predicate를 활용해 파라미터화 하는데 성공.
     *
     */
    static List<Apple> filterApples(List<Apple> inventory, Predicate<Apple> p) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (p.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }


}
