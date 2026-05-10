import java.rmi.Naming;

public class Server {
    public static void main(String[] args) {
        try {
            Calculator calc = new CalculatorImpl();

            Naming.rebind("rmi://localhost/CalcService", calc);

            System.out.println("Server is ready...");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}