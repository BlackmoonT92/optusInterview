package tam.com.interviewoptus.screen.scenario1;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import tam.com.interviewoptus.R;
import tam.com.interviewoptus.app.App;
import tam.com.interviewoptus.app.base.BaseFragment;
import tam.com.interviewoptus.screen.scenario1.task2.Task2PagerAdapter;

/**
 * Created by tamphan on 3/8/18.
 */

public class Scenario1Fragment extends BaseFragment {

  @BindView(R.id.view_pager) ViewPager viewPager;

  @BindView(R.id.tvItemName) TextView tvItemTask1Name;

  @BindView(R.id.layoutTask5) LinearLayout layoutTask5;

  public static Scenario1Fragment newInstance() {
    return new Scenario1Fragment();
  }

  @Nullable
  @Override
  public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
      @Nullable Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_scenario1, container, false);
    ButterKnife.bind(this, view);
    App.get(getActivity()).component().inject(Scenario1Fragment.this);
    return view;
  }

  @Override
  public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
    super.onViewCreated(view, savedInstanceState);
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
    final Task2PagerAdapter adapterViewPager =
        new Task2PagerAdapter(getActivity().getSupportFragmentManager());
    viewPager.setAdapter(adapterViewPager);
    viewPager.addOnPageChangeListener(new OnPageChangeListener() {
      @Override
      public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

      }

      @Override
      public void onPageSelected(int position) {
        Toast.makeText(getActivity(), adapterViewPager.getPageTitle(position), Toast.LENGTH_SHORT)
            .show();
      }

      @Override
      public void onPageScrollStateChanged(int state) {

      }
    });
  }

  // ====== Task1 ======
  @OnClick(R.id.tvItem1)
  public void onItem1Task1Clicked(View view) {
    updateTask4Name(((TextView) view).getText().toString());
  }

  @OnClick(R.id.tvItem2)
  public void onItem2Task1Clicked(View view) {
    updateTask4Name(((TextView) view).getText().toString());
  }

  @OnClick(R.id.tvItem3)
  public void onItem3Task1Clicked(View view) {
    updateTask4Name(((TextView) view).getText().toString());
  }

  @OnClick(R.id.tvItem4)
  public void onItem4Task1Clicked(View view) {
    updateTask4Name(((TextView) view).getText().toString());
  }

  @OnClick(R.id.tvItem5)
  public void onItem5Task1Clicked(View view) {
    updateTask4Name(((TextView) view).getText().toString());
  }

  private void updateTask4Name(String name) {
    Toast.makeText(getActivity(), name, Toast.LENGTH_SHORT)
        .show();
    tvItemTask1Name.setText(getString(R.string.itemTask1Message, name));
  }
}

