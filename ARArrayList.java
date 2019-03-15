package ARArrayList;

public class ARArrayList <E> implements BareArrayList <E>{
    private int size; //number of elements in the array list
    private int capacity; //number of elements an array can store
    private E[] myArray; //The reference to the actual data
    //Constructors

    //default constructor
    public ARArrayList(){
        this.capacity = 2;
        this.size = 0;
        myArray = (E[])new Object[this.capacity]; //creates the array with default size
    }
    //overloaded constructor
    public  ARArrayList(int c){
        this.capacity = c;
        this.size = 0;
          myArray = (E[])new Object[this.capacity];
    }


    @Override
    public void add(E a) { //adds element to end of arraylist
        if(size < capacity){   //if size is less than capacity then there is room
            myArray[size] = a;
            size++;
        }else{
            /*System.out.println("Not enough space. Call reallocate.");*/
            this.reallocate();
            this.add(a);
        }

    }
    private void reallocate(){
        //double capacity of arraylist
        this.capacity *= 2;
        E[] temp = (E[])new Object[this.capacity];
        //now we have an empty array double the size
        //copy over elements form original array to temp
        for(int i = 0; i < myArray.length; i++){
            temp[i] = myArray[i];
        }
        this.myArray = temp; //update reference
    }

    @Override
    public void add(int index, E a) { //adds data at specified index
        //check bounds
        if(index < 0 || index > size){
            throw new ArrayIndexOutOfBoundsException(index);
        }else if(index == size){
            //element needs to be added to end
            this.add(a);
        }else{
            if(this.capacity == this.size) {
                /*System.out.println("Not enough space. Call reallocate.");*/
                this.reallocate(); //arraylist is full
            }else{
                for (int i = size-1; i >= 0; i--) {
                    this.myArray[i+1] = this.myArray[i];
                }
                this.myArray[index] = a;
                this.size++;
            }
        }

        //make sure there is room
        if(size >= capacity){
            reallocate();
        }

    }

    @Override
    public E remove(int index) {
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        E returnValue = myArray[index];
        for(int i = index + 1; i < size; i++){
            this.myArray[i-1] = this.myArray[i];
        }
        size--;
        return returnValue;
    }

    @Override
    public E get(int index) {
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }

        return myArray[index];
    }

    @Override
    public void set(int index, E a) {
        if(index < 0 || index >= size){
            throw new ArrayIndexOutOfBoundsException(index);
        }
        myArray[index] = a;
    }

    @Override
    public int getSize() {
        return this.size;
    }

    public int getCapacity(){return this.capacity;}

    @Override
    public int indexOf(E a) {
        for(int i = 0; i < size; i++){
            if (myArray[i].equals(a)){
                return i;
            }

        }
        return -1;
    }
    public String toString(){
        System.out.print("ArrayList: ");
        String s = " ";
        for(int i=0; i <size; i++){
            s=s+myArray[i] + " | ";
        }
        return s;
    }
}
