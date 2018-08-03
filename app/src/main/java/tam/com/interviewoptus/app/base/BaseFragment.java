package tam.com.interviewoptus.app.base;

import android.content.Intent;
import android.support.v4.app.Fragment;
import tam.com.interviewoptus.R;

/**
 * Created by tamphan on 03/8/18.
 */

public class BaseFragment extends Fragment {
  public static BaseFragment newInstance() {
    return new BaseFragment();
  }

  /**
   * Overrides the pending Activity transition by performing the "Enter" animation.
   */
  protected void overridePendingTransitionEnter() {
    getActivity().overridePendingTransition(R.animator.slide_from_right, R.animator.slide_to_left);
  }

  /**
   * Overrides the pending Activity transition by performing the "Exit" animation.
   */
  protected void overridePendingTransitionExit() {
    getActivity().overridePendingTransition(R.animator.slide_from_left, R.animator.slide_to_right);
  }

  @Override
  public void startActivityForResult(Intent intent, int requestCode) {
    super.startActivityForResult(intent, requestCode);
    overridePendingTransitionEnter();
  }
}
