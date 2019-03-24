package printPrimes;

import org.junit.Test;
import static org.junit.Assert.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.After;
import org.junit.Before;


public class testprintPrimes {
    private int primes[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29}; 
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @Before
    public void setUpStreams(){
        System.setOut(new PrintStream(outContent));
    }
    @After
    public void cleanUpStreams(){
        System.setOut(null);
    }

    @Test
    public void testPrime(){
        testOnce(10);
    }

    public void testOnce(int num){

        String output = "";
        for(int i = 0; i < num; i++){
            output += "Prime: " + primes[i];
        }

        printPrimes.printPrimes(num);
        assertEquals(output, outContent.toString());
    }


}