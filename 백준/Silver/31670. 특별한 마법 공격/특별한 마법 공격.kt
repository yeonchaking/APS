import java.io.BufferedReader
import java.io.InputStreamReader
import kotlin.math.min

fun main() {
    val br = BufferedReader(InputStreamReader(System.`in`))
    val n = readLine()!!.toInt()
    val cost = listOf(0L) + readLine()!!.split(" ").map { it.toLong() }

    var prevNo = 0L
    var prevYes = cost[1]

    for(i in 2..n){
        val curNo = prevYes
        val curYes = cost[i] + min(prevYes,prevNo)
        prevYes = curYes
        prevNo = curNo
    }

    println(min(prevYes,prevNo))


}