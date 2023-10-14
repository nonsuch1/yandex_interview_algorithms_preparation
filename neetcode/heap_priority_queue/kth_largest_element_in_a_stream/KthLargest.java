class KthLargest {
	int k;
	PriorityQueue<Integer> heap = new PriorityQueue<>();
	
	public KthLargest(int k, int[] nums) {
		this.k = k;
		for (int num: nums) {
			heap.add(num);
		}
		while (heap.size() > k) {
			heap.poll();
		}
	}

	public int add(int val) {
		heap.add(val);
		while (heap.size() > k) {
			heap.poll();
		}
		return heap.peek();
	}
}
