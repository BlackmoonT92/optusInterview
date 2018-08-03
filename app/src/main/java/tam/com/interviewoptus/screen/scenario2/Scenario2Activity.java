package tam.com.interviewoptus.screen.scenario2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.widget.Toast;
import butterknife.ButterKnife;
import java.util.List;
import javax.inject.Inject;
import tam.com.interviewoptus.R;
import tam.com.interviewoptus.app.App;
import tam.com.interviewoptus.app.base.BaseActivity;
import tam.com.interviewoptus.data.source.objects.Place;
import tam.com.interviewoptus.screen.scenario2.Scenario2Contact.Scenario2View;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by tamphan on 3/8/18.
 */
public class Scenario2Activity extends BaseActivity implements Scenario2View {

  Scenario2Contact.Scenario2Presenter mPresenter;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scenario2);
    ButterKnife.bind(this);
    new Scenario2Presenter(this, this);
  }

  @Override
  public void setPresenter(Scenario2Contact.Scenario2Presenter presenter) {
    mPresenter = checkNotNull(presenter);
    mPresenter.loadPlaceList();
  }

  @Override
  public void onLoadingPlaces() {
    Toast.makeText(this, getString(R.string.loading), Toast.LENGTH_SHORT).show();
  }

  @Override
  public void onLoadingPlacesSuccess(List<Place> placeList) {
    Log.d("Places", (placeList != null ? placeList.size() : 0) + " Loading success!");
    for (int i = 0; i < placeList.size(); i++) {
      Log.d("Places" + i, placeList.get(i).toString());
    }
  }

  @Override
  public void onPlacesEmpty() {

  }
}

