# Advanced Java Programming (AJP)
# Fully Functional Experiment Tutorials

---

---

# Experiment No. 1
# Key Status Applet Program

## Aim
Write a program to demonstrate status of keys on an Applet window such as KeyPressed, KeyReleased, KeyTyped.

---

# STEP 1: Open CMD

Press:

Windows + R → type cmd → Enter

---

# STEP 2: Go to Working Folder

```bash
cd C:\Users\Dell\Downloads
```

---

# STEP 3: Create Java File

Create:

```text
KeyStatusApplet.java
```

---

# STEP 4: Paste Java Code

```java
import java.applet.Applet;
import java.awt.*;
import java.awt.event.*;

/* <applet code="KeyStatusApplet" width=400 height=300></applet> */

public class KeyStatusApplet extends Applet implements KeyListener {

    String msg = "Click here and press any key";

    public void init() {
        setBackground(Color.lightGray);
        addKeyListener(this);
    }

    public void keyPressed(KeyEvent ke) {
        msg = "Key Down : " + ke.getKeyChar();
        repaint();
    }

    public void keyReleased(KeyEvent ke) {
        msg = "Key Released : " + ke.getKeyChar();
        repaint();
    }

    public void keyTyped(KeyEvent ke) {
        msg = "Key Typed : " + ke.getKeyChar();
        repaint();
    }

    public void paint(Graphics g) {
        g.setColor(Color.blue);
        g.setFont(new Font("Arial", Font.BOLD, 16));
        g.drawString(msg, 80, 150);
    }
}
```

---

# STEP 5: Create HTML File

Create:

```text
KeyApplet.html
```

Paste:

```html
<html>
<body>

<applet code="KeyStatusApplet" width="400" height="300">
</applet>

</body>
</html>
```

---

# STEP 6: Delete Old Class File

```bash
del KeyStatusApplet.class
```

---

# STEP 7: Compile Using JDK 8

```bash
"C:\Program Files\Java\jdk1.8.0_491\bin\javac.exe" KeyStatusApplet.java
```

---

# STEP 8: Run Applet

```bash
"C:\Program Files\Java\jdk1.8.0_491\bin\appletviewer.exe" KeyApplet.html
```

---

# Output

```text
Key Down : A
Key Released : A
Key Typed : A
```



---


# Experiment No. 2
# AWT Mouse Event Program

## STEP 1

```bash
cd C:\Users\Dell\Downloads
```

---

## STEP 2

Create:

```text
MouseEventDemo.java
```

---

## STEP 3: Paste Code

```java
import java.awt.*;
import java.awt.event.*;

public class MouseEventDemo extends Frame implements MouseListener {

    public MouseEventDemo() {

        setTitle("AWT Mouse Event Demo");
        setSize(400, 300);

        addMouseListener(this);

        setVisible(true);
    }

    public void mouseClicked(MouseEvent e) {
        System.out.println("Mouse Clicked at X: " + e.getX() +
                " Y: " + e.getY());
    }

    public void mouseEntered(MouseEvent e) {
        System.out.println("Mouse Entered");
        setBackground(Color.GREEN);
    }

    public void mouseExited(MouseEvent e) {
        System.out.println("Mouse Exited");
        setBackground(Color.LIGHT_GRAY);
    }

    public void mousePressed(MouseEvent e) { }

    public void mouseReleased(MouseEvent e) { }

    public static void main(String[] args) {
        new MouseEventDemo();
    }
}
```

---

## STEP 4: Compile

```bash
javac MouseEventDemo.java
```

---

## STEP 5: Run

```bash
java MouseEventDemo
```



---


# Experiment No. 5
# RMI Palindrome Program

## STEP 1

```bash
cd C:\Users\Dell\Downloads
```

---

## STEP 2: Create Files

```text
one.java
two.java
rmiserver.java
rmiclient.java
```

---

## one.java

```java
import java.rmi.*;

public interface one extends Remote {

    public int palin(String a) throws RemoteException;
}
```

---

## two.java

```java
import java.rmi.*;
import java.rmi.server.*;

public class two extends UnicastRemoteObject implements one {

    public two() throws RemoteException {
        super();
    }

    public int palin(String a) throws RemoteException {

        String original = a;

        String reversed =
                new StringBuilder(a).reverse().toString();

        if (original.equals(reversed))
            return 1;
        else
            return 0;
    }
}
```

---

## rmiserver.java

```java
import java.rmi.*;

public class rmiserver {

    public static void main(String args[]) {

        try {

            two obj = new two();

            Naming.rebind("rmi://localhost/palin", obj);

            System.out.println("Server is ready...");

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}
```

---

## rmiclient.java

```java
import java.rmi.*;

public class rmiclient {

    public static void main(String args[]) {

        try {

            one obj =
                    (one) Naming.lookup("rmi://localhost/palin");

            int result = obj.palin("madam");

            if (result == 1)
                System.out.println("Palindrome");
            else
                System.out.println("Not Palindrome");

        } catch (Exception e) {

            System.out.println(e);
        }
    }
}
```

---

## STEP 3: Compile

```bash
javac *.java
```

---

## STEP 4: Start Registry

```bash
start rmiregistry
```

---

## STEP 5: Run Server

```bash
java rmiserver
```

---

## STEP 6: Run Client

Open NEW CMD:

