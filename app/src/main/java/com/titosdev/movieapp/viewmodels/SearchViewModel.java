package com.titosdev.movieapp.viewmodels;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;
import com.titosdev.movieapp.repositories.SearchTVShowRepository;
import com.titosdev.movieapp.responses.TVShowsResponse;

public class SearchViewModel extends ViewModel {

    private SearchTVShowRepository searchTVShowRepository;

    public SearchViewModel() {
        searchTVShowRepository = new SearchTVShowRepository();
    }

    public LiveData<TVShowsResponse> searchTVShow(String query, int page) {
        return searchTVShowRepository.searchTVShow(query, page);
    }
}
