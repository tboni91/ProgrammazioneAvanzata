import java.util.Scanner;

class Main {

    private static String firstMultiset;
    private static String secondMultiset;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        firstMultiset = getMultiset(scanner,"first");
        RealValuesMultiset multisetA = new RealValuesMultiset(firstMultiset);
        secondMultiset = getMultiset(scanner,"second");
        RealValuesMultiset multisetB = new RealValuesMultiset(secondMultiset);

        System.out.println(String.format("The two multiset [value (freq.)]:\n1. %s\n2. %s", multisetA, multisetB));

        System.out.println(multisetA.equals(multisetB) ? "Are equal" : "Are not equal");
        scanner.close();
    }

    private static String getMultiset (Scanner scanner, String num) {
        String multisetAsString;
        System.out.print("Insert " + num + " multiset as sequence of comma-separated real numbers: ");
        multisetAsString = scanner.nextLine();
        return multisetAsString;
    }

}