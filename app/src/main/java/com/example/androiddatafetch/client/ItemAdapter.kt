package com.example.androiddatafetch.client

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.androiddatafetch.R
import com.example.androiddatafetch.data.Item

class ItemAdapter(private val groupedItems: Map<Int, List<Item>>) :
    RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    private val sortedKeys = groupedItems.keys.sorted() // Sort listId for proper section order

    override fun getItemCount(): Int {
        return groupedItems.values.sumOf { it.size } + sortedKeys.size // Items + headers
    }

    override fun getItemViewType(position: Int): Int {
        var index = 0
        for (key in sortedKeys) {
            if (position == index) return 0 // Header type
            index++
            val size = groupedItems[key]?.size ?: 0
            if (position < index + size) return 1 // Item type
            index += size
        }
        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return if (viewType == 0) { // Header
            val view = inflater.inflate(R.layout.list_header, parent, false)
            HeaderViewHolder(view)
        } else { // Item
            val view = inflater.inflate(R.layout.list_item, parent, false)
            ItemViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        var index = 0
        for (key in sortedKeys) {
            if (position == index) {
                (holder as HeaderViewHolder).bind("List ID: $key") // Display header
                return
            }
            index++
            val items = groupedItems[key] ?: listOf()
            if (position < index + items.size) {
                (holder as ItemViewHolder).bind(items[position - index])
                return
            }
            index += items.size
        }
    }

    class HeaderViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val headerText: TextView = view.findViewById(R.id.header_text)
        fun bind(title: String) {
            headerText.text = title
        }
    }

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        private val itemText: TextView = view.findViewById(R.id.item_text)
        fun bind(item: Item) {
            itemText.text = item.name
        }
    }
}

