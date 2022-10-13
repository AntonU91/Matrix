import java.util.*;

class Main {

    public static void main(String[] args) throws UncorrectedElementIndexes {
        Matrix a = new Matrix(3, 3);
        System.out.println(a);
//        System.out.println(a);
//        System.out.println(Matrix.matrixDeterminant(a));
        System.out.println(Matrix.invertMatrix(a));

//        // System.out.println(a.getSpecifiedElement(2, 2));
//        System.out.println(a.getSpecifiedRow(0));
//        System.out.println(a.getSpecifiedColumn(1));
//        System.out.println(Arrays.toString(a.getSize()));

//        Matrix B = new Matrix(4, 2);
//        B.fillInWithRandomValues();
//        System.out.println(B.getEntries());
        // System.out.println(Matrix.getDiagonalMatrix(new Double[]{2, 5, 7}).getEntries());


    }
}

public class Matrix {
    private final int[] size;
    private final ArrayList<ArrayList<Double>> entries;

    public Matrix(int rowCount, int columnCount, boolean isEmpty) {
        this.size = new int[2];
        size[0] = rowCount;
        size[1] = columnCount;
        this.entries = new ArrayList<>();
        for (int i = 0; i < size[0]; i++) {
            ArrayList<Double> doubles = new ArrayList<>();
            for (int j = 0; j < size[1]; j++) {
                doubles.add(0.0);
            }
            entries.add(i, doubles);
        }

    }

    public Matrix(int rowCount, int columnCount) {
        size = new int[2];
        size[0] = rowCount;
        size[1] = columnCount;
        entries = new ArrayList<>();
    }

    public Matrix(Matrix anotherMatrix) {
        this.size = anotherMatrix.size;
        this.entries = anotherMatrix.entries;
    }

    public int[] getSize() {
        return size;
    }

    public ArrayList<ArrayList<Double>> getEntries() {
        return entries;
    }

    public void fillInWithValues() {
        System.out.printf("Set the value of a matrix of size %d x %d. Each line in the console is a matrix row. To finish entering the matrix, press Enter on the new empty line\n.", size[0], size[1]);
        Scanner scanner = new Scanner(System.in);
        int rowNum = 0;
        while (scanner.hasNextLine()) {
            ArrayList<Double> DoubleArrayList = new ArrayList<>();
            String retrievedStr = scanner.nextLine();
            if (retrievedStr.equals("")) {
                break;
            } else if (retrievedStr.matches("(\\s*\\d+)+\\s*")) {
                String[] retrievedDigits = retrievedStr.replaceAll("(^\\s+)|(\\s+$)", "").split("\\s+");
                for (String digit : retrievedDigits) {
                    DoubleArrayList.add(Double.parseDouble(digit));
                }
                if ((DoubleArrayList.size() == this.size[1]) && (entries.size() <= this.size[0])) {
                    entries.add(rowNum, DoubleArrayList);
                    rowNum++;
                } else {
                    System.out.println("The dimensionality of the matrix is broken when entering data in the row: \" " + retrievedStr + " \"");
                }
            } else {
                System.out.println("Incorrect entry of a matrix element in the row:\" " + retrievedStr + " \"");
                break;
            }
        }
        if (entries.size() < this.size[0]) {
            System.out.println("The matrix has fewer lines than specified!");
        }
    }

    public void fillInWithRandomValues() {

        for (int i = 0; i < size[0]; i++) {
            ArrayList<Double> arrayList = new ArrayList<>();
            for (int j = 0; j < size[1]; j++) {
                arrayList.add(j, (double) Math.round(Math.random() * 100));
            }
            entries.add(i, arrayList);
        }
    }

    public double getSpecifiedElement(int numberRow, int numberColumn) throws UncorrectedElementIndexes {
        if (numberRow >= this.size[0] || numberColumn >= this.size[1]) {
            throw new UncorrectedElementIndexes();
        }
        return this.entries.get(numberRow).get(numberColumn);
    }

    public ArrayList<Double> getSpecifiedRow(int rowNumber) throws UncorrectedElementIndexes {
        if (rowNumber >= this.size[0]) {
            throw new UncorrectedElementIndexes();
        }
        return this.entries.get(rowNumber);
    }

    public ArrayList<Double> getSpecifiedColumn(int columnNumber) throws UncorrectedElementIndexes {
        ArrayList<Double> result = new ArrayList<>();
        if (columnNumber >= size[1]) {
            throw new UncorrectedElementIndexes();
        }
        for (ArrayList<Double> entry : entries) {
            result.add(entry.get(columnNumber));
        }
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Matrix matrix = (Matrix) o;
        return Arrays.equals(size, matrix.size) && Objects.equals(entries, matrix.entries);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(entries);
        result = 31 * result + Arrays.hashCode(size);
        return result;
    }

