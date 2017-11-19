package studio.roboto.donationregistry.add_donation

import android.os.Bundle
import android.support.design.widget.CollapsingToolbarLayout
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_add_donation.*
import studio.roboto.donationregistry.R

class AddDonationActivity : AppCompatActivity() {

    var mCollapsingToolbarLayout: CollapsingToolbarLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_donation)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        findViews()
        initViews()
    }

    fun findViews() {
        mCollapsingToolbarLayout = findViewById(R.id.toolbar_layout)
    }

    fun initViews() {
        mCollapsingToolbarLayout!!
                .setCollapsedTitleTextColor(ContextCompat.getColor(this, android.R.color.white));

        mCollapsingToolbarLayout!!
                .setExpandedTitleColor(ContextCompat.getColor(this, android.R.color.transparent));
    }
}
