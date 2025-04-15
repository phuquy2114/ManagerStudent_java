package main;

import model.Student;
import utils.Validator;

import java.util.*;

public class ManagerStudent {
    // variable
    public static List<Student> studentList = new ArrayList<>();

    public ManagerStudent() {
    }

    public Student inputStudent(List<Student> studentList) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter Student Information:");
        Student student = new Student();
        boolean checkID;
        do {
            checkID = true;
            student.setId(Validator.getString(scanner, "Student ID: "));

            for (Student st : studentList) {
                if (st.getId().equalsIgnoreCase(student.getId())) {
                    System.out.println("The ID is available");
                    checkID = false;
                    break;
                }
            }
        } while (!checkID);

        student.setName(Validator.getString(scanner, "Name: "));
        student.setAge(Validator.getInt(scanner, "Age: "));
        student.setAddress(Validator.getString(scanner, "Address: "));
        scanner.nextLine(); // hai kieu du lieu dang trinh tu voi nhau
        student.setCourse(Validator.getString(scanner, "Course: "));
        student.setMediumScore(Validator.getFloat(scanner, "Medium Score: "));
        return student;
    }

    public void addStudent() {
        studentList.add(inputStudent(studentList));
    }

    public void showAllStudentList() {
        System.out.println("Show All Student List:");
        for (int i = 0; i < studentList.size(); i++) {
            Student st = studentList.get(i);
            System.out.println("----------------");
            System.out.println("ID " + st.getId());
            System.out.println("Name " + st.getName());
            System.out.println("Age " + st.getAge());
            System.out.println("Address " + st.getAddress());
            System.out.println("Course " + st.getCourse());
            System.out.println("Medium Score " + st.getMediumScore());
        }
    }

    public void sortStudentList() {
        System.out.println("Sort Student List by Medium Score Gradual:");
        List<Student> list1 = new ArrayList<>(studentList);

        // sap xep theo String
        Collections.sort(list1, new Comparator<Student>() {
            @Override
            public int compare(Student st1, Student st2) {
                return st1.getName().compareToIgnoreCase(st2.getName());
            }
        });

        // sap sep theo number
        Collections.sort(list1, new Comparator<Student>() {
            @Override
            public int compare(Student st1, Student st2) {
                if (st1.getMediumScore() > st2.getMediumScore())
                    return 1;
                else if (st1.getMediumScore() < st2.getMediumScore())
                    return -1;
                else
                    return 0;
            }
        });
    }

    public void showAllCourseList() {
        System.out.println("Show All Course List:");
        List<String> courseList = new ArrayList<>();

        for (Student st : studentList) {
            if (!courseList.contains(st.getCourse()))
                courseList.add(st.getCourse());
        }

        Collections.sort(courseList);

        for (String course : courseList)
            System.out.println(course);
    }

    public void searchCourse(String course) {
        System.out.println("Search Course of the Students");
        course = course.toLowerCase();
        int d = 0;

        for (Student st : studentList) {
            String courseData = st.getCourse().toLowerCase();
            if ((courseData.contains(course))) {
                outputStudent(st);
                d++;
            }
        }

        if (d == 0)
            System.out.println("No matching results were found");
    }

    public void searchStudent(String search) {
        System.out.println("Search Student by ID or Name:");
        search = search.toLowerCase();
        int d = 0;

        for (Student st : studentList) {
            String id = st.getId().toLowerCase();
            String name = st.getName().toLowerCase();
            if ((id.contains(search)) || (name.contains(search))) {
                outputStudent(st);
                d++;
            }
        }

        if (d == 0)
            System.out.println("No matching results were found");
    }

    public void outputStudent(Student st) {
        System.out.println("----------------");
        System.out.println("ID " + st.getId());
        System.out.println("Name " + st.getName());
        System.out.println("Age " + st.getAge());
        System.out.println("Address " + st.getAddress());
        System.out.println("Course " + st.getCourse());
        System.out.println("Medium Score " + st.getMediumScore());
    }
}
