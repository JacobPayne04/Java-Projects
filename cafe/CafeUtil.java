//CO CODED WITH MEGAN

package w1d1.cafe;
import java.util.ArrayList;

public class CafeUtil {
    public int getStreakGoal() {
        int numWeeks = 10;
        int sum = 0;
        for (int i = 0; i <= numWeeks; i++) {
            sum += i;
        }

        return sum;
    }

    public String printPriceChart() {
        return "testing the printPriceChart";
    }

    public double getOrderTotal(double[] prices) {
        double sum = 0;
        for (int i = 0; i < prices.length; i++) {
            sum += prices[i];
        }
        return sum;
    }

    public void displayMenu(ArrayList<String> menuItems) {
        for (int i = 0; i < menuItems.size(); i++) {
            System.out.println(menuItems.get(i));
        }

        
       
    }

    public void addCustomer(ArrayList<String> customers){

        System.out.println("please enter your name:");

        String username = System.console().readLine();

        customers.add(username);

        System.out.println("hello" + " " + username + "You have" + " " +(customers.size()-1) + " " + "ahead of you");
    }
}