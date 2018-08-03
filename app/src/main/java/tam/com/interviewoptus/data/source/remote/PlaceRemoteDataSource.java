package tam.com.interviewoptus.data.source.remote;

import android.support.annotation.NonNull;
import java.util.List;
import javax.inject.Inject;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import tam.com.interviewoptus.data.source.interfaces.IPlaceDataSource;
import tam.com.interviewoptus.data.source.objects.Place;

/**
 * Created by tamphan on 3/8/18.
 */

public class PlaceRemoteDataSource implements IPlaceDataSource {

  HttpApiService httpApiService;

  @Inject
  public PlaceRemoteDataSource(HttpApiService httpApiService) {
    this.httpApiService = httpApiService;
  }

  @Override
  public void getPlaces(@NonNull final LoadPlacesCallback callback) {
    Call<List<Place>> placesCall;
    placesCall = httpApiService.getPlaces();
    placesCall.enqueue(new Callback<List<Place>>() {
      @Override
      public void onResponse(Call<List<Place>> call, Response<List<Place>> response) {
        if (response.body() != null) {
          callback.onPlacesLoaded(response.body());
        } else {
          callback.onDataNotAvailable();
        }
      }

      @Override
      public void onFailure(Call<List<Place>> call, Throwable t) {
        callback.onDataNotAvailable();
      }
    });

  }
}
