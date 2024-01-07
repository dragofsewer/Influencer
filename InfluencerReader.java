package prj5;

import java.io.File;

import java.io.FileNotFoundException;

import java.util.Scanner;

import bsh.ParseException;

// Virginia Tech Honor Code Pledge:
// f
// As a Hokie, I will conduct myself with honor and integrity at all times.
// I will not lie, cheat, or steal, nor will I accept the actions of those who
// do.
// -- Aixa Atoa Ortiz (aixa)
// -- Jack Yang
// -- Stephen Ye
/**
 * The Influencer Reader class that reads the input files
 * 
 * @author Aixa Atoa Ortiz (aixa)
 * @author Jack Yang
 * @author Stephen Ye
 * @version 2022.11.16
 */
public class InfluencerReader {

    private DLList<Influencer> list;

    /**
     * 
     * Influencer reader takes in the csv data of influencers
     * 
     * 
     * 
     * @param influencerFileName
     * 
     * @throws FileNotFoundException
     * 
     *             if the file was not found
     * 
     * @throws ParseException
     * 
     *             if the number of elements was not 5
     * 
     * 
     */
    public InfluencerReader(String influencerFileName)

        throws FileNotFoundException{

        list = this.readListFile(influencerFileName);
        /// SpaceWindow window = new SpaceWindow(new ColonyCalculator(queue,
        /// planets));
    }
    
    public DLList<Influencer> getList() {
        return list;
    }
    
    /**
     * 
     * Returns the people from file as an DLList<Influencer>
     *
     * 
     * 
     * @param fileName
     * 
     *            name of file
     * 
     * 
     * @return DDList<influencer> of influencers to visualize
     * 
     * 
     * 
     * @throws FileNotFoundException
     * 
     * @throws IllegalArguementException
     */
    private DLList<Influencer> readListFile(String fileName)

        throws

        FileNotFoundException{

        Scanner file = new Scanner(new File(fileName));

        DLList<Influencer> people = new DLList<Influencer>();

        file.nextLine();

        while (file.hasNextLine()) {

            String[] split = file.nextLine().split(", *");

            if (split.length != 10) {
                throw new IllegalArgumentException();
            }

            else {
                people.add(new Influencer(split[0], split[1], split[2],
                    split[3], split[4], Integer.valueOf(split[5]), Integer
                        .valueOf(split[6]), Integer.valueOf(split[7]), Integer
                            .valueOf(split[8]), Integer.valueOf(split[9])));
            }
        }
        return people;

    }

}