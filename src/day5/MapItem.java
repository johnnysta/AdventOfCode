package day5;

public class MapItem {

    long outputRangeStart;
    long inputRangeStart;
    long range;

    public MapItem(long outputRangeStart, long inputRangeStart, long range) {
        this.outputRangeStart = outputRangeStart;
        this.inputRangeStart = inputRangeStart;
        this.range = range;
    }

    public boolean isInRange(long input) {
        if (input >= inputRangeStart && input <= inputRangeStart + range) {
            return true;
        }
        return false;
    }

    public Long mapInputToOutput(long input) {
        return outputRangeStart + (input - inputRangeStart);
    }


    public long getOutputRangeStart() {
        return outputRangeStart;
    }

    public long getInputRangeStart() {
        return inputRangeStart;
    }

    public long getRange() {
        return range;
    }

    @Override
    public String toString() {
        return "MapItem{" +
                "outputRangeStart=" + outputRangeStart +
                ", inputRangeStart=" + inputRangeStart +
                ", range=" + range +
                '}';
    }
}
