// Approach 1: Recursive (Queue)

// public class NestedIterator implements Iterator<Integer> {
//   public NestedIterator(List<NestedInteger> nestedList) {
//     addInteger(nestedList);
//   }

//   @Override
//   public Integer next() {
//     return q.poll();
//   }

//   @Override
//   public boolean hasNext() {
//     return !q.isEmpty();
//   }

//   private Queue<Integer> q = new ArrayDeque<>();

//   private void addInteger(final List<NestedInteger> nestedList) {
//     for (final NestedInteger ni : nestedList)
//       if (ni.isInteger())
//         q.offer(ni.getInteger());
//       else
//         addInteger(ni.getList());
//   }
// }
















// Approach 2: Stack



public class NestedIterator implements Iterator<Integer> {
  public NestedIterator(List<NestedInteger> nestedList) {
    addInteger(nestedList);
  }

  @Override
  public Integer next() {
    return stack.pop().getInteger();
  }

  @Override
  public boolean hasNext() {
    while (!stack.isEmpty() && !stack.peek().isInteger()) {
      final NestedInteger ni = stack.pop();
      addInteger(ni.getList());
    }
    return !stack.isEmpty();
  }

  private Deque<NestedInteger> stack = new ArrayDeque<>();

  // addInteger([1, [4, [6]]]) -> stack = [[4, [6]], 1]
  // addInteger([4, [6]]) -> stack = [[6], 4]
  // addInteger([6]) -> stack = [6]
  private void addInteger(final List<NestedInteger> nestedList) {
    for (int i = nestedList.size() - 1; i >= 0; --i)
      stack.push(nestedList.get(i));
  }
}
