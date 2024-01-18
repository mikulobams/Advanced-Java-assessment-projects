import java.util.ArrayList;
/**
 * Publication is the superclass of library objects.
 * It provides a foundation to hold the common fields of
 * the above named library entries and more
 *
 * @author (Michael Bamikunle)
 * @version (1.00)
 */
public class Publication
{
    // instance variables common to all subclasses
    private final String title;
    private final int year;
    

    /**
     * Constructor for objects of class Publication
     */
    public Publication(String title, int year)
    {
        // initialise instance variables that are common
        this.title = title;
        this.year = year;
    }

    /**
     * Get the title of the Publication
     *  
     * @return  The title of the Publication
     */
    public String getTitle()
    {
        return title;
    } 
        
    /**
     * Get the year the Publication was published
     *  
     * @return  The year when it was published
     */
    public int getYear()
    {
        return year;
    }
    
    /**
     * Get the details of the entry
     *  
     * @return the title and year as a string
     */
    @Override
    public String toString()
    {
        return title + ", " + year;      
    }             
    
    /**
     * Check if the Publication is the same as the given one.
     * 
     * @param obj The given object.
     * 
     * @return true if the Publication and the given object are the same 
     *         or they have the same title and year; 
     *         false otherwise
     */
    @Override
    public boolean equals(Object obj) {        
        if (obj == this) return true;
        
        if ( !(obj instanceof Publication publication) )  return false;   
        
        return this.title.equals(publication.title) && 
               this.year == publication.year;
    }
}