package com.titosdev.movieapp.listeners;

import com.titosdev.movieapp.models.TVShow;

public interface WatchlistListener {
    void onTVShowClicked(TVShow tvShow);
    void removeTVShowFromWatchList(TVShow tvShow, int position);
}
