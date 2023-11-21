package sorting;


public class selectionsort<T extends Comparable<T>> implements Sort {

    private long compares = 0;

    @Override
    public void sort(Comparable[] a) {
        int n = a.length;

        for (int i = 0; i < n - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < n; j++) {
                if (a[j].compareTo(a[minIndex]) < 0) {
                    minIndex = j;
                }
                compares++; // Increment the comparison count
            }
            // Swap a[i] and a[minIndex]
            Comparable temp = a[i];
            a[i] = a[minIndex];
            a[minIndex] = temp;
        }
    }

    @Override
    public long getCompares() {
        return compares;
    }
}
