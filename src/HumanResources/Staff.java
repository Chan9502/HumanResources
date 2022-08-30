package HumanResources;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

/**
 * class chưa thông tin cơ bản của all nhân viên k phân biệt Mangager or Employee
 * gồm: Mã NV, Tên NV, Tuổi NV, Hệ số lương, Ngày vào làm, Bộ phận làm việc, Số ngày nghỉ phép
 * thông tin được lấy và lưu ở DanhSach.TXT
 */
public abstract class Staff {
    String id,name;
    String inDate;
    String department;
    int age,vacationDates;
    float coeffSalary, totalSalary;

    //tạo hàm khởi tạo không tham số
    public Staff(){
    }

    //tạo hàm khởi tạo có tham số
    public Staff(String id, String name, int age, float coeffSalary, String inDate, String department,
                 int vacationDates, float totalSalary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.coeffSalary = coeffSalary;
        this.inDate = inDate;
        this.department = department;
        this.vacationDates = vacationDates;
        this.totalSalary = totalSalary;
    }

    //hàm toString hiển thị thông tin của nhân viên
    public void displayInformation(){
        System.out.printf(String.format("%-10s|%-16s|%-5s|%-10s|%-14s|%-15s|%-20s%-20.2f%n",
                id, name, age, coeffSalary, inDate,vacationDates, department,totalSalary));
    }

    //các phương thức getter và setter
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getCoeffSalary() {
        return coeffSalary;
    }

    public void setCoeffSalary(float coeffSalary) {
        this.coeffSalary = coeffSalary;
    }

    public String getInDate() {
        return inDate;
    }

    public void setInDate(String inDate) {
        this.inDate = inDate;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getVacationDates() {
        return vacationDates;
    }

    public void setVacationDates(int vacationDates) {
        this.vacationDates = vacationDates;
    }

    public float getTotalSalary() {
        return totalSalary;
    }

    public void setTotalSalary(float totalSalary) {
        this.totalSalary = totalSalary;
    }

    public int compare(Staff o){
        return this.id.compareTo(o.id);
    }


}
