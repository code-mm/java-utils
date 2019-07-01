package com.ms.utils.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public final class FileUtils {


    private FileUtils(){}

    public static final void mkdir(String path) {
        File file = new File(path);
        file.mkdir();
    }

    public static void mkdir(File file) {
        file.mkdir();
    }

    public static void mkdirs(String path) {
        File file = new File(path);
        file.mkdirs();
    }

    public static void mkdirs(File file) {
        file.mkdirs();
    }

    public static void createNewFile(String path) {
        File file = new File(path);
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void createNewFile(File file) {
        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void copyFile(String srcPath, String tagPath) {
        File srcFile = new File(srcPath);
        File tagFile = new File(tagPath);

        try {
            FileInputStream srcFis = new FileInputStream(srcFile);
            FileOutputStream tagFos = new FileOutputStream(tagFile);

            byte[] buf = new byte[1024 * 1024 * 8];
            int len = 0;
            while ((len = srcFis.read(buf)) != -1) {
                tagFos.write(buf, 0, len);
                tagFos.flush();
            }
            srcFis.close();
            tagFos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    public static void copyFile(File srcFile, File tagFile) {
        try {
            FileInputStream srcFis = new FileInputStream(srcFile);
            FileOutputStream tagFos = new FileOutputStream(tagFile);

            byte[] buf = new byte[1024 * 1024 * 8];
            int len = 0;
            while ((len = srcFis.read(buf)) != -1) {
                tagFos.write(buf, 0, len);
                tagFos.flush();
            }
            srcFis.close();
            tagFos.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void deleteFile(String path) {
        File file = new File(path);
        file.delete();
    }

    public static void deleteFile(File file) {
        file.delete();
    }
}