```bash
cd C:\Users\Dell\Downloads
java rmiclient
```

---

## Output

```text
Palindrome
```



---


# Experiment No. 7
# RMI Calculator Program

## Files Required

```text
Calculator.java
CalculatorImpl.java
Server.java
Client.java
policy.txt
```

---

## Calculator.java

```java
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Calculator extends Remote {

    int add(int a, int b) throws RemoteException;
}
```

---

## CalculatorImpl.java

```java
import java.rmi.server.UnicastRemoteObject;
import java.rmi.RemoteException;

public class CalculatorImpl extends UnicastRemoteObject
        implements Calculator {

    protected CalculatorImpl() throws RemoteException {
        super();
    }

    public int add(int a, int b)
            throws RemoteException {

        return a + b;
    }
}
```

---

## Server.java

```java
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
```

---

## Client.java

```java
import java.rmi.Naming;

public class Client {

    public static void main(String[] args) {

        try {

            Calculator calc =
                    (Calculator) Naming.lookup(
                            "rmi://localhost/CalcService");

            int result = calc.add(10, 20);

            System.out.println(
                    "Result from server : " + result);

        } catch (Exception e) {

            e.printStackTrace();
        }
    }
}
```

---

## policy.txt

```text
grant {

    permission java.security.AllPermission;

};
```

---

## Compile

```bash
javac *.java
```

---

## Start Registry

```bash
start rmiregistry
```

---

## Run Server

```bash
java -Djava.security.policy=policy.txt Server
```

---

## Run Client

```bash
java -Djava.security.policy=policy.txt Client
```

---

## Output

```text
Result from server : 30
```



---


# Experiment No. 9
# Simple JSP Program

## STEP 1: Set JAVA_HOME

```bash
set JAVA_HOME=C:\Program Files\Java\jdk-25
```

---

## STEP 2: Start Tomcat

```bash
cd C:\Users\Dell\Downloads\apache-tomcat-9.0.117\bin
startup.bat
```

---

## STEP 3: Create JSP File

Location:

```text
C:\Users\Dell\Downloads\apache-tomcat-9.0.117\webapps\ROOT
```

Create:

```text
index.jsp
```

---

## Paste Code

```jsp
<%@ page language="java" contentType="text/html; charset=UTF-8" %>

<!DOCTYPE html>
<html>
<head>
    <title>Simple JSP Page</title>
</head>

<body>

<h1>Welcome to JSP!</h1>

<p>This is a simple message displayed using JSP.</p>

</body>
</html>
```

---

## Run

Open browser:

```text
http://localhost:8080/index.jsp
```



---


# Experiment No. 10
# Servlet Calculator Program

## STEP 1: Start Tomcat

```bash
set JAVA_HOME=C:\Program Files\Java\jdk-25
```

```bash
cd C:\Users\Dell\Downloads\apache-tomcat-9.0.117\bin
startup.bat
```

---

## STEP 2: Create Project Folder

```text
CalculatorApp
```

inside:

```text
webapps
```

---

## Folder Structure

```text
CalculatorApp
 ├── index.html
 └── WEB-INF
      ├── web.xml
      └── classes
```

---

## index.html

```html
<!DOCTYPE html>
<html>
<head>
    <title>Calculator</title>
</head>
<body>

<h2>Simple Calculator</h2>

<form action="calculate" method="post">

Enter First Number:
<input type="text" name="num1"><br><br>

Enter Second Number:
<input type="text" name="num2"><br><br>

<select name="operation">
<option value="add">Addition</option>
<option value="subtract">Subtraction</option>
<option value="multiply">Multiply</option>
<option value="divide">Divide</option>
</select>

<br><br>

<input type="submit" value="Calculate">

</form>

</body>
</html>
```

---

## CalculatorServlet.java

```java
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;

public class CalculatorServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request,
                          HttpServletResponse response)
            throws ServletException, IOException {

        response.setContentType("text/html");

        PrintWriter out = response.getWriter();

        double num1 =
                Double.parseDouble(request.getParameter("num1"));

        double num2 =
                Double.parseDouble(request.getParameter("num2"));

        String operation =
                request.getParameter("operation");

        double result = 0;

        switch(operation) {

            case "add":
                result = num1 + num2;
                break;

            case "subtract":
                result = num1 - num2;
                break;

            case "multiply":
                result = num1 * num2;
                break;

            case "divide":
                result = num2 != 0 ? num1 / num2 : 0;
                break;
        }

        out.println("<h2>Result : " + result + "</h2>");
    }
}
```

---

## Compile Servlet

```bash
javac -cp "C:\Users\Dell\Downloads\apache-tomcat-9.0.117\lib\servlet-api.jar" CalculatorServlet.java
```

---

## Move Class File

Move:

```text
CalculatorServlet.class
```

into:

```text
WEB-INF\classes
```

---

## web.xml

```xml
<web-app>

<servlet>
    <servlet-name>calc</servlet-name>
    <servlet-class>CalculatorServlet</servlet-class>
</servlet>

<servlet-mapping>
    <servlet-name>calc</servlet-name>
    <url-pattern>/calculate</url-pattern>
</servlet-mapping>

</web-app>
```

---

## Run Application

Open browser:

```text
http://localhost:8080/CalculatorApp/index.html
```

---

# END OF AJP EXPERIMENT TUTORIALS

