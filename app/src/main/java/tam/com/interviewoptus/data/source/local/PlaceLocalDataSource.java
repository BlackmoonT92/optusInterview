package tam.com.interviewoptus.data.source.local;

import android.support.annotation.NonNull;
import javax.inject.Inject;
import tam.com.interviewoptus.data.source.interfaces.IPlaceDataSource;

/**
 * Created by tamphan on 3/8/18.
 */

public class PlaceLocalDataSource implements IPlaceDataSource {

  @Inject
  public PlaceLocalDataSource() {
  }

  @Override
  public void getPlaces(@NonNull LoadPlacesCallback callback) {

  }
}
