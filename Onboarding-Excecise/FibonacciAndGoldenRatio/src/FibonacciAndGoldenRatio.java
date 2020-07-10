import java.util.Scanner;

public class FibonacciAndGoldenRatio {



    public static double fibonacci(int n) {
        if (n <= 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        } else {
            return fibonacci(n - 1) + fibonacci(n - 2);
        }
    }

    public static double goldenRatio() {
        return (1 + Math.sqrt(5)) / 2;
    }

    public static void main(String[] args){
        Scanner scanner=new Scanner(System.in);
        int diff=Integer.parseInt(scanner.nextLine());
        scanner.close();
        System.out.println(fibonacciDifference(diff));
    }


    /*
     * Fill out the fibonacciDifference function to return the nearest index in fiboonacci series for which the
     * percent difference between the ratio of that element and successor and the golden ratio
     * does not exceed the given difference.
     */
    public static int fibonacciDifference(double diff){

        return 0;
    }
}