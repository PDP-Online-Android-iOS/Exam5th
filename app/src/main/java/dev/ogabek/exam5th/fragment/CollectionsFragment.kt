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
import dev.ogabek.exam5th.model.Collections

class CollectionsFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view =  inflater.inflate(R.layout.fragment_collections, container, false)

        val collections: RecyclerView = view.findViewById(R.id.rv_collections)

        collections.layoutManager = GridLayoutManager(requireContext(), 1)
        collections.adapter = CollectionsAdapter(requireContext(),
            prepareCollections() as ArrayList<Collections>
        )

        return view
    }

    private fun prepareCollections(): List<Collections> {
        return ArrayList<Collections>().apply {
            this.add(Collections(R.drawable.collections_hotel, "Hotels"))
            this.add(Collections(R.drawable.collections_hotel, "Hotels"))
            this.add(Collections(R.drawable.collections_hotel, "Hotels"))
            this.add(Collections(R.drawable.collections_hotel, "Hotels"))
            this.add(Collections(R.drawable.collections_hotel, "Hotels"))
            this.add(Collections(R.drawable.collections_hotel, "Hotels"))
            this.add(Collections(R.drawable.collections_hotel, "Hotels"))
            this.add(Collections(R.drawable.collections_hotel, "Hotels"))
            this.add(Collections(R.drawable.collections_hotel, "Hotels"))
            this.add(Collections(R.drawable.collections_hotel, "Hotels"))
            this.add(Collections(R.drawable.collections_hotel, "Hotels"))
            this.add(Collections(R.drawable.collections_hotel, "Hotels"))
            this.add(Collections(R.drawable.collections_hotel, "Hotels"))
            this.add(Collections(R.drawable.collections_hotel, "Hotels"))
            this.add(Collections(R.drawable.collections_hotel, "Hotels"))
        }
    }

}