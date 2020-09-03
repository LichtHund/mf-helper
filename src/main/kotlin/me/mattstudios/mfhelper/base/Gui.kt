package me.mattstudios.mfhelper.base

/**
 * @author Matt
 */
data class Gui(
    val rows: Int = 1,
    val title: String
) {

    companion object {
        fun getGuiFromMap(map: Map<String, Any>): Gui {
            val rows = map["rows"]
            val title = map["title"]

            if (rows == null) {
                return Gui(title = title as String)
            }

            return Gui(rows as Int, title as String)

        }
    }

}