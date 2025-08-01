
#编译java文件为class
javac org.example.springbootdemo.Bsdiff.java

#生成org_example_springbootdemo_BsdiffUtils.h头文件
javah -jni -classpath /Users/wangwc/IdeaProjects/springbootdemo/target/classes org.example.springbootdemo.BsdiffUtils

#进入c目录，将bzip2和bsdiff源码放入c目录
cd c

#修改bsdiff.c 
#include "org_example_springbootdemo_BsdiffUtils.h"

#include <sys/types.h>

//#include <bzlib.h>
#include "bzip2/bzlib.c"
#include "bzip2/crctable.c"
#include "bzip2/compress.c"
#include "bzip2/decompress.c"
#include "bzip2/randtable.c"
#include "bzip2/blocksort.c"
#include "bzip2/huffman.c"
//引入 jni 库
#include <jni.h>

mian改成Bsdiff

新增代码
JNIEXPORT jint JNICALL Java_org_example_springbootdemo_BsdiffUtils_bsdiff
  (JNIEnv *env, jclass clazz, jstring old, jstring new, jstring patch)
{
    int argc = 4;
    char *argv[argc];
    argv[0] = "bsdiff";
    argv[1] = (char *)((*env) -> GetStringUTFChars(env, old, 0));
    argv[2] = (char *)((*env) -> GetStringUTFChars(env, new, 0));
    argv[3] = (char *)((*env) -> GetStringUTFChars(env, patch, 0));
    int result = Bsdiff(argc, argv);
    //释放资源
    (*env) -> ReleaseStringUTFChars(env,old,argv[1]);
    (*env) -> ReleaseStringUTFChars(env,new,argv[2]);
    (*env) -> ReleaseStringUTFChars(env,patch,argv[3]);
    return result;
}

gcc -fPIC -D_REENTRANT -I/Library/Java/JavaVirtualMachines/jdk1.8.0_251.jdk/Contents/Home/include -I/Library/Java/JavaVirtualMachines/jdk1.8.0_251.jdk/Contents/Home/include/darwin -I/Users/wangwc/IdeaProjects/springbootdemo/src/main/c/bzip2 -I/Users/Ivonhoe/Downloads/VelocityDemo/src/main/c -c ./bsdiff.c

gcc bsdiff.o -o bsdiff.so -shared -v

#修改bspatch.c 参考bsdiff.c

gcc -fPIC -D_REENTRANT -I/Library/Java/JavaVirtualMachines/jdk1.8.0_251.jdk/Contents/Home/include -I/Library/Java/JavaVirtualMachines/jdk1.8.0_251.jdk/Contents/Home/include/darwin  -I/Users/wangwc/IdeaProjects/springbootdemo/src/main/c/bzip2 -I/Users/wangwc/IdeaProjects/springbootdemo/src/main/c -c ./bspatch.c

gcc bspatch.o -o bspatch.so -shared -v




