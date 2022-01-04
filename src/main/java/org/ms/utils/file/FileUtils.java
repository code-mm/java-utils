/*
 * Copyright (c) 2022 MS <mhw828@gmail.com>
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated
 * documentation files (the "Software"), to deal in the Software without restriction, including without limitation the
 * rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to
 * permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the
 * Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package org.ms.utils.file;

import java.io.*;

public final class FileUtils {

    private FileUtils() {}

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


    // 拷贝文件
    public static void copyFile(InputStream inputStream, OutputStream outputStream) {
        try {
            byte buf[] = new byte[1024 * 8];
            int len = 0;
            while ((len = inputStream.read(buf)) != -1) {
                outputStream.write(buf, 0, len);
                outputStream.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                outputStream.close();
                inputStream.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
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

    /**
     * 文件夹的拷贝
     *
     * @param sourcePath
     * @param newPath
     */
    public static void copyDir(String sourcePath, String newPath) {
        File start = new File(sourcePath);
        File end = new File(newPath);
        String[] filePath = start.list(); // 获取该文件夹下的所有文件以及目录的名字
        if (!end.exists()) {
            end.mkdir();
        }
        for (String temp : filePath) {
            // 查看其数组中每一个是文件还是文件夹
            if (new File(sourcePath + File.separator + temp).isDirectory()) {
                // 为文件夹，进行递归
                copyDir(sourcePath + File.separator + temp, newPath + File.separator + temp);
            } else {
                // 为文件则进行拷贝
                copyFile(sourcePath + File.separator + temp, newPath + File.separator + temp);
            }
        }
    }
}
