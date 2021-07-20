package io.todak.study.modernjavainaction.ch02;

import static io.todak.study.modernjavainaction.ch02.Color.RED;

public class AppleRedAndHeavyPredicate implements ApplePredicate {
    @Override
    public boolean test(Apple apple) {
        return RED.equals(apple.getColor())
                && apple.getWeight() > 150;
    }
}
