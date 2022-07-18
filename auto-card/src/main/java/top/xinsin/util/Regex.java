package top.xinsin.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created On 7/11/22 9:18 AM
 *
 * @author xinsin
 * @version 1.0.0
 */
public class Regex {
    public static final String pattern = "([a-zA-Z\\d@.]*)(.*)";
    public static final Pattern r = Pattern.compile(pattern);

    public static String[] getPasswordAndAccount(String s){
        String[] result = new String[2];
        Matcher matcher = r.matcher(s);
        if(matcher.find()){
            result[0] = matcher.group(1);
            result[1] = matcher.group(2).substring(4);
        }
        return result;
    }
}
