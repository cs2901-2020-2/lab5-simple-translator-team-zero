import org.testng.Assert;
import org.testng.annotations.Test;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Test
public class TranslateTest {

    public void testCase0() throws Exception {
        generic(0);
    }

    @Test(invocationCount = 80, threadPoolSize = 80)
    public void testCase1() throws Exception {
        generic(0);
    }

    @Test(invocationCount = 80, threadPoolSize = 80)
    public void testCase1() throws Exception {
        generic(0);
    }

    private void generic(int i) throws Exception {
        String input = readInput(i);
        String output = readOutput(i);
        Translate tranlater = new Translate();
        String response = tranlater.translate(input);
        Assert.assertEquals(response, output);
    }

    private String readInput(int testNumber){
        List<String> lines = readFile(testNumber, "input");
        return lines.get(0);
    }

    private String readOutput(int testNumber){
        List<String> lines = readFile(testNumber, "output");
        return lines.get(0);
    }

    public List<String> readFile(int testNumber, String type){
        String fileName = "test_case<testNumber>_<type>";
        fileName = fileName.replace("<testNumber>", Integer.toString(testNumber));
        fileName = fileName.replace("<type>", type);
        InputStream is = getClass().getClassLoader().getResourceAsStream(fileName);
        Scanner scan = new Scanner(is);
        List<String> lines = new ArrayList<String>();
        while(scan.hasNextLine()) {
            String line = scan.nextLine();
            lines.add(line);
        }
        return lines;
    }
}
