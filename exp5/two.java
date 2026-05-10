import java.rmi.*;
import java.rmi.server.*;

public class two extends UnicastRemoteObject implements one {

    public two() throws RemoteException {

        super();
    }

    public int palin(String a) throws RemoteException {

        System.out.println("Hello");

        String str1 = a;

        System.out.println("Original String : " + str1);

        String str2 = new StringBuilder(a).reverse().toString();

        System.out.println("Reversed String : " + str2);

        int b = str1.compareTo(str2);

        System.out.println("Compare Result : " + b);

        if (b == 0)
            return 1;
        else
            return 0;
    }
}