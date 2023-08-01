public class Main {

    public static int sumArray(String[][] array) throws MyArraySizeException, MyArrayDataException {
        for (String[] row : array) {
            if (row.length != 4 || array[0].length != 4) {
                throw new MyArraySizeException();
            }
        }


        int sum = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                try {
                    sum += Integer.parseInt(array[i][j]);
                } catch (NumberFormatException e) {
                    throw new MyArrayDataException(i, j);
                }
            }
        }

        return sum;
    }

    public static void main(String[] args) {

        String[][] array = {
                {"1", "2", "3", "4"},
                {"5", "6", "7", "8"},
                {"9", "10", "11", "12"},
                {"13", "14", "15", "16"}
        };


        try {
            int sum = sumArray(array);
            System.out.println("Сумма элементов массива: " + sum);
        } catch (MyArraySizeException e) {
            System.out.println("Размер массива неверный");
        } catch (MyArrayDataException e) {
            System.out.println("Неверные данные в ячейке: " + e.getRow() + ", " + e.getColumn());
        }
    }
}
