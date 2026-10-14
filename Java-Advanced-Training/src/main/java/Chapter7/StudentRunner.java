package Chapter7;

/**
 * @author : themb
 * Project : Java-Advanced-Training
 * Date : 10/12/2026
 **/
public class StudentRunner {
    public static void main(){
        Student objSiya = new Student("123456", "Siya", "Ntlati", "Siya@mail.com");
        objSiya.setAssessments(70,30,100);
        //objSiya.setFirstName("Siya");
        //objSiya.setLastName("Ntlati");

        objSiya.display();
    }

}
