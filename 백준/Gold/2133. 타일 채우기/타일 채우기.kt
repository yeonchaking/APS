fun main() {
    val n = readLine()!!.toInt()

    // 홀수는 불가능
    if(n%2!=0){
        println(0)
        return
    }

    val dp = IntArray(n+1)

    dp[0]=1
    dp[2] = 3

    for(i in 2..n step 2){
        if(i==2)continue
        var p = i-2
        var now = dp[p]*3
        p-=2
        while (p>=0){
            now += dp[p]*2
            p-=2
        }
        dp[i]=now
    }
//    println(dp.joinToString(" "))
    println(dp[n])
}