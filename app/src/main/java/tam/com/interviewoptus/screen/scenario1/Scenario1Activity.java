package tam.com.interviewoptus.screen.scenario1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import tam.com.interviewoptus.R;
import tam.com.interviewoptus.app.App;
import tam.com.interviewoptus.app.base.BaseActivity;

/**
 * Created by tamphan on 3/8/18.
 */

public class Scenario1Activity extends BaseActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scenario1);
    ButterKnife.bind(this);
    App.get(this).component().inject(Scenario1Activity.this);
  }

  // ====== Task1 ======
  public void onItemTask1Clicked(View view) {
    Toast.makeText(this, "Clicked on " + ((TextView) view).getText().toString(), Toast.LENGTH_SHORT)
        .show();
  }

  // ====== Task2 ======
}

