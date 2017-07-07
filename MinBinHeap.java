package MinBinHeap_A3;

public class MinBinHeap implements Heap_Interface {
  private EntryPair[] array; //load this array
  private int size;
  private static final int arraySize = 10000; //Everything in the array will initially 
                                              //be null. This is ok! Just build out 
                                              //from array[1]

  public MinBinHeap() {
    this.array = new EntryPair[arraySize];
    array[0] = new EntryPair(null, -100000); //0th will be unused for simplicity 
                                             //of child/parent computations...
                                             //the book/animation page both do this.
  }
    
  //Please do not remove or modify this method! Used to test your entire Heap.
  @Override
  public EntryPair[] getHeap() { 
    return this.array;
  }

@Override
public void insert(EntryPair entry) {
	int hole = ++size;
	EntryPair temp = entry;
	while(temp.priority < array[hole/2].priority){
		array[hole] = array[hole/2];
		hole /= 2;
	}
		array[hole] = entry;
}

@Override
public void delMin() {
	// TODO Auto-generated method stub
	if(size == 0){
		return;
	}
	array[1] = array[size];
	size--;
	percolatedown(1);
}	

private void percolatedown(int hole){
	int childindex;
	EntryPair temp = array[hole];
	
	for(; hole * 2 <= size; hole = childindex){
		childindex = hole * 2;
		if(childindex != size && array[childindex + 1].priority < array[childindex].priority){
			childindex++;
		}
		if(array[childindex].priority < temp.priority){
			array[hole] = array[childindex];
		}
		else{
			break;
		}
	}
	array[hole] = temp;
}
 
@Override
public EntryPair getMin() {
	if(array[1] == null){
		return null;
	}
	else{
		return array[1];
	}
	
}
@Override
public int size() {
	// TODO Auto-generated method stub
	if(array[1] == null){
		return 0;
	}
	return size;
}

@Override
public void build(EntryPair[] entries) {
	// TODO Auto-generated method stub
	for(int i = 0; i < entries.length; i++){
		array[i+1] = entries[i];
		size++;
	}
	for(int j = size/2 ; j > 0; j--){
		percolatedown(j);
	}
}

}

