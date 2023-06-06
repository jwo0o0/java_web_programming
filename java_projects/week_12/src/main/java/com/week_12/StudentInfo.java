package com.week_12;


import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class StudentInfo {
    //jsp 파일 입력폼의 속성 이름과 같게 해야 함
    @NotEmpty
    private String univ;
    private String dept;

    @NotEmpty
    private String name;

    @DecimalMin("19700000")
    @DecimalMax("20999999")
    private int stdid;

    @NotEmpty
    @Email
    private String email;

    public String getUniv() {
        return univ;
    }

    public void setUniv(String univ) {
        this.univ = univ;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStdid() {
        return stdid;
    }

    public void setStdid(int stdid) {
        this.stdid = stdid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
