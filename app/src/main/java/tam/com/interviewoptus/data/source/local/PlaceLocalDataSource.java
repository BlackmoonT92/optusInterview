package tam.com.interviewoptus.data.source.local;

import android.os.AsyncTask;
import android.support.annotation.NonNull;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import java.util.List;
import javax.inject.Inject;
import tam.com.interviewoptus.data.source.interfaces.IPlaceDataSource;
import tam.com.interviewoptus.data.source.objects.Place;

/**
 * Created by tamphan on 3/8/18.
 */

public class PlaceLocalDataSource implements IPlaceDataSource {

  @Inject
  public PlaceLocalDataSource() {
  }

  @Override
  public void getPlaces(@NonNull final LoadPlacesCallback callback) {
    new AsyncTask<Void, Void, List<Place>>() {
      @Override
      protected List<Place> doInBackground(Void... voids) {
        return SQLite.select().from(Place.class).queryList();
      }

      @Override
      protected void onPostExecute(List<Place> places) {
        if (places.isEmpty()) {
          // This will be called if the table is new or just empty.
          callback.onDataNotAvailable();
        } else {
          callback.onPlacesLoaded(places);
        }
      }
    }.execute();
  }
}
