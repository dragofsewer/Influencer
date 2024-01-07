// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those
// who do.
// -- Aixa Atoa Ortiz (aixa)
// -- Jack Yang
// -- Stephen Ye

package prj5;

import java.util.Comparator;

/**
 * Compares two Influencer objects based on their channel name.
 * 
 * @author Aixa Atoa Ortiz (aixa)
 * @author Jack Yang
 * @author Stephen Ye
 * @version 2022.11.20
 */
public class CompareByName implements Comparator<Influencer> {
    /**
     * Compares
     * 
     * @param left description
     * @param right description
     * @return positive int if left is bigger, negative int if left is smaller,
     * and 0 if their channel names are equal.
     */
    public int compare(Influencer left, Influencer right) {
        return left.getChannelName().compareToIgnoreCase(
            right.getChannelName());
    }
}