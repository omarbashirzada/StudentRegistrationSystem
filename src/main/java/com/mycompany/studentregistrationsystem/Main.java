/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */
package com.mycompany.studentregistrationsystem;

import beans.Student;
import util.InputUtil;
import util.StudentUtil;

/**
 *
 * @author User
 */
public class Main {

    public static void main(String[] args) {

        int menu = 0;

        while (true) {

            menu = InputUtil.requireNumber("""
                                           What do you want to do?
                                           1. Register student
                                           2. Show all students
                                           3. Find student 
                                           4. Update student""");

            switch (menu) {
                case 1 ->
                    StudentUtil.registerStudents();

                case 2 ->
                    StudentUtil.printAllRegisteredStudent();

                case 3 ->
                    StudentUtil.findStudentsAndPrint();

                case 4 ->
                    StudentUtil.updateStudent();
                default -> {
                    System.out.print("Please enter number (1,2,3,4): ");
                }
            }
        }
    }

}
