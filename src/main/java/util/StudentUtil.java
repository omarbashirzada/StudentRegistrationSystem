/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package util;

import beans.Student;
import com.mycompany.studentregistrationsystem.Config;

/**
 *
 * @author User
 */
public class StudentUtil {

    public static Student fillStudent() {
        String name = InputUtil.requireText("Enter name");
        String surname = InputUtil.requireText("Enter surname");
        int age = InputUtil.requireNumber("Enter age");
        String className = InputUtil.requireText("Enter class");

        Student st = new Student(name, surname, age, className);
        return st;
    }

    public static void updateStudent() {
        StudentUtil.printAllRegisteredStudent();
        int a = InputUtil.requireNumber("How many students do you want to change?");

        Student s = Config.students[a - 1];
        String changeParams = InputUtil.requireText("which one do you want to change?(name,surname...)");
        String[] params = changeParams.split(",");
        for (String param : params) {
            if ("name".equals(param)) {
                s.setName(InputUtil.requireText("Change name"));
            }
            if ("surname".equals(param)) {
                s.setSurname(InputUtil.requireText("Change surname"));
            }
            if ("age".equals(param)) {
                s.setAge(InputUtil.requireNumber("Change age"));
            }
            if ("class name".equals(param)) {
                s.setClassName(InputUtil.requireText("Change class"));
            }
        }
    }

    public static void printAllRegisteredStudent() {
        if (Config.students == null) {
            return;
        }
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            System.out.println((i + 1) + "." + st.getFullInfo());
        }
    }

    public static void registerStudents() {
        int count = InputUtil.requireNumber("How many students will you enroll?");
        Config.students = new Student[count];

        for (int i = 0; i < count; i++) {
            System.out.println((i + 1) + ". " + "Register");

            Config.students[i] = StudentUtil.fillStudent();
        }
        System.out.println("Register succesfully!");
    }

    public static void findStudentsAndPrint() {
        String text = InputUtil.requireText("Enter type name, surname or class name");
        Student[] foundStudent = findStudents(text);
        for (Student foundStudent1 : foundStudent) {
            System.out.println(foundStudent1.getFullInfo());
        }
    }

    public static Student[] findStudents(String text) {
        int count = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text)
                    || st.getSurname().contains(text)
                    || st.getClassName().contains(text)) {
                count++;
            }
        }
        Student[] result = new Student[count];
        int found = 0;
        for (int i = 0; i < Config.students.length; i++) {
            Student st = Config.students[i];
            if (st.getName().contains(text)
                    || st.getSurname().contains(text)
                    || st.getClassName().contains(text)) {
                result[found++] = st;
            }
        }
        return result;

    }

}
