package parking

/**
 * @author Pawel Sznura 15/10/2020
 */

import parking.States.*
import java.util.*

enum class States {
    NOT_CREATED, NOT_FULL, FULL
}

var state = NOT_CREATED

val input = Scanner(System.`in`)

fun main() {
    lateinit var parking: Parking

    var choice = input.next()
    while (choice != "exit") {
        when (state) {
            NOT_CREATED -> {
                when (choice) {
                    "create" -> parking = create()
                    "park" -> println("Sorry, a parking lot has not been created.")
                    "leave" -> println("Sorry, a parking lot has not been created.")
                    "status" -> println("Sorry, a parking lot has not been created.")
                    "reg_by_color" -> println("Sorry, a parking lot has not been created.")
                    "spot_by_color" -> println("Sorry, a parking lot has not been created.")
                    "spot_by_reg" -> println("Sorry, a parking lot has not been created.")
                }
            }
            NOT_FULL -> {
                when (choice) {
                    "create" -> parking = create()
                    "park" -> parkCar(parking)
                    "leave" -> leaveParking(parking)
                    "status" -> status(parking)
                    "reg_by_color" -> regByColor(parking)
                    "spot_by_color" -> spotByColor(parking)
                    "spot_by_reg" -> spotByReg(parking)
                }
            }
            FULL -> {
                when (choice) {
                    "create" -> parking = create()
                    "park" -> parkCar(parking)
                    "leave" -> leaveParking(parking)
                    "status" -> status(parking)
                    "reg_by_color" -> regByColor(parking)
                    "spot_by_color" -> spotByColor(parking)
                    "spot_by_reg" -> spotByReg(parking)
                }
            }
        }
        choice = input.next()
    }
}

fun spotByReg(parking: Parking) {
    val regNumber = input.next()
    val spotNumber = parking.spotByReg(regNumber)
    println(spotNumber)
}

fun spotByColor(parking: Parking) {
    val color = input.next()
    val spotNumbers = parking.spotByColor(color)
    println(spotNumbers)
}

fun regByColor(parking: Parking) {
    val color = input.next()
    val regsNumbers = parking.regByColor(color)
    println(regsNumbers)
}

fun status(parking: Parking) {
    val info = parking.status()
    if (info == "")
        println("Parking lot is empty.")
    else
        println(info)
}

fun create(): Parking {
    state = NOT_FULL
    val numberOfSpots = input.nextInt()
    println("Created a parking lot with $numberOfSpots spots.")
    return Parking(numberOfSpots)
}

fun leaveParking(parking: Parking) {
    val spotNumber = input.nextInt()
    if (parking.leave(spotNumber))
        println("Spot $spotNumber is free.")
    else
        println("There is no car in spot 2.")
}

fun parkCar(parking: Parking) {
    val regNumber = input.next()
    val color = input.next()
    val spotNumber = parking.park(color, regNumber)
    if (spotNumber > -1)
        println("$color car parked in spot $spotNumber.")
    else
        println("Sorry, the parking lot is full.")
    // this should go to the when state loop
}
