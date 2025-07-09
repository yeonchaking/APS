fun main() {
    val (a, k) = readLine()!!.split(" ").map { it.toInt() }

    val array = IntArray(k + 1)
    array[a] = 1
    
    for(i in a+1..k){
        if(i%2==0&&array[i/2]!=0){
            if(array[i-1]>array[i/2]){
                array[i] = array[i/2]+1
            }else array[i] = array[i-1]+1
        }else{
            array[i]= array[i-1]+1
        }
    }
    println(array[k]-1)
}