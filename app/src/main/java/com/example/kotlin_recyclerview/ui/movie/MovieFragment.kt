package com.example.kotlin_recyclerview.ui.movie

import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlin_recyclerview.R
import com.example.kotlin_recyclerview.data.interfaces.MoviesApi
import com.example.kotlin_recyclerview.data.interfaces.RecyclerClickListener
import com.example.kotlin_recyclerview.data.models.Movie
import com.example.kotlin_recyclerview.data.repositories.MoviesRepository
import kotlinx.android.synthetic.main.movie_fragment.*

class MovieFragment : Fragment(), RecyclerClickListener {

    companion object {
        fun newInstance() =
            MovieFragment()
    }

    private lateinit var factory: MoviesViewModelFactory
    private lateinit var viewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        // viewModel = ViewModelProvider(this).get(MoviesViewModel::class.java)

        val api = MoviesApi()
        val repository =
            MoviesRepository(api)
        factory =
            MoviesViewModelFactory(repository)
        viewModel = ViewModelProvider(this, factory).get(MovieViewModel::class.java)
        viewModel.getMovies()
        viewModel.moviesList.observe(viewLifecycleOwner, Observer {
                movies -> recycler_view_movies.also {
                    it.layoutManager = LinearLayoutManager(requireContext())
                    it.setHasFixedSize(true)
                    it.adapter =
                        MovieAdapter(movies, this)
                }
        })
    }

    // callback when button or layout like is clicked
    override fun onRecyclerViewClickListener(view: View, movie: Movie) {
        when(view.id){
            R.id.button_book -> {
                Toast.makeText(
                    requireContext(),
                    "This is callback when button_book clicked",
                    Toast.LENGTH_LONG
                ).show()
            }
            R.id.layout_like -> {
                Toast.makeText(
                    requireContext(),
                    "This is callback when layout_like is clicked",
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }
}