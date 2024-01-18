import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

/**
 * The test class DatabaseTest.
 *
 * @author  (your name)
 * @version (a version number or a date)
 */
public class DatabaseTest extends junit.framework.TestCase
{
    private Book book1;
    private Journal journal1;
    private Thesis thesis1;
    private Thesis thesis2;
    private Book book2;
    private Journal journal2;
    private Book bookNull;
    private Database database1;
    private Book book3;
    private Thesis thesis3;

    
    
    
    
    
    
    

    
    
    
    
    

    
    
    
    

    
    
    

    
    

    /**
     * Default constructor for test class DatabaseTest
     */
    public DatabaseTest()
    {
    }

    /**
     * Sets up the test fixture.
     *
     * Called before every test case method.
     */
    @BeforeEach
    public void setUp()
    {
        book1 = new Book("Harry Potter", "JK Rowling", 2000);
        journal1 = new Journal("Antidiarrhoea", 2000, 5);
        thesis1 = new Thesis("Analgesic activity", "bams kensei", 2014, "University of Kent");
        thesis2 = new Thesis("PMTCT", "Didus", 2005, "Ahmadu Bello University");
        book2 = new Book("Game of Thrones", "GRR Martin", 2005);
        journal2 = new Journal("globuferous", 2005, 7);
        database1 = new Database();
        book3 = new Book("Harry Potter", "JK Rowling", 2000);
        database1.getTotal();
        database1.addPublication(book1);
        database1.addPublication(book3);
        database1.addPublication(book3);
        thesis3 = new Thesis("Harry Potter", "JK Rowling", 2000, "ABU");
    }

    /**
     * Tears down the test fixture.
     *
     * Called after every test case method.
     */
    @AfterEach
    public void tearDown()
    {
    }

    

    public void testAll()
    {
        Book book1 = new Book("Harry Potter and the Order of the Phoenix", "JK Rowling", 2005);
        Journal journal1 = new Journal("Analgesic and antiinflammatory activitie of Eriosema Psoraloiedes in laboratory Animals", 2021, 9);
        Database database1 = new Database();
        database1.addPublication(journal1);
        database1.addPublication(book1);
        assertEquals(2, database1.getTotal());
        database1.print();
        Book book2 = new Book("Lord of the Rings", "JRR Tolkein", 1945);
        database1.addPublication(book2);
        assertEquals(false, book1.equals(book2));
    }

    public void testNullAndDuplicates()
    {
        Database database1 = new Database();
        Book testDuplicates1 = new Book("test", "bams", 2000);
        Book testDuplicate2 = new Book("test", "bams", 2000);
        database1.addPublication(testDuplicates1);
        database1.addPublication(testDuplicate2);
        Journal journal3 = new Journal("test", 2000, 7);
        assertEquals(1, database1.getTotal());
        database1.addPublication(journal3);
        assertEquals(2, database1.getTotal());
        database1.print();
    }

    public void testThesisList()
    {
        Database database1 = new Database();
        database1.addPublication(thesis1);
        database1.addPublication(thesis2);
        Thesis thesis3 = new Thesis("fjdjfjfj", "bam", 2000, "University of Kent");
        database1.addPublication(thesis3);
        Thesis thesis4 = new Thesis("fjsljfsljf", "dfslfjdf", 2014, "University of Kent");
        database1.addPublication(thesis4);
        assertNotNull(database1.thesesList("University of Kent", 2000));
    }
}



