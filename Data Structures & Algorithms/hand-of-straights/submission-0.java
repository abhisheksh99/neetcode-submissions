class Solution {
   public boolean isNStraightHand(int[] hand, int groupSize) {
        if (hand.length % groupSize != 0) return false; // Early exit if not divisible

        TreeMap<Integer, Integer> cardCounts = new TreeMap<>();
        // Count each card
        for (int card : hand) {
            cardCounts.put(card, cardCounts.getOrDefault(card, 0) + 1);
        }
        
        // Attempt to form groups
        while (!cardCounts.isEmpty()) {
            int first = cardCounts.firstKey(); // Start with the smallest card
            for (int i = 0; i < groupSize; i++) {
                int currentCard = first + i;
                if (!cardCounts.containsKey(currentCard)) {
                    return false; // Can't form a group
                }
                
                // Decrease count or remove card if count is 0
                int count = cardCounts.get(currentCard);
                if (count == 1) {
                    cardCounts.remove(currentCard);
                } else {
                    cardCounts.put(currentCard, count - 1);
                }
            }
        }
        
        return true;
    }
}