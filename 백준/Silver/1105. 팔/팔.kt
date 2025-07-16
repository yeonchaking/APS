fun main() {
    val (L,R) = readLine()!!.split(" ")
    var count = 0

    if(L.length == R.length){
        for(i in L.indices){
            if(L[i]==R[i]) {
                if(L[i] == '8')count++
            }else break
        }
    }



    println(count)
}