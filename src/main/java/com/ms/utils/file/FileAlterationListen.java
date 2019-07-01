package com.ms.utils.file;

import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.log4j.Logger;

import java.io.File;


public class FileAlterationListen extends FileAlterationListenerAdaptor {


    public File DirContext;

    public FileAlterationListen(File dirContext) {
        super();
        DirContext = dirContext;
    }

    //文件夹创建
    @Override
    public void onDirectoryCreate(File directory) {
        logger.info("文件夹创建 : " + directory.getPath());
    }

    //文件夹改变
    @Override
    public void onDirectoryChange(File directory) {
        logger.info("文件夹改变 : " + directory.getPath());
    }

    //文件夹删除
    @Override
    public void onDirectoryDelete(File directory) {
        logger.info("文件夹删除 : " + directory.getPath());
    }

    //文件创建
    @Override
    public void onFileCreate(File file) {
        super.onFileCreate(file);
        logger.info("文件创建 : " + file.getPath());



    }


    //文件夹改变
    @Override
    public void onFileChange(File file) {
        super.onFileChange(file);
        logger.info("文件改变 : " + file.getPath());
    }

    //文件删除
    @Override
    public void onFileDelete(File file) {
        super.onFileDelete(file);
        logger.info("文件删除 : " + file.getPath());
    }

    private static Logger logger;

    public static void main(String[] args) throws Exception {

        logger = Logger.getLogger("logRollingFile");


        File dir = new File("G:\\SHARE\\");
        FileAlterationMonitor monitor = new FileAlterationMonitor();
        IOFileFilter filter = FileFilterUtils.or(FileFilterUtils.directoryFileFilter(), FileFilterUtils.fileFileFilter());

        FileAlterationObserver observer = new FileAlterationObserver(dir, filter);
        observer.addListener(new FileAlterationListen(dir));

        monitor.addObserver(observer);
        try {
            //开始监听
            monitor.start();
            System.out.println("文件监听 | START ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
