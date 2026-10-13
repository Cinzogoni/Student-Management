package view;

import controller.StudentManager;
import java.time.LocalDate;
import java.util.Scanner;
import model.Student;
import utils.Utils;

public class StudentIOHandler {

    private StudentManager studentManager;
    private Scanner scan;

    public StudentIOHandler() {
    }

    public StudentIOHandler(StudentManager studentManager, Scanner scan) {
        this.studentManager = studentManager;
        this.scan = scan;
    }

    public void handleAddStudent() {
        System.out.println("-----THEM HOC SINH-----");

        try {
            String studentId;
            while (true) {
                studentId = Utils.checkInputString("Nhap id hoc sinh: ", scan, "Aa", null);

                if (studentManager.findById(studentId) == null) {
                    break;
                }
                System.out.println("Id da ton tai!");
            }

            System.out.print("Nhap ten hoc sinh: ");
            String studentName = scan.nextLine().trim();

            LocalDate studentDOB = Utils.checkInputDOB("Nhap ngay sinh (dd/MM/yyyy): ",
                    scan, "dobA", null);

            System.out.print("Nhap so dien thoai hoc sinh: ");
            String studentPhone = scan.nextLine().trim();

            System.out.print("Nhap email hoc sinh: ");
            String studentEmail = scan.nextLine().trim();

            System.out.print("Nhap id lop: ");
            String studentClassId = scan.nextLine().trim();

            System.out.print("Nhap chuc vu hoc sinh: ");
            String studentRole = scan.nextLine().trim();

            double studentGpa = Utils.checkInputGPA("Nhap diem GPA (0.0 den 4.0): ",
                    scan, "GPAa", -1);

            Student student = new Student(studentClassId, studentRole, studentGpa, studentId, studentName, studentDOB, studentPhone, studentEmail);
            if (studentManager.addStudent(student)) {
                System.out.println("Them hoc sinh thanh cong!");
            } else {
                System.out.println("Them hoc sinh that bai!");
            }

        } catch (Exception e) {
            System.out.println("LOI: " + e.getMessage());
        }
    }

    public void handleRemoveStudent() {
        System.out.println("-----XOA HOC SINH-----");

        try {
            Student student;
            while (true) {
                String stuId = Utils.checkInputString("Nhap Id hoc sinh can xoa (Enter bo qua): ",
                        scan, "Bb", null);

                if (stuId == null) {
                    return;
                }

                student = studentManager.findById(stuId);
                if (student != null) {
                    break;
                }
                System.out.println("Khong tim thay Id hoc sinh nay!");
            }

            System.out.print("Ban co chac muon xoa hoc sinh nay (Y/N): ");
            String confirm = scan.nextLine().trim();
            if (confirm.equalsIgnoreCase("Y")) {
                if (studentManager.removeStudent(student.getId())) {
                    System.out.println("Xoa thanh cong!");
                } else {
                    System.out.println("Xoa that bai!");
                }
            } else {
                System.out.println("Da huy xoa!");
            }
        } catch (Exception e) {
            System.out.println("LOI: " + e.getMessage());
        }

    }

    public void handleUpdateStudent() {
        System.out.println("-----CAP NHAT HOC SINH-----");

        try {
            Student oldStudent;
            String stuId;
            while (true) {
                stuId = Utils.checkInputString("Nhap Id hoc sinh muon sua (Enter bo qua): ",
                        scan, "Bb", null);

                if (stuId == null) {
                    return;
                }

                oldStudent = studentManager.findById(stuId);
                if (oldStudent != null) {
                    break;
                }

                System.out.println("Khong tim thay Id hoc sinh nay!");

                String retry;
                while (true) {
                    System.out.print("Ban co muon nhap lai (Y/N): ");
                    retry = scan.nextLine().trim();

                    if (retry.equalsIgnoreCase("Y") || retry.equalsIgnoreCase("N")) {
                        break;
                    }
                    System.out.println("Vui long chi chon Y hoac N!");
                }

                if (retry.equalsIgnoreCase("N")) {
                    System.out.println("Da huy cap nhat!");
                    return;
                }
            }

            String newName = Utils.checkInputString("Nhap ten moi (Enter bo qua): ",
                    scan, "Cc", oldStudent.getName());

            LocalDate dob = Utils.checkInputDOB("Nhap ngay sinh moi (Enter bo qua): ",
                    scan, "dobB", oldStudent.getDob());

            String newPhone = Utils.checkInputString("Nhap so dien thoai moi (Enter bo qua): ",
                    scan, "Cc", oldStudent.getPhone());

            String newEmail = Utils.checkInputString("Nhap email moi (Enter bo qua): ",
                    scan, "Cc", oldStudent.getEmail());

            String newClassId = Utils.checkInputString("Nhap id lop moi (Enter bo qua): ",
                    scan, "Cc", oldStudent.getClassId());

            String newRole = Utils.checkInputString("Nhap chuc vu moi (Enter bo qua): ",
                    scan, "Cc", oldStudent.getStudentRole());

            double gpa = Utils.checkInputGPA("Nhap diem GPA moi (Enter bo qua): ",
                    scan, "GPAb", oldStudent.getGpa());

            Student student = new Student(newClassId, newRole, gpa, oldStudent.getId(), newName, dob, newPhone, newEmail);
            if (studentManager.updateStudent(oldStudent.getId(), student)) {
                System.out.println("Cap nhat thanh cong!");
            } else {
                System.out.println("Cap nhat that bai!");
            }

        } catch (Exception e) {
            System.out.println("LOI: " + e.getMessage());
        }

    }

    public void handleSearchStudent() {
        System.out.println("-----TIM KIEM HOC SINH THEO ID-----");

        String stuId = Utils.checkInputString("Nhap id hoc sinh muon tim: ",
                scan, "Bb", null);

        if (stuId == null) {
            return;
        }

        Student student = studentManager.findById(stuId);
        if (student != null) {
            System.out.println("Ket qua tim kiem");
            System.out.println(student);
        } else {
            System.out.println("Khong tim thay hoc sinh co id: " + stuId);
        }

    }
}
