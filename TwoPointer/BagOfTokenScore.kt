
data class TokenHandler(var score: Int, var tokens: IntArray, var power: Int, var firstTime: Boolean)

class Solution {
    fun bagOfTokensScore(tokens: IntArray, power: Int): Int {
        tokens.sort()
        val result = calculateScore(TokenHandler(0, tokens, power, true))
        return result.score

    }

    private fun calculateScore(handler: TokenHandler): TokenHandler {
        val result = handler
        var left = 0
        var right = result.tokens.size - 1
        val indicesToRemove = mutableSetOf<Int>()
        while(left < right) {
            if (result.power >= result.tokens[left]) {
                result.score += 1
                result.power -= result.tokens[left]
                indicesToRemove.add(left)
                left += 1
            } else if (result.power >= 1 && result.score > 0) {
                result.power += result.tokens[right]
                result.score -= 1
                indicesToRemove.add(right)
                right -= 1
            }
        }
        result.tokens = result.tokens.filterIndexed { index, _ -> index !in indicesToRemove }.toIntArray()
        if (result.tokens.size == 1 && result.tokens[0] <= result.power) result.score += 1
        if (!result.firstTime && result.tokens.size <= 1) return result
        result.firstTime = false
        return calculateScore(result)
    }
}