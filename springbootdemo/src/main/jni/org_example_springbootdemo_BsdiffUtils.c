#include <jni.h>
#include <stdio.h>
#include <sys/types.h>
#include "bzip2/bzlib.c"
#include "bzip2/crctable.c"
#include "bzip2/compress.c"
#include "bzip2/decompress.c"
#include "bzip2/randtable.c"
#include "bzip2/blocksort.c"
#include "bzip2/huffman.c"
#include "org_example_springbootdemo_BsdiffUtils.h"
#include "bsdiff.c"
#include "bspatch.c"

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


JNIEXPORT jint JNICALL Java_org_example_springbootdemo_BsdiffUtils_bspatch
  (JNIEnv *env, jclass clazz, jstring old, jstring new, jstring patch)
{
    int argc = 4;
    char *argv[argc];
    argv[0] = "bspatch";
    argv[1] = (char *)((*env) -> GetStringUTFChars(env, old, 0));
    argv[2] = (char *)((*env) -> GetStringUTFChars(env, new, 0));
    argv[3] = (char *)((*env) -> GetStringUTFChars(env, patch, 0));
    int result = Bspatch(argc, argv);
    //释放资源
    (*env) -> ReleaseStringUTFChars(env,old,argv[1]);
    (*env) -> ReleaseStringUTFChars(env,new,argv[2]);
    (*env) -> ReleaseStringUTFChars(env,patch,argv[3]);
    return result;
}