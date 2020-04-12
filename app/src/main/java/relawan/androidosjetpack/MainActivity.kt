package relawan.androidosjetpack

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.onNavDestinationSelected

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = this.findNavController(R.id.nav_host_fragment)

        val appBarConfiguration = AppBarConfiguration
            .Builder(
                R.id.listFragment,
                R.id.gridFragment,
                R.id.cardFragment)
            .build()


        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration)
    }

    // show back up button
    override fun onSupportNavigateUp(): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        return navController.navigateUp()
    }




    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val navController = this.findNavController(R.id.nav_host_fragment)
        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.listFragment -> {
                    menuInflater.inflate(R.menu.menu_main, menu)
                }
                R.id.gridFragment -> {
                    menuInflater.inflate(R.menu.menu_main, menu)
                }
                R.id.cardFragment -> {
                    menuInflater.inflate(R.menu.menu_main, menu)
                }
                else -> menu?.clear()
            }
        }
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return item.onNavDestinationSelected(navController) || super.onOptionsItemSelected(item)
    }

}
