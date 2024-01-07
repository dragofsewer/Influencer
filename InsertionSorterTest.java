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
 * Tests the methods in the InsertionSorter class.
 * 
 * @author Aixa Atoa Ortiz (aixa)
 * @author Jack Yang
 * @author Stephen Ye
 * @version 2022.11.20
 */
public class InsertionSorterTest extends student.TestCase {

    private DLList<Influencer> basic;
    private InsertionSorter sorter;
    private Influencer tim;
    private Influencer larry;
    private Influencer bob;
    private DLList<Influencer> sorted;
    private DLList<Influencer> tester;

    /**
     * Sets up for testing
     */
    public void setUp() {
        basic = new DLList<Influencer>();

        tim = new Influencer("January", "Tim Sands", "Tim's Hot Takes",
            "America", "Podcasts", 1, 1000, 0, 50, 99);
        larry = new Influencer("January", "Larry Burns", "Larry's Reviews",
            "Russia", "Random", 1, 1500, 0, 60, 120);
        bob = new Influencer("January", "Bob Bobs", "Bobby Bakes", "Germany",
            "Recipies", 100000, 100, 10000, 600, 1200000);

        basic.add(tim);
        basic.add(larry);
        basic.add(bob);

        sorter = new InsertionSorter();

        tester = new DLList<Influencer>();
        tester.add(tim);

    }


    /**
     * test sorting by traditional engagement
     */
    public void testSortByTraditionalEngagement() {

        DLList<Influencer> traditional = new DLList<Influencer>();
        traditional.add(bob);
        traditional.add(larry);
        traditional.add(tim);

        sorted = sorter.sortByTraditonalEngagement(basic);
        for (int i = 0; i < sorted.size(); i++) {
            assertTrue(traditional.get(i).equals(sorted.get(i)));
        }

        DLList<Influencer> single = sorter.sortByTraditonalEngagement(tester);

    }


    /**
     * tests sorting by reach engagement
     */
    public void testSortByReachEngagement() {

        DLList<Influencer> reach = new DLList<Influencer>();
        reach.add(larry);
        reach.add(tim);
        reach.add(bob);
        sorted = sorter.sortByReachEngagement(basic);
        for (int i = 0; i < sorted.size(); i++) {
            assertTrue(reach.get(i).equals(sorted.get(i)));
        }
        DLList<Influencer> single = sorter.sortByReachEngagement(tester);
    }


    /**
     * tests sorting by name
     */
    public void testSortByName() {

        DLList<Influencer> name = new DLList<Influencer>();
        name.add(bob);
        name.add(larry);
        name.add(tim);
        sorted = sorter.sortByName(basic);
        for (int i = 0; i < sorted.size(); i++) {
            assertTrue(name.get(i).equals(sorted.get(i)));
        }
        DLList<Influencer> single = sorter.sortByName(tester);
    }

}