/**
 * A simple model of a Journal
 * 
 * @author  (Michael Bamikunle)
 * @version (1.00)
 */
public class Journal extends Publication
{
    private final int month;     // The month when the journal was published

    /**
     * Create a Journal. 
     * 
     * @param title     The title of the Journal.
     * @param month     The month when the Journal was published.
     * @param year      The year when the Journal was published.     
     */
    public Journal(String title, int year, int month)
    {
        super(title, year);
        this.month = month;
    }
 
    /**
     * Get the month of the Journal when it was published
     *  
     * @return  The month of the Journal when it was published
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * Get the details of the Journal
     *  
     * @return  The details of the Journal: 
     *          the title, year and month
     */
    @Override
    public String toString()
    {
        //adds month to toString method of super 
        return super.toString() +", " + getMonthName(month);  
    }             
    
    /**
     * Check if the Journal is the same as the given object.
     * 
     * @param obj The given object.
     * 
     * @return true if the Journal and the given object are the same 
     *         or they have the same title, year and month; 
     *         false otherwise
     */
    @Override
    public boolean equals(Object obj) {        
        /*uses the superclass equality method 
         * to check equality of superclass fields.
         * Also checks for reference equality
         */
        if (super.equals(obj) == false) return false; 
        //if not same type, then they are not equal
        if (!(obj instanceof Journal jJournal )) return false; 
        return this.month == jJournal.month;
    }    
    
    /**
     * To get the first three letters of a given month's name
     * 
     * @param month A given month
     * @return   The first three letters of the given month's name
     */
    private String getMonthName(int month) {
        switch (month) {
            case 1: return "January";
            case 2: return "February";
            case 3: return "March";
            case 4: return "April";
            case 5: return "May";
            case 6: return "June";
            case 7: return "July";
            case 8: return "August";
            case 9: return "September";
            case 10: return "October";
            case 11: return "November";
            case 12: return "December";
            default: return "Unknown";
        }
    }    
}
