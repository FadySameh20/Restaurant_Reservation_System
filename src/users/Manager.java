package users;

import java.util.ArrayList;

public class Manager extends Employee {

    private double totalProfit;

    public double getStatistics(ArrayList<Customer> customers) {
        for (int i = 0; i < customers.size(); i++) {
            totalProfit += customers.get(i).getTotalPrice();
        }
        return totalProfit;
    }
}
