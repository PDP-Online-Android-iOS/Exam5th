package dev.ogabek.exam5th.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import dev.ogabek.exam5th.R
import dev.ogabek.exam5th.model.Message

class MessageAdapter(val context: Context, val messages: List<Message>): RecyclerView.Adapter<RecyclerView.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_messages, parent, false)
        return MessageViewHolder(view)
    }

    class MessageViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val image: ShapeableImageView = view.findViewById(R.id.message_photo)
        val name: TextView = view.findViewById(R.id.message_name)
        val text: TextView = view.findViewById(R.id.message_text)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val message = messages[position]

        if (holder is MessageViewHolder) {
            holder.apply {
                image.setImageResource(message.photo)
                name.text = message.name
                text.text = message.text
            }
        }

    }

    override fun getItemCount() = messages.size
}