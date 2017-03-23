import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by YSingh on 23/03/17.
 */

class Student {
    String name;
    int age;

    public Student(String name, int age) {
        this.age = age;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

public class StreamAPI {
    public static void main(String[] args) {
        List<Student> students = new ArrayList<>();
        Student s1 = new Student("Yogesh", 25);
        Student s2 = new Student("Yasi", 2);
        students.add(s1);
        students.add(s2);
        List<Student> list = students
                                .stream()
                                .filter(item -> item.age > 20)
                                .collect(Collectors.toList());

        List<Integer> names = students.stream()
                                .map(Student :: getAge)
                                .filter(age -> age > 20)
                                .limit(10)
                                .collect(Collectors.toList());

        for(Student s: list) {
            System.out.println(s.getName());
        }

        for(Integer val : names) {
            System.out.println(val);
        }
    }
}
