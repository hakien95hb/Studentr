package com.manager.student.entity;
import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
public class Student {
@Id
private int studentId;
@NotNull(message = "Not empty")
@Size(max = 50, min = 7, message = "Name is charset max 50, min 7")
    private String name;
    @Email(message = "email not format")
    private String email;
    private String password;
 @Size(min = 7, max = 7, message = "code 7")
    private String codeStudent;
    public int getId() {
        return studentId ;
    }

    public void setId(int id) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getCodeStudent() {
        return codeStudent;
    }

    public void setCodeStudent(String codeStudent) {
        this.codeStudent = codeStudent;
    }
}
