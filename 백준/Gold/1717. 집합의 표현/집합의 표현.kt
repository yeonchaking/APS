fun main() {
    val (n,m) = readLine()!!.split(" ").map { it.toInt() }
    val parent = IntArray(n + 1) { it }

    fun find(x: Int): Int {
        if (parent[x] != x) {
            parent[x] = find(parent[x])
        }
        return parent[x]
    }
    fun union(a: Int, b: Int) {
        val ra = find(a)
        val rb = find(b)
        if (ra != rb) {
            parent[rb] = ra  
        }
    }
    for (operation in 1..m) {
        val (o,a,b) = readLine()!!.split(" ").map { it.toInt() }
        if(o==0){
            union(a,b)
        }else{
            if(find(a)==find(b)){
                println("YES")
            }else println("NO")

        }
    }
}
