import java.util.LinkedList
import java.util.Queue

fun main() {
    val (n, k) = readln().split(" ").map { it.toInt() }


    val q: Queue<Pair<Int, Int>> = LinkedList()
    q.add(Pair(0, 0)) 

    val visited = IntArray(n + 1) { Int.MAX_VALUE }
    visited[0] = 0

    while (q.isNotEmpty()) {
        val (currentStair, currentStep) = q.poll()
        if (n - currentStair <= k - currentStep) {
            println("minigimbob")
            return
        }
        if (currentStep < k) {
            val nextStair1 = currentStair + 1
            if (nextStair1 <= n && currentStep + 1 < visited[nextStair1]) {
                visited[nextStair1] = currentStep + 1
                q.add(Pair(nextStair1, currentStep + 1))
            }

            val nextStair2 = currentStair + currentStair / 2
            if (nextStair2 <= n && currentStep + 1 < visited[nextStair2]) {
                visited[nextStair2] = currentStep + 1
                q.add(Pair(nextStair2, currentStep + 1))
            }
        }
    }
    if (visited[n] <= k) {
        println("minigimbob")
    } else {
        println("water")
    }
}