// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Aixa Atoa Ortiz (aixa)
// -- Jack Yang
// -- Stephen Ye

package prj5;

/**
 * Tests the methods in the CompareBy class.
 * 
 * @author Aixa Atoa Ortiz (aixa)
 * @author Jack Yang
 * @author Stephen Ye
 * @version 2022.11.20
 */
public class CompareTest extends student.TestCase {

    private Influencer tim;
    private Influencer larry;
    private CompareByName name;
    private CompareByReachEngagement reach;
    private CompareByTraditionalEngagement traditional;

    /**
     * Sets up for testing
     */
    public void setUp() {
        tim = new Influencer("January", "Tim Sands", "Tim's Hot Takes",
            "America", "Podcasts", 1, 1000, 0, 50, 99);
        larry = new Influencer("January", "Larry Burns", "Larry's Reviews",
            "Russia", "Random", 1, 1500, 0, 60, 120);

        name = new CompareByName();
        reach = new CompareByReachEngagement();
        traditional = new CompareByTraditionalEngagement();
    }


    /**
     * test comparing by name
     */
    public void testCompareByName() {
        assertEquals(8, name.compare(tim, larry));
    }


    /**
     * test comparing by reach engagement
     */
    public void testCompareByReachEngagement() {
        assertEquals(0, reach.compare(tim, larry));
    }


    /**
     * test comparing by traditional engagement
     */
    public void testCompareByTraditionalEngagement() {
        assertEquals(0, traditional.compare(tim, larry));
    }
}