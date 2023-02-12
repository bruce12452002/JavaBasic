#include <jni.h>
#include <stdio.h>
#include <D:\JavaBasic\src\my_native\my_native_TestNative.h>

/*
 * Class:     my_native_TestNative
 * Method:    helloNative1
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_my_1native_TestNative_helloNative1
  (JNIEnv *, jobject) {
      printf("%s", "helloNative1\n");
  }

/*
 * Class:     my_native_TestNative
 * Method:    helloNative2
 * Signature: ()V
 */
JNIEXPORT void JNICALL Java_my_1native_TestNative_helloNative2
  (JNIEnv *, jclass){
      printf("%s", "helloNative2\n");
  }