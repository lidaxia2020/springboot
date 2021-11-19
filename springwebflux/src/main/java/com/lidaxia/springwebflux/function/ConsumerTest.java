package com.lidaxia.springwebflux.function;


import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author lijiannan
 * @desc
 * @date 2021/11/19 9:28（
 */
public class ConsumerTest {


    /**
     * Consumer是一个函数式编程接口；
     * 顾名思义，Consumer的意思就是消费，
     * 即针对某个东西我们来使用它，
     * 因此它包含有一个有输入而无输出的accept接口方法；
     * 除accept方法，它还包含有andThen这个方法
     */
    public static void consumerTest() {
        Consumer f = System.out::println;
        Consumer f2 = n -> System.out.println(n + "-F2");

        //执行完F后再执行F2的Accept方法
        f.andThen(f2).accept("test");

        //连续执行F的Accept方法
        f.andThen(f).andThen(f).andThen(f).accept("11");
    }

    /**
     * Function也是一个函数式编程接口；
     * 它代表的含义是“函数”，
     * 而函数经常是有输入输出的，因此它含有一个apply方法，包含一个输入与一个输出
     */
    public static void functionTest() {
        Function<Integer, Integer> f = s -> ++s;
        Function<Integer, Integer> g = s -> s * 5;

        /**
         * 下面表示在执行F时，先执行G，并且执行F时使用G的输出当作输入。
         * 相当于以下代码：
         * Integer a = g.apply(1);
         * System.out.println(f.apply(a));
         *
         * B.compose(A).apply(5)
         * compose等价于B.apply(A.apply(5))
         */
        System.out.println(f.compose(g).apply(1));

        /**
         * 表示执行F的Apply后使用其返回的值当作输入再执行G的Apply；
         * 相当于以下代码
         * Integer a = f.apply(1);
         * System.out.println(g.apply(a));
         */
        System.out.println(f.andThen(g).apply(1));

        /**
         * identity方法会返回一个不进行任何处理的Function，即输出与输入值相等；
         */
        System.out.println(Function.identity().apply("a"));
    }

    private static void predicateTest() {
        Predicate<String> p = o -> o.equals("test");
        Predicate<String> g = o -> o.startsWith("t");

        /**
         * negate: 用于对原来的Predicate做取反处理；
         * 如当调用p.test("test")为True时，调用p.negate().test("test")就会是False；
         */
//        Assert.assertFalse(p.negate().test("test"));

        /**
         * and: 针对同一输入值，多个Predicate均返回True时返回True，否则返回False；
         */
//        Assert.assertTrue(p.and(g).test("test"));

        /**
         * or: 针对同一输入值，多个Predicate只要有一个返回True则返回True，否则返回False
         */
//        Assert.assertTrue(p.or(g).test("ta"));
    }

    /**
     * Stream可以由数组或集合创建，对流的操作分为两种
     * 1 中间操作，每次返回一个新的流，可以有多个
     * 2 终端操作，每个流只能进行一次终端操作，终端操作结束后流无法再次使用。终端操作会产生一个新的集合或值。
     * 3 stream不存储数据，而是按照特定的规则对数据进行计算，一般会输出结果。
     * 4 stream不会改变数据源，通常情况下会产生一个新的集合或一个值。
     * 5 stream具有延迟执行特性，只有调用终端操作时，中间操作才会执行。
     */
    private static void streamTest() {
        /**
         * 创建
         * 1、通过 java.util.Collection.stream() 方法用集合创建流
         * 2、使用java.util.Arrays.stream(T[] array)方法用数组创建流
         * 3、使用Stream的静态方法：of()、iterate()、generate()
         */

        List<String> list = Arrays.asList("a", "b", "c");
        // 创建一个顺序流
        Stream<String> stream = list.stream();
        // 创建一个并行流
        Stream<String> parallelStream = list.parallelStream();

        int[] array={1,3,5,6,8};
        IntStream streamInt = Arrays.stream(array);

        Stream<Integer> streamOf = Stream.of(1, 2, 3, 4, 5, 6);

        Stream<Integer> stream2 = Stream.iterate(0, (x) -> x + 3).limit(4);
        // 0 2 4 6 8 10
        stream2.forEach(System.out::println);

        Stream<Double> stream3 = Stream.generate(Math::random).limit(3);
        stream3.forEach(System.out::println);

    }


    public static void main(String[] args) {
        consumerTest();
        functionTest();
        predicateTest();
    }
}
