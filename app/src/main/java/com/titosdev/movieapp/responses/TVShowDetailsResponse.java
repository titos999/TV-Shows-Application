package com.titosdev.movieapp.responses;

import com.google.gson.annotations.SerializedName;
import com.titosdev.movieapp.models.TVShowDetails;

public class TVShowDetailsResponse {

    @SerializedName("tvShow")
    private TVShowDetails tvShowDetails;

    public TVShowDetails getTvShowDetails() {
        return tvShowDetails;
    }
}
