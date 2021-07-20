package io.todak.study.modernjavainaction.ch02;

public class AppleHeavyWeightPredicate implements ApplePredicate {
    // 무거운 사과만 선택
    @Override
    public boolean test(Apple apple) {
        return apple.getWeight() > 150;
    }
}
