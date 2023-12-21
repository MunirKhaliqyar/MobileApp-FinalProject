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
import com.example.finalproject.databinding.FragmentSearchBinding

/**
 * A simple [Fragment] subclass as the second destination in the navigation.
 */
class SearchFragment : Fragment() {

    companion object {
        const val fromDateKey = "fromDate"
        const val toDateKey = "toDate"
    }

    private var _binding: FragmentSearchBinding? = null
    private val binding get() = _binding!!

    private val datasource = Datasource()
    private lateinit var recyclerView: RecyclerView
    private lateinit var adapter: RoomAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        recyclerView = binding.searchRecyclerView
        val layoutManager = LinearLayoutManager(requireContext())
        adapter = RoomAdapter(requireContext(), datasource.loadAllRooms())

        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    fun performSearch(navController: NavController, fromDate: String, toDate: String) {
        val args = Bundle().apply {
            putString(fromDateKey, fromDate)
            putString(toDateKey, toDate)
        }
        navController.navigate(R.id.action_to_SearchFragment, args)

        // Update the RecyclerView with the new dataset based on the received dates
        updateRecyclerView(fromDate, toDate)
    }

    private fun updateRecyclerView(fromDate: String, toDate: String) {
        val newDataset = datasource.loadAvailableRooms(fromDate, toDate)
        adapter.updateDataset(newDataset)
    }
}
