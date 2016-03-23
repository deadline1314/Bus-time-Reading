package DataStructure;

public class MinHeap {

	private int size;
	private int heapSize;
	
	private int[] data;
	private MinHeap(){}
	public MinHeap(int size){ 
		data = new int[size];
		this.heapSize = 0;
		this.size = size;
	}
	
	public int getMin(){
		if(heapSize == 0)
			return Integer.MAX_VALUE;  //as a distinction
		return data[0];
	}
	
	public boolean isEmpty(){
		if(heapSize == 0)
			return true;
		return false;
	}
	
	private int getLeftChildIndex(int index){
		return 2*index+1;
	}
	private int getRightChildIndex(int index){
		return 2*index+2;
	}
	private int getParentIndex(int index){
		return (index-1)/2;
	}
	
	public void insert(int val){
		if(heapSize == data.length)
			return;
		heapSize++;
		data[heapSize - 1] = val;  //insert in the end
		siftUp(heapSize-1);
	}
	
	public void remove(){
		if(isEmpty())
			return;
		data[0] = data[heapSize-1]; //swap root with the last element, then delete the root 
		heapSize--;
		if(heapSize>0)
			siftDown(0);
	}
	
	private void siftDown(int index){
		int temp;
		int minIndex;
		int leftChild = getLeftChildIndex(index);
		int rightChild = getRightChildIndex(index);
		
		if(rightChild >= heapSize){   //only have leftChild
			if(leftChild >= heapSize)
				return;
			else
				minIndex = leftChild;
		}else{
			if(data[leftChild] <= data[rightChild])
				minIndex = leftChild;
			else
				minIndex = rightChild;
		}
		if(data[index] > data[minIndex]){
			temp = data[index];
			data[index] = data[minIndex];
			data[minIndex] = temp;
			siftDown(minIndex);
		}
	}
	private void siftUp(int index){ //need to consider the other side of its child....
		int temp;
		if(index != 0){
			int parentIndex = getParentIndex(index);
			if(data[parentIndex] > data[index]){
				temp = data[parentIndex];
				data[parentIndex] = data[index];
				data[index] = temp;
				siftUp(parentIndex);
			}
		}
	}
	
	public static void main(String[] args) {
		System.out.println(Integer.MAX_VALUE);

	}

}
