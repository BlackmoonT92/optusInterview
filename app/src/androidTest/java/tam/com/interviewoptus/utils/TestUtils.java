package tam.com.interviewoptus.utils;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.content.res.Configuration;
import android.support.test.espresso.matcher.BoundedMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import tam.com.interviewoptus.data.source.objects.Place;

/**
 * Created by tamphan on 6/8/18.
 */

public class TestUtils {

  private static void rotateToLandscape(Activity activity) {
    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
  }

  private static void rotateToPortrait(Activity activity) {
    activity.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
  }

  public static void rotateOrientation(Activity activity) {
    int currentOrientation = activity.getResources().getConfiguration().orientation;

    switch (currentOrientation) {
      case Configuration.ORIENTATION_LANDSCAPE:
        rotateToPortrait(activity);
        break;
      case Configuration.ORIENTATION_PORTRAIT:
        rotateToLandscape(activity);
        break;
      default:
        rotateToLandscape(activity);
    }
  }

}
