package Chapter7;

/**
 * @author : themb
 * Project : Java-Advanced-Training
 * Date : 10/12/2026
 **/
public class Student {
    private String stuNum;
    private String FirstName;
    private String LastName;
    private String StuEmail;
    private int testMark, assignment1, assignment2;

    /**
     * construct an object of student with attributes
     * @param stuNum student number
     * @param FirstName first name
     * @param LastName last name
     * @param stuEmail email
     */
    public Student(String stuNum, String FirstName, String LastName, String stuEmail){
        setStuNum(stuNum);
        setLastName(LastName);
        setFirstName(FirstName);
        setStuEmail(stuEmail);
    }

    /**
     * set student number
     * @param stuNum student number
     */

    public void setStuNum(String stuNum){
        this.stuNum = "ST-26"+stuNum;
    }

    /**
     * set first name
     * @param FirstName first name
     */

    public void setFirstName(String FirstName){
        this.FirstName = FirstName;
    }

    /**
     * set last name
     * @param lastName last name
     */

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    /**
     * set email address
     * @param stuEmail email address
     */

    public void setStuEmail(String stuEmail) {
        StuEmail = stuEmail;
    }

    //public void setTestMark(int testMark) {
    //    this.testMark = testMark;
    //}

    //public void setAssignment1(int assignment1) {
     //   this.assignment1 = assignment1;
    //}

    //public void setAssignment2(int assignment2) {
    //    this.assignment2 = assignment2;
    //}

    //here is a method that can set all of them at the same time
    public void setAssessments(int test, int Assignment1, int Assignment2) {
        this.testMark = test;
        this.assignment1 = assignment1;
        this.assignment2 = assignment2;
    }

    public String getStuNum(){
        return stuNum;
    }

    public String getName(){
        return FirstName + " " + LastName;
    }

    public String getEmail(){
        return StuEmail;
    }

    public double getSemMark(){
        //test * 40%, Assignment1 * 30%, Assignment2 * 30%
        return (testMark * 0.4) + (assignment1 * 0.35) + (assignment2 * 0.25);
    }

    public void display(){
        System.out.println("Student#: " + getStuNum());
        System.out.println("Name: " + getName());
        System.out.println("Email: " + getEmail());
        System.out.println("Student#: " + getStuNum());
    }
}
