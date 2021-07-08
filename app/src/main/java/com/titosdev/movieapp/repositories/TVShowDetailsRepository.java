package com.titosdev.movieapp.repositories;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.titosdev.movieapp.network.ApiClient;
import com.titosdev.movieapp.network.ApiService;
import com.titosdev.movieapp.responses.TVShowDetailsResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class TVShowDetailsRepository {

    private ApiService apiService;

    public TVShowDetailsRepository() {
        apiService = ApiClient.getRetrofit().create(ApiService.class);
    }

    public LiveData<TVShowDetailsResponse> getTVShowDetails(String tvShowId) {
        MutableLiveData<TVShowDetailsResponse> data = new MutableLiveData<>();
        apiService.getTVShowDetails(tvShowId).enqueue(new Callback<TVShowDetailsResponse>() {
            @Override
            public void onResponse(@NonNull Call<TVShowDetailsResponse> call, @NonNull Response<TVShowDetailsResponse> response) {
                data.postValue(response.body());
            }

            @Override
            public void onFailure(@NonNull Call<TVShowDetailsResponse> call, @NonNull Throwable t) {
                data.postValue(null);
            }
        });

        return data;
    }
}
