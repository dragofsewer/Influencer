package prj5;

import java.text.DecimalFormat;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Aixa Atoa Ortiz (aixa)
// -- Jack Yang
// -- Stephen Ye
/**
 * Test cases for the influencer class
 * 
 * @author Aixa Atoa Ortiz (aixa)
 * @author Jack Yang
 * @author Stephen Ye
 * @version 2022.11.20
 */
public class InfluencerTest extends student.TestCase {

    private Influencer tim;
    private Influencer tim2;
    private Influencer bob;
    private Influencer sarah;
    private Influencer tim3;
    private Influencer tim4;
    private Influencer tim5;
    private Influencer tim6;
    private Influencer tim7;
    private Influencer tim8;
    private Influencer tim9;

    /**
     * Sets up each test method.
     */
    public void setUp() {
        tim = new Influencer("January", "Tim Sands", "Tim's Hot Takes",
            "America", "Podcasts", 1, 1000, 0, 50, 99);
        tim2 = new Influencer("Febuary", "Tim Sands", "Tim's Hot Takes",
            "America", "Podcasts", 1, 1500, 0, 60, 120);
        bob = new Influencer("Febuary", "Bob Bobs", "Bobby Bakes", "Germany",
            "Recipies", 100000, 100, 10000, 600, 1200000);
        tim3 = new Influencer("March", "Tim Sands", "Tim's Hot Bakes",
            "America", "Podcasts", 1, 1500, 0, 60, 120);
        tim4 = new Influencer("March", "Tim Sands", "Tim's Hot Takes", "Canada",
            "Podcasts", 1, 1500, 0, 60, 120);
        tim7 = new Influencer("March", "Tim Sands", "Tim's Hot Bakes", "Canada",
            "Podcasts", 1, 1500, 0, 60, 120);
        tim8 = new Influencer("March", "Tim Sands", "Tim's Hot Bakes", "Canada",
            "Recipies", 1, 1500, 0, 60, 120);
        tim5 = new Influencer("March", "Tim Sands", "Tim's Hot Bakes",
            "America", "Recipies", 1, 1500, 0, 60, 120);
        sarah = new Influencer("May", "Sarah Smith", "Sarah Breaks",
            "Australia", "Comedy", 500, 50, 100, 15, 10);
        tim6 = new Influencer("May", "Timi Sands", "Timi's Hot Bakes",
            "Americas", "Podcasts", 1, 1500, 0, 60, 120);
        tim9 = new Influencer("January", "Tim Sands", "Tim's Hot Takes",
            "America", "Drama", 1, 1000, 0, 50, 99);

    }


    /**
     * test month getter
     */
    public void testGetMonth() {
        assertEquals("January", tim.getMonth());
    }


    /**
     * test username getter
     */
    public void testGetUsername() {
        assertEquals("Tim Sands", tim.getUsername());

    }


    /**
     * test channelname getter
     */
    public void testGetChannelName() {
        assertEquals("Tim's Hot Takes", tim.getChannelName());
    }


    /**
     * test country getter
     */
    public void testGetCountry() {
        assertEquals("America", tim.getCountry());
    }


    /**
     * test maintopic getter
     */
    public void testGetMainTopic() {
        assertEquals("Podcasts", tim.getMainTopic());
    }


    /**
     * test totalikes getter
     */
    public void testGetTotalLikes() {
        assertEquals(1, tim.getTotalLikes());
    }


    /**
     * test totalposts getter
     */
    public void testGetTotalPosts() {
        assertEquals(1000, tim.getTotalPosts());
    }


    /**
     * test totalfollowers getter
     */
    public void testGetTotalFollowers() {
        assertEquals(0, tim.getTotalFollowers());
    }


    /**
     * test totalcomments getter
     */
    public void testGetTotalComments() {
        assertEquals(50, tim.getTotalComments());
    }


    /**
     * test totalviews getter
     */
    public void testGetTotalViews() {
        assertEquals(99, tim.getTotalViews());
    }


    /**
     * test reach engagement
     */
    public void testGetReachEngagement() {
        Influencer pete = new Influencer("January", "Tim Sands",
            "Tim's Hot Takes", "America", "Drama", 1, 1000, 1, 50, 0);
        assertEquals("51.5", new DecimalFormat("#.#").format(tim
            .getReachEngagement()));
        assertEquals("-1", new DecimalFormat("#.#").format(pete
            .getReachEngagement()));
    }


    /**
     * test traditional engagement
     */
    public void testGetTraditionalEngagement() {
        Influencer pete = new Influencer("January", "Tim Sands",
            "Tim's Hot Takes", "America", "Drama", 1, 1000, 1, 50, 99);
        assertEquals("-1", new DecimalFormat("#.#").format(tim
            .getTraditionalEngagement()));
        assertEquals("5100", new DecimalFormat("#.#").format(pete
            .getTraditionalEngagement()));
    }


    /**
     * test setting likes
     */
    public void testSetLikes() {
        tim.setLikes(100);
        assertEquals(100, tim.getTotalLikes());
    }


    /**
     * test setting followers
     */
    public void testSetFollowers() {
        tim.setFollowers(5);
        assertEquals(5, tim.getTotalFollowers());
    }


    /**
     * test setting views
     */
    public void testSetViews() {
        tim.setViews(6);
        assertEquals(6, tim.getTotalViews());
    }


    /**
     * test setting comments
     */
    public void testSetComments() {
        tim.setComments(69);
        assertEquals(69, tim.getTotalComments());
    }


    /**
     * test setting posts
     */
    public void testSetPosts() {
        tim.setPosts(1000);
        assertEquals(1000, tim.getTotalPosts());
    }


    /**
     * test to string conversion
     */
    public void testToString() {

        String timmy =
            "January Tim Sands Tim's Hot Takes America Podcasts 1 1000 0 50 99";
        assertEquals(tim.toString(), timmy);
    }


    /**
     * test object comparison
     */
    public void testEquals() {
        Influencer nullInfluencer = null;
        int[] nums = new int[] { 1, 2, 3 };

        assertTrue(tim.equals(tim));
        assertTrue(tim.equals(tim2));
        assertFalse(tim.equals(nullInfluencer));
        assertFalse(tim.equals(bob));
        assertFalse(tim.equals(nums));
        assertFalse(tim.equals(tim3));
        assertFalse(tim.equals(tim4));
        assertFalse(tim.equals(tim5));
        assertFalse(tim.equals(sarah));
        assertFalse(bob.equals(sarah));
        assertFalse(tim.equals(tim6));
        assertFalse(tim.equals(tim7));
        assertFalse(tim.equals(tim8));
        assertFalse(tim.equals(tim9));

    }
}