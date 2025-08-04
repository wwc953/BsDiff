cd ./jni
#so名称前需要加lib   libxxx.so
gcc -fPIC -I/Library/Java/JavaVirtualMachines/jdk1.8.0_251.jdk/Contents/Home/include -I/Library/Java/JavaVirtualMachines/jdk1.8.0_251.jdk/Contents/Home/include/darwin  -shared -o libbsdiff.so org_example_springbootdemo_BsdiffUtils.c