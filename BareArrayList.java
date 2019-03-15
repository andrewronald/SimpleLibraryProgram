package ARArrayList;

public interface BareArrayList <E> {
    //two versions for adding in arraylist
    public void add(E a); //adds element to end of the array
    public void add(int index, E a); //adds element at a specific index

    //Remove method
    public E remove(int index);

    // getters and setters
    public E get(int index);
    public void set(int index, E a); //update value at index

    public int getSize(); //returns number of elements in the list

    public int indexOf(E a); //returns index of an object
}
