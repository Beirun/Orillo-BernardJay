import java.util.*;
public class Activity1{
    static int sub1, sub2;
    static String operators = "+-*/^√";
    static double tempResult = 0;
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Input Equation: ");
        String equation = sc.nextLine().trim();
        System.out.print(equation + " -> ");
        for(int i = equation.length()-1; i>=0; i--){
            if(equation.charAt(i)=='('){
                for(int j = i; j < equation.length(); j++){
                    if(equation.charAt(j)==')'){
                        equation = equation.replace(equation.substring(i,j+1),Solver(equation.substring(i+1,j)));
                        break;
                    }
                }
            }
        }
        equation = exponentAndSquareRootChecker(equation);
        while(!isDouble(equation)) equation = Solver(equation);
        if((int) Double.parseDouble(equation)== Double.parseDouble(equation)) System.out.println((int) Double.parseDouble(equation));
        else System.out.printf("%.2f", Double.parseDouble(equation));
    }
    static boolean isDouble(String testString) {
        try {
            Double.parseDouble(testString);
            return true;
        }
        catch(NumberFormatException e){ return false;}
    }
    static double firstNumber(String expression){
        for(int i = expression.length()-1; i >= 0; i--){
            if(i==0) {
                sub1 = i;
                if(expression.charAt(i)=='√') {
                    sub1 = i+1;
                    return Double.parseDouble(expression.substring(i+1));
                }
                return Double.parseDouble(expression);
            } else if(operators.contains(String.valueOf(expression.charAt(i)))){
                if(operators.contains(String.valueOf(expression.charAt(i-1)))){
                    sub1 = i;
                    return Double.parseDouble(expression.substring(i));
                } else {
                    sub1 = i + 1;
                    return Double.parseDouble(expression.substring(i + 1));
                }
            }
        }
        return 0;
    }
    static double secondNumber(String expression){
        for(int i = 1; i < expression.length(); i++){
            if(operators.contains(String.valueOf(expression.charAt(i)))){
                sub2 = i;
                return Double.parseDouble(expression.substring(0, i));
            }
        }
        sub2 = expression.length();
        return Double.parseDouble(expression);
    }
    static String Solver(String expression){
        expression = exponentAndSquareRootChecker(expression);
        while(expression.contains("*") || expression.contains("/")) {
            for (int i = 0; i < expression.length(); i++) {
                if (expression.charAt(i) == '*') {
                    tempResult = firstNumber(expression.substring(0, i)) * secondNumber(expression.substring(i + 1));
                    expression = expression.substring(0, sub1) + tempResult + expression.substring(i + 1 + sub2);
                    System.out.print(expression + " -> ");
                } else if (expression.charAt(i) == '/') {
                    tempResult = firstNumber(expression.substring(0, i)) / secondNumber(expression.substring(i + 1));
                    expression = expression.substring(0, sub1) + tempResult + expression.substring(i + 1 + sub2);
                    System.out.print(expression + " -> ");
                }

            }
        }
        for(int i = 0; i<expression.length(); i++){
            if(expression.charAt(i)=='+') {
                tempResult = firstNumber(expression.substring(0,i)) + secondNumber(expression.substring(i+1));
                expression = expression.replace(expression.substring(sub1,i+1+sub2),Double.toString(tempResult));
                System.out.print(expression + " -> ");
            } else if(expression.charAt(i)=='-'){
                tempResult = firstNumber(expression.substring(0,i)) - secondNumber(expression.substring(i+1));
                expression = expression.replace(expression.substring(sub1,i+1+sub2),Double.toString(tempResult));
                System.out.print(expression + " -> ");
            }
        }
        return expression;
    }
    static String exponentAndSquareRootChecker(String expression){
        for (int i = expression.length()-1; i >= 0; i--) {
            if (expression.charAt(i) == '^') {
                tempResult = Math.pow(firstNumber(expression.substring(0, i)), secondNumber(expression.substring(i + 1)));
                expression = expression.substring(0, sub1) + tempResult + expression.substring(i + 1 + sub2);
                System.out.print(expression + " -> ");
            } if (expression.charAt(i) == '√') {
                tempResult = Math.sqrt(secondNumber(expression.substring(i + 1)));
                expression = expression.substring(0, i) + tempResult + expression.substring(i + 1 + sub2);
                System.out.print(expression + " -> ");
            }
        }
        return expression;
    }
}