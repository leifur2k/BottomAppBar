package com.example.material

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import com.example.material.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var binding:ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        // Показать Бар при загрузке Приложения
        setSupportActionBar(binding?.bottomBar)

        // Клики по бару (В методе)
        binding?.bottomBar?.setOnMenuItemClickListener { menuItem -> itemSelected(menuItem)}

    }

    // Надуваем бар
    override fun onCreateOptionsMenu(menu: Menu): Boolean {

        val menuInflater = menuInflater

        menuInflater.inflate(R.menu.bottom_menu, menu)

        return true

    }

    // Метод нажатий на иконки бара
    private fun itemSelected(item: MenuItem):Boolean {

        when(item.itemId) {

            R.id.shopItemBottomNav ->  supportFragmentManager.beginTransaction().replace(R.id.content,
                Shop()
            ).commit()

            R.id.deliveryItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content,
                Delivery()
            ).commit()

            R.id.accountItemBottomNav -> supportFragmentManager.beginTransaction().replace(R.id.content,
                Account()
            ).commit()
        }

        return true
    }


}