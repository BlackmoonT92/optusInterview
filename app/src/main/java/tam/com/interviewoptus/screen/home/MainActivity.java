package tam.com.interviewoptus.screen.home;

import android.content.Intent;
import android.os.Bundle;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tam.com.interviewoptus.R;
import tam.com.interviewoptus.app.base.BaseActivity;
import tam.com.interviewoptus.screen.scenario1.Scenario1Activity;
import tam.com.interviewoptus.screen.scenario2.Scenario2Activity;

/**
 * Created by tamphan on 03/8/18.
 */
public class MainActivity extends BaseActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);
  }

  @OnClick(R.id.btnScen1)
  public void onScenario1ButtonClicked() {
    startActivity(new Intent(MainActivity.this, Scenario1Activity.class));
  }

  @OnClick(R.id.btnScen2)
  public void onScenario2ButtonClicked() {
    startActivity(new Intent(MainActivity.this, Scenario2Activity.class));
  }
}
