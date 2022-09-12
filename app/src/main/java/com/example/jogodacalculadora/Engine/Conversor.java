package com.example.jogodacalculadora.Engine;

public class Conversor {
    public static String Decimal_Binario(Integer Integer_Decimal) {

        return Integer.toBinaryString(Integer_Decimal);
    }

    public static String Decimal_Octal(Integer Integer_Decimal) {

        return Integer.toOctalString(Integer_Decimal);
    }

    public static Integer[] arrayString_Integer(String[] arrayString) {

        Integer[] arrayInteger = new Integer[arrayString.length];
        for (int i = 0; i < arrayString.length; i++) {
            if (arrayString[i] != null) {
                arrayInteger[i] = Integer.valueOf(arrayString[i]);
            }
        }

        return arrayInteger;
    }

    public static String[] arrayInteger_String(Integer[] arrayInteger) {

        String[] arrayString = new String[arrayInteger.length];
        for (int i = 0; i < arrayInteger.length; i++) {
            if (arrayInteger != null) {
                arrayString[i] = String.valueOf(arrayInteger[i]);
            }
        }
        return arrayString;
    }

    public static String[] ArrayDecimal_Binario(Integer[] ArrayDecimal) {

        String[] ArrayBinario = new String[ArrayDecimal.length];
        for (int i = 0; i < ArrayDecimal.length; i++) {
            ArrayBinario[i] = Conversor.Decimal_Binario(ArrayDecimal[i]);

        }

        return ArrayBinario;
    }

    public static String[] ArrayDecimal_Octal(Integer[] ArrayDecimal) {

        String[] ArrayOctal = new String[ArrayDecimal.length];
        for (int i = 0; i < ArrayDecimal.length; i++) {
            ArrayOctal[i] = Conversor.Decimal_Octal(ArrayDecimal[i]);

        }

        return ArrayOctal;
    }
}
