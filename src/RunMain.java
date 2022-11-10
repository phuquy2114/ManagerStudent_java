import main.ManagerStudent;
import utils.MenuUtils;
import utils.Validator;

import java.util.Scanner;

public class RunMain {

    /**
     * fun run main --> run before
     *
     * @param args
     */
    public static void main(String[] args) {
        System.out.println("main");
        Scanner scanner = new Scanner(System.in);
        ManagerStudent studentManager = new ManagerStudent();
        int i;
        do {
            MenuUtils.printMenu();

            do {
                i = Validator.getInt(scanner, "Choice: ");
                if ((i < 1) || (i > 6))
                    System.out.println("Enter a number from 1 to 6");
            } while ((i < 1) || (i > 6));

            switch (i) {
                case 1 -> {
                    studentManager.addStudent();
                    System.out.println();
                }
                case 2 -> {
                    studentManager.showAllStudentList();
                    System.out.println();
                }
                case 3 -> {
                    studentManager.sortStudentList();
                    System.out.println();
                }
                case 4 -> {
                    studentManager.showAllCourseList();
                    System.out.println();
                }
                case 5 -> {
                    String search = Validator.getString(scanner, "Enter ID or Name for search: ");
                    studentManager.searchStudent(search);
                    System.out.println();
                }
                case 6 -> System.out.println("Program is finished");
            }
        } while (i != 6);
    }
}
