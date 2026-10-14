package Chapter7.inheritance;

/**
 * @author : themb
 * Project : Java-Advanced-Training
 * Date : 10/12/2026
 **/
public class Employee {
    private String empNum;
    private String Name;
    private String email;

    public employee(String empNum, String Name, String email){
        this.empNum = empNum;
        this.Name = Name;
        this.email = email;

    }

    public String getEmpNum() {
        return empNum;
    }

    public void setEmpNum(String empNum) {
        this.empNum = empNum;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
