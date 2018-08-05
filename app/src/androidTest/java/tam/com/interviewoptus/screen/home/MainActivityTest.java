package tam.com.interviewoptus.screen.home;

import android.support.test.rule.ActivityTestRule;
import android.support.v4.view.ViewPager;
import android.view.View;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import tam.com.interviewoptus.R;

import static org.junit.Assert.*;

/**
 * Created by tamphan on 5/8/18.
 */
public class MainActivityTest {

  @Rule public ActivityTestRule<MainActivity> mainActivityActivityTestRule =
      new ActivityTestRule<MainActivity>(MainActivity.class);

  private MainActivity mainActivity = null;

  @Before
  public void setUp() throws Exception {
    mainActivity = mainActivityActivityTestRule.getActivity();
  }

  @After
  public void tearDown() throws Exception {
    mainActivity = null;
  }

  @Test
  public void testInitApp() {
    ViewPager viewPager = mainActivity.findViewById(R.id.pager);
    assertNotNull(viewPager);
    assertEquals(viewPager.getAdapter().getPageTitle(0), "SCENARIO 1");
    assertEquals(viewPager.getAdapter().getPageTitle(1), "SCENARIO 2");
  }
}