import org.junit.Test;
import top.xinsin.util.ReadJson;

import java.io.File;

/**
 * Created On 7/18/22 8:32 PM
 *
 * @author xinsin
 * @version 1.0.0
 */
public class Test01 {
    @Test
    public void test01() {
        System.out.println(ReadJson.isFlies(new File("res/cards.json")));
    }
}
