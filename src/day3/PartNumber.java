package day3;

public class PartNumber {
    private int startIndex;
    private int endIndex;

    private int row;
    private int number;

    public PartNumber(int startIndex, int endIndex, int row, int number) {
        this.startIndex = startIndex;
        this.endIndex = endIndex;
        this.row = row;
        this.number = number;
    }

    public boolean isIncludes(int i, int j) {
        if (this.row == i && j>=startIndex && j<=endIndex){
            return true;
        }
        return false;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public int getEndIndex() {
        return endIndex;
    }

    public int getNumber() {
        return number;
    }
}
