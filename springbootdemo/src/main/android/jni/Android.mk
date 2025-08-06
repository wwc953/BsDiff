LOCAL_PATH := $(call my-dir)

include $(CLEAR_VARS)

LOCAL_MODULE    := bsdiff-android
LOCAL_SRC_FILES := org_example_springbootdemo_BsdiffUtils.c
LOCAL_ALLOW_UNDEFINED_SYMBOLS :=true

include $(BUILD_SHARED_LIBRARY)