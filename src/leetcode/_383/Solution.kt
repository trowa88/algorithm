package leetcode._383

class Solution {
    fun canConstruct(ransomNote: String, magazine: String): Boolean {
        var result = ransomNote
        for (c in magazine) {
            result = result.replaceFirst(c.toString(), "")
        }
        return result.isEmpty()
    }
}

fun main() {
    println(
        Solution().canConstruct(
            "aa",
            "aab"
        )
    )
}
