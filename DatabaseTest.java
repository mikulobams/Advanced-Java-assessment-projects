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
public class DatabaseTest
{
    private Database database1;
    private Publication publicat1;
    private Book book1;
    private Journal journal1;
    private Thesis thesis1;
    private Book book2;
    private Publication publicat2;
    private Publication publicat3;
    private Thesis thesis2;
    private Thesis thesis3;
    private Journal journal2;
    private Journal journal3;
    private Book book3;
    
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
        database1 = new Database();
        publicat1 = new Publication("Bams", 2000);
        book1 = new Book("Harry Potter", "JK Rowling", 2005);
        journal1 = new Journal("Analgesic", 2023, 7);
        thesis1 = new Thesis("PMTCT", "TT Shekarau", 2022, "ABU");
        database1.addPublication(book1);
        database1.addPublication(thesis1);
        database1.addPublication(publicat1);
        database1.addPublication(journal1);
        database1.printSortedPublications();
        book2 = new Book("Game of Thrones", "GRR MArtin", 2005);
        database1.addPublication(book2);
        database1.printSortedPublications();
        publicat2 = new Publication("Heroes", 2025);
        database1.addPublication(publicat2);
        database1.printSortedPublications();
        publicat3 = new Publication("Adams Oshomole", 1999);
        database1.addPublication(publicat3);
        database1.printSortedPublications();
        database1.getThesesList("dfadf", 2000);
        database1.getThesesList("ABU", 2022);
        thesis2 = new Thesis("Juvenile Rheumatoid Arthritis", "BAMSKENS", 2022, "ABU");
        database1.getThesesList("ABU", 2022);
        database1.addPublication(thesis1);
        database1.addPublication(thesis2);
        database1.addPublication(thesis2);
        database1.getThesesList("ABU", 2022);
        thesis3 = new Thesis("Diabetes Insipidus", "DFSFSF", 2021, "ABU");
        database1.addPublication(thesis3);
        database1.getThesesList("ABU", 2022);
        database1.printSortedPublications();
        database1.printSortedPublications();
        database1.printSortedPublications();
        journal2 = new Journal("Adverse Drug Reactions", 2007, 3);
        database1.addPublication(journal2);
        database1.printSortedPublications();
        journal3 = new Journal("Aids: The Half-Century", 2000, 1);
        database1.addPublication(journal3);
        database1.printSortedPublications();
        database1.printSortedPublications();
        book3 = new Book("The Lord of the Rings", "JRR Tolkein", 1967);
        database1.addPublication(book3);
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
}
