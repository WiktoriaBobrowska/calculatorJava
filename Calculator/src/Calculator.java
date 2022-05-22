
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Calculator {
    private JFrame f = new JFrame("Calculator");
    private JLabel l1 = new JLabel("Test");
    private TextArea t1 = new TextArea();
    private Point point = new Point(20, 140);
    private JButton[] buttons_number = new JButton[10];
    private JButton[] buttons_operation = new JButton[7];
    String operation;
    int buttW = 80;
    int buttH = 50;
    double res, num;
    private void setALLButtons() {

        for (int i = 0; i < buttons_number.length; i++) {
            buttons_number[i] = new JButton(String.valueOf(i));
            buttons_number[i].setSize(buttW, buttH);
            buttons_number[i].setVisible(true);
            buttons_number[i].setFont(new Font("Helvetica", Font.BOLD, 25));
            buttons_number[i].addActionListener(listener);
            f.add(buttons_number[i]);
        }
        buttons_operation[0] = new JButton("+");
        buttons_operation[1] = new JButton("-");
        buttons_operation[2] = new JButton("*");
        buttons_operation[3] = new JButton("/");
        buttons_operation[4] = new JButton("=");
        buttons_operation[5] = new JButton("C"); //C as clear
        buttons_operation[6] = new JButton(".");

        for (int i = 0; i < buttons_operation.length; i++) {
            buttons_operation[i].setSize(buttW, buttH);
            buttons_operation[i].setVisible(true);
            if(i==0) buttons_operation[i].addActionListener(add);
            else if (i==1) buttons_operation[i].addActionListener(subtraction);
            else if(i==2)buttons_operation[i].addActionListener(multiplication);
            else if(i==3)    buttons_operation[i].addActionListener(division);
            else if (i == 4) buttons_operation[i].addActionListener(resultListener);
            else if (i == 5) buttons_operation[i].addActionListener(clear);
            else buttons_operation[i].addActionListener(listener);
            buttons_operation[i].setFont(new Font("Helvetica", Font.BOLD, 25));
            f.add(buttons_operation[i]);
        }
        buttons_number[7].setLocation(point); //7
        buttons_number[8].setLocation(point.x + buttW, point.y);//8
        buttons_number[9].setLocation(point.x + 2 * buttW, point.y); //9
        buttons_number[4].setLocation(point.x, point.y + buttH); //4
        buttons_number[5].setLocation(point.x + buttW, point.y + buttH); //5
        buttons_number[6].setLocation(point.x + 2 * buttW, point.y + buttH); //6
        buttons_number[1].setLocation(point.x, point.y + 2 * buttH); //1
        buttons_number[2].setLocation(point.x + buttW, point.y + 2 * buttH); //2
        buttons_number[3].setLocation(point.x + 2 * buttW, point.y + 2 * buttH); //3
        buttons_number[0].setLocation(point.x, point.y + 3 * buttH); //0
        buttons_operation[6].setLocation(point.x + buttW, point.y + 3 * buttH); //.
        buttons_operation[5].setLocation(point.x + 2 * buttW, point.y + 3 * buttH); //c
        buttons_operation[0].setLocation(point.x + 3 * buttW, point.y); //+
        buttons_operation[1].setLocation(point.x + 3 * buttW, point.y + buttH); //-
        buttons_operation[2].setLocation(point.x + 3 * buttW, point.y + 2 * buttH); // *
        buttons_operation[3].setLocation(point.x + 3 * buttW, point.y + 3 * buttH); // /
        buttons_operation[4].setSize(4 * buttW, buttH);
        buttons_operation[4].setLocation(point.x, point.y + 4 * buttH); //=
    }
    private void do_maths(){
        switch (operation) {
            case "addition" -> {
                res = num + Double.parseDouble(t1.getText());
                t1.setText(Double.toString(res));
            }
            case "subtraction" -> {
                res = num - Double.parseDouble(t1.getText());
                t1.setText(Double.toString(res));
            }
            case "multiplication" -> {
                res = num * Double.parseDouble(t1.getText());
                t1.setText(Double.toString(res));
            }
            case "division" -> {
                res = num / Double.parseDouble(t1.getText());
                t1.setText(Double.toString(res));
            }
        }
    }
    ActionListener listener = e -> {
        if (e.getSource() instanceof JButton) {
            String buttonText = e.getActionCommand();
            t1.append(buttonText);
        }
    };
    ActionListener clear = e -> {
        if (e.getSource() instanceof JButton) {
            t1.setText("");
        }
    };
    ActionListener subtraction = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
               num = Double.parseDouble(t1.getText());
               operation = "subtraction";
               t1.setText("");
               l1.setText(num + "-");
            }
    };
    ActionListener add = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
                num = Double.parseDouble(t1.getText());
                operation = "addition";
                t1.setText("");
                l1.setText(num + "+");
        }
    };
    ActionListener division = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            num = Double.parseDouble(t1.getText());
            operation = "division";
            t1.setText("");
            l1.setText(num + "/");
        }
    };
    ActionListener multiplication = new ActionListener() {
        public void actionPerformed(ActionEvent e) {
            num = Double.parseDouble(t1.getText());
            operation = "multiplication";
            t1.setText("");
            l1.setText(num + "*");
        }
    };
    ActionListener resultListener = e -> {
        if (e.getSource() instanceof JButton) {
            do_maths();
            l1.setText("");
        }
    };
/* String res_ = t1.getText();
                l1.setText(res_);
                t1.setText("");
                operation = "addition";*/
    private void setTextArea () {
        t1.setSize(320, 80);
        t1.setEditable(false);
        t1.setLocation(point.x, point.y-t1.getHeight()-10);
        t1.setFont(new Font("Helvetica", Font.BOLD, 25));
        t1.setVisible(true);
        f.add(t1);
    }

    private void setLabel(){
        l1.setSize(300, 40);
        l1.setLocation(point.x+3 * buttW +20, 5);
        l1.setFont(new Font("Helvetica", Font.PLAIN, 15));
        l1.setVisible(true);
        f.add(l1);
    }
    private void setFrame () {
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        f.setLayout(null);
        f.setSize(400, 480);
        f.setVisible(true);
        f.setResizable(false);
        setTextArea();
        setLabel();
        setALLButtons();


    }

        public Calculator() {
                setFrame();
            }

}
