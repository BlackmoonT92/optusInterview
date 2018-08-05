package tam.com.interviewoptus.screen.scenario1;

import android.support.test.espresso.intent.Checks;
import android.support.test.espresso.matcher.BoundedMatcher;
import android.support.test.espresso.matcher.ViewMatchers.Visibility;
import android.support.test.rule.ActivityTestRule;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.text.Layout;
import android.view.View;
import android.widget.TextView;
import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import tam.com.interviewoptus.R;
import tam.com.interviewoptus.screen.home.MainActivity;
import tam.com.interviewoptus.utils.ColorMatcher;
import tam.com.interviewoptus.utils.TestUtils;

import static android.support.test.InstrumentationRegistry.getInstrumentation;
import static android.support.test.InstrumentationRegistry.getTargetContext;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.scrollTo;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withEffectiveVisibility;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static android.support.test.internal.runner.junit4.statement.UiThreadStatement.runOnUiThread;
import static org.hamcrest.core.AllOf.allOf;
import static org.junit.Assert.*;

/**
 * Created by tamphan on 5/8/18.
 */
public class Scenario1FragmentTest {

  @Rule public ActivityTestRule<MainActivity> mainActivityTestRule =
      new ActivityTestRule<MainActivity>(MainActivity.class);

  private MainActivity mainActivity = null;

  @Before
  public void setUp() throws Throwable {
    mainActivity = mainActivityTestRule.getActivity();
    final ViewPager viewPager = mainActivity.findViewById(R.id.pager);
    assertNotNull(viewPager);
    runOnUiThread(new Runnable() {
      @Override
      public void run() {
        viewPager.setCurrentItem(0);
      }
    });
  }

  @After
  public void tearDown() throws Exception {
    mainActivity = null;
  }

  @Test
  public void onRedButtonClick() throws Exception {
    onView(withId(R.id.btnRed)).perform(click());
    onView(withId(R.id.layoutTask5)).check(matches(new ColorMatcher(R.color.red)));
  }

  @Test
  public void onBlueButtonClick() throws Exception {
    onView(withId(R.id.btnBlue)).perform(click());
    onView(withId(R.id.layoutTask5)).check(matches(new ColorMatcher(R.color.blue)));
  }

  @Test
  public void onGreenButtonClick() throws Exception {
    onView(withId(R.id.btnGreen)).perform(click());
    onView(withId(R.id.layoutTask5)).check(matches(new ColorMatcher(R.color.green)));
  }

  @Test
  public void onItem1Task1Clicked() throws Exception {
    onView(allOf(withId(R.id.tvItem1), withEffectiveVisibility(Visibility.VISIBLE))).perform(
        scrollTo(), click());
    onView(withId(R.id.tvItemName)).check(matches(withText("Clicked on Item 1")));
  }

  @Test
  public void onItem2Task1Clicked() throws Exception {
    onView(allOf(withId(R.id.tvItem2), withEffectiveVisibility(Visibility.VISIBLE))).perform(
        scrollTo(), click());
    onView(withId(R.id.tvItemName)).check(matches(withText("Clicked on Item 2")));
  }

  @Test
  public void onItem3Task1Clicked() throws Exception {
    onView(allOf(withId(R.id.tvItem3), withEffectiveVisibility(Visibility.VISIBLE))).perform(
        scrollTo(), click());
    onView(withId(R.id.tvItemName)).check(matches(withText("Clicked on Item 3")));
  }

  @Test
  public void onItem4Task1Clicked() throws Exception {
    onView(allOf(withId(R.id.tvItem4), withEffectiveVisibility(Visibility.VISIBLE),
        withId(R.id.tvItem4))).perform(scrollTo(), click());
    onView(withId(R.id.tvItemName)).check(matches(withText("Clicked on Item 4")));
  }

  @Test
  public void onItem5Task1Clicked() throws Exception {
    onView(allOf(withId(R.id.tvItem5), withEffectiveVisibility(Visibility.VISIBLE))).perform(
        scrollTo(), click());
    onView(withId(R.id.tvItemName)).check(matches(withText("Clicked on Item 5")));
  }

  @Test
  public void orientationChange_menuAndTaskPersist() {
    //setup background of task 5 is red and text of task 4 is Item 5
    onView(withId(R.id.btnRed)).perform(click());
    onView(allOf(withId(R.id.tvItem5), withEffectiveVisibility(Visibility.VISIBLE),
        withId(R.id.tvItem5))).perform(scrollTo(), click());

    TestUtils.rotateOrientation(mainActivityTestRule.getActivity());

    // Check that the Item 5 is shown
    onView(withId(R.id.tvItemName)).check(matches(withText("Clicked on Item 5")));
    // Check that background color of task 5 is still red
    onView(withId(R.id.layoutTask5)).check(matches(new ColorMatcher(R.color.red)));
  }
}