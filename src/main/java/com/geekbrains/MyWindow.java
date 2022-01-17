package com.geekbrains;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class MyWindow extends JFrame {
    private boolean textNeedStart = false;
    private Calculator calculator = new Calculator();

    public MyWindow() {


        setTitle("Calculator");
        setBounds(2000, 300, 400, 400);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        JTextField field = new JTextField();
        add(field, BorderLayout.NORTH);
        JButton clearButton = new JButton("Clear");
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                calculator.reset();
                field.setText("");
                textNeedStart = true;
            }
        });
        add(clearButton, BorderLayout.SOUTH);


        JPanel panel = new JPanel(new GridLayout(4, 4));
        add(panel, BorderLayout.CENTER);


        JButton[] buttons = new JButton[16];

        buttons[0] = new JButton("1");
        buttons[0].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printToField(field, "1");
            }
        });
        buttons[1] = new JButton("2");
        buttons[1].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printToField(field, "2");
            }
        });
        buttons[2] = new JButton("3");
        buttons[2].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printToField(field, "3");
            }
        });
        buttons[3] = new JButton("/");
        buttons[3].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationCalculate(field, Calculator.Operation.DIVIDE);
            }
        });
        buttons[4] = new JButton("4");
        buttons[4].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printToField(field, "4");
            }
        });
        buttons[5] = new JButton("5");
        buttons[5].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printToField(field, "5");
            }
        });
        buttons[6] = new JButton("6");
        buttons[6].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printToField(field, "6");
            }
        });
        buttons[7] = new JButton("*");
        buttons[7].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationCalculate(field, Calculator.Operation.MULTIPLY);
            }
        });
        buttons[8] = new JButton("7");
        buttons[8].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printToField(field, "7");
            }
        });
        buttons[9] = new JButton("8");
        buttons[9].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printToField(field, "8");
            }
        });
        buttons[10] = new JButton("9");
        buttons[10].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printToField(field, "9");
            }
        });
        buttons[11] = new JButton("+");
        buttons[11].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationCalculate(field, Calculator.Operation.SUM);
            }
        });
        buttons[12] = new JButton("0");
        buttons[12].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printToField(field, "0");
            }
        });
        buttons[13] = new JButton(".");
        buttons[13].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                printToField(field, ".");
            }
        });
        buttons[14] = new JButton("=");
        buttons[14].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (calculator.setOperand(Float.valueOf(field.getText()))) {
                    field.setText(String.valueOf(calculator.result()));
                    textNeedStart = true;
                } else
                    JOptionPane.showMessageDialog(null, "Необходимо нажать =");
                calculator.reset();
            }
        });
        buttons[15] = new JButton("-");
        buttons[15].addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                operationCalculate(field, Calculator.Operation.MINUS);
            }
        });


        for (JButton button : buttons) {
            panel.add(button);
        }

        setVisible(true);
    }

    private void printToField(JTextField field, String simbol) {
        if (textNeedStart) {
            field.setText(simbol);
            textNeedStart = false;
        } else
            field.setText(field.getText() + simbol);
    }

    private void operationCalculate(JTextField field, Calculator.Operation multiply) {
        if (calculator.setOperand(Float.valueOf(field.getText()))) {
            calculator.setOperation(multiply);
            textNeedStart = true;
        } else
            JOptionPane.showMessageDialog(null, "Необходимо нажать =");
    }

    public static void main(String[] args) {
        new MyWindow();
    }
}
