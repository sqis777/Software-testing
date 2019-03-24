package printPrimes;

public class printPrimes {
    public static int MAXPRIMES = 10;
    public static void printPrimes(int n){
        int curPrime;
        int numPrimes;
        boolean isPrime;
        int[] primes = new int[MAXPRIMES];

        //Initialize 2 into the list of primes
        primes[0] = 2;
        numPrimes = 1;
        curPrime = 2;
        while(numPrimes < n){
            curPrime++;
            isPrime = true;
            for(int i = 0; i <= numPrimes - 1; i++){
                if(isDivisible(primes[i], curPrime)){
                    isPrime = false;
                    break;
                }
            }
            if(isPrime){
                primes[numPrimes] = curPrime;
                numPrimes++;
            }
        }//End While

        //Print all the primes out
        for(int i = 0; i <= numPrimes-1; i++){
            System.out.print("Prime: " + primes[i]);
        }
    }

    private static boolean isDivisible(int divisor, int divided){
        if(divisor != 0){
            return (divided % divisor) == 0;
        }
        return false;
    }
}
