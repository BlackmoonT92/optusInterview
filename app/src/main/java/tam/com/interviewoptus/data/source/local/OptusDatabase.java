package tam.com.interviewoptus.data.source.local;

import com.raizlabs.android.dbflow.annotation.Database;

/**
 * Created by tamphan on 03/8/18.
 */
@Database(name = OptusDatabase.NAME, version = OptusDatabase.VERSION)
public class OptusDatabase {
  public static final String NAME = "Optus";

  public static final int VERSION = 1;
}
