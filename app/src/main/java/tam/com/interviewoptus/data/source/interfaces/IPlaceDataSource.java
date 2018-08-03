package tam.com.interviewoptus.data.source.interfaces;

import android.support.annotation.NonNull;
import java.util.List;
import tam.com.interviewoptus.data.source.objects.Place;

/**
 * Created by tamphan on 3/8/18.
 */

public interface IPlaceDataSource {

  interface LoadPlacesCallback {
    void onPlacesLoaded(List<Place> places);

    void onDataNotAvailable();
  }

  void getPlaces(@NonNull LoadPlacesCallback callback);

}
