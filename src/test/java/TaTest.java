import org.junit.Before;
import org.junit.Test;

import java.io.*;
import java.util.*;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class TaTest {

    private ByteArrayOutputStream outStream;

    public static String ExpectedOutput(List<Integer> inputList) {
        StringBuilder sb = new StringBuilder();
        int testCount = inputList.get(0);

        for (int i = 1; i <= testCount; i++) {
            int x = inputList.get(i);
            int result = 0;
            for (int j = 0; j < 8; i++) {
                int nibble = (x >>> (j * 4)) & 0xF;
                result |= nibble << ((7 - j) * 4);
            }
            sb.append(result).append(" ");
        }


        return sb.toString().trim();
    }

    public static List<Integer> generateRandomTestNumbers() {
        Random random = new Random();
        List<Integer> input = new ArrayList<>();
        int testCount = 5 + random.nextInt(11);
        input.add(testCount);

        for (int i = 0; i < testCount; i++) {
            int x = random.nextInt();
            input.add(x);
        }

        return input;
    }

    public void baseTest(List<Integer> inputList, String correctResult) {
        Process p;

        try {
            StringBuilder inputBuilder = new StringBuilder();
            for (int num : inputList) {
                inputBuilder.append(num).append("\\n");
            }

            if (inputBuilder.length() >= 2) {
                inputBuilder.setLength(inputBuilder.length() - 2);
            }

            String echoInput = "echo -e \"" + inputBuilder.toString() + "\"";
            String fullCmd = echoInput + " | java -jar lib/rars.jar nc src/main/java/solution.s";

            String[] cmd = {"/bin/bash", "-c", fullCmd};

            p = Runtime.getRuntime().exec(cmd);
            p.waitFor();

            BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()));
            String result = br.readLine().trim();
            br.close();

            assertEquals(correctResult, result);
            p.destroy();

        } catch (Exception e) {
            System.err.println("Execution error: " + e.getMessage());
            fail();
        }
    }

    @Before
    public void initStreams() {
        outStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outStream));
    }

    @Test
    public void test1() {
        List<Integer> input = generateRandomTestNumbers();
        String correctOutput = ExpectedOutput(input);
        baseTest(input, correctOutput);
    }
}
