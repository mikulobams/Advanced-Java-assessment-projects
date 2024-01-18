import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Comparator;
/**
 * A database for a collection of Publications, 
 * e.g. books, journals, Thesis etc.
 * 
 * @author  (Michael Bamikunle)
 * @version (1.00)
 */
public class Database
{
    // A collecion of publications
    private final List<Publication> publicationList;   

    /**
     * Construct a new database
     */
    public Database()
    {
        publicationList = new ArrayList<>();
    }

    /**
     * Add a non-null Publication
     * that is not already in the database
     * 
     * @param newPublication to be added
     */
    public void addPublication(Publication newPublication) {
        //flag
        boolean contains = false;
        //tells user to input a valid entry
        if (newPublication == null) {
            System.out.println("You have tried to input a blank entry into the Database, please try again"); 
                } 
        //checks if publication is already in the publication list   
        else if (newPublication != null) {
            for (Publication checkEquality: publicationList){
                if (checkEquality.equals(newPublication) 
                && checkEquality.getClass().getName().equals(newPublication.getClass().getName()) ) {
                    contains = true;
                }
            }   
            //adds new publications
            if (!contains) {
                publicationList.add(newPublication); 
            }
            //tells user that publication is already in the database.
            else {
                System.out.println("This publication is already in the Database");
            }
        }
        
    }    

    /**
     * Get the total number of publications 
     * 
     * @return The total number of publications  
     */
    public int getTotal() {
        return publicationList.size();
    }    

    /** 
     * 
     * Print the details of all publications
     */
    public void print() {
        for (Publication publi: publicationList) {
            System.out.println(publi);
        }
        System.out.println("Total number of Publications: " + getTotal());
    } 
    
    /**
     * Returns a list of all Theses published in
     * the specified year by the specified university
     * 
     * @param uni Universtiy yr year to be specified
     */
    public List<Thesis> getThesesList(String uni, int yr)
    {
        List<Thesis> theList = new ArrayList<>();
        for (Publication pubs: publicationList) {
            if (pubs instanceof Thesis thes) {
                if (thes.getUniversity().equals(uni) && thes.getYear() == yr) {
                theList.add(thes);
                }
            }
        }
        /* Return null if no matches found for said university and said year
           i.e, the list was empty after the search was completed. */
        if (theList.size() == 0) {
            theList = null;
        }
        return theList;
    }
    
    /**
     * This method prints a sorted output of all publications 
     * in the publication list.
     *
     * It calls a Collections.sort() method 
     * on the Publication List using the comparator interface's
     * static methods thereby ordering the list based on 
     * Class type and title of Publication
     */
    public void printSortedPublications()
    {
        Collections.sort(publicationList, 
            Comparator.comparing((Publication publ) -> publ.getClass().getName())
            .thenComparing(Publication::getTitle));
        for (Publication pub: publicationList) {
            System.out.println(pub.getClass().getName() + "\t------\t" +pub);
        }
    }  
}