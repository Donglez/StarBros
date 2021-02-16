package starbrosgame;
/**
  * An object that has 2 values (integers) assigned to it.
  * Science defines a vector as a value that has both magnitude and direction,
  * so if needed, x can be set as magnitude while y can be set as direction.
  *  Otherwise it can be used to represent co-ordinates.
  * (NOTE: When creating this object, I was unaware that the object "Point()"
  * Existed and performed almost the same function, with minute differences).
  */
public class Vector 
{
 public int x;
 public int y;
  
 /**
  * Blank constructor
  */
    public Vector()
    {
        
    }
    
    /**
     * 
     * @param xx horizontal position.
     * @param yy vertical position.
     */
    public Vector(int xx, int yy)
    {
     x = xx;
     y = yy;
    }
    
    /**
     * 
     * @return a visual representation of the vector.
     */
 @Override
    public String toString()
    {
      String s = "(" + x + ", " + y + ")";
      return s;
    }
    
    /**
     * Checks to see if a vector is within a specific 
     * horizontal range of another vector.
     * @param v a vector
     * @param w horizontal length (width) both left and right.
     * @return true if the one vector is in range of another vector, else false.
     */
    public boolean isWithinHRange(Vector v, int w)
    {
        boolean b = false;
        if (v.x >= x - w && v.x <= x + w)
        {
           b = true; 
        }
        return b;
    }
    
    /**
     * Checks to see if a vector is within a specific 
     * Vertical range of another vector.
     * @param v a vector
     * @param h vertical length (height) both up and down.
     * @return true if the one vector is in range of another vector, else false.
     */
    public boolean isWithinVRange(Vector v, int h)
    {
        boolean b = false;
        if (v.y >= y - h && v.y <= y + h)
        {
           b = true; 
        }
        return b;
    }
}
