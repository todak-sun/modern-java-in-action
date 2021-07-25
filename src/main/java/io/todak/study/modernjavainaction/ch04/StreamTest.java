package io.todak.study.modernjavainaction.ch04;

import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class StreamTest {

    public static void main(String[] args) {
        // 단일 스트림
        List<String> collect = Dish.menu.stream().filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());

        System.out.println(collect);

        // 병럴 처리
        List<String> parallelResult = Dish.menu.parallelStream().filter(d -> d.getCalories() < 400)
                .sorted(Comparator.comparing(Dish::getCalories))
                .map(Dish::getName)
                .collect(Collectors.toList());

        System.out.println(parallelResult);

        List<String> threeHighCaloricDishNames = Dish.menu.stream()
                .filter(dish -> dish.getCalories() > 300) // 고 칼로리 요리 필터
                .map(Dish::getName)// 이름 추출
                .limit(3) // 선착순 세개 만 선택
                .collect(Collectors.toList()); // 결과를 다른 리스트로 저장

        System.out.println(threeHighCaloricDishNames);

    }

}
