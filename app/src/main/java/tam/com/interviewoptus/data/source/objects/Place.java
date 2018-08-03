package tam.com.interviewoptus.data.source.objects;

import com.google.gson.Gson;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ConflictAction;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.annotation.Unique;
import com.raizlabs.android.dbflow.structure.BaseModel;
import tam.com.interviewoptus.data.source.local.OptusDatabase;

/**
 * Created by tamphan on 3/8/18.
 */

@Table(database = OptusDatabase.class)
public class Place extends BaseModel {
  @Column @PrimaryKey(autoincrement = true) @Expose
  @Unique(onUniqueConflict = ConflictAction.REPLACE) private int id;

  @Expose @Column private String name;

  @Expose @Column private double latitude;
  @Expose @Column private double longtitude;

  @Expose @Column private String fromCentralByCar;
  @Expose @Column private String fromCentralByTrain;

  public Place() {
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongtitude() {
    return longtitude;
  }

  public void setLongtitude(double longtitude) {
    this.longtitude = longtitude;
  }

  public String getFromCentralByCar() {
    return fromCentralByCar;
  }

  public void setFromCentralByCar(String fromCentralByCar) {
    this.fromCentralByCar = fromCentralByCar;
  }

  public String getFromCentralByTrain() {
    return fromCentralByTrain;
  }

  public void setFromCentralByTrain(String fromCentralByTrain) {
    this.fromCentralByTrain = fromCentralByTrain;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  @Override
  public String toString() {
    return new Gson().toJson(this);
  }
}
