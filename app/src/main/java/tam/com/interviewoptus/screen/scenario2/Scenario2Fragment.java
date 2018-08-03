package tam.com.interviewoptus.screen.scenario2;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.Spinner;
import android.widget.TextView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import java.util.ArrayList;
import java.util.List;
import tam.com.interviewoptus.R;
import tam.com.interviewoptus.app.base.BaseFragment;
import tam.com.interviewoptus.data.source.objects.Place;
import tam.com.interviewoptus.screen.scenario2.Scenario2Contact.Scenario2View;

import static com.google.common.base.Preconditions.checkNotNull;

/**
 * Created by tamphan on 3/8/18.
 */
public class Scenario2Fragment extends BaseFragment implements Scenario2View {

  Scenario2Contact.Scenario2Presenter mPresenter;

  @BindView(R.id.spinnerPlaces) Spinner mSpinner;

  private SpinPlaceAdapter mSpinnerAdapter;

  @BindView(R.id.tvStatus) TextView tvStatus;

  @BindView(R.id.layoutInfo) View layoutInfo;

  @BindView(R.id.tvModeCar) TextView tvModeCar;

  @BindView(R.id.tvModeTrain) TextView tvModeTrain;

  public static Scenario2Fragment newInstance() {
    return new Scenario2Fragment();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_scenario2, container, false);
    ButterKnife.bind(this, view);
    return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
    new Scenario2Presenter(this, getActivity());
  }

  @Override
  public void setPresenter(Scenario2Contact.Scenario2Presenter presenter) {
    mPresenter = checkNotNull(presenter);
    mPresenter.loadPlaceList();
    initViews();
  }

  private void initViews() {
    mSpinnerAdapter = new SpinPlaceAdapter(getActivity(), android.R.layout.simple_spinner_item,
        new ArrayList<Place>());
    mSpinner.setAdapter(mSpinnerAdapter);
    mSpinner.setOnItemSelectedListener(new OnItemSelectedListener() {
      @Override
      public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Place place = mSpinnerAdapter.getItem(position);
        if (place.getFromCentralByCar() != null) {
          tvModeCar.setVisibility(View.VISIBLE);
          tvModeCar.setText(getString(R.string.mode_transport_car, place.getFromCentralByCar()));
        } else {
          tvModeCar.setVisibility(View.GONE);
        }
        if (place.getFromCentralByTrain() != null) {
          tvModeTrain.setVisibility(View.VISIBLE);
          tvModeTrain.setText(
              getString(R.string.mode_transport_train, place.getFromCentralByTrain()));
        } else {
          tvModeTrain.setVisibility(View.GONE);
        }
      }

      @Override
      public void onNothingSelected(AdapterView<?> parent) {

      }
    });
  }

  @OnClick(R.id.btnNavigate)
  public void onNavigateButtonClicked() {
    Place place = mSpinnerAdapter.getItem(mSpinner.getSelectedItemPosition());
    Uri gmmIntentUri = Uri.parse(
        getString(R.string.navigation_uri, String.valueOf(place.getLatitude()),
            String.valueOf(place.getLongtitude())));
    Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
    mapIntent.setPackage("com.google.android.apps.maps");
    startActivity(mapIntent);
  }

  @Override
  public void onLoadingPlaces() {
    tvStatus.setVisibility(View.VISIBLE);
    layoutInfo.setVisibility(View.GONE);
    tvStatus.setText(getString(R.string.loading));
  }

  @Override
  public void onLoadingPlacesSuccess(List<Place> placeList) {
    Log.d("Places", (placeList != null ? placeList.size() : 0) + " Loading success!");
    tvStatus.setVisibility(View.GONE);
    layoutInfo.setVisibility(View.VISIBLE);
    mSpinnerAdapter.updatePlaces(placeList);
  }

  @Override
  public void onPlacesEmpty() {
    layoutInfo.setVisibility(View.GONE);
    tvStatus.setVisibility(View.VISIBLE);
    tvStatus.setText(getString(R.string.noDataMessage));
  }
}

