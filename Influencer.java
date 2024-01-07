package prj5;

// Virginia Tech Honor Code Pledge:
// 
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Aixa Atoa Ortiz (aixa)
// -- Jack Yang
// -- Stephen Ye
/**
 * The Influencer class containing their information
 * 
 * @author Aixa Atoa Ortiz (aixa)
 * @author Jack Yang
 * @author Stephen Ye
 * @version 2022.11.16
 */
public class Influencer {

    private String month;
    private String username;
    private String channelName;
    private String country;
    private String mainTopic;
    private int totalLikes;
    private int totalPosts;
    private int totalFollowers;
    private int totalComments;
    private int totalViews;
    
    // ~ Constructor ...........................................................

    /**
     * 
     * New Influencer object.
     * 
     * @param mon
     *            month of data
     * 
     * @param user
     *            username of influencer
     * 
     * @param channel
     *            channelname of influencer
     * 
     * @param coun
     *            country of influencer
     * 
     * @param topic
     *            main topic of influencer
     * 
     * @param likes
     *            total likes of influencer
     * 
     * @param posts
     *            total posts of influencer
     * 
     * @param followers
     *            total followers of influencer
     * 
     * @param comments
     *            total comments of influencer
     * 
     * @param views
     *            total views of influencer
     */
    public Influencer(
        String mon,
        String user,
        String channel,
        String coun,
        String topic,
        int likes,
        int posts,
        int followers,
        int comments,
        int views) {

        month = mon;
        username = user;
        channelName = channel;
        country = coun;
        mainTopic = topic;
        totalLikes = likes;
        totalPosts = posts;
        totalFollowers = followers;
        totalComments = comments;
        totalViews = views;
    }


    /**
     * Getter for month.
     * 
     * @return month of data
     */
    public String getMonth() {
        return month;
    }


    /**
     * Getter for username.
     * 
     * @return The username
     */
    public String getUsername() {
        return username;

    }


    /**
     * Getter for channelname
     * 
     * @return channel name
     */
    public String getChannelName() {
        return channelName;
    }


    /**
     * Getter for country
     * 
     * @return The country
     */
    public String getCountry() {
        return country;
    }


    /**
     * Getter for maintopic
     * 
     * @return The influencer topic
     */
    public String getMainTopic() {
        return mainTopic;
    }


    /**
     * Getter for likes
     * 
     * @return The total number of likes
     */
    public int getTotalLikes() {
        return totalLikes;
    }
    
    /**
     * Setter for likes
     * 
     * @param likes description
     */
    public void setLikes(int likes) {
        totalLikes = likes;
    }


    /**
     * Getter for posts
     * 
     * @return The total number of posts
     */
    public int getTotalPosts() {
        return totalPosts;
    }


    /**
     * Getter for followers
     * 
     * @return The total number of followers
     */
    public int getTotalFollowers() {
        return totalFollowers;
    }


    /**
     * Getter for comments
     * 
     * @return The total number of comments
     */
    public int getTotalComments() {
        return totalComments;
    }


    /**
     * Getter for views.
     * 
     * @return The total number of views.
     */
    public int getTotalViews() {
        return totalViews;
    }
    
    /**
     * Getter for trad engagement
     * 
     * @return trad engagement
     */
    public double getTraditionalEngagement() {
        if (totalFollowers == 0) {
            return -1.0;
        }
        return (((double)(totalLikes + totalComments)) / totalFollowers) * 100;

    }

    /**
     * Getter for reach engagement
     * 
     * @return reach engagement
     */
    public double getReachEngagement() {
        if (totalViews == 0) {
            return -1.0;
        }
        return (((double)(totalLikes + totalComments)) / totalViews) * 100;
    }
    
    /**
     * 
     * Returns the influencer object in String form
     * 
     * @return String of person class
     * 
     */
    public String toString() {

        StringBuilder string;

        string = new StringBuilder(getMonth() + " " + getUsername()

            + " " + getChannelName() + " " + getCountry() + " " + getMainTopic()
            + " " + getTotalLikes() + " " + getTotalPosts() + " "
            + getTotalFollowers() + " " + getTotalComments() + " "
            + getTotalViews());

        return string.toString();

    }


    /**
     * Compares the objects to see if they are the same influencer
     * 
     * @param obj
     *            comparison target
     * 
     * @return whether its the same influencer
     */
    public boolean equals(Object obj) { // test

        if (obj == this) {

            return true;

        }

        if (obj == null) {

            return false;

        }

        if (this.getClass() != obj.getClass()) {

            return false;

        }

        Influencer otherPerson = (Influencer)obj;

        return (username.equals(

            otherPerson.username) && channelName.equals(

                otherPerson.channelName) && country.equals(otherPerson.country)
            && mainTopic.equals(otherPerson.mainTopic));
    }


    /**
     * Setter for followers 
     * 
     * @param followers description
     */
    public void setFollowers(int followers) {
        totalFollowers = followers;    
    }

    /**
     * Setter for views
     * 
     * @param views description
     */
    public void setViews(int views) {
        totalViews = views;
        
    }

    /**
     * Setter for comments
     * 
     * @param comments description
     */
    public void setComments(int comments) {
        totalComments = comments;
    }
    
     /**
     * Setter for posts
     * 
     * @param posts description
     */
    public void setPosts(int posts) {
        totalPosts = posts;
    }

}