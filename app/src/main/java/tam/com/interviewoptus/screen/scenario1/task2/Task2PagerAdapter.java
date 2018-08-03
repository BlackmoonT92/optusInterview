package tam.com.interviewoptus.screen.scenario1.task2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

/**
 * Created by tamphan on 3/8/18.
 */

public class Task2PagerAdapter extends FragmentPagerAdapter {

  private static int NUM_ITEMS = 4;

  public Task2PagerAdapter(FragmentManager fm) {
    super(fm);
  }

  @Override
  public Fragment getItem(int position) {
    switch (position) {
      case 0:
        return FragmentTask2.newInstance("Page #1");
      case 1:
        return FragmentTask2.newInstance("Page #2");
      case 2:
        return FragmentTask2.newInstance("Page #3");
      case 3:
        return FragmentTask2.newInstance("Page #4");
      default:
        return null;
    }
  }

  @Override
  public int getCount() {
    return NUM_ITEMS;
  }

  @Override
  public CharSequence getPageTitle(int position) {
    return "Page " + (position + 1);
  }
}
