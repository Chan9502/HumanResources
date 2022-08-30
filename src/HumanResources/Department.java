package HumanResources;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Chứa thông tin chung về bộ phận
 * mã bộ phận, tên bộ phận, số lượng nhân viên hiện tại
 * thông tin được lấy từ BoPhan.TXT
 */

public class Department {
    private String departName;
    private String departId;
    int departOfStaff = 0;

    public Department() {
    }

    public Department(String departId,String departName, int departOfStaff) {
        this.departName = departName;
        this.departId = departId;
        this.departOfStaff = departOfStaff;
    }
//  tính số lượng nhân viên hiện tại theo bộ phận


    //phương thức toString
    public String toString(){
        return String.format("%-15s|%-20s|%-10s%n",departId, departName, departOfStaff);
    }

    //các phương thức getter và setter
    public String getDepartName() {
        return departName;
    }

    public void setDepartName(String departName) {
        this.departName = departName;
    }

    public String getDepartId() {
        return departId;
    }

    public void setDepartId(String departId) {
        this.departId = departId;
    }

    public int getDepartOfStaff() {
        return departOfStaff;
    }

    public void setDepartOfStaff(int departOfStaff) {
        this.departOfStaff = departOfStaff;
    }
}
