package tam.com.interviewoptus.screen.scenario2;

import java.util.List;
import tam.com.interviewoptus.app.base.BasePresenter;
import tam.com.interviewoptus.app.base.BaseView;
import tam.com.interviewoptus.data.source.objects.Place;

/**
 * Created by tamphan on 3/8/18.
 */
public class Scenario2Contact {
  interface Scenario2View extends BaseView<Scenario2Presenter> {
    void onLoadingPlaces();

    void onLoadingPlacesSuccess(List<Place> placeList);

    void onPlacesEmpty();
  }

  interface Scenario2Presenter extends BasePresenter {
    void loadPlaceList();
  }
}
