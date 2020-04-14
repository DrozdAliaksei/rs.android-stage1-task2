package subtask6

class Fibonacci {
    fun productFibonacciSequenceFor(n: Int): IntArray {
        var i = 1
        while(fib(i)*fib(i+1) < n){
            i++
        }
        return intArrayOf(fib(i),fib(i+1),if(fib(i)*fib(i+1)>n) 0 else 1)
    }

    private fun fib(n:Int): Int{
        if (n <= 1)
            return n
        return fib(n - 1) + fib(n - 2)
    }
}
