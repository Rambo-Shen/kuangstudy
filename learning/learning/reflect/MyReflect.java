package learning.reflect;

import learning.oop.Outer.Inner;

public class MyReflect {
    public static void main(String[] args) {
        Class class1;
        Class class2;
        Person person = new Student("rambo");
        try {
            class1 = Class.forName("learning.reflect.Person");
            class2 = Class.forName("learning.reflect.Person");
            Class class3 = person.getClass();
            Class class4 = Student.class;

            System.out.println(class1);
            System.out.println(class2 == class1 );//true
            System.out.println(class3 == class4 );
            System.out.println(class1 == class4.getSuperclass() );

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

/**
 * InnerMyReflect
 */
 class Person {
    String name;
    public Person(String name){
        this.name = name;
    }
    @Override
    public String toString() {
        return String.format("Person{name=%s}", name);
    }
}

class Student extends Person{
    public Student(String name) {
        super(name);
    }
    @Override
    public String toString() {
        return String.format("Person{Student{name=%s}}", name);
    }
}