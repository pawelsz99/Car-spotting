package parking

/**
 * @author Pawel Sznura 15/10/2020
 */
data class Spot(private var isFree: Boolean = true,
           private var color: String = "none",
           private var regNumber: String = "none") {


    // Getters

    fun getIsFree() = isFree

    @JvmName("getColor1")
    fun getColor() = color

    fun getRegNumber() = regNumber


    // Setters
    fun setNewIsFree(newStatus: Boolean) {
        isFree = newStatus
    }

    fun setNewColor(newColor: String) {
        color = newColor
    }

    fun setNewRegNumber(newRegNumber: String) {
        regNumber = newRegNumber
    }

}