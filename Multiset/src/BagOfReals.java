import java.util.Arrays;

public class BagOfReals {
    private double[] multiset;

    public BagOfReals(double[] multiset) {
        this.multiset = multiset;
    }

    @Override
    public String toString() {
        return "BagOfReals{" +
                "multiset=" + Arrays.toString(multiset) +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BagOfReals that = (BagOfReals) o;
        return Arrays.equals(multiset, that.multiset);
    }

}
