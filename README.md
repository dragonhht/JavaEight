# Java8 新特性

## 一、Lambda表达式

### 1、[简单事例](./src/lambda/TestLambda.java)

### 2、语法格式

> Java8引入操作符：`->`， 该操作符将Lambda表达式分为两部分：  
左侧： 参数列表， 即接口(函数式接口：接口中只有一个方法)中抽象方法的参数列表，可显示写出数据类型，但若写出数据类型则需所有参数都写，也可不显示写出数据类型  
右侧： 所需执行的功能代码， Lambda体, 若有多条语句使用`{}`包含

### 3、格式情况

-   无参数，无返回值：`() -> 方法体`

-   有参数，无返回值：`(参数表) -> 方法体`， 若参数只有一个，则包含参数的括号可不写，如: `x -> System.out.println(x)`

-   有参数，有返回值，但方法中含多条语句，如：
    ```
    List<Student> studentList1 = comparStudent(students, (student) -> {
                                      System.out.println(student.getAge());
                                      return student.getAge() >= 40; 
                                  } );
    ```
    需写出`return`关键词,并使用`{}`包含方法
   
-   有参数，有返回值，但只有一条返回语句：
    ```
    List<Student> studentList1 = comparStudent(students, (student) -> student.getAge() >= 40 );
    ```
    可不使用`{}`包含方法，无需写明`return`关键词
    
### 4、[四大内置函数式接口](./src/lambda/TestFunctionalInterface.java)

-   `Consumer<Integer>`: 消费性接口， 抽象方法: `void accept()`

-   `Supplier<T>`：供给型接口, 抽象方法：`T get()`

-   `Function<T, R>`：函数型接口，抽象方法：`R apply(T t)`

-   `Predicate<T>`：断言型接口，抽象方法：`boolean test(T t)`;

