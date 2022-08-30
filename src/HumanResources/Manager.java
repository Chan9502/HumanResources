package HumanResources;

/**
 * chứa thông tin của manager
 * là subClass của class Staff
 * Thuộc tính: chức danh
 */
public class Manager extends Staff implements ICalculator {
    private String positiontName; //chức danh
//  thuộc tính lương cơ bản, không thay đổi
    private final float BASEMANAGERSALARY = 5000000;

//  hàm khởi tạo không có tham số ngầm định
    public Manager(){}
    public Manager(String id, String name, int age, float coeffSalary, String inDate, String department,
                   int vacationDates, String positiontName,float ResponSalary) {

        super(id, name, age, coeffSalary, inDate, department, vacationDates, ResponSalary);
        this.positiontName = positiontName;
    }
//  hàm displayInformation hiển thị thông tin nhân viên
    @Override
    public void displayInformation() {
//        super.displayInformation();
        System.out.printf("%-10s|%-16s|%-5s|%-10s|%-14s|%-15s|%-20s|%-20s|%-20.2f%n",
                id, name, age, coeffSalary, inDate,vacationDates, department, positiontName, calculateSalary());
    }

//  các phương thức getter và setter
    public String getPositiontName() {
        return positiontName;
    }

    public void setPositiontName(String positiontName) {
        this.positiontName = positiontName;
    }

//  hàm tính lương cho manager, lương trách nhiệm được phân theo chức vụ khác nhau
    @Override
    public double calculateSalary() {
        float salaryByPosition;
        if(positiontName == "Business Leader"){
            salaryByPosition = 8000000;
        } else if (positiontName == "Project Leader") {
            salaryByPosition = 5000000;
        }else { //Technical Leader
            salaryByPosition = 6000000;
        }
//      công thức tính lương "Quản lý: Hệ số lương * 5,000,000 + lương trách nhiệm"
        return getCoeffSalary()*BASEMANAGERSALARY + salaryByPosition;
    }

}
