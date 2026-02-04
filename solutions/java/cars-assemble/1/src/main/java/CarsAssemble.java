enum SpeedSuccessRate {
    ZERO(0, 0, 0),
    VERY_LOW(1, 4, 100),
    LOW(5, 8, 90),
    MEDIUM(9, 9, 80),
    HIGH(10, 10, 77);

    private final int minSpeed;
    private final int maxSpeed;
    private final int successRate;

    SpeedSuccessRate(int minSpeed, int maxSpeed, int successRate) {
        this.minSpeed = minSpeed;
        this.maxSpeed = maxSpeed;
        this.successRate = successRate;
    }

    public int getSuccessRate() {
        return successRate;
    }

    public boolean matches(int speed) {
        return speed >= minSpeed && speed <= maxSpeed;
    }

    public static SpeedSuccessRate fromSpeed(int speed) {
        for (SpeedSuccessRate rate : values()) {
            if (rate.matches(speed)) {
                return rate;
            }
        }
        throw new IllegalArgumentException("Invalid speed: " + speed);
    }
}

public class CarsAssemble {
    private final int baseRate = 221;

    public double productionRatePerHour(int speed) {
        SpeedSuccessRate rate = SpeedSuccessRate.fromSpeed(speed);

        return (double) ((speed * baseRate) * rate.getSuccessRate()) / 100;
    }

    public int workingItemsPerMinute(int speed) {
        double productionRatePerHour = productionRatePerHour(speed);

        return (int) productionRatePerHour / 60;
    }
}

