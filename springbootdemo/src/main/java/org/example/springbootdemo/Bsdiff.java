//package org.example.springbootdemo;
//
//import java.net.URL;
//
///**
// * Created by ywl on 2017-10-23.
// */
//public class Bsdiff {
//
//    public static Bsdiff instance = new Bsdiff();
//
//    public Bsdiff() {
//    }
//
//    public static Bsdiff getInstance() {
//        return instance;
//    }
//
//    public native static int bsdiff(String oldfile, String newfile, String patchfile);
//
//    public native static int bspatch(String oldfile, String newfile, String patchfile);
//
//    //    static String path="/Users/wangwc/Downloads/bsdiff-4.3/bsdiff";
//    static String path = "/Users/wangwc/IdeaProjects/springbootdemo/src/main/resources/lib/bsdiff.so";
//
//    static {
//        System.load(path);
////        NativeLibLoader.load(new String[]{path});
//    }
//
//
//}
