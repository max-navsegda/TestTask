package max.com.testtask.activity.helper;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Maxim on 12/7/2017.
 */

public class JsonHelper {

    public static String inputStreamToString(InputStream inputStream) {
        try {
            byte[] bytes = new byte[inputStream.available()];
            inputStream.read(bytes, 0, bytes.length);
            String json = new String(bytes);
            return json;
        } catch (IOException e) {
            return null;
        }
    }
}
