package parking

/**
 * @author Pawel Sznura 15/10/2020
 */

class Parking(numberOfSpots: Int) {
    private var spotsList = Array(numberOfSpots) { Spot() }

    fun regByColor(color: String?): Any {
        var result = ""
        for (i in 0..spotsList.lastIndex) {
            //println(spotsList[i].toString())
            if (!spotsList[i].getIsFree()) {
                if (spotsList[i].getColor().toUpperCase() == color?.toUpperCase() ?: color)
                    result += "${spotsList[i].getRegNumber()}, "
            }
        }
        return if (result == "") "No cars with color $color were found."
        else result.dropLast(2)
    }

    fun spotByColor(color: String?): Any {
        var result = ""
        for (i in 0..spotsList.lastIndex) {
            if (!spotsList[i].getIsFree()) {
                if (spotsList[i].getColor().toUpperCase() == color?.toUpperCase() ?: color)
                    result += "${i + 1}, "
            }
        }
        return if (result == "") "No cars with color $color were found."
        else result.dropLast(2)
    }

    fun spotByReg(regNumber: String?): Any {
        for (i in 0..spotsList.lastIndex) {
            if (!spotsList[i].getIsFree()) {
                if (spotsList[i].getRegNumber() == regNumber)
                    return i + 1
            }
        }
        return "No cars with registration number $regNumber were found."
    }

    fun status(): String {
        var info = ""
        for (i in 0..spotsList.lastIndex) {
            if (!spotsList[i].getIsFree()) {
                info += "${i + 1} ${spotsList[i].getRegNumber()} ${spotsList[i].getColor()}\n"
            }
        }
        info = info.dropLast(1)
        return info
    }

    fun leave(spotNumber: Int): Boolean {
        return if (spotsList[spotNumber - 1].getIsFree())
            false
        else {
            spotsList[spotNumber - 1].setNewIsFree(true)
            true
        }
    }

    fun park(color: String, regNumber: String): Int {
        val freeSpot = nextFreeSpot()
        if (freeSpot > -1) {
            spotsList[freeSpot].setNewIsFree(false)
            spotsList[freeSpot].setNewColor(color)
            spotsList[freeSpot].setNewRegNumber(regNumber)
        } else
            return freeSpot

        return freeSpot + 1
    }

    private fun nextFreeSpot(): Int = spotsList.indexOfFirst { it.getIsFree() }

}