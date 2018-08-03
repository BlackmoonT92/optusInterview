package tam.com.interviewoptus.app.di;

import android.content.Context;
import dagger.Module;
import dagger.Provides;

/**
 * Created by tamphan on 03/8/18.
 */
@Module
public class ApplicationContextModule {
  private final Context context;

  public ApplicationContextModule(Context context) {
    this.context = context.getApplicationContext();
  }

  @Provides
  @ApplicationScope
  public Context context() {
    return context;
  }
}
