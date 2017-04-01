package devfigas.com.parcelable

import android.os.Parcel
import android.os.Parcelable


data class User (var name : String, var subscribed :  Boolean =  false): Parcelable{

    companion object{
        @JvmField val CREATOR: Parcelable.Creator<User> = object : Parcelable.Creator<User> {
            override fun createFromParcel(dest: Parcel) = User(dest.readString(),dest.readBoolean())
            override fun newArray(size: Int): Array<User?> = arrayOfNulls(size)
        }
    }

    override fun writeToParcel(dest: Parcel, flags: Int) {
        dest.writeString(name)
        dest.writeBoolean(subscribed)
    }

    override fun describeContents() = 0
}