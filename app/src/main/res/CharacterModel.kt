
import com.google.gson.annotations.SerializedName

data class CharacterModel(
    @SerializedName("docs")
    val docs: List<Doc>,
    @SerializedName("items")
    val items: Items,
    @SerializedName("pages")
    val pages: Pages
)