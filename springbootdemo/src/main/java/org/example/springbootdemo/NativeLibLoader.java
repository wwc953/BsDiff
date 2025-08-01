//package org.example.springbootdemo;
//import cn.hutool.core.io.IoUtil;
//import cn.hutool.core.util.StrUtil;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.core.io.Resource;
//import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
//
//import java.io.*;
//
//public class NativeLibLoader {
//    private static final Logger logger = LoggerFactory.getLogger(NativeLibLoader.class);
//
//    public static void load(String[] snks) {
//        String currentOS = System.getProperty("os.name");
//        if (currentOS.contains("Windows")) {
//            linuxPrefix(new String[]{"dir"});
//            for (String snk : snks) {
//                if (StrUtil.endWithIgnoreCase(snk, "dll")) {
//                    loadFile(snk, snk);
//                }
//            }
//        } else if (currentOS.contains("Linux")) {
//            String linuxPrefix = linuxPrefix(new String[]{"/bin/bash", "-c", "cat /etc/*-release"});
//            for (String snk : snks) {
//                if (StrUtil.endWithIgnoreCase(snk, "so")) {
//                    loadFile(linuxPrefix + "-" + snk, snk);
//                }
//            }
//        } else if (currentOS.contains("Mac OS X")) {
//            linuxPrefix(new String[]{"ls"});
//            for (String snk : snks) {
//                if (StrUtil.endWithIgnoreCase(snk, "jnilib") || StrUtil.endWithIgnoreCase(snk, "dylib")) {
//                    loadFile(snk, snk);
//                }
//            }
//        } else {
//            logger.info("NativeLibLoader : not supported " + currentOS);
//        }
//    }
//
//    private static String linuxPrefix(String[] args) {
//        StringBuilder sbRead = new StringBuilder();
//        StringBuilder sbErr = new StringBuilder();
//        try {
//            // 启动另一个进程来执行命令
//            Process pro = Runtime.getRuntime().exec(args);
//            pro.waitFor();
//            try (BufferedReader read = new BufferedReader(new InputStreamReader(pro.getInputStream()));
//                 BufferedReader err = new BufferedReader(new InputStreamReader(pro.getErrorStream()))) {
//                String line;
//                while ((line = read.readLine()) != null) {
//                    logger.info(line);
//                    sbRead.append(line);
//                }
//
//                while ((line = err.readLine()) != null) {
//                    logger.error(line);
//                    sbErr.append(line);
//                }
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        String releaseInfo = sbRead.toString();
//        if (releaseInfo.contains("Debian")) {
//            return "debian";
//        }
//        return "centos";
//    }
//
//    public static void loadFile(String src, String snk) {
//        String srcAndPath = "classpath:" + src;
//        try {
//            logger.info("NativeLibLoader : copy " + srcAndPath + " to " + snk);
//            File file = copyResourceToTempDirFile(srcAndPath, snk);
//            String filePath = file.getAbsolutePath();
//            System.load(filePath);
//            logger.info("NativeLibLoader : load " + filePath + " successful");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    private static File copyResourceToTempDirFile(String src, String snk) throws IOException {
//        File tempDir = new File(System.getProperty("java.io.tmpdir"));
//        File tempDirFile = new File(tempDir, snk);
//
//        PathMatchingResourcePatternResolver patternResolver = new PathMatchingResourcePatternResolver();
//        Resource[] resources = patternResolver.getResources(src);
//
//        if (resources.length == 0) {
//            return null;
//        }
//
//        try (InputStream input = resources[0].getInputStream();
//             OutputStream output = new FileOutputStream(tempDirFile)) {
//            IoUtil.copy(input, output);
//            tempDirFile.deleteOnExit();
//            return tempDirFile;
//        } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
