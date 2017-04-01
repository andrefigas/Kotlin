package devfigas.com.parcelable

import android.os.Parcel


fun Parcel.writeBoolean(extra : Boolean) : Unit{
   if(extra){
       this.writeInt(1)
   }else{
       this.writeInt(0)
   }
}
fun Parcel.readBoolean() : Boolean{
    if(this.readInt()==1){
       return true;
    }else{
      return false;
    }
}