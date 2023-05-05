package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
    public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1, job2);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job testJob = new Job("Product test", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality Control"), new CoreCompetency("Persistence"));

        assertTrue(testJob instanceof Job);
        assertTrue(testJob.getEmployer() instanceof Employer);
        assertTrue(testJob.getLocation() instanceof Location);
        assertTrue(testJob.getPositionType() instanceof PositionType);
        assertTrue(testJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Product test", testJob.getName());
        assertEquals("ACME", testJob.getEmployer().getValue());
        assertEquals("Desert", testJob.getLocation().getValue());
        assertEquals("Quality Control", testJob.getPositionType().getValue());
        assertEquals("Persistence", testJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product", new Employer("ACE"), new Location("Wonder Land"),
                new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product", new Employer("ACE"), new Location("Wonder Land"),
                new PositionType("Quality Control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job test1 = new Job("Game Tester", new Employer("RIOT"), new Location("St. Louis"), new PositionType("Quality Control"), new CoreCompetency("Logic Testing"));
        String testString = test1.toString();
        assertEquals(testString.charAt(0), '\n');
        assertEquals(testString.charAt(testString.length()-1), '\n');
    }
    @Test
    public void testToStringContainsCorrectLabelsAndData(){
        Job test1 = new Job("Game Tester", new Employer("RIOT"), new Location("St. Louis"), new PositionType("Quality Control"), new CoreCompetency("Logic Testing"));
        String testJob = test1.toString();
        String expectedString = "\nID: " + test1.getId() +
                "\nName: Game Tester" +
                "\nEmployer: RIOT" +
                "\nLocation: St. Louis" +
                "\nPosition Type: Quality Control" +
                "\nCore Competency: Logic Testing\n";
        assertEquals(testJob, expectedString);
    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job test1 = new Job("Game Tester", new Employer(""), new Location("St. Louis"), new PositionType(""), new CoreCompetency("Logic Testing"));
        String testJob = test1.toString();
        String expectedString = "\nID: " + test1.getId() +
                "\nName: Game Tester" +
                "\nEmployer: Data not available" +
                "\nLocation: St. Louis" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: Logic Testing\n";
        assertEquals(testJob, expectedString);
    }
    @Test
    public void testToStringHandlesNonExistingJob(){
       Job test1 = new Job("",new Employer(""),new Location(""),new PositionType(""),new CoreCompetency(""));
       String testString = test1.toString();
       String expectedOutput = "\nID: " + test1.getId() +
               "\nOOPS! This job does not seem to exist.";
       assertEquals(expectedOutput, testString);
    }
}
