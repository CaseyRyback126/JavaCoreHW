import java.io.IOException;

public class MyArrayDataException extends IOException {
    private final int row;
    private final int column;

    public MyArrayDataException(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
