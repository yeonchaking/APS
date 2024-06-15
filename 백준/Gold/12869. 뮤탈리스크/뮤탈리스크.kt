import java.util.LinkedList
import java.util.Queue

var n = 0
var scv = IntArray(3)
var min = Int.MAX_VALUE

fun main() {
    n = readln().toInt()
    val input = readln().split(" ").map { it.toInt() }
    for (i in input.indices) scv[i] = input[i]

    if (n == 1) {
        println((scv[0] + 8) / 9) 
        return
    }
    bfs()
    println(min)
}

fun bfs() {
    val q: Queue<IntArray> = LinkedList()
    val visited = mutableSetOf<Triple<Int, Int, Int>>()

    q.add(intArrayOf(scv[0], scv[1], scv[2], 0))
    visited.add(Triple(scv[0], scv[1], scv[2]))

    while (q.isNotEmpty()) {
        val now = q.poll()

        val hp1 = now[0]
        val hp2 = now[1]
        val hp3 = now[2]
        val count = now[3]

        if (hp1 <= 0 && hp2 <= 0 && hp3 <= 0) {
            min = minOf(min, count)
            continue
        }

        val newStates = arrayOf(
            intArrayOf(hp1 - 9, hp2 - 3, hp3 - 1),
            intArrayOf(hp1 - 9, hp2 - 1, hp3 - 3),
            intArrayOf(hp1 - 3, hp2 - 9, hp3 - 1),
            intArrayOf(hp1 - 3, hp2 - 1, hp3 - 9),
            intArrayOf(hp1 - 1, hp2 - 9, hp3 - 3),
            intArrayOf(hp1 - 1, hp2 - 3, hp3 - 9)
        )

        for (state in newStates) {
            val normalizedState = intArrayOf(
                state[0].coerceAtLeast(0),
                state[1].coerceAtLeast(0),
                state[2].coerceAtLeast(0)
            )
            val stateTriple = Triple(normalizedState[0], normalizedState[1], normalizedState[2])
            if (stateTriple !in visited) {
                visited.add(stateTriple)
                q.add(intArrayOf(normalizedState[0], normalizedState[1], normalizedState[2], count + 1))
            }
        }
    }
}