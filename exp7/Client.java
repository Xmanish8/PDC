import java.rmi.Naming;

public class Client {
    public static void main(String[] args) {
        try {
            Calculator calc = (Calculator) Naming.lookup("rmi://localhost/CalcService");

            int result = calc.add(10, 20);
//java -Djava.security.policy=policy.txt Client
//java -Djava.security.policy=policy.txt Server
            System.out.println("Result from server: " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}