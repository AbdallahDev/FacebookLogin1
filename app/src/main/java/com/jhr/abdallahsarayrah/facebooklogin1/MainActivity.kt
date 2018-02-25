package com.jhr.abdallahsarayrah.facebooklogin1

import android.annotation.SuppressLint
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.facebook.CallbackManager
import com.facebook.FacebookSdk
import com.facebook.FacebookException
import com.facebook.login.LoginResult
import com.facebook.FacebookCallback
import com.facebook.login.LoginManager
import android.content.Intent
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    private var callbackManager: CallbackManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        callbackManager = CallbackManager.Factory.create()

        LoginManager.getInstance().registerCallback(callbackManager,
                object : FacebookCallback<LoginResult> {
                    @SuppressLint("SetTextI18n")
                    override fun onSuccess(loginResult: LoginResult) {
                        textView.text = "success ${loginResult.accessToken}"
                    }

                    override fun onCancel() {
                        textView.text = "cancel"
                    }

                    override fun onError(exception: FacebookException) {
                        // App code
                    }
                })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent) {
        callbackManager!!.onActivityResult(requestCode, resultCode, data)
        super.onActivityResult(requestCode, resultCode, data)
    }
}
