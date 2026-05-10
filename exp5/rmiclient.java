import java.rmi.*;

public class rmiclient {

    public static void main(String args[]) {

        try {

            String s1 = "rmi://localhost/palin";

            one onex = (one) Naming.lookup(s1);

            int m = onex.palin("madam");

            System.out.println("Result : " + m);

            if (m == 1) {

                System.out.println("The given string is a Palindrome");

            } else {

                System.out.println("The given string is not a Palindrome");
            }

        } catch (Exception e) {

            System.out.println("Exception : " + e);
        }
    }
}