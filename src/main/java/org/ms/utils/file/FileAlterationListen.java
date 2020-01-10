package org.ms.utils.file;

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

    @Override
    public void onDirectoryCreate(File directory) {

    }


    @Override
    public void onDirectoryChange(File directory) {

    }

    @Override
    public void onDirectoryDelete(File directory) {

    }


    @Override
    public void onFileCreate(File file) {
        super.onFileCreate(file);

    }



    @Override
    public void onFileChange(File file) {
        super.onFileChange(file);

    }


    @Override
    public void onFileDelete(File file) {
        super.onFileDelete(file);

    }

    private static Logger logger;

    public static void main(String[] args) throws Exception {




        File dir = new File("G:\\SHARE\\");
        FileAlterationMonitor monitor = new FileAlterationMonitor();
        IOFileFilter filter = FileFilterUtils.or(FileFilterUtils.directoryFileFilter(), FileFilterUtils.fileFileFilter());

        FileAlterationObserver observer = new FileAlterationObserver(dir, filter);
        observer.addListener(new FileAlterationListen(dir));

        monitor.addObserver(observer);
        try {
            monitor.start();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
