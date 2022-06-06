import java.util.*;


public class Main {
    static String[] stringArray;
    public static int a;
    public static int b;
    public static int result;

    public static Oper oper;


/*
        boolean isBothRoman;

        System.out.println("Hello Java!");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение с арабскими, либо с римскими числами до 10:");
        String inputString = scanner.next();


        String[] stringArray = inputString.split("[/*+-]");
        System.out.println("Количество элементов в массиве=" + stringArray.length);

        if (stringArray.length != 2) {
            throw new RuntimeException("Выражение не соответсвует формату Оператор1-Операнд-Оператор2 ");
        }

        if (
                (RomanConverter.romanToDecimal(stringArray[0]) != -1) &
                        (RomanConverter.romanToDecimal(stringArray[1]) != -1)) {
            isBothRoman = true;
        } else {
            throw new RuntimeException("Операнды разных систем");
        }


        for (int i = 0; i < stringArray.length; i++) {
            System.out.println("операнд " + (i + 1) + "=" + stringArray[i]);
        }
        //String s=IntegerConverter.intToRoman();

 */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите арифметическое выражение с арабскими, либо с римскими числами до 10:");
        String inputString = scanner.next();
        inputString.trim();
        if (inputString.contains("+")) {
            stringArray = inputString.split("[+]");
            oper = Oper.SUM;
        } else if (inputString.contains("-")) {
            stringArray = inputString.split("[-]");
            oper = Oper.SUBSTRUCT;
        } else if (inputString.contains("/")) {
            stringArray = inputString.split("[/]");
            oper = Oper.DIV;
        } else if (inputString.contains("*")) {
            stringArray = inputString.split("[*]");
            oper = Oper.MULT;
        }

        if (isDigitRoman(stringArray[0]) & isDigitRoman(stringArray[1])) {
            a = RomanConverter.romanToDecimal(stringArray[0]);
            b = RomanConverter.romanToDecimal(stringArray[1]);
            result = calculate(a,b,oper);
            System.out.println(IntegerConverter.intToRoman(result));
        }

    }

    public static boolean isDigitRoman(String str) {
        boolean isDigitOK = false;
        for (Digits digit : Digits.values()) {
            if (str.equalsIgnoreCase(digit.name())) {
                isDigitOK = true;
                break;
            }
        }
        if (!isDigitOK) {
            System.err.println("Цифры не греческие");
            //exit program here or throw some exception
        }
        return isDigitOK;
    }

    public static int calculate(int a, int b, Oper op) {
        result = 0;
        switch (op){
            case SUBSTRUCT -> result=a-b;
            case DIV -> result=a/b;
            case SUM -> result=a+b;
            case MULT -> result=a*b;
        }

        return result;
    }

}
