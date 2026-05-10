import java.net.*;

public class InetAddressExample {
    public static void main(String[] args) {
        try {
            // 1. Local host
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Host Name: " + localHost.getHostName());
            System.out.println("Local Host IP: " + localHost.getHostAddress());

            // 2. Single website
            InetAddress google = InetAddress.getByName("www.google.com");
            System.out.println("\nGoogle Host Name: " + google.getHostName());
            System.out.println("Google IP: " + google.getHostAddress());

            // 3. Multiple IPs
            InetAddress[] microsoft = InetAddress.getAllByName("www.microsoft.com");
            System.out.println("\nAll IPs of Microsoft:");
            for (InetAddress ip : microsoft) {
                System.out.println(ip);
            }

        } catch (UnknownHostException e) {
            System.out.println("Error: " + e);
        }
    }
}