package controller;

import java.util.ArrayList;
import model.Student;

public class StudentManager {

    private final ArrayList<Student> studentList = new ArrayList<>();

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public Student findById(String studentId) {
        if (studentId == null || studentId.isEmpty()) {
            return null;
        }

        for (Student s : this.studentList) {
            if (s.getId().equalsIgnoreCase(studentId)) {
                return s;
            }
        }
        return null;
    }

    public boolean addStudent(Student student) {
        if (student == null || student.getId() == null) {
            return false;
        }
        if (findById(student.getId()) != null) {
            return false;
        }
        studentList.add(student);
        return true;
    }

    public boolean removeStudent(String studentId) {
        Student foundStudent = findById(studentId);

        if (foundStudent != null) {
            studentList.remove(foundStudent);
            return true;
        }
        return false;
    }

    public boolean updateStudent(String studentId, Student updateStudent) {
        Student foundStudent = findById(studentId);

        if (foundStudent != null) {
            int index = studentList.indexOf(foundStudent);
            studentList.set(index, updateStudent);
            return true;
        }
        return false;
    }
}
