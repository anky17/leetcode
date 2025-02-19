/*🔹 Step-by-Step Explanation:
    Check Length:
        If the two strings s and t are of different lengths, they cannot be anagrams.
        Time Complexity: O(1)O(1), since checking length is constant time.

    Create a Frequency Array (charCounts) of Size 26:
        Since the input consists only of lowercase English letters ('a' to 'z'), we use an integer array charCounts[26], where each index represents a character:
            'a' → index 0
            'b' → index 1
            ...
            'z' → index 25

    Update the Frequency Array:
        Iterate through both strings at the same time and update the charCounts array:
            Increment for characters in s.
            Decrement for characters in t.
        This ensures that matching characters cancel each other out.

    Verify All Counts Are Zero:
        After processing both strings, if s and t are anagrams, all elements in charCounts should be 0 (because every increment has a corresponding decrement).
        If any count is nonzero, s and t have different characters or frequencies, so they are not anagrams.
*/

class Solution {
    public boolean isAnagram(String s, String t) {

        if (s.length() != t.length()) {
            return false;
        }

        int[] charCounts = new int[26];

        // considering only lowercase
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i) - 'a']++;
            charCounts[t.charAt(i) - 'a']--;
        }

        for (int count : charCounts) {
            if (count != 0) {
                return false;
            }
        }
        return true;
    }
}