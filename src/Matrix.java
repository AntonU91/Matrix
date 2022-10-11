import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

class Main {

    public static void main(String[] args) throws UncorrectedElementIndexes {
        Matrix a = new Matrix(2, 2);
        a.fillInWithValues();
       // System.out.println(a.getSpecifiedElement(2, 2));
        System.out.println(a.getSpecifiedRow(0));
        System.out.println(a.getSpecifiedColumn(1));
        System.out.println(Arrays.toString(a.getSize()));

//        Matrix B = new Matrix(4, 2);
//        B.fillInWithRandomValues();
//        System.out.println(B.getEntries());

    }
}

public class Matrix {
    private final int[] size;
    private ArrayList<ArrayList<Integer>> entries;

    public Matrix() {
        this.size = new int[0];
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

    public ArrayList<ArrayList<Integer>> getEntries() {
        return entries;
    }

    public void fillInWithValues() {
        Scanner scanner = new Scanner(System.in);//.useDelimiter("\\n");
        int rowNum = 0;
        while (scanner.hasNextLine()) {
            ArrayList<Integer> integerArrayList = new ArrayList<>();
            String retrievedStr = scanner.nextLine();
            if (retrievedStr.equals("")) {
                break;
            } else if (retrievedStr.matches("(\\s*\\d+)+\\s*")) {
                String[] retrievedDigits = retrievedStr.replaceAll("(^\\s+)|(\\s+$)", "").split("\\s+");
                for (String digit : retrievedDigits) {
                    integerArrayList.add(Integer.parseInt(digit));
                }
                if ((integerArrayList.size() == this.size[1]) && (entries.size() <= this.size[0])) {
                    entries.add(rowNum, integerArrayList);
                    rowNum++;
                } else {
                    System.out.println("Нарушена размерность матрици при вводе данных в строке: \" " + retrievedStr + " \"");
                }
            } else {
                System.out.println("Некорректный ввод елемента матрици  в строке:\" " + retrievedStr + " \"");
                break;
            }
        }
        if (entries.size() < this.size[0]) {
            System.out.println("Матрица имеет меньше строк, чем задано!");
        }
    }

    public void fillInWithRandomValues() {

        for (int i = 0; i < size[0]; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = 0; j < size[1]; j++) {
                arrayList.add(j, (int) (Math.random() * 100));
            }
            entries.add(i, arrayList);
        }
    }

    public int getSpecifiedElement(int numberRow, int numberColumn) throws UncorrectedElementIndexes {
        if (numberRow >= this.size[0] || numberColumn >= this.size[1]) {
            throw new UncorrectedElementIndexes();
        }
        return this.entries.get(numberRow).get(numberColumn);
    }

    public ArrayList<Integer> getSpecifiedRow(int rowNumber) throws UncorrectedElementIndexes {
        if (rowNumber >= this.size[0]) {
            throw new UncorrectedElementIndexes();
        }
        return this.entries.get(rowNumber);
    }

    public ArrayList<Integer> getSpecifiedColumn(int columnNumber) throws UncorrectedElementIndexes {
        ArrayList<Integer> result = new ArrayList<>();
        if (columnNumber >= size[1]) {
            throw new UncorrectedElementIndexes();
        }
        for (ArrayList<Integer> entry : entries) {
            result.add(entry.get(columnNumber));
        }
        return result;
    }



}
