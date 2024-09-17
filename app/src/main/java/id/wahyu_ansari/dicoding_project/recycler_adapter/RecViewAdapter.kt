package id.wahyu_ansari.dicoding_project.recycler_adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import id.wahyu_ansari.dicoding_project.R
import id.wahyu_ansari.dicoding_project.utils.DataLoader.Companion.HistoricalPlace
import id.wahyu_ansari.dicoding_project.utils.DataLoader.Companion.centerCrop
import id.wahyu_ansari.dicoding_project.utils.DataLoader.Companion.resize
import id.wahyu_ansari.dicoding_project.utils.DataLoader.Companion.toBitmap

class RecViewAdapter(
    private val dataSet: MutableList<HistoricalPlace>
) : RecyclerView.Adapter<RecViewAdapter.ViewHolder>() {
    private var onClickListener: ((HistoricalPlace) -> Unit)? = null
    class ViewHolder(
        view: View, onClickListener: ((HistoricalPlace) -> Unit)? = null
    ) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.findViewById(R.id.list_item_title)
        val summary: TextView = view.findViewById(R.id.list_item_summary)
        val icon: ImageView = view.findViewById(R.id.icon)
        var rowData: HistoricalPlace? = null
        init { view.setOnClickListener { onClickListener?.invoke(rowData!!) } }
    }

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(viewGroup.context)
        val view = inflater.inflate(R.layout.recycler_view_item, viewGroup, false)
        return ViewHolder(view, onClickListener)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        try {
            viewHolder.title.text = dataSet[position].title
            viewHolder.summary.text = dataSet[position].description

            // Resize the icon to 10% of its original size to make RecyclerView faster
            viewHolder.icon.setImageBitmap(dataSet[position].icon.toBitmap().centerCrop().resize(0.1f))
            viewHolder.rowData = dataSet[position]
        } catch (e: Exception) { e.printStackTrace() }
    }

    override fun getItemCount() = dataSet.size

    /* commented out because this function is not used in this project
    fun edit(data: HistoricalPlace, position: Int) {
        dataSet[position] = data
        notifyItemChanged(position)
    }

    fun insertNewData(data: HistoricalPlace) {
        dataSet.add(data)
        notifyItemInserted(itemCount)
    }

    fun delete(position: Int) {
        dataSet.removeAt(position)
        notifyItemRemoved(position)
    }
    */

    fun setOnClickListener(listener: (HistoricalPlace) -> Unit) { onClickListener = listener }
}
