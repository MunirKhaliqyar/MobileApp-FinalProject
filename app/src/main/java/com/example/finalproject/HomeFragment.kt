package com.example.finalproject

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.adapter.RoomAdapter
import com.example.data.Datasource
import com.example.finalproject.databinding.FragmentHomeBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    //private lateinit var recyclerView: RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentHomeBinding.inflate(inflater, container, false)

        val datasource = Datasource()

        // Inside your fragment
        val recyclerView: RecyclerView = binding.homeRecyclerView
        val layoutManager = LinearLayoutManager(requireContext())
        val adapter = RoomAdapter(requireContext(), datasource.loadAllRooms())

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        //recyclerView = binding.recyclerView
        super.onViewCreated(view, savedInstanceState)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun performSearch(navController: NavController, fromDate: String, toDate: String) {
        navController.navigate(R.id.action_to_SearchFragment)
    }
}