package view;

import controller.StudentManager;
import java.util.Scanner;
import model.Student;

public class MenuView {

    private static void displayAllStudent(StudentManager studentManager) {
        if (studentManager.getStudentList().isEmpty()) {
            System.out.println("Danh sach rong!");
            return;
        }

        System.out.println("===== DANH SACH HOC SINH =====");
        for (Student s : studentManager.getStudentList()) {
            System.out.println(s);
        }
    }

    private static void printMenu() {
        System.out.println("===== QUAN LY HOC SINH =====");
        System.out.println("1.Them hoc sinh");
        System.out.println("2.Xoa hoc sinh");
        System.out.println("3.Sua thong tin hoc sinh");
        System.out.println("4.Tim kiem hoc sinh theo id");
        System.out.println("5.Hien thi danh sach hoc sinh");
        System.out.println("0.Thoat chuong trinh");
        System.out.print("Nhap lua chon: ");
    }

    public static void runView() {
        Scanner scan = new Scanner(System.in);
        StudentManager stuManager = new StudentManager();
        StudentIOHandler stuIOHandler = new StudentIOHandler(stuManager, scan);
        boolean running = true;

        while (running) {
            printMenu();
            String choice = scan.nextLine().trim();

            switch (choice) {
                case "1":
                    stuIOHandler.handleAddStudent();
                    break;
                case "2":
                    stuIOHandler.handleRemoveStudent();
                    break;
                case "3":
                    stuIOHandler.handleUpdateStudent();
                    break;
                case "4":
                    stuIOHandler.handleSearchStudent();
                    break;
                case "5":
                    displayAllStudent(stuManager);
                    break;
                case "0":
                    running = false;
                    System.out.println("Tam biet!");
                    break;
                default:
                    System.out.println("Lua chon chua hop le. Moi nhap lai!");
            }
        }
    }
}
