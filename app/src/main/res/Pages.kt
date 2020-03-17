
import com.google.gson.annotations.SerializedName

data class Pages(
    @SerializedName("current")
    val current: Int,
    @SerializedName("hasNext")
    val hasNext: Boolean,
    @SerializedName("hasPrev")
    val hasPrev: Boolean,
    @SerializedName("next")
    val next: Int,
    @SerializedName("prev")
    val prev: Int,
    @SerializedName("total")
    val total: Any
)