package de.syntax_institut.jpc

import android.os.Parcel
import android.os.Parcelable



data class Coffee(
    val name: String,
    val description: String,
    val price: Double,
    val rating: Double,
    val ratingCount: Int,
    val image: Int
): Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString().toString(),
        parcel.readString().toString(),
        parcel.readDouble(),
        parcel.readDouble(),
        parcel.readInt(),
        parcel.readInt(),
      //  parcel.readString().toString()
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(name)
        parcel.writeString(description)
        parcel.writeDouble(price)
        parcel.writeDouble(rating)
        parcel.writeInt(ratingCount)
        parcel.writeInt(ratingCount)
       // parcel.writeString(image)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Coffee> {
        override fun createFromParcel(parcel: Parcel): Coffee {
            return Coffee(parcel)
        }

        override fun newArray(size: Int): Array<Coffee?> {
            return arrayOfNulls(size)
        }
    }
}


val coffeeList = listOf(
    Coffee(
        name = "Cinnamon & Cocoa",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        price = 14.99,
        rating = 4.5,
        ratingCount = 1423,
        image = R.drawable.img2
    ),

    Coffee(
        name = "Drizzled with Caramel",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        price = 12.99,
        rating = 4.1,
        ratingCount = 123,
        image = R.drawable.img4 ),

    Coffee(
        name = "Cinnamon & Cocoa",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        price = 14.99,
        rating = 4.5,
        ratingCount = 1423,
        image = R.drawable.img5 ),

    Coffee(
        name = "Cinnamon & Cocoa",
        description = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat.",
        price = 14.99,
        rating = 4.5,
        ratingCount = 1423,
        image = R.drawable.img3  ),
)
