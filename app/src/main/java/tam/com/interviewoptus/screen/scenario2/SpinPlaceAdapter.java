package tam.com.interviewoptus.screen.scenario2;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;
import java.util.List;
import tam.com.interviewoptus.data.source.objects.Place;

/**
 * Created by tamphan on 3/8/18.
 */

public class SpinPlaceAdapter extends ArrayAdapter<Place> {

  private Context context;
  private List<Place> places;

  public SpinPlaceAdapter(Context context, int textViewResourceId, List<Place> places) {
    super(context, textViewResourceId, places);
    this.context = context;
    this.places = places;
  }

  @Override
  public int getCount() {
    return places.size();
  }

  @Override
  public Place getItem(int position) {
    return places.get(position);
  }

  @Override
  public long getItemId(int position) {
    return position;
  }

  @NonNull
  @Override
  public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
    TextView name = (TextView) super.getView(position, convertView, parent);
    name.setTextColor(Color.BLACK);
    name.setText(places.get(position).getName());
    return name;
  }

  @Override
  public View getDropDownView(int position, View convertView,
      ViewGroup parent) {
    TextView name = (TextView) super.getDropDownView(position, convertView, parent);
    name.setTextColor(Color.BLACK);
    name.setText(places.get(position).getName());
    return name;
  }

  public void updatePlaces(List<Place> newData) {
    this.places = newData;
    notifyDataSetChanged();
  }
}
