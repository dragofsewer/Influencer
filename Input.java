// Virginia Tech Honor Code Pledge:
//
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Aixa Atoa Ortiz (aixa)
// -- Jack Yang
// -- Stephen Ye

package prj5;

import java.io.FileNotFoundException;
import java.text.DecimalFormat;
import java.text.ParseException;


/**
 * Project Runner that starts everything
 * 
 * @author Aixa Atoa Ortiz (aixa)
 * @author Jack Yang
 * @author Stephen Ye
 * @version 2022.11.16
 */
public class Input {

    /**
     * 
     * runs project
     * 
     * @param args
     *            argument for main function
     * 
     * @throws bsh.ParseException
     * @throws FileNotFoundException
     * @throws bsh.ParseException 
     * 
     */
    public static void main(String[] args)

        throws FileNotFoundException

    {

        if (args.length == 1) {

            InfluencerReader influencer = new InfluencerReader(args[0]);
            EngagementCalculator calc = new EngagementCalculator(influencer.getList());
            GUISocialMediaWindow window = new GUISocialMediaWindow(calc);
        }

        else {

            InfluencerReader influencer = new InfluencerReader(
                "SampleInput1_2022.csv");
            EngagementCalculator calc = new EngagementCalculator(influencer.getList());
            GUISocialMediaWindow window = new GUISocialMediaWindow(calc);
        }

    }

}