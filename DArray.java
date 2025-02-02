/**
 * =====================================
 * Please complete the remaining operations:
  0. add a default constructor with initial size of 10 - make this default size
     into a constant
  1. add/insert: an element to a given index (reset as necessary), and a method
     to add an element to the back of the array
  2. resize: reset the size of the array as the user inserts data past the 
     maxSize/capacity or they explicitly invoke the operation 
  3. add getFirst/getLast methods to retrieve the corresponding element
  4. Modify the class so it can handle any kind of data type (generic data type class)
  5. Make sure the code is fully documented and the file is fully described 
     with appropriate information and algorithms
 * ==================================
 * @author Ken Nguyen
 * @editor Benjamin Acosta
 * @class Data Structures and Algorithms
 * @section 01
 * @purpose: simple illustration of a dynamic array/vector 
 * @activity P-Module 3 Activity
 * 
 * Algorithm:
 * 1. Initialize the dynamic array with a default size and calculate the buffer size using the grow factor.
 * 2. Add methods to insert elements at specific indices and to append elements at the end of the array.
 * 3. Implement a mechanism to increase the capacity of the array when the current capacity is exceeded by:
 *    a. Calculating a new buffer size based on the grow factor.
 *    b. Creating a new buffer and copying existing elements to the new buffer.
 * 4. Provide methods to retrieve the first and last elements of the array, ensuring the array is not empty.
 * 5. Utilize Java generics to ensure the array can handle any data type.
 * 6. Add safeguards and validation to handle edge cases and prevent errors.
 */
public class DArray<T> {
    private static final int DEFAULT_SIZE = 10;
    private final double GROW_FACTOR = 0.5; // array size growing rate
    
    //attributes
    private int size;
    private int elementCount;
    private T[] buffer; //the actual array
    
   // Default constructor
   @SuppressWarnings("unchecked")
   public DArray() {
       this.size = DEFAULT_SIZE;
       this.elementCount = 0;
       int bufferSize = (int) Math.ceil(this.size + this.size * GROW_FACTOR);
       this.buffer = (T[]) new Object[bufferSize];
   }
    
   // Parameterized constructor
   @SuppressWarnings("unchecked")
   public DArray(int size) throws Exception {
       if(size < 0) {
           throw new Exception("Not a valid range");
       }
       this.size = size; //the actual array size
       this.elementCount = 0;
       int bufferSize = (int) Math.ceil(this.size + this.size * GROW_FACTOR);
       this.buffer = (T[]) new Object[bufferSize]; //create the buffer
   }
   
   /**
    * Adds an element to a given index in the array.
    * 
    * @param index the index at which the element should be inserted
    * @param element the element to be inserted
    * @throws Exception if the index is out of bounds
    */
   public void add(int index, T element) throws Exception {
       if(index < 0 || index > this.elementCount) {
           throw new Exception("Index out of bound");
       }
       if(this.elementCount == this.buffer.length) {
           resize(this.size + 1);
       }
       for (int i = this.elementCount; i > index; i--) {
           this.buffer[i] = this.buffer[i - 1];
       }
       this.buffer[index] = element;
       this.elementCount++;
   }
   
   /**
    * Adds an element to the back of the array.
    * 
    * @param element the element to be added
    */
   public void add(T element) {
       if(this.elementCount == this.buffer.length) {
           resize(this.size + 1);
       }
       this.buffer[this.elementCount++] = element;
   }
   
   /**
    * Resizes the array to a new size.
    * 
    * @param newSize the new size of the array
    */
   @SuppressWarnings("unchecked")
   public void resize(int newSize) {
       if(newSize <= this.size || newSize < this.buffer.length) {
           this.size = newSize;
       }
       else if(newSize < 0) {
           throw new IllegalArgumentException("New size cannot be less than the current size");
       }
       int bufferSize = (int) Math.ceil(newSize + newSize * GROW_FACTOR);
       T[] newBuffer = (T[]) new Object[bufferSize];
       for (int i = 0; i < this.elementCount; i++) {
           newBuffer[i] = this.buffer[i];
       }
       this.buffer = newBuffer;
       this.size = newSize;
   }
   
   /**
    * Retrieves the first element of the array.
    * 
    * @return the first element of the array
    * @throws Exception if the array is empty
    */
   public T getFirst() throws Exception {
       if(this.elementCount == 0) {
           throw new Exception("Array is empty");
       }
       return this.buffer[0];
   }
   
   /**
    * Retrieves the last element of the array.
    * 
    * @return the last element of the array
    * @throws Exception if the array is empty
    */
   public T getLast() throws Exception {
       if(this.elementCount == 0) {
           throw new Exception("Array is empty");
       }
       return this.buffer[this.elementCount - 1];
   }
   
   /**
    * 
    * @return the actual size of the array
    */
   public int length() {
       return this.elementCount;
   }
   
   /**
    * 
    * @return the max length of the dynamic array
    */
   public int maxLength() {
       return this.buffer.length;
   }
   
   /**
    * 
    * @param index - the location of the element in the array
    * @return the element at the given location/index
    * @throws Exception if the index is out of bounds
    */
   public T elementAt(int index) throws Exception {
       if(index < 0 || index >= this.elementCount) {
           throw new Exception("Index out of bound");
       }
       return this.buffer[index];
   }
   
   //////////////////////////////////////////////////////////
   // Driver to test the code
   public static void main(String[] args) throws Exception {
      DArray<Integer> a = new DArray<>(5);
      System.out.println("Length: " + a.length());
      System.out.println("MaxLength: " + a.maxLength());
      
      a.add(0, 10); //set value 10 into index 0
      a.add(50); //add value 50 to the back
      a.resize(15);
      
      System.out.println("Resized to be able to hold up to 15 elements");
      System.out.println("New size: " + a.length());
      System.out.println("Max size: " + a.maxLength());
      
      System.out.println("First element: " + a.getFirst());
      System.out.println("Last element: " + a.getLast());
      
      a.add(2, 13);
      System.out.println("Added element at index 2: " + a.elementAt(2));
      
      DArray<String> b = new DArray<>();
      b.add("Sam");
      System.out.println("Added String 'Sam' to array");
      System.out.println("First element in string array: " + b.getFirst());
      
      DArray<Character> c = new DArray<>();
      c.add('+');
      System.out.println("Added Character '+' to array");
      System.out.println("First element in character array: " + c.getFirst());
      
      System.out.println("Resized to be able to hold up to 4 elements");
      a.resize(4);
      System.out.println("New size: " + a.length());
      System.out.println("Max size: " + a.maxLength());
   } //end of main

} //end of DArray class
