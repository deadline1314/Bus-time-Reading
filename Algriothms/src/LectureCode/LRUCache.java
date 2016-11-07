package LectureCode;

import java.util.HashSet;
import java.util.LinkedList;

public class LRUCache<T> {
	
	private Object lockObject;
	private int maxSize;
	private LinkedList<T> listLRU;
	private HashSet<T> set;
	private LRUCache(){
		
	}
	
	public LRUCache(int maxSize){
		lockObject = new Object();
		this.maxSize = maxSize;
		listLRU = new LinkedList<T>();
		set = new HashSet<T>();
	}
	
	public void addItem(T item){
		synchronized(lockObject){
			if(set.contains(item)){
				//remove item from the list and add it to start
				listLRU.remove(item);
				listLRU.addFirst(item);
			}else{
				//add the element in the set
				//add the element to start of list
				set.add(item);
				listLRU.addFirst(item);
				if(listLRU.size() > maxSize){
					//if the size is > maxSize, remove the last element
					//remove last element from the set
					T remove = listLRU.getLast();
					set.remove(remove);
					listLRU.removeLast();
				}
			}
		}
	}
	
	public void clearList(){
		synchronized(lockObject){
			listLRU.clear();
			set.clear();
		}
	}

	public static void main(String[] args) {
		

	}

}
