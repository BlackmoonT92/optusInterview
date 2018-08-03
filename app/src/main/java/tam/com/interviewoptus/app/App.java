package tam.com.interviewoptus.app;

import android.app.Activity;
import android.app.Application;
import com.raizlabs.android.dbflow.config.FlowManager;
import tam.com.interviewoptus.app.di.AppComponent;
import tam.com.interviewoptus.app.di.ApplicationContextModule;
import tam.com.interviewoptus.app.di.DaggerAppComponent;
import timber.log.Timber;

/**
 * Created by tamphan on 03/8/18.
 */
public class App extends Application {

  private AppComponent component;

  public static App get(Activity activity) {
    return (App) activity.getApplication();
  }

  @Override
  public void onCreate() {
    super.onCreate();
    Timber.plant(new Timber.DebugTree());
    FlowManager.init(this);
    component = DaggerAppComponent.builder()
        .applicationContextModule(new ApplicationContextModule(this))
        .build();
  }

  public AppComponent component() {
    return component;
  }
}
