package com.titosdev.movieapp.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.titosdev.movieapp.network.ApiClient;
import com.titosdev.movieapp.network.ApiService;
import com.titosdev.movieapp.responses.TVShowsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SearchTVShowRepository {

    private ApiService apiService;

    public SearchTVShowRepository() {
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<TVShowsResponse> searchTVShow(String query, int page) {
        MutableLiveData<TVShowsResponse> data = new MutableLiveData<>();
        apiService.searchTVShow(query, page).enqueue(new Callback<TVShowsResponse>() {
            @Override
            public void onResponse(@NonNull  Call<TVShowsResponse> call, @NonNull Response<TVShowsResponse> response) {
                data.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<TVShowsResponse> call, @NonNull Throwable t) {
                data.postValue(null);
            }
        });

        return data;
    }
}
