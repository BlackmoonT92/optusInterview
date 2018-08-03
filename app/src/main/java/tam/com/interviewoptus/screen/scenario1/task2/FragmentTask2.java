package tam.com.interviewoptus.screen.scenario1.task2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import tam.com.interviewoptus.R;
import tam.com.interviewoptus.app.base.BaseFragment;

/**
 * Created by tamphan on 3/8/18.
 */

public class FragmentTask2 extends BaseFragment {

  public static final String KEY_CONTENT = "content";
  private String content;

  // newInstance constructor for creating fragment with arguments
  public static FragmentTask2 newInstance(String content) {
    FragmentTask2 fragment = new FragmentTask2();
    Bundle args = new Bundle();
    args.putString(KEY_CONTENT, content);
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    content = getArguments().getString(KEY_CONTENT);
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.scen1_task2_fragment, container, false);
    TextView tvContent = (TextView) view.findViewById(R.id.tvContent);
    tvContent.setText(content);
    return view;
  }

}
