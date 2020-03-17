
import com.google.gson.annotations.SerializedName

data class Items(
    @SerializedName("begin")
    val begin: Any,
    @SerializedName("end")
    val end: Any,
    @SerializedName("total")
    val total: Int
)