package tam.com.interviewoptus.screen.scenario1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tam.com.interviewoptus.R;
import tam.com.interviewoptus.app.App;
import tam.com.interviewoptus.app.base.BaseActivity;
import tam.com.interviewoptus.screen.scenario1.task2.Task2PagerAdapter;

/**
 * Created by tamphan on 3/8/18.
 */

public class Scenario1Activity extends BaseActivity {

  @BindView(R.id.view_pager) ViewPager viewPager;

  @BindView(R.id.tvItemName) TextView tvItemTask1Name;

  @BindView(R.id.layoutTask5) LinearLayout layoutTask5;

  @Override
  protected void onCreate(@Nullable Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_scenario1);
    ButterKnife.bind(this);
    App.get(this).component().inject(Scenario1Activity.this);
    initTask2();
  }

  // ====== Task5 ======

  @OnClick(R.id.btnRed)
  public void onRedButtonClick() {
    layoutTask5.setBackgroundResource(R.color.red);
  }

  @OnClick(R.id.btnBlue)
  public void onBlueButtonClick() {
    layoutTask5.setBackgroundResource(R.color.blue);
  }

  @OnClick(R.id.btnGreen)
  public void onGreenButtonClick() {
    layoutTask5.setBackgroundResource(R.color.green);
  }

  // ====== Task2 ======
  private void initTask2() {
    final Task2PagerAdapter adapterViewPager = new Task2PagerAdapter(getSupportFragmentManager());
    viewPager.setAdapter(adapterViewPager);
    viewPager.addOnPageChangeListener(new OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

      }

      @Override
      public void onPageSelected(int position) {
        Toast.makeText(Scenario1Activity.this, adapterViewPager.getPageTitle(position),
            Toast.LENGTH_SHORT).show();
      }

      @Override
      public void onPageScrollStateChanged(int state) {

      }
    });
  }

  // ====== Task1 ======
  public void onItemTask1Clicked(View view) {
    Toast.makeText(this,
        getString(R.string.itemTask1Message, ((TextView) view).getText().toString()),
        Toast.LENGTH_SHORT).show();

    tvItemTask1Name.setText(
        getString(R.string.itemTask1Message, ((TextView) view).getText().toString()));
  }
}

