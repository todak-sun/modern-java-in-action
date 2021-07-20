package io.todak.study.modernjavainaction.ch02;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

public class FilteringApples {

    public static void main(String[] args) {
        List<Apple> inventory = Arrays.asList(
                new Apple(80, Color.GREEN),
                new Apple(155, Color.GREEN),
                new Apple(120, Color.RED));

        List<Apple> greenApples = filterApplesByColor(inventory, Color.GREEN);
        System.out.println(greenApples);

        List<Apple> redApples = filterApplesByColor(inventory, Color.RED);
        System.out.println(redApples);

    }

    public static List<Apple> filterGreenApples(List<Apple> inventory) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (Color.GREEN.equals(apple.getColor())) { // 녹색 사과를 선택하는데 필요한 조건.
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * Color를 기준으로 필터링
     */
    public static List<Apple> filterApplesByColor(List<Apple> inventory, Color color) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getColor().equals(color)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 무게값을 기준으로 필터링
     */
    public static List<Apple> filterApplesByWeight(List<Apple> inventory, int weight) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (apple.getWeight() > weight) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 추상적 조건으로 필터링
     */
    public static List<Apple> filterApples(List<Apple> inventory, ApplePredicate preidcate) {
        List<Apple> result = new ArrayList<>();
        for (Apple apple : inventory) {
            if (preidcate.test(apple)) {
                result.add(apple);
            }
        }
        return result;
    }

    /**
     * 퀴즈 2-1. 유연한 prettyPrintApple 메서드 구현하기
     * <p>
     * 사과 리스트를 인수로 받아 다양한 방법으로 문자열을 생성(커스터마이즈된 다양한 toString 메서드와 같이) 할 수 있도록
     * 파라미터화된 prettyPrintApple 메서드를 구현해보자.
     */

    interface AppleFormatter {
        String accept(Apple a);
    }

    public static void prettyPrintApple(List<Apple> inventory, AppleFormatter formatter) {
        for (Apple apple : inventory) {
            String output = formatter.accept(apple);
            System.out.println(output);
        }
    }

    /**
     * 리스트 형식으로 추상화
     */

    public static <T> List<T> filter(List<T> list, Predicate<T> predicate) {
        List<T> result = new ArrayList<>();
        for (T item : list) {
            if (predicate.test(item)) {
                result.add(item);
            }
        }
        return result;
    }

}
