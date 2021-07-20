package io.todak.study.modernjavainaction.ch02;

import static io.todak.study.modernjavainaction.ch02.Color.GREEN;

public class AppleGreenColorPredicate implements ApplePredicate {
    // 녹색 사과만 선택
    @Override
    public boolean test(Apple apple) {
        return GREEN.equals(apple.getColor());
    }
}
