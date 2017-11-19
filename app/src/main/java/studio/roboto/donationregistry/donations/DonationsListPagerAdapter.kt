package studio.roboto.donationregistry.donations

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter

class DonationsListPagerAdapter(fm: FragmentManager,
                                val tabTitles: Array<String>): FragmentPagerAdapter(fm) {

    override fun getItem(position: Int): Fragment {
        val fragment = DonationsListFragment.newInstance(1)
        return fragment
    }

    override fun getCount(): Int {
        return 3
    }

    override fun getPageTitle(position: Int): CharSequence {
        return tabTitles[position]
    }
}