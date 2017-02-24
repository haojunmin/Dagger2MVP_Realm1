这是一个使用MVP架构，加上Dagger2，来操作Realm数据库，供大家参考。
目前的Realm和Dagger2都是最新版本，Realm在版本更新过程中有些方法就不能用了，提醒大家注意。
在使用realm过程中出现一个问题：
xxxis not part of the schema for this Realm
这是我在谷歌上面搜索到的解决方案
This failed.

apply plugin: 'com.android.application'
apply plugin: 'realm-android'
apply plugin: 'android-apt'
apply plugin: 'com.neenbedankt.android-apt'



Yet this worked (note how real-android is last).

apply plugin: 'com.android.application'
apply plugin: 'android-apt'
apply plugin: 'com.neenbedankt.android-apt'
apply plugin: 'realm-android'
