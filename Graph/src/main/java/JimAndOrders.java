import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

    public class JimAndOrders {

        public static class Customer implements Comparable<Customer>{
            int id;
            int totalTime;

            public Customer(int id, int totalTime){
                this.id = id;
                this.totalTime = totalTime;
            }

            public int compareTo(Customer o) {
                if (totalTime < o.totalTime){
                    return -1;
                }
                else if (totalTime > o.totalTime){
                    return 1;
                }
                else{
                    return this.id - o.id;
                }
            }
        }

        // Complete the jimOrders function below.
        static int[] jimOrders(int[][] orders) {

            ArrayList<Customer> list = new ArrayList();
            int[] result = new int[orders.length];

            for(int i = 0; i < orders.length ; i++){
                 int j = 0;
                 list.add(new Customer(i + 1,orders[i][j] + orders[i][j+1]));
            }

            Collections.sort(list);

            for(int i = 0; i < list.size(); i++){
                result[i] = list.get(i).id;
            }

            return result;
        }



        public static void main(String[] args) throws IOException {
            File file1 = new File("target/classes/" + args[0]);
            Scanner scanner = new Scanner(file1);

            int n = scanner.nextInt();
            scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

            int[][] orders = new int[n][2];

            for (int i = 0; i < n; i++) {
                String[] ordersRowItems = scanner.nextLine().split(" ");
                scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

                for (int j = 0; j < 2; j++) {
                    int ordersItem = Integer.parseInt(ordersRowItems[j]);
                    orders[i][j] = ordersItem;
                }
            }

            int[] result = jimOrders(orders);

            for (int i = 0; i < result.length; i++) {

                System.out.println(String.valueOf(result[i]));

                if (i != result.length - 1) {
                    System.out.println(" ");
                }
            }
            scanner.close();
        }
    }

