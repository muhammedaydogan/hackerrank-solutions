package java_priority_queue;
import java.io.*;
import java.util.*;

public class Solution {

  public static void main(String[] args) {
    /*
     * Enter your code here. Read input from STDIN. Print output to STDOUT. Your
     * class should be named Solution.
     */
    List<String> events = new LinkedList<String>();
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    in.nextLine();
    while (n-- > 0) {
      String event = in.nextLine();
      events.add(event);
    }

    Priorities priorities = new Priorities();
    List<Student> students = priorities.getStudents(events);

    // System.out.println(students.size());
    for (int i = students.size() - 1; i >= 0; i--) {
      System.out.println(students.get(i).getName());
    }

    if (students.size() == 0) {
      System.out.println("EMPTY");
    }

    in.close();
  }

}

class Priorities {

  List<Student> students;

  public Priorities() {
    students = new ArrayList<Student>();
  }

  List<Student> getStudents(List<String> events) {
    for (String event : events) {
      // System.out.print(students.size() + ":");
      String[] splitted = event.split(" ");
      if (splitted[0].equals("SERVED")) {
        // System.out.print("*");
        if (students.size() > 0) {
          students.remove(students.size() - 1);
        }
      } else if (splitted[0].equals("ENTER")) {
        // System.out.print("/");
        Student student = new Student(Integer.parseInt(splitted[3]), splitted[1], Double.valueOf(splitted[2]));
        int indexToAdd = -1;
        for (int i = 0; i < students.size(); i++) {
          Student current = students.get(i);
          if (student.getCgpa() > current.getCgpa()) {
            continue;
          } else if (student.getCgpa() < current.getCgpa()) {
            // students.add(i, student);
            indexToAdd = i;
            break;
          } else {
            int compare = student.getName().compareTo(current.getName());
            // System.out.print(student.getName() + compare + ">");
            if (compare < 0) {
              continue;
            } else if (compare > 0) {
              // students.add(i, student);
              indexToAdd = i;
              break;
            } else {
              if (student.getId() > current.getId()) {
                continue;
              } else if (student.getId() < current.getId()) {
                // students.add(i, student);
                indexToAdd = i;
                break;
              } else {
                // students.add(i, student);
                indexToAdd = i;
                break;
              }
            }
          }
        }
        if (students.size() == 0) {
          students.add(student);
        } else if (indexToAdd == -1) {
          students.add(student);
        } else {
          students.add(indexToAdd, student);
        }
      }
      // list();
      // System.out.println();
    }

    return students;
  }

  void list() {
    for (int i = 0; i < students.size(); i++) {
      System.out.print(" " + students.get(i).getName());
    }
  }
}

class Student {
  private int id;
  private String name;
  private double cgpa;

  public Student(int id, String name, double cgpa) {
    this.id = id;
    this.name = name;
    this.cgpa = cgpa;
  }

  public int getId() {
    return id;
  }

  public String getName() {
    return name;
  }

  public double getCgpa() {
    return cgpa;
  }
}