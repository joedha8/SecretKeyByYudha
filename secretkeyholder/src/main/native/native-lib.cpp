//
// Created by Vipul Asri on 02/04/17.
//

#include <jni.h>

extern "C" {

    JNIEXPORT jstring JNICALL
    Java_com_squareboat_secretkeys_CustomKeyHolder_getAPIKey(JNIEnv *env, jobject instance) {

        return env-> NewStringUTF("c2VjcmV0X2tleQ==");
    }

}

