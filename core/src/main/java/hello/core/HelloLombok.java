package hello.core;

import java.util.Arrays;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class HelloLombok {
    private String name;
    private int age;

    public static void main(String[] args) {
        HelloLombok helloLombok = new HelloLombok();
        helloLombok.setName("Lombok");
        helloLombok.setAge(18);



        String name = helloLombok.getName();
        int age = helloLombok.getAge();

        System.out.println(name);
        System.out.println(age);
    }
}
