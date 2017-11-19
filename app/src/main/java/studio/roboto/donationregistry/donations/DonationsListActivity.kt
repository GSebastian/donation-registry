package studio.roboto.donationregistry.donations

import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.design.widget.Snackbar
import android.support.design.widget.TabLayout
import android.support.v4.view.ViewPager
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_donations_list.*
import net.hockeyapp.android.CrashManager
import net.hockeyapp.android.UpdateManager
import studio.roboto.donationregistry.BuildConfig
import studio.roboto.donationregistry.DataConnector
import studio.roboto.donationregistry.R
import studio.roboto.donationregistry.donations.DonationsListFragment.OnListFragmentInteractionListener
import studio.roboto.donationregistry.dummy.DummyContent
import studio.roboto.donationregistry.other.TimeFilter

class DonationsListActivity : AppCompatActivity(), OnListFragmentInteractionListener {

    var mViewPager: ViewPager? = null
    var mTimeFilterTabs: TabLayout? = null
    var mCollapsingToolbarLayout: CollapsingToolbarLayout? = null

    var mCurrentTimeFilter: TimeFilter = TimeFilter.DAILY
        set(value) {
            mCollapsingToolbarLayout!!.title =
                    getString(
                            R.string.donations_total_for_time,
                            getString(value.stringTag()),
                            DataConnector.getTotalDonations(value))
        }

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

        findViews()
        initViews()
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
            R.id.action_export ->
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

    //region Methods
    fun findViews() {
        mViewPager = findViewById(R.id.vp_donations_list)
        mTimeFilterTabs = findViewById(R.id.tl_tile_filter_tabs);
        mCollapsingToolbarLayout = findViewById(R.id.toolbar_layout)
    }

    fun initViews() {
        setupFragments()

        mTimeFilterTabs!!.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabReselected(tab: TabLayout.Tab?) {}

            override fun onTabUnselected(tab: TabLayout.Tab?) {}

            override fun onTabSelected(tab: TabLayout.Tab?) {
                val position = tab!!.position
                mCurrentTimeFilter = TimeFilter.forId(position)
            }
        })
    }

    fun setupFragments() {
        val tabTitles = arrayOf(getString(R.string.daily), getString(R.string.monthly), getString(R.string.yearly))
        val adapter = DonationsListPagerAdapter(supportFragmentManager, tabTitles)

        mViewPager?.adapter = adapter
    }
    //endregion

    //region OnListFragmentInteractionListener
    override fun onListFragmentInteraction(item: DummyContent.DummyItem) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
    //endregion
}
