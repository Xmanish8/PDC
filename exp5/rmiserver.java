import java.rmi.*;
import java.rmi.registry.*;

public class rmiserver {

    public static void main(String args[]) {

        try {

            // Create object
            two obj = new two();

            // Create RMI Registry on port 1099
            Registry reg = LocateRegistry.createRegistry(1099);

            // Bind object
            reg.rebind("palin", obj);

            System.out.println("Server is ready and waiting...");

        } catch (Exception e) {

            System.out.println("Exception : " + e);
        }
    }
}