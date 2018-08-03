package tam.com.interviewoptus.data.source.remote.deserializer;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import java.lang.reflect.Type;
import tam.com.interviewoptus.data.source.objects.Place;

/**
 * Created by tamphan on 3/8/18.
 */

public class PlaceDeserializer implements JsonDeserializer<Place> {
  @Override
  public Place deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context)
      throws JsonParseException {
    JsonObject jobject = (JsonObject) json;
    Place place = new Place();
    if (jobject.has("id")) {
      place.setId(jobject.get("id").getAsInt());
    }
    if (jobject.has("name")) {
      place.setName(jobject.get("name").getAsString());
    }

    if (jobject.has("fromcentral")) {
      JsonObject fromCentral = jobject.getAsJsonObject("fromcentral");
      if (fromCentral.has("car")) {
        place.setFromCentralByCar(fromCentral.get("car").getAsString());
      }
      if (fromCentral.has("train")) {
        place.setFromCentralByTrain(fromCentral.get("train").getAsString());
      }
    }

    if (jobject.has("location")) {
      JsonObject location = jobject.getAsJsonObject("location");
      if (location.has("latitude")) {
        place.setLatitude(location.get("latitude").getAsDouble());
      }
      if (location.has("longitude")) {
        place.setLongtitude(location.get("longitude").getAsDouble());
      }
    }
    return place;
  }
}
