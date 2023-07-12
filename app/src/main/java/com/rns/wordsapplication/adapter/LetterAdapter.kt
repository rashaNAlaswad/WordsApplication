package com.rns.wordsapplication.adapter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.findNavController
import androidx.recyclerview.widget.RecyclerView
import com.rns.wordsapplication.LetterListFragmentDirections
import com.rns.wordsapplication.R

class LetterAdapter : RecyclerView.Adapter<LetterAdapter.LetterViewHolder>() {

    private val charList: List<Char> = ('A'..'Z').toList()

    class LetterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val button = itemView.findViewById<Button>(R.id.button_item)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): LetterViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.item_view, parent, false)
        return LetterViewHolder(layout)
    }

    override fun getItemCount(): Int = charList.size

    override fun onBindViewHolder(holder: LetterViewHolder, position: Int) {
        holder.button.text = charList[position].toString()

        holder.button.setOnClickListener {
            val action = LetterListFragmentDirections.actionLetterListFragmentToWordListFragment(letter = holder.button.text.toString())
            holder.itemView.findNavController().navigate(action)
        }
    }
}