package lambda;

import org.junit.Test;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

/**
 * 方法引用.
 *
 * @author: huang
 * Date: 17-12-26
 */
public class TestMethodReference {

    /**
     * 对象：：实例方法.
     */
    @Test
    public void test1() {
        Consumer<String> com = System.out::println;
        com.accept("你好！");

        System.out.println("----------------------");

        Student student = new Student("张三", 18);
        Supplier<String> sup = () -> student.getName();
        Supplier<String> sup1 = student::getName;
        System.out.println(sup.get());
        System.out.println(sup1.get());
    }

    /**
     * 类：：静态方法名.
     */
    @Test
    public void test2() {
        Comparator<Integer> com = (x, y) -> Integer.compare(x, y);
        System.out.println(com.compare(100, 101));

        System.out.println("----------------------------------");

        Comparator<Integer> comparator = Integer::compare;
        System.out.println(comparator.compare(100, 101));
    }

    /**
     * 类：：实例方法.
     */
    @Test
    public void test3() {
        BiPredicate<String, String> bp = (x, y) -> x.equals(y);
        System.out.println(bp.test("test", "test1"));

        System.out.println("------------------------------------");

        BiPredicate<String, String> biPredicate = String::equals;
        System.out.println(biPredicate.test("test1", "test"));
    }

    /**
     * 构造器引用.
     */
    @Test
    public void test4() {
        Supplier<Student> sup = () -> new Student();

        Supplier<Student> supplier = Student::new;
    }

    /**
     * 数组引用.
     */
    @Test
    public void test5() {
        Function<Integer, String[]> fun = (x) -> new String[x];
        String[] strs = fun.apply(5);
        System.out.println(strs.length);

        System.out.println("----------------------------------");

        Function<Integer, String[]> function = String[]::new;
        String[] strings = function.apply(4);
        System.out.println(strings.length);
    }

}
