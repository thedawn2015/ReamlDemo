package com.app.simon.realmdemo

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.realm.Realm
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        init()
        assignViews()
    }

    private fun assignViews() {
        btn_add.setOnClickListener {
            RealmHelper.getRealm().executeTransaction {
                val user = it.createObject(User::class.java)
                user.id = 101
                user.name = "赵云"
            }
        }
        btn_delete.setOnClickListener {

        }
        btn_update.setOnClickListener {

        }
        btn_query.setOnClickListener {

        }
    }

    private fun init() {
        Realm.init(this)
//        val realm = Realm.getDefaultInstance()
        /*val config = RealmConfiguration.Builder()
                .name("my_realm.realm") //文件名
                .schemaVersion(0) //版本号
                .build()*/
        RealmHelper.getRealm()
    }

    override fun onDestroy() {
        super.onDestroy()
        RealmHelper.getRealm().close()
    }
}
