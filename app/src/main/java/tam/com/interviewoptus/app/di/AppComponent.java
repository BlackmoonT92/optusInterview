package tam.com.interviewoptus.app.di;

import android.app.Activity;
import dagger.Component;
import tam.com.interviewoptus.data.source.remote.HttpApiService;

/**
 * Created by tamphan on 03/8/18.
 */
@ApplicationScope
@Component(modules = { HttpServiceModule.class })
public interface AppComponent {

  HttpApiService getHttpApiService();

  void inject(Activity activity);
}
