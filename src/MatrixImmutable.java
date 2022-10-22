import java.util.ArrayList;

public final class MatrixImmutable extends Matrix {


    public MatrixImmutable(int rowCount, int columnCount, boolean isEmpty) {
        super(rowCount, columnCount, isEmpty);
    }

    public MatrixImmutable(int rowCount, int columnCount) {
        super(rowCount, columnCount);
    }

    public MatrixImmutable(Matrix anotherMatrix) {
        super(anotherMatrix);
        int[] size = anotherMatrix.getSize();
        ArrayList<ArrayList<Double>> newArr = new ArrayList<>();
        for (int rowCount = 0; rowCount < size[0]; rowCount++) {
            ArrayList<Double> doubles = new ArrayList<>();
            for (int columnCount = 0; columnCount < size[1]; columnCount++) {
                doubles.add(this.getEntries().get(rowCount).get(columnCount));
            }
            newArr.add(rowCount, doubles);
        }
        this.setEntries(newArr);
    }


}
