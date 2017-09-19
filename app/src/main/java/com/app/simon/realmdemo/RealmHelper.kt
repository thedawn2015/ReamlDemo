package com.app.simon.realmdemo

import android.annotation.SuppressLint
import io.realm.Realm
import io.realm.RealmConfiguration

/**
 * desc:
 * date: 2017/9/19

 * @author xw
 */
object RealmHelper {
    @SuppressLint("StaticFieldLeak")
    private var realm: Realm? = null

    fun getRealm(): Realm {
        if (realm == null) {
            realm = Realm.getInstance(RealmConfiguration.Builder()
                    .name("my_realm.realm") //文件名
                    .schemaVersion(0) //版本号
                    .build())
        }
        return realm!!
    }


}
