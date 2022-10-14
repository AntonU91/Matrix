import java.util.ArrayList;

public final class MatrixChild extends Matrix {

    public MatrixChild(int rowCount, int columnCount, boolean isEmpty) {
        super(rowCount, columnCount, isEmpty);
    }

    public MatrixChild(int rowCount, int columnCount) {
        super(rowCount, columnCount);
    }

    public MatrixChild(Matrix anotherMatrix) {
        super(anotherMatrix);
    }

}
