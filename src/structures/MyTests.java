package structures;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;
import java.math.BigInteger;
import org.junit.jupiter.api.Test;

import structures.AssociativeArray;
import structures.KeyNotFoundException;


public class MyTests {
  /**
   * Tests get(K key) on a given associative array
   */
  @Test
  public void alexanderMaretTest01() throws Exception{
    AssociativeArray<Integer, String> arr = new AssociativeArray();

    arr.set(0, "Hello");
    arr.set(1, "World");

    assertEquals("Hello", arr.get(0));
    assertEquals("World", arr.get(1));
    assertThrows(KeyNotFoundException.class, () -> {arr.get(2);});
  }


  /**
   * Tests size() at various points in the construction of an associative array
   */
  @Test
  public void alexanderMaretTest02() throws Exception{
    AssociativeArray<Integer, String> arr = new AssociativeArray();
    assertEquals(0, arr.size());

    arr.set(0, "Hello");
    assertEquals(1, arr.size());

    arr.set(1, "World");
    assertEquals(2, arr.size());

    arr.set(0, "Goodbye");
    assertEquals(2, arr.size());

    arr.remove(1);
    assertEquals(1, arr.size());
  }

  /**
   * Tests size() and hasKey(K key) specifically when the final element of an array is removed
   */
  @Test
  public void alexanderMaretEdge01() throws Exception{
    AssociativeArray<Integer, String> arr = new AssociativeArray();

    arr.set(0, "Test");
    assertEquals(1, arr.size());
    assertTrue(arr.hasKey(0));

    arr.remove(0);
    assertEquals(0, arr.size());
    assertFalse(arr.hasKey(0));
  }
}
