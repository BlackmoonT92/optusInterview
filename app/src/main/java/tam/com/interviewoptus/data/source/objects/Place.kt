package tam.com.interviewoptus.data.source.objects

import com.google.gson.Gson
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import com.raizlabs.android.dbflow.annotation.Column
import com.raizlabs.android.dbflow.annotation.ConflictAction
import com.raizlabs.android.dbflow.annotation.PrimaryKey
import com.raizlabs.android.dbflow.annotation.Table
import com.raizlabs.android.dbflow.annotation.Unique
import com.raizlabs.android.dbflow.structure.BaseModel
import tam.com.interviewoptus.data.source.local.OptusDatabase

/**
 * Created by tamphan on 3/8/18.
 */

@Table(database = OptusDatabase::class)
class Place : BaseModel() {
    @Column
    @PrimaryKey(autoincrement = true)
    @Expose
    @Unique(onUniqueConflict = ConflictAction.REPLACE)
    var id: Int = 0

    @Expose
    @Column
    var name: String? = null

    @Expose
    @Column
    var latitude: Double = 0.toDouble()
    @Expose
    @Column
    var longtitude: Double = 0.toDouble()

    @Expose
    @Column
    var fromCentralByCar: String? = null
    @Expose
    @Column
    var fromCentralByTrain: String? = null

    override fun toString(): String {
        return Gson().toJson(this)
    }
}
