class Solution {
  List<List<int>> combinationSum(List<int> candidates, int target) {
    List<List<int>> result = [];
    List<int> combination = [];

    candidates.sort();

    // Helper function for backtracking
    void backtrack(int start, int target) {
      if (target == 0) {
        result.add(List.from(combination));
        return;
      }
      if (target < 0) return;

      for (int i = start; i < candidates.length; i++) {
        combination.add(candidates[i]);
        backtrack(i, target - candidates[i]);
        combination.removeLast();
      }
    }

    backtrack(0, target);

    return result;
  }
}
