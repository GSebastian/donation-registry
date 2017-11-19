package studio.roboto.donationregistry.other

import studio.roboto.donationregistry.R

enum class TimeFilter() {
    DAILY {
        override fun id(): Int = 0
        override fun stringTag(): Int = R.string.daily
    },
    MONTHLY {
        override fun id(): Int = 1
        override fun stringTag(): Int = R.string.monthly
    },
    YEARLY {
        override fun id(): Int = 2
        override fun stringTag(): Int = R.string.yearly
    };

    abstract fun stringTag(): Int
    abstract fun id(): Int

    companion object {
        fun forId(id: Int): TimeFilter {
            return when (id) {
                0 -> DAILY
                1 -> MONTHLY
                2 -> YEARLY
                else -> {
                    throw RuntimeException("Unrecognized id for TimeFilter")
                }
            }
        }
    }
}