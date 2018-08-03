package tam.com.interviewoptus.app.di;

import android.app.Activity;
import dagger.Component;
import tam.com.interviewoptus.data.source.remote.HttpApiService;
import tam.com.interviewoptus.screen.scenario1.Scenario1Activity;
import tam.com.interviewoptus.screen.scenario2.Scenario2Presenter;

/**
 * Created by tamphan on 03/8/18.
 */
@ApplicationScope
@Component(modules = { HttpServiceModule.class })
public interface AppComponent {

  HttpApiService getHttpApiService();

  void inject(Scenario2Presenter scenario2Presenter);

  void inject(Scenario1Activity scenario1Activity);
}
