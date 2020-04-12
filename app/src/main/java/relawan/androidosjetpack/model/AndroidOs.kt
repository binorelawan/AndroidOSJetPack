package relawan.androidosjetpack.model


import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class AndroidOs(
    var name: Int = 0,
    var remarks: Int = 0,
    var photo: Int = 0,
    var detail: Int = 0
): Parcelable

