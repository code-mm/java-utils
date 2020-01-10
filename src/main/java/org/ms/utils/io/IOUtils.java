package org.ms.utils.io;

import java.io.Closeable;
import java.io.IOException;

/**
 * @author maohuawei created in 2018/10/8
 * <p>
 */
public final class IOUtils {
    private IOUtils(){}

    public static void close(Closeable object) {
        if (object != null) {
            try {
                object.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
