package tam.com.interviewoptus.data.source;

import android.support.annotation.NonNull;
import javax.inject.Inject;
import tam.com.interviewoptus.data.source.interfaces.IPlaceDataSource;
import tam.com.interviewoptus.data.source.local.PlaceLocalDataSource;
import tam.com.interviewoptus.data.source.remote.PlaceRemoteDataSource;

/**
 * Created by tamphan on 3/8/18.
 */

public class PlaceRepository implements IPlaceDataSource {

  private final PlaceLocalDataSource mPlaceLocalDataSource;

  private final PlaceRemoteDataSource mPlaceRemoteDataSource;

  @Inject
  public PlaceRepository(@NonNull PlaceLocalDataSource localDataSource,
      @NonNull PlaceRemoteDataSource remoteDataSource) {
    this.mPlaceLocalDataSource = localDataSource;
    this.mPlaceRemoteDataSource = remoteDataSource;
  }

  @Override
  public void getPlaces(@NonNull LoadPlacesCallback callback) {
    mPlaceRemoteDataSource.getPlaces(callback);
  }
}
