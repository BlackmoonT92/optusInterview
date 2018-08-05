package tam.com.interviewoptus.utils;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

/**
 * Created by tamphan on 6/8/18.
 */

public class ColorMatcher extends BaseMatcher<View> implements Matcher<View> {

  private final int matchColor;

  public ColorMatcher(int matchColor) {
    this.matchColor = matchColor;
  }

  @Override
  public boolean matches(Object item) {
    Context context = ((View) item).getContext();
    int c2 = context.getColor(this.matchColor);
    int c1 = ((ColorDrawable) ((View) item).getBackground()).getColor();
    return c1 == c2;
  }

  @Override
  public void describeTo(Description description) {
    description.appendText("with text color: ");
  }
}