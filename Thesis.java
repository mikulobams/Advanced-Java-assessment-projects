import java.util.ArrayList;
/**
 * A simple model of a Thesis
 * 
 * @author  (Michael Bamikunle)
 * @version (1.00)
 */
public class Thesis extends Book
{    
    // The name of the University the Thesis was published in
    private final String university;   
    
    /**
     * Create a Thesis. 
     * 
     * @param title     The title of the Thesis.
     * @param author    The title of the Thesis.
     * @param year      The year when the Thesis was published.
     * @param university    The university in which the Thesis was defended
     */
    public Thesis(String title, String author, int year, String university)
    {
        super(title, author, year);
        this.university = university;
    }
    
    /**
     * Get the details of the Thesis
     *  
     * @return  The details of the Thesis including 
     *          the title, author, publisher(University) and year
     */
    @Override
    public String toString ()
    {
        //Adds university to toString method of super
        return super.toString() +", " + university;   
    }         
    
    /**
     * Check if the Thesis is the same as the given object.
     * 
     * @param obj The given object.
     * 
     * @return true if the Thesis and the given object are the same 
     *         or they have the same title, author, University and year; 
     *         false otherwise
     */
    @Override
    public boolean equals(Object obj) {        
        //uses the superclass equality method to check equality of superclass fields
        if (super.equals(obj) == false) return false; 
        //They are not the same if class is not equal
        if (!(obj instanceof Thesis thes)) return false; 
        return thes.university.equals(this.university);
    }   
    
    /**
     * Get the name of the university the Thesis was published in
     * 
     * @return String name of the university
     */
    public String getUniversity()
    {
        return university;
    }
}