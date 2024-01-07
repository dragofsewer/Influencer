// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Aixa Atoa Ortiz (aixa)
// -- Jack Yang
// -- Stephen Ye

package prj5;

import java.util.Iterator;

/** EngagementCalculator.
*  
* @author Aixa Atoa Ortiz (aixa)
* @author Jack Yang
* @author Stephen Ye
* @version 2022.11.16
*/
public class EngagementCalculator {
    private DLList<Influencer> aggregateInfluencers;
    private DLList<Influencer> data;
    
    /**
     * 
     */
    public static final String FIRST_QUARTER = "First Quarter (Jan-March)";
    
    /**
     * 
     */
    public static final String JANUARY = "January";
    
    /**
     * 
     */
    public static final String FEBRUARY = "February";
    
    /**
     * 
     */
    public static final String MARCH = "March";
    
    /**
     * 
     */
    public static final String TRADITIONAL_RATE = "Traditional Engagement Rate";
    
    /**
     * 
     */
    public static final String REACH_RATE = "Reach Engagement Rate";
    
    /**
     * 
     */
    public static final String ENGAGEMENT_SORT = "Sorting by Engagement Rate";
    
    /**
     * 
     */
    public static final String CHANNEL_NAME_SORT = "Sorting by Channel Name";
    
    /**
     * Constructor 
     * 
     * @param data description
     */
    public EngagementCalculator(DLList<Influencer> data) {
        this.data = data;
        this.aggregateInfluencers = new DLList<Influencer>();
    }
    public DLList<Influencer> filterInfluencers(String timePeriod, String rateType, String sort) {
        aggregateInfluencers.clear();
        for (int index = 0; index < data.size(); index++) {
            if (!aggregateInfluencers.contains(data.get(index))) {
                aggregateInfluencers.add(data.get(index));
            }
            else {
                Iterator<Influencer> iter = aggregateInfluencers.iterator();
                while (iter.hasNext()) {
                    Influencer aggregate = iter.next();
                    Influencer temp = data.get(index);
                    if (aggregate.equals(temp)) {
                        if (timePeriod.equals(FIRST_QUARTER)) {
                            if (temp.getMonth().equals("January") || 
                                temp.getMonth().equals("March") || 
                                temp.getMonth().equals("February")) {
                                aggregate.setLikes(temp.getTotalLikes() 
                                    + aggregate.getTotalLikes());
                                aggregate.setComments(temp.getTotalComments() 
                                    + aggregate.getTotalComments());
                                aggregate.setViews(temp.getTotalViews() 
                                    + aggregate.getTotalViews());
                                if (temp.getMonth().equals("March")) {
                                    aggregate.setFollowers(
                                    temp.getTotalFollowers());
                                    }
                            }
                        }
                        else {
                            if (temp.getMonth().equals(timePeriod)) {
                                aggregate.setLikes(temp.getTotalLikes() 
                                    + aggregate.getTotalLikes());
                                aggregate.setComments(temp.getTotalComments() 
                                    + aggregate.getTotalComments());
                                aggregate.setViews(temp.getTotalViews() 
                                    + aggregate.getTotalViews());
                            }
                    }
                }
            }
        }
            
            InsertionSorter sorter = new InsertionSorter();
            if (sort.equals(ENGAGEMENT_SORT)) {
                if (rateType.equals(TRADITIONAL_RATE)) {
                    aggregateInfluencers = sorter.sortByTraditonalEngagement(aggregateInfluencers);
                }
                else {
                    aggregateInfluencers = sorter.sortByReachEngagement(aggregateInfluencers);
                }
            }
            else {
                aggregateInfluencers = sorter.sortByName(aggregateInfluencers);
            }
        }
        return this.getAggregateInfluencers();
    }
    
    /**
     * Getter for aggregate list
     * 
     * @return list
     */
     public DLList<Influencer> getAggregateInfluencers() {
         return aggregateInfluencers;
     }
        
     /**
      * Getter for list of non filtered influencer data.
      * 
      * @return list
      */
      public DLList<Influencer> getInfluencers() {
          return data;
      }
}