import java.util.*;

class Solution {

    class Node {
        int l, r, w, idx;

        Node(int l, int r, int w, int idx) {
            this.l = l;
            this.r = r;
            this.w = w;
            this.idx = idx;
        }
    }

    class Result {
        long score;
        List<Integer> indices;

        Result(long score, List<Integer> indices) {
            this.score = score;
            this.indices = indices;
        }
    }

    Node[] arr;
    Result[][] memo;

    public int[] maximumWeight(List<List<Integer>> intervals) {

        int n = intervals.size();

        arr = new Node[n];

        for (int i = 0; i < n; i++) {
            arr[i] = new Node(
                intervals.get(i).get(0),
                intervals.get(i).get(1),
                intervals.get(i).get(2),
                i
            );
        }

        // Sort by LEFT endpoint
        Arrays.sort(arr, (a, b) -> {
            if (a.l != b.l)
                return Integer.compare(a.l, b.l);

            return Integer.compare(a.r, b.r);
        });

        memo = new Result[n][5];

        Result ans = solve(0, 4);

        int[] result = new int[ans.indices.size()];

        for (int i = 0; i < ans.indices.size(); i++) {
            result[i] = ans.indices.get(i);
        }

        return result;
    }

    private Result solve(int i, int k) {

        // No intervals left
        if (i == arr.length || k == 0) {
            return new Result(0, new ArrayList<>());
        }

        if (memo[i][k] != null) {
            return memo[i][k];
        }

        // --------------------
        // OPTION 1: SKIP
        // --------------------
        Result skip = solve(i + 1, k);

        // --------------------
        // OPTION 2: PICK
        // --------------------

        Node cur = arr[i];

        int next = findNext(cur.r);

        Result nextResult = solve(next, k - 1);

        long pickScore = cur.w + nextResult.score;

        List<Integer> pickIndices =
                new ArrayList<>(nextResult.indices);

        pickIndices.add(cur.idx);

        // Sort original indices
        Collections.sort(pickIndices);

        Result pick =
                new Result(pickScore, pickIndices);

        // Choose better answer
        Result best = better(skip, pick);

        memo[i][k] = best;

        return best;
    }

    // First interval whose LEFT > currentRight
    private int findNext(int right) {

        int low = 0;
        int high = arr.length;

        while (low < high) {

            int mid = low + (high - low) / 2;

            if (arr[mid].l > right) {
                high = mid;
            } else {
                low = mid + 1;
            }
        }

        return low;
    }

    private Result better(Result a, Result b) {

        // Higher score wins
        if (a.score != b.score) {
            return a.score > b.score ? a : b;
        }

        // Same score -> lexicographically smaller
        return compare(a.indices, b.indices) <= 0 ? a : b;
    }

    private int compare(List<Integer> a, List<Integer> b) {

        int n = Math.min(a.size(), b.size());

        for (int i = 0; i < n; i++) {

            if (!a.get(i).equals(b.get(i))) {
                return Integer.compare(a.get(i), b.get(i));
            }
        }

        return Integer.compare(a.size(), b.size());
    }
}