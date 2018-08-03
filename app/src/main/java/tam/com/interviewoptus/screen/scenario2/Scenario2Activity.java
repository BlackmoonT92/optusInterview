package tam.com.interviewoptus.screen.scenario2;

import android.os.Bundle;
import android.support.annotation.Nullable;
import butterknife.ButterKnife;
import tam.com.interviewoptus.R;
import tam.com.interviewoptus.app.App;
import tam.com.interviewoptus.app.base.BaseActivity;

/**
 * Created by tamphan on 3/8/18.
 */
public class Scenario2Activity extends BaseActivity {

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scenario2);
    ButterKnife.bind(this);
    App.get(this).component().inject(Scenario2Activity.this);
  }
}

