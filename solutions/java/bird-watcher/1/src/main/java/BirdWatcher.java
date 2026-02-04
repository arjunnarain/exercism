
class BirdWatcher {
    private final int[] birdsPerDay;

    public BirdWatcher(int[] birdsPerDay) {
        this.birdsPerDay = birdsPerDay.clone();
    }

    public int[] getLastWeek() {
        return birdsPerDay;
    }

    public int getToday() {
        return birdsPerDay[birdsPerDay.length - 1];
    }

    public void incrementTodaysCount() {
        int currentCount = birdsPerDay[birdsPerDay.length - 1];
        birdsPerDay[birdsPerDay.length - 1] = currentCount + 1;
    }

    public boolean hasDayWithoutBirds() {
        for (int i = 0; i < birdsPerDay.length; i++) {
            if (birdsPerDay[i] == 0) {
                return true;
            } 
        }

        return false;
    }

    public int getCountForFirstDays(int numberOfDays) {
        int sum = 0;
        int length = numberOfDays > birdsPerDay.length ? birdsPerDay.length : numberOfDays;
        for(int i = 0; i < length; i++) {
            sum += birdsPerDay[i];
        }

        return sum;
    }

    public int getBusyDays() {
        int numberOfBusyDays = 0;

        for (int i = 0; i < birdsPerDay.length; i++) {
            if (birdsPerDay[i] >= 5) {
                numberOfBusyDays++;
            }
        }

        return numberOfBusyDays;
    }
}
