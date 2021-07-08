package com.titosdev.movieapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.titosdev.movieapp.repositories.MostPopularTVShowsRepository;
import com.titosdev.movieapp.responses.TVShowsResponse;

public class MostPopularTVShowsViewModel extends ViewModel {

    private MostPopularTVShowsRepository mostPopularTVShowsRepository;

    public MostPopularTVShowsViewModel() {
        mostPopularTVShowsRepository = new MostPopularTVShowsRepository();
    }

    public LiveData<TVShowsResponse> getMostPopularTVShows(int page) {
        return mostPopularTVShowsRepository.getMostPopularTVShows(page);
    }
}
