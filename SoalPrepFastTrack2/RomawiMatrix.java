package SoalPrepFastTrack2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RomawiMatrix<T> {

    private Romawi rome;
    private List<List<T>> romeMatrix1;
    private List<List<T>> romeMatrix2;

    public RomawiMatrix(List<List<T>> mult1, List<List<T>> mult2) {

        this.rome = new Romawi();
        this.romeMatrix1 = mult1;
        this.romeMatrix2 = mult2;
    }

    public int[][] getMatrixMultiplication() throws InvalidRomeNumberException {

        int matrix1RowSize = this.romeMatrix1.size();
        int matrix2RowSize = this.romeMatrix2.size();

        int matrix1ColumnSize = this.romeMatrix1.get(0).size();
        int matrix2ColumnSize = this.romeMatrix2.get(0).size();

        int[][] result = new int[matrix1RowSize][matrix2ColumnSize];

        for (int i = 0; i < matrix1RowSize; i++) {
            for (int j = 0; j < matrix2ColumnSize; j++) {
                for (int k = 0; k < matrix1ColumnSize; k++) {
                    try {
                        result[i][j] += this.rome.getNumericValue((String) this.romeMatrix1.get(i).get(k)) * this.rome.getNumericValue((String)this.romeMatrix2.get(k).get(j));
                    } catch (InvalidRomeNumberException e) {
                        throw e;
                    }
                }
            }
        }

        return result;

    }

    public static void main(String args[]) {

        List<List<String>> m1 = new ArrayList<>();
        m1.add(Arrays.asList("X", "V")); // Row 0 (10, 5)
        m1.add(Arrays.asList("I", "II")); // Row 1 (1, 2)

        List<List<String>> m2 = new ArrayList<>();
        m2.add(Arrays.asList("I", "V"));  // Row 0 (1, 5)
        m2.add(Arrays.asList("X", "II")); // Row 1 (10, 2)

        try {

            RomawiMatrix<String> rm = new RomawiMatrix<>(m1, m2);
            int[][] res = rm.getMatrixMultiplication();
            
            System.out.println(Arrays.deepToString(res));

        } catch (InvalidRomeNumberException e) {
            System.err.println("Invalid Roman numeral encountered: " + e.getMessage());
        }
    }
    
}
