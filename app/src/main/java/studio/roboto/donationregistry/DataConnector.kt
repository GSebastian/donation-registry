package studio.roboto.donationregistry

import studio.roboto.donationregistry.other.TimeFilter

object DataConnector {

    fun getTotalDonations(timeFilter: TimeFilter): Float {
        // TODO: Implement this
        return when (timeFilter) {
            TimeFilter.DAILY -> 126.2f
            TimeFilter.MONTHLY -> 600.25f
            TimeFilter.YEARLY -> 12542.1f
        }
    }
}