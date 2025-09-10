import kotlin.math.max

fun main() {
    val c = readLine()!!.toDouble()
    val st = if (c >= 1.98) 2 else if (c >= 0.99) 1 else 0
    val n = readLine()!!.toInt()

    var maxStreak = 0
    var maxSolved = 0

    val dp = Array(n) { IntArray(st + 1) }
    val days = readLine()!!.split(" ").map { it.toInt() }
    for (i in 0 until n) {
        maxSolved = max(maxSolved, days[i])

        for (j in 0..st) {
            if (days[i] > 0) {
                dp[i][j] = (if (i > 0) dp[i - 1][j] else 0) + 1
            } else {
                if (j > 0) {
                    dp[i][j] = (if (i > 0) dp[i - 1][j - 1] else 0) + 1
                } else {
                    dp[i][j] = 0
                }
            }
            maxStreak = max(maxStreak, dp[i][j])
        }
    }

    println(maxStreak)
    println(maxSolved)
}
