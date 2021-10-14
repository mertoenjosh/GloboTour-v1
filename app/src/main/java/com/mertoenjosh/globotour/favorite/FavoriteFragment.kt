package com.mertoenjosh.globotour.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.mertoenjosh.globotour.R
import com.mertoenjosh.globotour.city.City
import com.mertoenjosh.globotour.city.VacationSpots


class FavoriteFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        val view = inflater.inflate(R.layout.fragment_favorite_list, container, false)

        setUpRecyclerView(view)

        return view
    }

    private fun setUpRecyclerView(view: View) {
        val context = requireContext()

        // create an instance of the adapter
        val favCityList = VacationSpots.favoriteCityList as ArrayList<City> // cast from mutable list
        val favouriteAdapter = FavouriteAdapter(context, favCityList)

        // init the recyclerview
        val recyclerView = view.findViewById<RecyclerView>(R.id.favorite_recycler_view)

        // set the adapter
        recyclerView.adapter = favouriteAdapter
        recyclerView.setHasFixedSize(true)

        // define a layout manager
        val layoutManager = LinearLayoutManager(context)
        layoutManager.orientation = RecyclerView.VERTICAL
        recyclerView.layoutManager = layoutManager
    }
}
