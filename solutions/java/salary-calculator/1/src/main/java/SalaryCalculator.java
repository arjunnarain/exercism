public class SalaryCalculator {
    private final double baseSalary = 1000.0;
    
    public double salaryMultiplier(int daysSkipped) {
        return (daysSkipped < 5) ? 1.0 : 0.85;
    }

    public int bonusMultiplier(int productsSold) {
        return productsSold >= 20 ? 13 : 10;
    }

    public double bonusForProductsSold(int productsSold) {
        return (double) productsSold * bonusMultiplier(productsSold);
    }

    public double finalSalary(int daysSkipped, int productsSold) {
        double computedSalary = (baseSalary + bonusForProductsSold(productsSold)) * salaryMultiplier(daysSkipped); 
        return (computedSalary > 2000.0) ? 2000.0 : computedSalary;
    } 
}
