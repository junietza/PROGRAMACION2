/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;


public class Calculadora {
    private double num1;
    private double num2;
    private String operador;
    
    public Calculadora(){
        num1= 0d;
        num2= 0d;
        operador = "";
        
    }

    public double getNum1() {
        return num1;
    }

    public void setNum1(double num1) {
        this.num1 = num1;
    }

    public double getNum2() {
        return num2;
    }

    public void setNum2(double num2) {
        this.num2 = num2;
    }

    public String getOperador() {
        return operador;
    }

    public void setOperador(String operador) {
        this.operador = operador;
    }
   
    public String resolve(){        
        double r;
        String sr = "";
        switch(operador){
            case "+":
                r= num1+num2;
                sr = sr.valueOf(r);
                break;
            case "-":
                r= num1-num2;
                sr = sr.valueOf(r);
                break;
            case "x":
                r= num1*num2;
                sr = sr.valueOf(r);
                break;
            case "/":
                r= num1/num2;
                sr = sr.valueOf(r);
                break;   
            default:
                r=0d;
                break;
        }
        return sr;
    }    
            
   
}
