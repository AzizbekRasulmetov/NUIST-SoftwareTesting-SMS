package cn.nuist.model;

import java.io.Serializable;

public class Student implements Serializable {

    private String id;
    private String studentName;

    private String major;

    public Student() {
    }

    public Student(String id, String studentName, String major) {
        this.id = id;
        this.studentName = studentName;
        this.major = major;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }


}
