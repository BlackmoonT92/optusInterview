package tam.com.interviewoptus.app.base;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import tam.com.interviewoptus.R;

/**
 * Created by tamphan on 03/8/18.
 */

public abstract class BaseActivity extends AppCompatActivity {

  @Override
  public void onCreate(@Nullable Bundle savedInstanceState,
      @Nullable PersistableBundle persistentState) {
    super.onCreate(savedInstanceState, persistentState);
  }

  @Override
  public void finish() {
    super.finish();
    overridePendingTransitionExit();
  }

  @Override
  public void startActivity(Intent intent) {
    super.startActivity(intent);
    overridePendingTransitionEnter();
  }

  /**
   * Overrides the pending Activity transition by performing the "Enter" animation.
   */
  protected void overridePendingTransitionEnter() {
    overridePendingTransition(R.animator.slide_from_right, R.animator.slide_to_left);
  }

  /**
   * Overrides the pending Activity transition by performing the "Exit" animation.
   */
  protected void overridePendingTransitionExit() {
    overridePendingTransition(R.animator.slide_from_left, R.animator.slide_to_right);
  }

  @Override
  public void onBackPressed() {
    super.onBackPressed();
    overridePendingTransitionExit();
  }
}
