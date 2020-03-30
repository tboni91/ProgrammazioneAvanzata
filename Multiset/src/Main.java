import java.util.Scanner;

class Main {
    private final static String SEPARATOR = ",";
    private static String firstMultiset;
    private static String secondMultiset;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        firstMultiset = getMultiset(scanner,"first");
        if (firstMultiset.length() == 0) {
            System.out.println("Error, empty multiset!");
            return;
        }
        RealValuesMultiset multisetA = new RealValuesMultiset(toRealValues(firstMultiset));

        secondMultiset = getMultiset(scanner,"second");
        if (secondMultiset.length() == 0) {
            System.out.println("Error, empty multiset!");
            return;
        }
        RealValuesMultiset multisetB = new RealValuesMultiset(toRealValues(secondMultiset));

        System.out.println(String.format("The two multisets [value (occurrence)]:\n1. %s\n2. %s", multisetA, multisetB));

        System.out.println(multisetA.equals(multisetB) ? "Are equivalent" : "Are not equivalent");
        scanner.close();
    }

    private static String getMultiset (Scanner scanner, String num) {
        String multisetAsString;
        System.out.print("Insert " + num + " multiset as sequence of comma-separated real numbers: ");
        multisetAsString = scanner.nextLine().trim();
        return multisetAsString;
    }

    private static double[] toRealValues (String multiset) {
        double[] realValues;
        multiset = multiset.trim();

        if (multiset == null || multiset.length() == 0) {
            realValues = new double[0];
        } else {
            String[] stringValues = multiset.split(SEPARATOR);
            realValues = new double[stringValues.length];
            for (int i = 0; i < realValues.length; i++) {
                realValues[i] = Double.parseDouble(stringValues[i]);
            }
        }

        return realValues;
    }

}