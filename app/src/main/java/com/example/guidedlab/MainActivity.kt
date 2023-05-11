package com.example.guidedlab

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
class MainActivity : AppCompatActivity() {

    enum class LoginSuccess
        constructor(val intValue: Int) {

            login(1),
            password(2),
            success(0)

        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtLogin = findViewById<TextView>(R.id.txtLoginEdit)
        val txtPassword = findViewById<TextView>(R.id.txtPasswordEdit)
        val txtButton = findViewById<Button>(R.id.txtButton)

        txtButton.setOnClickListener{
            when (CheckLogin(txtLogin.text.toString(), txtPassword.text.toString())){

                LoginSuccess.login -> {
                    Toast.makeText(applicationContext, getString(R.string.errMessageLogin), Toast.LENGTH_LONG).show()
                    txtLogin.requestFocus()
                }

                LoginSuccess.password -> {
                    Toast.makeText(applicationContext, getString(R.string.errMessagePassword), Toast.LENGTH_LONG).show()
                    txtPassword.requestFocus()
                }

                else ->
                    startActivity(Intent(this@MainActivity, MainTodoActivity::class.java))

            }
        }
    }

    fun CheckLogin(txtLogin: String, txtPassword: String): LoginSuccess{
        val holdLogin = "Matt"
        val holdPass = "password"

        if (holdLogin != txtLogin) {
            return LoginSuccess.login
        }
        return if (holdPass != txtPassword) {
            LoginSuccess.password
        } else LoginSuccess.success
    }
}