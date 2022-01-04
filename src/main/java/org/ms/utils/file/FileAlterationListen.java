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

import java.io.File;
import org.apache.commons.io.filefilter.FileFilterUtils;
import org.apache.commons.io.filefilter.IOFileFilter;
import org.apache.commons.io.monitor.FileAlterationListenerAdaptor;
import org.apache.commons.io.monitor.FileAlterationMonitor;
import org.apache.commons.io.monitor.FileAlterationObserver;
import org.apache.log4j.Logger;


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
        IOFileFilter filter =
                FileFilterUtils.or(FileFilterUtils.directoryFileFilter(), FileFilterUtils.fileFileFilter());

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
