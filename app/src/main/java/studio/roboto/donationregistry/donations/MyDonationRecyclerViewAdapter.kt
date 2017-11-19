package studio.roboto.donationregistry.donations

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import studio.roboto.donationregistry.R
import studio.roboto.donationregistry.donations.DonationsListFragment.OnListFragmentInteractionListener
import studio.roboto.donationregistry.dummy.DummyContent.DummyItem

/**
 * [RecyclerView.Adapter] that can display a [DummyItem] and makes a call to the
 * specified [OnListFragmentInteractionListener].
 * TODO: Replace the implementation with code for your data type.
 */
class MyDonationRecyclerViewAdapter(
        private val mValues: List<DummyItem>,
        private val mListener: OnListFragmentInteractionListener?) :
        RecyclerView.Adapter<MyDonationRecyclerViewAdapter.ViewHolder>() {

    var mContext: Context? = null

    public override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_donation_list_item, parent, false)
        mContext = parent.context
        return ViewHolder(view)
    }

    public override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        if (position >= 1) {
            holder.mItem = mValues.get(position - 1)
            holder.mNameView.setText(mValues.get(position - 1).id)
            holder.mAmountView.setText(mValues.get(position - 1).content)
            holder.mDateView.text = ""

            holder.mView.setOnClickListener { mListener?.onListFragmentInteraction(holder.mItem!!) }
        } else {
            holder.mNameView.text = mContext!!.getString(R.string.name)
            holder.mAmountView.text = mContext!!.getString(R.string.amount)
            holder.mDateView.text = mContext!!.getString(R.string.date)

            holder.mView.setOnClickListener(null)
        }
    }

    public override fun getItemCount(): Int {
        return mValues.size + 1
    }

    inner class ViewHolder(val mView: View) : RecyclerView.ViewHolder(mView) {
        val mNameView = mView.findViewById<TextView>(R.id.name)
        val mAmountView = mView.findViewById<TextView>(R.id.amount)
        val mDateView = mView.findViewById<TextView>(R.id.date)

        var mItem: DummyItem? = null

        public override fun toString(): String {
            return super.toString() + " '" + mAmountView.text + "'"
        }
    }
}
