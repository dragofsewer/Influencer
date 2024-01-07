// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those 
// who do.
// -- Aixa Atoa Ortiz (aixa)
// -- Jack Yang
// -- Stephen Ye

package prj5;

import java.util.Iterator;
import java.util.NoSuchElementException;
import student.TestCase;

/**
 * Tests the methods in the DLList class.
 * 
 * @author Aixa Atoa Ortiz (aixa)
 * @author Jack Yang
 * @author Stephen Ye
 * @version 2022.11.17
 */
public class DLListTest extends TestCase {
    private DLList<String> list;
    private Iterator<String> iterator;
    
    /**
     * Sets up each test method.
     */
    public void setUp() {
        list = new DLList<String>();
        iterator = list.iterator();
    }
    
    /**
     * Tests DLList size method.
     */
    public void testSize() {
        assertEquals(0, list.size());
        
        list.add("Aixa");
        assertEquals(1, list.size());
        
        list.remove(0);
        assertEquals(0, list.size());
    }
    
    /**
     * Tests DLList isEmpty method.
     */
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
        
        list.add("Aixa");
        assertFalse(list.isEmpty());
    }
    
    /**
     * Tests DLList clear method.
     */
    public void testClear() {
        list.add("Aixa");
        list.clear();
        assertTrue(list.isEmpty());
        assertFalse(list.contains("Aixa"));
    }
    
    /**
     * Tests DLList clear method.
     */
    public void testContains() {
        assertFalse(list.contains("Aixa"));
        
        list.add("Aixa");
        assertTrue(list.contains("Aixa"));
        assertFalse(list.contains("Will"));
    }
    
    /**
     * Tests DLList get method.
     */
    public void testGet() {
        list.add("Aixa");
        list.add("Will");
        list.add("Andrea");
        
        Exception exception = null;
        try {
            list.get(-5);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        
        exception = null;
        try {
            list.get(5);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        
        assertEquals("Aixa", list.get(0));
        assertEquals("Will", list.get(1));
        assertEquals("Andrea", list.get(2));
    }
   
    /**
     * Tests DLList toString method.
     */
    public void testToString() {
        assertEquals("{}", list.toString());
        
        list.add("Aixa");
        list.add("Will");
        assertEquals("{Aixa, Will}", list.toString());
    }
    
    /**
     * Tests DLList add method.
     */
    public void testAdd() {
        list.add("Aixa");
        assertEquals(1, list.size());
        assertEquals("{Aixa}", list.toString());
        
        list.add("Andrea");
        assertEquals(2, list.size());
        assertEquals("{Aixa, Andrea}", list.toString());
    }
    
    /**
     * Tests DLList add method with a given index.
     */
    public void testAddIndex() {
        Exception exception = null;
        try {
            list.add(-5, "Aixa");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        
        exception = null;
        try {
            list.add(5, "Aixa");
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        
        exception = null;
        try {
            list.add(0, null);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IllegalArgumentException);
        
        list.add(0, "Aixa");
        assertEquals(1, list.size());
        assertEquals("{Aixa}", list.toString());
        
        list.add(0, "Will");
        assertEquals(2, list.size());
        assertEquals("{Will, Aixa}", list.toString());
    }
    
    /**
     * Tests DLList remove method with a given index.
     */
    public void testRemoveIndex() {
        Exception exception = null;
        try {
            list.remove(-5);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        
        exception = null;
        try {
            list.remove(5);
        }
        catch (Exception e) {
            exception = e;
        }
        assertTrue(exception instanceof IndexOutOfBoundsException);
        
        list.add("Aixa");
        assertTrue(list.remove(0));
        assertTrue(list.isEmpty());
        assertFalse(list.contains("Aixa"));
    }
    
    /**
     * Tests DLList remove method with a given object.
     */
    public void testRemove() {
        list.add("Aixa");
        assertFalse(list.remove("Will"));
        assertEquals(1, list.size());
        
        list.add("Andrea");
        assertTrue(list.remove("Andrea"));
        assertEquals(1, list.size());
        assertEquals("{Aixa}", list.toString());
    }
    
    /**
     * Tests DLList lastIndexOf method.
     */
    public void testLastIndexOf() {
        list.add("Aixa");
        list.add("Andrea");
        list.add("Aixa");
        list.add("Will");
        
        assertEquals(-1, list.lastIndexOf("Oliver"));
        assertEquals(2, list.lastIndexOf("Aixa"));
        assertEquals(1, list.lastIndexOf("Andrea"));
        assertEquals(3, list.lastIndexOf("Will"));
    }
    
    /**
     * Tests DLListIterator hasNext method.
     */
    public void testHasNext() {
        assertFalse(iterator.hasNext());
        
        list.add(0, "aixa");
        assertTrue(iterator.hasNext());
    }
    
    /**
     * Tests DLListIterator next method .
     */
    public void testNext() {
        Exception e = null;
        try {
            iterator.next();
        }
        catch (Exception exception) {
            e = exception;
        }
        assertTrue(e instanceof NoSuchElementException);
        list.add("Aixa");
        list.add("Will");
        assertEquals("Aixa", iterator.next());
    }
}