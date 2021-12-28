package com.example.spring_test.model.entity;

public class hw3_data {
    private String empno;
    private String ename;
    private String job;
    private String mgr;
    private String salary;
    private String deptno;

    public hw3_data() {
    }

    public hw3_data(String empno, String ename, String job, String mgr, String salary, String deptno) {
        this.empno = empno;
        this.ename = ename;
        this.job = job;
        this.mgr = mgr;
        this.salary = salary;
        this.deptno = deptno;
    }

    public String getEmpno() {
        return empno;
    }

    public void setEmpno(String empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public String getMgr() {
        return mgr;
    }

    public void setMgr(String mgr) {
        this.mgr = mgr;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getDeptno() {
        return deptno;
    }

    public void setDeptno(String deptno) {
        this.deptno = deptno;
    }
}
