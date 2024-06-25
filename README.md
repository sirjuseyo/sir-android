
[![](https://jitpack.io/v/sirjuseyo/sir-android.svg)](https://jitpack.io/#sirjuseyo/sir-android)

# Sir-android
android project 용 library 임.
소스 내용을 sir-android 로 모두 이동하고, 이 프로젝트는 더 이상 사용하지 않음. (2024-06-25)


## Setup
Add the JitPack repository in your build.gradle (top level module):
```gradle
allprojects {
    repositories {
        jcenter()
        maven { url "https://jitpack.io" }
    }
}
```

And add next dependencies in the build.gradle of the module:
```gradle
dependencies {
    implementation 'com.github.sirjuseyo:sir-android:1.0.3'
}
```
