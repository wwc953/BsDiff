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

                System.out.println("======"+System.getProperty("java.library.path"));

        //System.load  so文件绝对路径
//        System.load("/Users/wangwc/IdeaProjects/BsDiff/springbootdemo/src/main/resources/lib/libbsdiff.so");

        /**
         * 动态链接
         * 1、linux -> *.so  mac -> *.jnilib   jnilib将so改后缀即可
         * 2、System.loadLibrary加载去除名称前面的lib和后缀
         * 3、运行时指定java.library.path  java -Djava.library.path=/Users/wangwc/IdeaProjects/BsDiff/springbootdemo/src/main/resources/libmac -jar xxx.jar
         */
        System.loadLibrary("bsdiff");

    }


}
