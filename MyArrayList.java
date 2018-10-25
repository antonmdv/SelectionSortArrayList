/*
 * Author: Anton Medvedev, amedvedev2013@my.fit.edu
 * Course: CSE 1002, Section 03, Fall 2014
 * Project: myarraylist
 */
import java.util.*;
public class MyArrayList extends AbstractList <Integer>{
  
    /**
     * size of an array
     */
    int size = 0;
    /**
     * Array of an elements
     */
    int[] array;
    
    /**
     * Increases the capacity of an array to ensure that it can hold at least the number 
     * of elements specified by the argument
     * @param minCapacity
     */
    private void ensureCapacity (int minCapacity){
        if(array.length < minCapacity){
            array = Arrays.copyOf(array, (minCapacity + array.length));
        }
    }
    /**
     * Constructs an empty list with an initial Capacity of ten
     */
    public MyArrayList(){
        array = new int[10];
    }
    /**
     * Constructs and empty list with a specified initial capacity
     * @param initialCapacity
     */
    public MyArrayList(int initialCapacity){
        array = new int[initialCapacity];
    }
    /**
     * Inserts the specified element at the end of the list, return true if succeeded.
     * @param element
     * @return
     */
    public boolean add(Integer element){
        ensureCapacity(size + 1);
        array[size] = element;
        size++;
        return true;
    }
    /**
     * Returns an element of a specified position in this list
     * @param index
     * @return
     */
    public Integer get(int index){
        return array[index];
    }
    /**
     * Replaces an element at the specified position in this list, should return the removed element value.
     * @param index
     * @param element
     * @return
     */
    public Integer set(int index, Integer element){
        if((index <=0) ||(index >=size)){
            throw new IndexOutOfBoundsException();
        } else {
            Integer hold = array[index];
            array[index] = element;
            return hold;
        }
    }
    /**
     * Removes the element of an index, returns removed value 
     * @param index
     * @return
     */
    public Integer remove(int index){
        if((index <=0) ||(index >=size)){
            throw new IndexOutOfBoundsException();
        } else {
            Integer hold = array[index];
            array[index] = 0;
            for(int i = index; i < size-1; i++){
                array[i] = array[i+1];
            }
            size--;
            return hold;
        }
    }
    /**
     * Finds and Removes the first occurrence of the specified element from the list. Returns removed element value 
     * @param element
     * @return
     */
    public boolean remove(Integer element){
        Integer hold;
        for(int i = 0; i <= size; i++){
            if(array[i] == element){
                hold = array[i];
                remove(array[i]);
                return true;
            }
        }
        return false;
    }
    /**
     * Removes all the elements from this list;
     */
    public void clear(){
        for(int i = 0; i <= size; i++){
            array[i] = 0;
        }
        size = 0;
    }
    @Override
    public int size() {
        // TODO Auto-generated method stub
        return 0;
    }
}