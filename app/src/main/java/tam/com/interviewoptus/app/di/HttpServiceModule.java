package tam.com.interviewoptus.app.di;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import tam.com.interviewoptus.data.source.objects.Place;
import tam.com.interviewoptus.data.source.remote.HttpApiService;
import tam.com.interviewoptus.data.source.remote.deserializer.PlaceDeserializer;

/**
 * Created by tamphan on 03/8/18.
 */
@Module(includes = NetworkModule.class)
public class HttpServiceModule {

  @Provides
  @ApplicationScope
  public HttpApiService httpApiService(Retrofit httpRetrofit) {
    return httpRetrofit.create(HttpApiService.class);
  }

  @Provides
  @ApplicationScope
  public Gson gson() {
    GsonBuilder gsonBuilder = new GsonBuilder();
    //add custom json converter here
    gsonBuilder.registerTypeAdapter(Place.class, new PlaceDeserializer());
    return gsonBuilder.create();
  }

  @Provides
  @ApplicationScope
  public Retrofit retrofit(OkHttpClient okHttpClient, Gson gson) {
    return new Retrofit.Builder().addConverterFactory(GsonConverterFactory.create(gson))
        .client(okHttpClient)
        .baseUrl("http://express-it.optusnet.com.au/")
        .build();
  }
}
