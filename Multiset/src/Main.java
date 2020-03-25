import java.util.Scanner;

class Main {

    private static String[] multisetAsString;
    private static double[] multisetA;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("*** Inserire il primo multiset usando ',' come separatore dei valori: ");
        multisetAsString = scanner.nextLine().split("[, \n]+");
        multisetA = convertToDouble(multisetAsString);



        scanner.close();
    }

    private static double[] convertToDouble (String[] str) {
        double[] values = new double[str.length];

        for (int i=0; i<str.length; i++) {
            values[i] = Double.parseDouble(multisetAsString[i]);
        }

        return values;
    }
}