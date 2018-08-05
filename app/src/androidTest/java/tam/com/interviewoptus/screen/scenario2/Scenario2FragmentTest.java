package tam.com.interviewoptus.screen.scenario2;

import android.content.Intent;
import android.support.test.espresso.intent.rule.IntentsTestRule;
import android.support.test.espresso.matcher.ViewMatchers.Visibility;
import android.support.v4.view.ViewPager;
import android.widget.Spinner;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import tam.com.interviewoptus.R;
import tam.com.interviewoptus.data.source.objects.Place;
import tam.com.interviewoptus.screen.home.MainActivity;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.intent.Intents.intended;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.toPackage;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.hamcrest.core.AllOf.allOf;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotNull;

/**
 * Created by tamphan on 6/8/18.
 */
public class Scenario2FragmentTest {
  @Rule public IntentsTestRule<MainActivity> intentsTestRule =
      new IntentsTestRule<>(MainActivity.class);

  private MainActivity mainActivity = null;

  @Before
  public void setUp() throws Throwable {
    mainActivity = intentsTestRule.getActivity();
    final ViewPager viewPager = mainActivity.findViewById(R.id.pager);
    assertNotNull(viewPager);
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        viewPager.setCurrentItem(1);
      }
    });
  }

  @After
  public void tearDown() throws Exception {
    mainActivity = null;
  }

  @Test
  public void testShouldFindSpinner() {
    onView(withId(R.id.spinnerPlaces)).perform(click());
  }

  @Test
  public void onSpinnerItemSelected() throws Exception {
    Spinner spinner = mainActivity.findViewById(R.id.spinnerPlaces);
    assertNotNull(spinner);
    Place place = ((SpinPlaceAdapter) spinner.getAdapter()).getItem(2);

    onView(withId(R.id.spinnerPlaces)).perform(click());
    onView(allOf(withText(place.getName()), withEffectiveVisibility(Visibility.VISIBLE))).perform(
        scrollTo(), click());

    //test updated transport text
    onView(withId(R.id.tvModeCar)).check(matches(withText(
        mainActivity.getString(R.string.mode_transport_car, place.getFromCentralByCar()))));
    onView(withId(R.id.tvModeTrain)).check(matches(withText(
        mainActivity.getString(R.string.mode_transport_train, place.getFromCentralByTrain()))));
  }

  @Test
  public void onNavigateButtonClicked() throws Exception {
    onView(withId(R.id.btnNavigate)).perform(click());

    intended(
        allOf(hasAction(equalTo(Intent.ACTION_VIEW)), toPackage("com.google.android.apps.maps")));
  }

}