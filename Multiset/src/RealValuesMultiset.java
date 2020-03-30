import java.util.Arrays;

public class RealValuesMultiset {
    private final String SEPARATOR = ",";
    private double[] realValues;

    public RealValuesMultiset(String multiset) {
        realValues = toRealValues(multiset);
        Arrays.sort(realValues);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("multiset: {");
        String separator = "";

        int frequency = 1;
        double lastValue = realValues[0];
        for (int i = 1; i < realValues.length; i++) {
            if (realValues[i] != lastValue) {
                builder.append(String.format("%s%s (%d)", separator, lastValue, frequency));
                separator = ", ";
                frequency = 1;
                lastValue = realValues[i];
            } else {
                frequency++;
            }
        }
        builder.append(String.format("%s%s (%d)}", separator, realValues[realValues.length - 1], frequency));
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }

        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        RealValuesMultiset that = (RealValuesMultiset) o;
        return Arrays.equals(realValues, that.realValues);
    }

    private double[] toRealValues (String multiset) {
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
