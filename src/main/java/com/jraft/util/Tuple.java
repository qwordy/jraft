package com.jraft.util;

public class Tuple{

    public static class Tuple2<F, S> {

        private final F first;

        private final S second;

        public Tuple2(F first, S second) {
            this.first = first;
            this.second = second;
        }

        public F getFirst() {
            return first;
        }

        public S getSecond() {
            return second;
        }
    }

    public static class Tuple3<F, S, T> {

        private final F first;

        private final S second;

        private final T third;

        public Tuple3(F first, S second, T third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        public F getFirst() {
            return first;
        }

        public S getSecond() {
            return second;
        }

        public T getThird() {
            return third;
        }
    }

    public static <F, S> Tuple2<F, S> getTuple(F first, S second) {
        return new Tuple2<>(first, second);
    }

    public static  <F, S, T> Tuple3<F, S, T> getTuple(F first, S second, T third) {
        return new Tuple3<>(first, second, third);
    }

}
