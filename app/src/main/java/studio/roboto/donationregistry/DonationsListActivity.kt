package studio.roboto.donationregistry

import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_donations_list.*
import net.hockeyapp.android.CrashManager
import net.hockeyapp.android.UpdateManager

class DonationsListActivity : AppCompatActivity() {

    //region AppCompatActivity
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_donations_list)

        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        if (BuildConfig.DEBUG) {
            checkForUpdates()
        }
    }

    override fun onResume() {
        super.onResume()

        checkForCrashes()
    }

    override fun onPause() {
        super.onPause()

        if (BuildConfig.DEBUG) {
            unregisterManagers()
        }
    }

    override fun onDestroy() {
        super.onDestroy()

        if (BuildConfig.DEBUG) {
            unregisterManagers()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings ->
                return true
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_donations_list, menu)
        return true
    }
    //endregion

    //region HockeyApp setup
    fun checkForUpdates() {
        UpdateManager.register(this)
    }

    fun checkForCrashes() {
        CrashManager.register(this)
    }

    fun unregisterManagers() {
        UpdateManager.unregister()
    }
    //endregion
}
