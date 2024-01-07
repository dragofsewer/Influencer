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
 * Tests the methods in the EngagementCalculator class.
 * 
 * @author Aixa Atoa Ortiz (aixa)
 * @author Jack Yang
 * @author Stephen Ye
 * @version 2022.11.20
 */
public class EngagementCalculatorTest extends student.TestCase {

    private DLList<Influencer> list;

    private EngagementCalculator calc;
    private EngagementCalculator calc2;
    private EngagementCalculator calc3;
    private EngagementCalculator calc4;

    /**
     * Sets up for testing
     */
    public void setUp() {
        list = new DLList<Influencer>();
        Influencer tim = new Influencer("January", "Tim Sands",
            "Tim's Hot Takes", "America", "Podcasts", 1, 1000, 0, 50, 99);
        Influencer larry = new Influencer("January", "Larry Burns",
            "Larry's Reviews", "Russia", "Random", 1, 1500, 0, 60, 120);
        Influencer bob = new Influencer("January", "Bob Bobs", "Bobby Bakes",
            "Germany", "Recipies", 100000, 100, 10000, 600, 1200000);

        list.add(tim);
        list.add(larry);
        list.add(bob);

        calc = new EngagementCalculator(list);

        Influencer tim2 = new Influencer("January", "Tim Sands",
            "Tim's Hot Takes", "America", "Podcasts", 1, 1000, 0, 50, 99);
        Influencer larry2 = new Influencer("January", "Larry Burns",
            "Larry's Reviews", "Russia", "Random", 1, 1500, 0, 60, 120);
        Influencer bob2 = new Influencer("January", "Bob Bobs", "Bobby Bakes",
            "Germany", "Recipies", 100000, 100, 10000, 600, 1200000);
        Influencer tim3 = new Influencer("January", "Tim Sands",
            "Tim's Hot Takes", "America", "Podcasts", 1, 1000, 0, 50, 99);

        DLList<Influencer> list2 = new DLList<Influencer>();
        list2.add(tim2);
        list2.add(larry2);
        list2.add(bob2);
        list2.add(tim3);

        calc2 = new EngagementCalculator(list2);

        Influencer tim4 = new Influencer("February", "Tim Sands",
            "Tim's Hot Takes", "America", "Podcasts", 1, 1000, 0, 50, 99);
        Influencer larry3 = new Influencer("February", "Larry Burns",
            "Larry's Reviews", "Russia", "Random", 1, 1500, 0, 60, 120);
        Influencer bob3 = new Influencer("February", "Bob Bobs", "Bobby Bakes",
            "Germany", "Recipies", 100000, 100, 10000, 600, 1200000);
        Influencer tim5 = new Influencer("February", "Tim Sands",
            "Tim's Hot Takes", "America", "Podcasts", 1, 1000, 0, 50, 99);

        DLList<Influencer> list3 = new DLList<Influencer>();
        list3.add(tim4);
        list3.add(larry3);
        list3.add(bob3);
        list3.add(tim5);

        calc3 = new EngagementCalculator(list3);

        Influencer tim6 = new Influencer("March", "Tim Sands",
            "Tim's Hot Takes", "America", "Podcasts", 1, 1000, 0, 50, 99);
        Influencer larry4 = new Influencer("March", "Larry Burns",
            "Larry's Reviews", "Russia", "Random", 1, 1500, 0, 60, 120);
        Influencer bob4 = new Influencer("March", "Bob Bobs", "Bobby Bakes",
            "Germany", "Recipies", 100000, 100, 10000, 600, 1200000);
        Influencer tim7 = new Influencer("March", "Tim Sands",
            "Tim's Hot Takes", "America", "Podcasts", 1, 1000, 0, 50, 99);

        DLList<Influencer> list4 = new DLList<Influencer>();
        list4.add(tim6);
        list4.add(larry4);
        list4.add(bob4);
        list4.add(tim7);

        calc4 = new EngagementCalculator(list4);

        Influencer tim8 = new Influencer("April", "Tim Sands",
            "Tim's Hot Takes", "America", "Podcasts", 1, 1000, 0, 50, 99);
        list4.add(tim8);

        EngagementCalculator calc5 = new EngagementCalculator(list4);

    }


    /**
     * Testing engagement calculator is returning correct list
     */
    public void testGetAggregateInfluencers() {

        for (int i = 0; i < list.size(); i++) {
            assertTrue(list.get(i).equals(calc.getAggregateInfluencers().get(
                i)));
        }

        Influencer tim2 = new Influencer("January", "Tim Sands",
            "Tim's Hot Takes", "America", "Podcasts", 1, 1000, 0, 50, 99);
        Influencer larry2 = new Influencer("January", "Larry Burns",
            "Larry's Reviews", "Russia", "Random", 1, 1500, 0, 60, 120);
        Influencer bob2 = new Influencer("January", "Bob Bobs", "Bobby Bakes",
            "Germany", "Recipies", 100000, 100, 10000, 600, 1200000);
        DLList<Influencer> temp = new DLList<Influencer>();
        temp.add(tim2);
        temp.add(larry2);
        temp.add(bob2);

        for (int i = 0; i < temp.size(); i++) {
            assertTrue(temp.get(i).equals(calc2.getAggregateInfluencers().get(
                i)));
        }

        assertEquals(3, calc3.getAggregateInfluencers().size());
        assertEquals(3, calc4.getAggregateInfluencers().size());
    }

}