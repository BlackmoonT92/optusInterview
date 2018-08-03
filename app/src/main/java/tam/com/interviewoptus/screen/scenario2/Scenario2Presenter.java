package tam.com.interviewoptus.screen.scenario2;

import android.app.Activity;
import java.util.List;
import javax.inject.Inject;
import tam.com.interviewoptus.app.App;
import tam.com.interviewoptus.data.source.PlaceRepository;
import tam.com.interviewoptus.data.source.interfaces.IPlaceDataSource.LoadPlacesCallback;
import tam.com.interviewoptus.data.source.objects.Place;
import tam.com.interviewoptus.screen.scenario2.Scenario2Contact.Scenario2View;

/**
 * Created by tamphan on 3/8/18.
 */
public class Scenario2Presenter implements Scenario2Contact.Scenario2Presenter {

  private Scenario2View mView;

  private Activity activity;

  @Inject PlaceRepository mPlaceRepository;

  public Scenario2Presenter(Scenario2View mView, Activity activity) {
    this.mView = mView;
    this.activity = activity;
    App.get(activity).component().inject(this);
    mView.setPresenter(this);
  }

  @Override
  public void start() {
    mView.onLoadingPlaces();
  }

  @Override
  public void loadPlaceList() {
    mPlaceRepository.getPlaces(new LoadPlacesCallback() {
      @Override
      public void onPlacesLoaded(List<Place> places) {
        if (places != null && !places.isEmpty()) {
          mView.onLoadingPlacesSuccess(places);
        } else {
          mView.onPlacesEmpty();
        }
      }

      @Override
      public void onDataNotAvailable() {
        mView.onPlacesEmpty();
      }
    });
  }
}
