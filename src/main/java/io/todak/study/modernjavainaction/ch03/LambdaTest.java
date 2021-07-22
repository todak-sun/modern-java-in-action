package io.todak.study.modernjavainaction.ch03;

import java.util.Comparator;

public class LambdaTest {

    Comparator<Apple> byWeightAnonymousClass = new Comparator<Apple>() {
        @Override
        public int compare(Apple o1, Apple o2) {
            return o1.getWeight().compareTo(o2.getWeight());
        }
    };

    Comparator<Apple> byWeightLambda = (apple1, apple2) -> apple1.getWeight().compareTo(apple2.getWeight());




}
