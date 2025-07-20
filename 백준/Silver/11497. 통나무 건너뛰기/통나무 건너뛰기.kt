fun main() {
    val t = readLine()!!.toInt()
    for(tc in 1 .. t){
        val n = readLine()!!.toInt()
        val woods = readLine()!!.split(" ").map { it.toInt() }.sorted()

        var lev = woods[1]-woods[0]
        var prev = woods[0]
        for(i in 2 until  n step 2){
            lev = maxOf(woods[i]-prev,lev)
            prev= woods[i]
        }
        prev = woods[1]
        for(i in 3 until  n step 2){
            lev = maxOf(woods[i]-prev,lev)
            prev= woods[i]
        }
        println(lev)
    }
}