public class Lasagna {
    private final int timePerLasagnaLayer = 2;
    private final int minutesInOven = 40;

    // TODO: define the 'expectedMinutesInOven()' method
    public int expectedMinutesInOven() {
        return this.minutesInOven;
    }

    // TODO: define the 'remainingMinutesInOven()' method
    public int remainingMinutesInOven(int elapsedTimeInMinutes) {
        if (elapsedTimeInMinutes >= this.minutesInOven) {
            return 0;
        }
        else {
            return this.minutesInOven - elapsedTimeInMinutes;
        }
    }

    // TODO: define the 'preparationTimeInMinutes()' method
    public int preparationTimeInMinutes(int layers) {
        return layers * this.timePerLasagnaLayer;
    }
    // TODO: define the 'totalTimeInMinutes()' method
    public int totalTimeInMinutes(int layers, int timeInOven) {
        return this.preparationTimeInMinutes(layers) + timeInOven;
    }
};
