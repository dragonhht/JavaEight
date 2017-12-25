package lambda;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Lambda学习.
 *
 * @author: huang
 * Date: 17-12-25
 */
public class TestLambda {

    List<Student> students = Arrays.asList(
            new Student("张三", 18),
            new Student("李四", 15),
            new Student("王五", 80),
            new Student("刘六", 40)
    );

    /**
     * 比较方法.
     * @param students
     * @param filter
     * @return
     */
    public List<Student> comparStudent(List<Student> students, FilterStudent filter) {
        List<Student> list = new ArrayList<>();
        for (Student stu : students) {
            if (filter.compare(stu)) {
                list.add(stu);
            }
        }
        return list;
    }

    @Test
    public void test1() {
        // 使用匿名内部类查询
        List<Student> studentList = comparStudent(students, new FilterStudent() {
            @Override
            public boolean compare(Student student) {
                return student.getAge() >= 40;
            }
        });
        for (Student student : studentList) {
            System.out.println(student);
        }

        System.out.println("-------------------------");

        // 使用Lambda表达式
        List<Student> studentList1 = comparStudent(students, (student) -> student.getAge() >= 40 );
        studentList1.forEach(System.out::println);
    }

}
