/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.kopano_matlapeng_prize;

import java.util.Scanner;

/**
 *
 * @author Kopano
 **/

public class Kopano_Matlapeng_Prize {
    static int StudentNumber = 0;
    static Student[] students = new Student[7];

    public static void main(String[] args){
        Scanner input = new Scanner(System.in);

        int choice = 0;

        while (choice != 4){
            System.out.println();

            System.out.println("1. Enter student surname and initial.");
            System.out.println("2. Display all student details.");
            System.out.println("3. Display top student.");
            System.out.println("4. Exit program.");
            System.out.println();

            System.out.print("Please enter your choice from the menu given: ");
            choice = input.nextInt();

            switch (choice)
            {
                case 1:
                    enterStudents(input);
                    break;

                case 2:
                    displayStudents();
                    break;

                case 3:
                    topStudent();
                    break;

                case 4:
                    System.out.println("Exiting program...");
                    break;

                default:
                    System.out.println("Invalid choice.");
                    System.out.println("Please input a valid choice.");
            }
        }
    }


    public static void enterStudents(Scanner input)
    {
        String name;
        int grade;
        int term1;
        int term2;
        int term3;
        int term4;

        input.nextLine();

        System.out.print("Please enter the surname and initial of the student: ");
        name = input.nextLine();
        
            while (!name.matches("[a-zA-Z]+ [a-zA-z]")){
                  System.out.println("Please only input surnames and initials with letters.");
                  name = input.nextLine();
                  
            }

        System.out.print("Please enter the grade of the student: ");
        grade = input.nextInt();
            
             while (grade != 12){
                    System.out.println ("The student grade must be 12.");
                    System.out.println ("Please re-input a valid student grade.");
                   grade = input.nextInt();         
                }
    

        System.out.print("Please enter the Term 1 mark of the student: ");
        term1 = input.nextInt();

                      while (term1<0 || term1>100){
                          System.out.println();
                          System.out.println("Invalid choice.");
                          System.out.println("Please only input values between 0 and 100.");
                          term1 = input.nextInt();
                      }
    
                      
        System.out.print("Please enter the Term 2 mark of the student: ");
        term2 = input.nextInt();
        
                     while (term2<0 || term2>100){
                          System.out.println();
                          System.out.println("Invalid choice.");
                          System.out.println("Please only input values between 0 and 100.");
                          term2 = input.nextInt();
                      }

        System.out.print("Please enter the Term 3 mark of the student: ");
        term3 = input.nextInt();
        
                     while (term3<0 || term3>100){
                          System.out.println();
                          System.out.println("Invalid choice.");
                          System.out.println("Please only input values between 0 and 100.");
                          term3 = input.nextInt();
                      }

        System.out.print("Please enter the Term 4 mark of the student: ");
        term4 = input.nextInt();

        
                     while (term4<0 || term4>100){
                          System.out.println();
                          System.out.println("Invalid choice.");
                          System.out.println("Please only input values between 0 and 100.");
                         term4 = input.nextInt();
                      }
         
         
         
        students[StudentNumber] = new Student(
                name,
                StudentNumber + 1,
                grade,
                term1,
                term2,
                term3,
                term4
        );

        StudentNumber++;

        System.out.println("Student number: " + StudentNumber);
    }


    static class Student
    {
        String name;
        int number;
        int grade;
        int term1;
        int term2;
        int term3;
        int term4;

        Student(String name, int number, int grade,
                int term1, int term2, int term3, int term4)
        {
            this.name = name;
            this.number = number;
            this.grade = grade;
            this.term1 = term1;
            this.term2 = term2;
            this.term3 = term3;
            this.term4 = term4;
        }
    }


    public static void displayStudents()
    {
       System.out.println();
        System.out.println("Name\tNumber\tGrade\tTerm 1\tTerm 2\tTerm 3\tTerm 4\tAverage");
        System.out.println();

        for (int i = 0; i < StudentNumber; i++)
        {
            double average;

            average = (students[i].term1 * 0.125)
                    + (students[i].term2 * 0.25)
                    + (students[i].term3 * 0.125)
                    + (students[i].term4 * 0.5);
           average = Math.round(average * 10.0) / 10.0;
           
           
            System.out.println(
                    students[i].name + "\t" +


                    students[i].number + "\t" +


                    students[i].grade + "\t" +


                    students[i].term1 + "\t" +


                    students[i].term2 + "\t" +


                    students[i].term3 + "\t" +


                    students[i].term4 + "\t" +


                    average
            );
        }

        System.out.println();
        
        
    }
    public static void topStudent (){
            double topStudentAverage = 0;
            Student topStudent = null;
            
            for (int i = 0; i < StudentNumber; i++)
        {
            double average;

            average = (students[i].term1 * 0.125)
                    + (students[i].term2 * 0.25)
                    + (students[i].term3 * 0.125)
                    + (students[i].term4 * 0.5);
            
            average = Math.round(average * 10.0) / 10.0;
            
            
            
            if (average>topStudentAverage){
                topStudentAverage = average;
                 topStudent = students[i];       
        }
        }
            System.out.println();
            System.out.println("Top Student Grade 12");
            System.out.println("Name\tNumber\tAverage");
            
            System.out.println (topStudent.name + "\t"+ topStudent.number + "\t" +
                    topStudentAverage);
            
            System.out.println();
            
            
            
        }
    }
