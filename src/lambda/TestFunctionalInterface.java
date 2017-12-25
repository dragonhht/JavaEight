package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

/**
 * 四大内置函数式接口.
 *
 * @author: huang
 * Date: 17-12-25
 */
public class TestFunctionalInterface {

    /**
     * 消费型接口.
     */
    @Test
    public void testConsumer() {
        consumer(1000, (m) -> System.out.println(m));
    }

    public void consumer(int num, Consumer<Integer> com) {
        com.accept(num);
    }

    /**
     * 供给型接口.
     */
    @Test
    public void testSupplier() {
        List<Integer> nums = getNum(10, () -> new Random().nextInt(100));
        nums.forEach(System.out::println);
    }

    public List<Integer> getNum(int num, Supplier<Integer> sup) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < num; i++) {
            int n = sup.get();
            list.add(n);
        }
        return list;
    }

    /**
     * 函数型接口.
     */
    @Test
    public void testFunction() {
        String s = "dragonhht";
        int num = getFunction(s, (s1) -> s.length());
        System.out.println(num);
    }

    public int getFunction(String s, Function<String, Integer> fun) {
        return fun.apply(s);
    }

    @Test
    public void testPredicate() {
        String str = getStr(100, (s) -> s>99);
        System.out.println(str);
    }

    public String getStr(int n, Predicate<Integer> pre) {
        if (pre.test(n)) {
            return "True";
        }
        return "False";
    }
}
