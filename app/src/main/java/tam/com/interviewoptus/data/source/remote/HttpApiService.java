package tam.com.interviewoptus.data.source.remote;

import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;
import tam.com.interviewoptus.data.source.objects.Place;

/**
 * Created by tamphan on 03/8/18.
 */
public interface HttpApiService {

  @GET("sample.json")
  Call<List<Place>> getPlaces();

}
