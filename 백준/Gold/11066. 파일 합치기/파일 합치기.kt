fun main() {
    val T = readLine()!!.toInt()

    for (t in 1..T) {
        val k = readLine()!!.toInt()
        val files = readLine()!!.split(" ").map { it.toInt() }

        val dp = Array(k) { IntArray(k) { 0 } }

        val prefix = IntArray(k + 1)
        for (i in 0 until k) {
            prefix[i + 1] = prefix[i] + files[i]
        }

        for (length in 2..k) {
            for (i in 0..k - length) {
                val j = i + length - 1
                dp[i][j] = Int.MAX_VALUE
                for (mid in i until j) {
                    val cost = dp[i][mid] + dp[mid + 1][j] + (prefix[j + 1] - prefix[i])
                    dp[i][j] = minOf(dp[i][j], cost)
                }
            }
        }

        println(dp[0][k - 1])
    }
}
