public final class MatrixImmutable extends Matrix {

    public MatrixImmutable(int rowCount, int columnCount, boolean isEmpty) {
        super(rowCount, columnCount, isEmpty);
    }

    public MatrixImmutable(int rowCount, int columnCount) {
        super(rowCount, columnCount);
    }

    public MatrixImmutable(Matrix anotherMatrix) {
        super(anotherMatrix);
    }

}
