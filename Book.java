/**
 * A simple model of a Book
 * 
 * @author  (Michael Bamikunle)
 * @version (1.00)
 */
public class Book extends Publication
{    
    //The author of the book
    private final String author;   
    
    
    /**
     * Create a Book. 
     * 
     * @param title     The title of the Book.
     * @param author    The title of the Book.
     * @param year      The year when the Book was published.
     */
    public Book(String title, String author, int year)
    {
        super(title, year);
        this.author = author;
    }

    /**
     * Get the author of the Book
     *  
     * @return  The author of the Book
     */
    public String getAuthor()
    {
        return author;
    }
    
    /**
     * Get the details of the Book
     *  
     * @return  The details of the Book including 
     *          the title, author, publisher and year
     */
    @Override
    public String toString ()
    {
        /*Adds author to toString method of super
         * Will Override super.toString() method
         */
        return super.toString() + ", " + author;         
    }         
    
    /**
     * Check if the Book is the same as the given object.
     * 
     * @param obj The given object.
     * 
     * @return true if the Book and the given object are the same 
     *         or they have the same title, author, publisher and year; 
     *         false otherwise
     */
    @Override
    public boolean equals(Object obj) {        
        //Uses the superclass equality method to check equality of superclass fields
        if (super.equals(obj) == false) return false; 
        //Type equality check. If not same type, then not same obj
        if (!(obj  instanceof Book book)) return false; 
        return this.author.equals(book.author);
    }   
}
