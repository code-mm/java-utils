package org.ms.utils.file;

import java.io.*;

public final class FileUtils {

    private FileUtils() {
    }

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

    public static byte[] getBytesByFile(String filePath) {
        try {
            File file = new File(filePath);

            FileInputStream fis = new FileInputStream(file);


            ByteArrayOutputStream bos = new ByteArrayOutputStream(1024);

            byte[] b = new byte[1024];
            int n;
            while ((n = fis.read(b)) != -1) {
                bos.write(b, 0, n);
            }
            fis.close();

            byte[] data = bos.toByteArray();

            bos.close();
            return data;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    public static void getFileByBytes(byte[] bytes, String filePath, String fileName) {
        BufferedOutputStream bos = null;
        FileOutputStream fos = null;
        File file = null;
        try {
            File dir = new File(filePath);
            if (!dir.exists() && dir.isDirectory()) {
                dir.mkdirs();
            }
            file = new File(filePath + "\\" + fileName);

            fos = new FileOutputStream(file);

            bos = new BufferedOutputStream(fos);

            bos.write(bytes);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (bos != null) {
                try {
                    bos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
