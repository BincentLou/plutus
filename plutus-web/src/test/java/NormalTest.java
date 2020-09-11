import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @version $Id: null.java, v 1.0 2020/9/4 12:31 PM david Exp $$
 * @Author:louwenbin(louwb@runyong.cn)
 * @Description:${TODO}(这里用一句话描述这个类的作用)
 * @since 1.0
 **/
public class NormalTest {

    public static void main(String[] args) throws ParseException {

        String  YYYY_MM_DD = "yyyy-MM-dd";
        DateFormat dateFormat = new SimpleDateFormat(YYYY_MM_DD);
        String aa = "日报_"+dateFormat.format(new Date())+".xlsx";

        System.out.println(aa);
    }
}
