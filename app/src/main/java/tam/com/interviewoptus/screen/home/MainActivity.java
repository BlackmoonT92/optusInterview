package tam.com.interviewoptus.screen.home;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import butterknife.BindView;
import butterknife.ButterKnife;
import java.util.Locale;
import net.yanzm.mth.MaterialTabHost;
import tam.com.interviewoptus.R;
import tam.com.interviewoptus.app.base.BaseActivity;
import tam.com.interviewoptus.app.base.BaseFragment;
import tam.com.interviewoptus.screen.scenario1.Scenario1Fragment;
import tam.com.interviewoptus.screen.scenario2.Scenario2Fragment;

/**
 * Created by tamphan on 03/8/18.
 */
public class MainActivity extends BaseActivity {

  @BindView(android.R.id.tabhost) MaterialTabHost tabHost;

  @BindView(R.id.pager) ViewPager viewPager;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ButterKnife.bind(this);

    if (getSupportActionBar() != null) {
      getSupportActionBar().setElevation(0);
    }

    tabHost.setType(MaterialTabHost.Type.FullScreenWidth);

    SectionsPagerAdapter pagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());
    for (int i = 0; i < pagerAdapter.getCount(); i++) {
      tabHost.addTab(pagerAdapter.getPageTitle(i));
    }

    viewPager.setAdapter(pagerAdapter);
    viewPager.setOnPageChangeListener(tabHost);

    tabHost.setOnTabChangeListener(new MaterialTabHost.OnTabChangeListener() {
      @Override
      public void onTabSelected(int position) {
        viewPager.setCurrentItem(position);
      }
    });
  }

  public class SectionsPagerAdapter extends FragmentPagerAdapter {

    public SectionsPagerAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      BaseFragment fragment = null;
      switch (position) {
        case 0:
          fragment = Scenario1Fragment.newInstance();
          break;
        case 1:
          fragment = Scenario2Fragment.newInstance();
          break;
        default:
          fragment = BaseFragment.newInstance();
      }
      return fragment;
    }

    @Override
    public int getCount() {
      return 2;
    }

    @Override
    public CharSequence getPageTitle(int position) {
      Locale l = Locale.getDefault();
      switch (position) {
        case 0:
          return getString(R.string.scenario1).toUpperCase(l);
        case 1:
          return getString(R.string.scenario2).toUpperCase(l);
      }
      return null;
    }
  }
}

