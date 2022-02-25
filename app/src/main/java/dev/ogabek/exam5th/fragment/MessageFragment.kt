package dev.ogabek.exam5th.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dev.ogabek.exam5th.R
import dev.ogabek.exam5th.adapter.CollectionsAdapter
import dev.ogabek.exam5th.adapter.MessageAdapter
import dev.ogabek.exam5th.model.Message

class MessageFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_message, container, false)

        val messages: RecyclerView = view.findViewById(R.id.rv_messages)

        messages.layoutManager = GridLayoutManager(requireContext(), 1)
        messages.adapter = MessageAdapter(requireContext(), prepareMessages())

        return view
    }

    private fun prepareMessages(): ArrayList<Message> {
        return ArrayList<Message>().apply{
            this.add(Message(R.drawable.user, "OgabekDev", getString(R.string.assalomu_alaykum_yordamiz_kerak_edi)))
            this.add(Message(R.drawable.user, "OgabekDev", getString(R.string.assalomu_alaykum_yordamiz_kerak_edi)))
            this.add(Message(R.drawable.user, "OgabekDev", getString(R.string.assalomu_alaykum_yordamiz_kerak_edi)))
            this.add(Message(R.drawable.user, "OgabekDev", getString(R.string.assalomu_alaykum_yordamiz_kerak_edi)))
            this.add(Message(R.drawable.user, "OgabekDev", getString(R.string.assalomu_alaykum_yordamiz_kerak_edi)))
        }
    }

}