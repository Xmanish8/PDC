import java.awt.*;
import java.awt.event.*;

class StudentMarksEntry extends Frame implements ActionListener {

    TextField[] marksFields;
    Button submit;

    public StudentMarksEntry() {
        setLayout(new GridLayout(6, 2));
        setTitle("Student Marks Entry");
        setSize(400, 300);

        marksFields = new TextField[5];

        for (int i = 0; i < 5; i++) {
            add(new Label("Subject " + (i + 1) + " Marks: "));
            marksFields[i] = new TextField(10);
            add(marksFields[i]);
        }

        submit = new Button("Submit");
        submit.addActionListener(this);
        add(submit);

        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        int total = 0;
        boolean pass = true;

        try {
            for (TextField field : marksFields) {
                int marks = Integer.parseInt(field.getText());
                total += marks;

                if (marks < 35) {
                    pass = false;
                }
            }

            float percentage = total / 5.0f;

            new ResultWindow(total, percentage, pass);

        } catch (Exception ex) {
            System.out.println("Please enter valid numeric marks!");
        }
    }

    // 🔵 Result Window
    class ResultWindow extends Frame {
        public ResultWindow(int total, float percentage, boolean pass) {
            setLayout(new FlowLayout());
            setTitle("Result");
            setSize(250, 150);

            add(new Label("Total: " + total));
            add(new Label("Percentage: " + percentage + "%"));

            if (pass) {
                add(new Label("Result: PASS"));
            } else {
                add(new Label("Result: FAIL"));
            }

            setVisible(true);
        }
    }

    public static void main(String[] args) {
        new StudentMarksEntry();
    }
}