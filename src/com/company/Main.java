package com.company;

import java.util.ArrayList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static ArrayList<Student> students;
    private static Scanner scanner = new Scanner(System.in);


    public static void main(String[] args) {
        students = new ArrayList<Student>();
        printActions();
        boolean quit = false;
        int action;
        while (!quit) {
            System.out.println("\nEnter an Action (6 to show available actions)");
            action = scanner.nextInt();
            scanner.nextLine();
            switch (action) {
                case 0:
                    quit = true;
                    break;
                case 1:
                    printArray();
                    break;
                case 2:
                    System.out.println("Please enter name\n");
                    String name = scanner.nextLine();
                    System.out.println("Please enter roll no\n");
                    int rollno = scanner.nextInt();
                    scanner.nextLine();
                    createarray(name, rollno);
                    break;
                case 3:
                    System.out.println("Enter the name of the student\n");
                    remoItem(scanner.nextLine());
                    break;
                case 4:
                    System.out.println("Please enter the name to replace\n");
                    String oldname = scanner.nextLine();
                    System.out.println("Please enter the new name\n");
                    String newname = scanner.nextLine();
                    modifyArray(oldname, newname);


            }
        }
    }

    private static void printArray() {
        for (int i = 0; i < students.size(); i++) {
            Student a = students.get(i);
            System.out.println(i + 1 + ".Name " + a.getName() + " Roll no." + a.getRollno());
        }
    }

    public static void createarray(String name, int rollno) {
        if (findArray(name) >= 0 && rollnofind(rollno) != 0) {
            System.out.println("Sorry " + name + " already in the list");
        }
        students.add(new Student(name, rollno));
        System.out.println("Created student's database .");


    }

    private static int findArray(String name) {
        for (int i = 0; i < students.size(); i++) {
            Student listedarray = students.get(i);
            if (listedarray.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    private static int rollnofind(int rollnode) {
        for (int i = 0; i < students.size(); i++) {
            int rollnofinder = 0;
            if (rollnofinder == students.get(i).getRollno()) {
                System.out.println("sorry cannot input same roll no");
                return 0;
            }
        }
        return rollnode;
    }

    public static void remoItem(String name) {
        int arryed = findArray(name);
        students.remove(arryed);
    }

    public static void modifyArray(String name, String newname) {
        ListIterator<Student> liststudent = students.listIterator();
       if (liststudent.hasNext()){
           Student next = liststudent.next();
           if (next.getName().equals(name)){
               liststudent.set(new Student(newname,next.getRollno()));
           }
       }

    }

    private static void printActions() {
        System.out.println("\n Available Actions:");
        System.out.println("0 - to shutdown\n" +
                "1 - to print Students\n" +
                "2 - to add Student\n" +
                "3 - to remove Student\n" +
                "4 - to modify Student\n");


    }
}
