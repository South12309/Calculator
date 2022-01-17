package com.geekbrains;

public class Calculator {
    private float firstOperand = 0;
    private float secondOperand = 0;

    public Calculator() {

    }

    public float sum() {
        return firstOperand + secondOperand;
    }

    public float minus() {
        return firstOperand - secondOperand;
    }

    public float divide() {
        return firstOperand / secondOperand;
    }

    public float multiply() {
        return firstOperand * secondOperand;
    }

    public float getFirstOperand() {
        return firstOperand;
    }

    public void setFirstOperand(float firstOperand) {
        this.firstOperand = firstOperand;
    }

    public float getSecondOperand() {
        return secondOperand;
    }

    public void setSecondOperand(float secondOperand) {
        this.secondOperand = secondOperand;
    }
}
