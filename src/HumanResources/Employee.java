package HumanResources;

/**
 * hàm chứa thông tin của nhân viên
 * là Subclass của class Staff
 * có thuộc tính: số h tăng ca
 */
public class Employee extends Staff implements ICalculator{
    private float overTime;
    private final int BASEEMPLOSALARY = 3000000;
    private final int BASEOVERTIMESALARY = 200000;
//  hàm khởi tạo không có tham số
    public Employee(){};
//  hàm khởi tạo có tham số
    public Employee(String id, String name, int age, float coeffSalary, String inDate, String department,
                    int vacationDates,  float overTime, float salary) {

        super(id, name, age, coeffSalary, inDate, department, vacationDates, salary);
        this.overTime = overTime;
    }

//  hàm displayInformation()
    @Override
    public void displayInformation() {
//        super.displayInformation();
        System.out.printf("%-10s|%-16s|%-5s|%-10s|%-14s|%-15s|%-20s|%-20s|%-20.2f%n",
                id, name, age, coeffSalary, inDate,vacationDates, department, overTime, calculateSalary());
    }

//  các phương thức getter và setter
    public float getOverTime() {
        return overTime;
    }
    public void setOverTime(float overTime) {
        this.overTime = overTime;
    }


//  công thức tính lương nhân viên: Hệ số lương * 3,000,000 + số giờ làm thêm * 200,000
    @Override
    public double calculateSalary() {
        return (getCoeffSalary()*BASEEMPLOSALARY) + (getOverTime()*BASEOVERTIMESALARY);
    }

}
