package com.geekbrains;

public class Calculator {


    enum Operation {
        SUM,
        MINUS,
        DIVIDE,
        MULTIPLY
    }


    private float firstOperand = 0;
    private float secondOperand = 0;
    private Operation operation;


    public Calculator() {

    }

    public float result() {
        if (operation == Operation.SUM)
            return sum();
        else if (operation == Operation.MINUS)
            return minus();
        else if (operation == Operation.DIVIDE)
            return divide();
        else
            return multiply();

    }

    public Operation getOperation() {
        return operation;
    }

    public void reset() {
        firstOperand = 0;
        secondOperand = 0;
    }

    public void setOperation(Operation operation) {
        this.operation = operation;
    }

    private float sum() {
        return firstOperand + secondOperand;
    }

    private float minus() {
        return firstOperand - secondOperand;
    }

    private float divide() {
        return firstOperand / secondOperand;
    }

    private float multiply() {
        return firstOperand * secondOperand;
    }


    public boolean setOperand(Float operand) {

        if (firstOperand == 0) {
            firstOperand = operand;
            return true;
        } else if (secondOperand == 0) {
            secondOperand = operand;
            return true;
        } else return false;


    }


}
