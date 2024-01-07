// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Aixa Atoa Ortiz (aixa)
// -- Jack Yang
// -- Stephen Ye

package prj5;

import java.awt.Color;
import java.text.DecimalFormat;
import cs2.Button;
import cs2.Shape;
import cs2.TextShape;
import cs2.Window;
import cs2.WindowSide;

/**
 * 
 * @author
 *
 */
public class GUISocialMediaWindow {
    private EngagementCalculator calculator;
    private InsertionSorter sorter;
    private String currentSort;
    private String currentRate;
    private String currentTimePeriod;
    private DLList<Influencer> influencers;
    private Shape[] shapes;
    private Color[] colors;
    private TextShape[] settings;
    private TextShape[] names;
    private TextShape[] engagements;
    private int[] xIndex;
    private int height;
    private Window window;
    private Button quit;
    private Button engagementSort;
    private Button channelNameSort;
    private Button traditionalEngagementRate;
    private Button reachEngagementRate;
    private Button january;
    private Button february;
    private Button march;
    private Button firstQuarter;
    
    /**
     *
     */
    public static final int BAR_WIDTH = 30;

    /**
     * 
     * @param calculator
     */
    public GUISocialMediaWindow(EngagementCalculator calculator) { 
        colors = new Color[] { Color.orange, Color.blue, Color.cyan,
            Color.green };
        xIndex = new int[] {100, 250, 400, 550};
        height = 0;
        names = new TextShape[4];
        engagements = new TextShape[4];
        settings = new TextShape[3];
        shapes = new Shape[4];
        window = new Window();
        window.setTitle("Social Media Visualization");
        window.setSize(1000, 600);
        this.calculator = calculator;
        
        quit = new Button("Quit");
        quit.onClick(this, "clickedQuit");
        
        engagementSort = new Button("Sort by Engagement Rate");
        engagementSort.onClick(this, "clickedEngagementSort");
        
        channelNameSort = new Button("Sort by Channel Name");
        channelNameSort.onClick(this, "clickedChannelNameSort");
        
        traditionalEngagementRate = new Button("Traditional Engagement Rate");
        traditionalEngagementRate.onClick(this, "clickedTraditionalEngagementSort");
        
        reachEngagementRate = new Button("Reach Engagement Rate");
        reachEngagementRate.onClick(this, "clickedReachEngagementSort");
        
        january = new Button("Janurary");
        january.onClick(this, "clickedJanuary");
        
        february = new Button("February");
        february.onClick(this, "clickedFebruary");
        
        march = new Button("March");
        march.onClick(this, "clickedMarch");
        
        firstQuarter = new Button("First Quarter");
        firstQuarter.onClick(this, "clickedFirstQuarter");
        
        window.addButton(channelNameSort, WindowSide.NORTH);
        window.addButton(engagementSort, WindowSide.NORTH);
        window.addButton(quit, WindowSide.NORTH);
        
        window.addButton(traditionalEngagementRate, WindowSide.WEST);
        window.addButton(reachEngagementRate, WindowSide.WEST);
        
        window.addButton(january, WindowSide.SOUTH);
        window.addButton(february, WindowSide.SOUTH);
        window.addButton(march, WindowSide.SOUTH);
        window.addButton(firstQuarter, WindowSide.SOUTH);
        
        influencers = calculator.getInfluencers();
        
        currentTimePeriod = EngagementCalculator.FIRST_QUARTER;
        currentRate = EngagementCalculator.TRADITIONAL_RATE;
        currentSort = EngagementCalculator.ENGAGEMENT_SORT;
        
        updateScreen();
    }
    
    private void updateScreen() {
        DecimalFormat format = new DecimalFormat("#.#");
        window.removeAllShapes();
        influencers = calculator.filterInfluencers(currentTimePeriod, currentRate, currentSort);
        
        for (int i = 0; i < influencers.size(); i++) {
            if (currentRate.equals(EngagementCalculator.TRADITIONAL_RATE)) {
                height = (int)(100 * (influencers.get(i)
                    .getTraditionalEngagement() / 100));
                engagements[i] = new TextShape(xIndex[i], 370, format.format(
                    influencers.get(i).getTraditionalEngagement()));
            }
            else if (currentRate.equals(EngagementCalculator.REACH_RATE)) {
                height = (int)(100 * (influencers.get(i).getReachEngagement()
                    / 100));
                engagements[i] = new TextShape(xIndex[i], 370, format.format(
                    influencers.get(i).getReachEngagement()));
            }
            
            names[i] = new TextShape(xIndex[i], 350, influencers.get(i)
                .getChannelName());
            
            Shape shape = new Shape(xIndex[i], 300 - height, BAR_WIDTH, height);
            shape.setForegroundColor(colors[i]);
            shape.setBackgroundColor(colors[i]);
            shapes[i] = shape;
            height = 0;
        }
       
        settings[0] = new TextShape(10, 10, currentTimePeriod);
        settings[1] = new TextShape(10, 30, currentRate);
        settings[2] = new TextShape(10, 50, currentSort);

        for (int i = 0; i < settings.length; i++) {
            window.addShape(settings[i]);
        }
        
        for (int i = 0; i < influencers.size(); i++) {
            window.addShape(shapes[i]);
            window.addShape(names[i]);
            window.addShape(engagements[i]);
        } 
    }

    /**
     * Closes the window and quits the program after an inputed button is pressed.
     * 
     * @param button The Button that is clicked to quit.
     */
    public void clickedQuit(Button button) {
        System.exit(0);
    }


    /**
     * Sorts data based on engagement rate
     * 
     * @param button
     */
    public void clickedEngagementSort(Button button) {
        currentSort = EngagementCalculator.ENGAGEMENT_SORT;
        updateScreen();
    }


    /**
     * Sorts data based on name
     * 
     * @param button
     */
    public void clickedChannelNameSort(Button button) {
        currentSort = EngagementCalculator.CHANNEL_NAME_SORT;
        updateScreen();
    }


    /**
     * Displays data from traditional engagement
     * 
     * @param button
     */
    public void clickedTraditionalEngagementSort(Button button) {
        currentRate = EngagementCalculator.TRADITIONAL_RATE;
        updateScreen();
    }


    /**
     * Displays data from reach engagement
     * 
     * @param button
     */
    public void clickedReachEngagementSort(Button button) {
        currentRate = EngagementCalculator.REACH_RATE;
        updateScreen();
    }


    /**
     * 
     * @param button
     */
    public void clickedJanuary(Button button) {
        currentTimePeriod = EngagementCalculator.JANUARY;
        updateScreen();
    }


    /**
     * 
     * @param button
     */
    public void clickedFebruary(Button button) {
        currentTimePeriod = EngagementCalculator.FEBRUARY;
        updateScreen();
    }


    /**
     * 
     * @param button
     */
    public void clickedMarch(Button button) {
        currentTimePeriod = EngagementCalculator.MARCH;
        updateScreen();
    }


    /**
     * 
     * @param button
     */
    public void clickedFirstQuarter(Button button) {
        currentTimePeriod = EngagementCalculator.FIRST_QUARTER;
        updateScreen();
    }
}