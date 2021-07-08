package com.titosdev.movieapp.viewmodels;

import android.app.Application;
import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import com.titosdev.movieapp.database.TVShowsDatabase;
import com.titosdev.movieapp.models.TVShow;
import com.titosdev.movieapp.repositories.TVShowDetailsRepository;
import com.titosdev.movieapp.responses.TVShowDetailsResponse;
import io.reactivex.Completable;
import io.reactivex.Flowable;

public class TVShowDetailsViewModel extends AndroidViewModel {

    private TVShowDetailsRepository tvShowDetailsRepository;
    private TVShowsDatabase tvShowsDatabase;

    public TVShowDetailsViewModel(@NonNull Application application) {
        super(application);
        tvShowDetailsRepository = new TVShowDetailsRepository();
        tvShowsDatabase = TVShowsDatabase.getTvShowsDatabase(application);
    }

    public LiveData<TVShowDetailsResponse> getTVShowDetails(String tvShowId) {
        return tvShowDetailsRepository.getTVShowDetails(tvShowId);
    }

    public Completable addToWatchlist(TVShow tvShow) {
        return tvShowsDatabase.tvShowDao().addToWatchlist(tvShow);
    }

    public Flowable<TVShow> getTVShowFromWatchlist(String tvShowId) {
        return tvShowsDatabase.tvShowDao().getTVShowFromWatchlist(tvShowId);
    }

    public Completable removeTVShowFromWatchList(TVShow tvShow) {
        return tvShowsDatabase.tvShowDao().removeFromWatchlist(tvShow);
    }
}
