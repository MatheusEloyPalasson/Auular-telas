package com.example.auular

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import com.example.auular.fragments.AppName
import com.example.auular.fragments.BotaoHome

class ErrorActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_error)

        val container = findViewById<LinearLayout>(R.id.container)
        val container2 = findViewById<LinearLayout>(R.id.container2)

        // Crie uma instância do fragmento
        val appName = AppName()
        val buttonHome = BotaoHome()

// Use o supportFragmentManager para iniciar a transação e adicionar o fragmento ao contêiner
        supportFragmentManager.beginTransaction()
            .add(R.id.container, appName)
            .commit()

        supportFragmentManager.beginTransaction()
            .add(R.id.container2, buttonHome)
            .commit()
    }
}