    public static Matrix getDiagonalMatrix(Double[] vector) {
        Matrix diagonalMatrix = new Matrix(vector.length, vector.length);
        for (int i = 0; i < diagonalMatrix.size[0]; i++) {
            ArrayList<Double> arrayList = new ArrayList<>();
            for (int j = 0; j < diagonalMatrix.size[1]; j++) {
                if (j == i) {
                    arrayList.add(vector[i]);
                    continue;
                }
                arrayList.add(0.0);
            }
            diagonalMatrix.entries.add(i, arrayList);
        }
        return diagonalMatrix;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < size[0]; i++) {
            String str = entries.get(i).toString().replaceAll("[\\[\\]]", "");
            stringBuilder.append(str).append("\n");
        }
        return stringBuilder.toString();
    }

    public static double matrixDeterminant(Matrix mat) {
        double[][] matrix = new double[mat.size[0]][mat.size[0]];

        for (int i = 0; i < mat.entries.size(); i++) {
            for (int j = 0; j < mat.entries.get(i).size(); j++) {
                matrix[i][j] = mat.entries.get(i).get(j);
            }
        }

        double[][] temporary;
        double result = 0;

        if (matrix.length == 1) {
            result = matrix[0][0];
            return (result);
        }

        if (matrix.length == 2) {
            result = ((matrix[0][0] * matrix[1][1]) - (matrix[0][1] * matrix[1][0]));
            return (result);
        }

        for (int i = 0; i < matrix[0].length; i++) {
            temporary = new double[matrix.length - 1][matrix.length - 1];

            for (int j = 1; j < matrix.length; j++) {
                for (int k = 0; k < matrix.length; k++) {
                    if (k < i) {
                        temporary[j - 1][k] = matrix[j][k];
                    } else if (k > i) {
                        temporary[j - 1][k - 1] = matrix[j][k];
                    }
                }
            }
            Matrix tempMatrix = new Matrix(temporary.length, temporary.length);
            for (int l = 0; l < temporary.length; l++) {
                ArrayList<Double> arrayList = new ArrayList<>();
                for (int z = 0; z < temporary.length; z++) {
                    arrayList.add(z, temporary[l][z]);
                }
                tempMatrix.entries.add(l, arrayList);
            }


            result += matrix[0][i] * Math.pow(-1, (double) i) * matrixDeterminant(tempMatrix);
        }
        return (result);
    }

    public static Matrix invertMatrix(Matrix mat) {
        double[][] matrix = new double[mat.size[0]][mat.size[0]];
        double[][] auxiliaryMatrix, invertedMatrix;
        int[] index;
        for (int i = 0; i < mat.entries.size(); i++) {
            for (int j = 0; j < mat.entries.get(i).size(); j++) {
                matrix[i][j] = mat.entries.get(i).get(j);
            }
        }

        auxiliaryMatrix = new double[matrix.length][matrix.length];
        invertedMatrix = new double[matrix.length][matrix.length];
        index = new int[matrix.length];

        for (int i = 0; i < matrix.length; ++i) {
            auxiliaryMatrix[i][i] = 1;
        }

        transformToUpperTriangle(matrix, index);

        for (int i = 0; i < (matrix.length - 1); ++i) {
            for (int j = (i + 1); j < matrix.length; ++j) {
                for (int k = 0; k < matrix.length; ++k) {
                    auxiliaryMatrix[index[j]][k] -= matrix[index[j]][i] * auxiliaryMatrix[index[i]][k];
                }
            }
        }

        for (int i = 0; i < matrix.length; ++i) {
            invertedMatrix[matrix.length - 1][i] = (auxiliaryMatrix[index[matrix.length - 1]][i] / matrix[index[matrix.length - 1]][matrix.length - 1]);

            for (int j = (matrix.length - 2); j >= 0; --j) {
                invertedMatrix[j][i] = auxiliaryMatrix[index[j]][i];

                for (int k = (j + 1); k < matrix.length; ++k) {
                    invertedMatrix[j][i] -= (matrix[index[j]][k] * invertedMatrix[k][i]);
                }

                invertedMatrix[j][i] /= matrix[index[j]][j];
            }
        }
        Matrix invertedMatrix1 = new Matrix(invertedMatrix.length, invertedMatrix.length);
        for (int l = 0; l < invertedMatrix.length; l++) {
            ArrayList<Double> arrayList = new ArrayList<>();
            for (int z = 0; z < invertedMatrix.length; z++) {
                arrayList.add(z, invertedMatrix[l][z]);
            }
            invertedMatrix1.entries.add(l, arrayList);
        }

        return (invertedMatrix1);
    }

    public static void transformToUpperTriangle(double[][] matrix, int[] index) {
        double[] c;
        double c0, c1, pi0, pi1, pj;
        int itmp, k;

        c = new double[matrix.length];

        for (int i = 0; i < matrix.length; ++i) {
            index[i] = i;
        }

        for (int i = 0; i < matrix.length; ++i) {
            c1 = 0;

            for (int j = 0; j < matrix.length; ++j) {
                c0 = Math.abs(matrix[i][j]);

                if (c0 > c1) {
                    c1 = c0;
                }
            }

            c[i] = c1;
        }

        k = 0;

        for (int j = 0; j < (matrix.length - 1); ++j) {
            pi1 = 0;

            for (int i = j; i < matrix.length; ++i) {
                pi0 = Math.abs(matrix[index[i]][j]);
                pi0 /= c[index[i]];

                if (pi0 > pi1) {
                    pi1 = pi0;
                    k = i;
                }
            }

            itmp = index[j];
            index[j] = index[k];
            index[k] = itmp;

            for (int i = (j + 1); i < matrix.length; ++i) {
                pj = matrix[index[i]][j] / matrix[index[j]][j];
                matrix[index[i]][j] = pj;

                for (int l = (j + 1); l < matrix.length; ++l) {
                    matrix[index[i]][l] -= pj * matrix[index[j]][l];
                }
            }
        }
    }
}
