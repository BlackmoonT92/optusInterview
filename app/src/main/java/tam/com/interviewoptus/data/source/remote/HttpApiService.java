package tam.com.interviewoptus.data.source.remote;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by tamphan on 03/8/18.
 */
public interface HttpApiService {

  @GET("sample.json")
  Call<Object> getSampleData();

}
