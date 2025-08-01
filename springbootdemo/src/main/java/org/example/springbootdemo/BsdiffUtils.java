package org.example.springbootdemo;

/**
 * Created by ywl on 2017-10-23.
 */
public class BsdiffUtils {

    public static BsdiffUtils instance = new BsdiffUtils();

    public BsdiffUtils() {
    }

    public static BsdiffUtils getInstance() {
        return instance;
    }

    public native static int bsdiff(String oldfile, String newfile, String patchfile);

    public native static int bspatch(String oldfile, String newfile, String patchfile);

    static {
        System.load("/Users/wangwc/IdeaProjects/BsDiff/springbootdemo/src/main/resources/lib/bsdiff.so");
        System.load("/Users/wangwc/IdeaProjects/BsDiff/springbootdemo/src/main/resources/lib/bspatch.so");
    }


}
