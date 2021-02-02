package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job job1, job2, job3, job4, job5, job6;

    @Before
    public void createJobObjects() {
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job4 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job5 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job6 = new Job();
    }

    @Test
    public void testSettingJobId() {
        assertFalse(job1.getId() == job2.getId()); //confirm IDs are not the same
        assertTrue((job2.getId() - job1.getId()) >= 1); //ensure IDs are at least 1 apart
        // OR assertEquals(1, job2.getId() - job1.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        assertTrue(job3 instanceof Job);
        assertEquals(job3.getName(), "Product tester");
        assertEquals(job3.getEmployer().getValue(), "ACME"); //getEmployer() returns Employer object, must do getValue to return string
        assertEquals(job3.getLocation().getValue(), "Desert");
        assertEquals(job3.getPositionType().getValue(), "Quality control");
        assertEquals(job3.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        assertFalse(job4 == job5);
    }

    @Test
    public void testToStringForBlankLines() {
        char firstChar = job4.toString().charAt(0);
        char lastChar = job4.toString().charAt(job4.toString().length()-1);
        assertEquals('\n', firstChar);
        assertEquals('\n', lastChar);
        // answer in git: assertTrue(firstChar == lastChar);
    }

    @Test
    public void testToStringForFields() {
//        String output = String.format("\nID: %d\n" +
//                        "Name: %s\n" +
//                        "Employer: %s\n" +
//                        "Location: %s\n" +
//                        "Position Type: %s\n" +
//                        "Core Competency: %s\n",job4.getId(), job4.getName(), job4.getEmployer(), job4.getLocation(),
//                job4.getPositionType(), job4.getCoreCompetency());
        String output = "\nID: " + job4.getId() + "\n" +
                "Name: " + job4.getName() + "\n" +
                "Employer: " + job4.getEmployer() + "\n" +          // .getValue() optional here since String variable is being created ?
                "Location: " + job4.getLocation() + "\n" +
                "Position Type: " + job4.getPositionType() + "\n" +
                "Core Competency: " + job4.getCoreCompetency() + "\n";
        assertEquals(output, job4.toString());
    }

    @Test
    public void testToStringForEmptyFields() { // .getValue() optional here since String variable is being created ?
        job5.getEmployer().setValue(""); // can't use setter because it takes in an Employee object, not a string
        job5.getLocation().setValue("");
        job5.getPositionType().setValue("");
        job5.getCoreCompetency().setValue("");
        String output = "\nID: " + job5.getId() + "\n" + "Name: " + job5.getName() + "\n" + "Employer: Data not available\n" + "Location: Data not available\n" +"Position Type: Data not available\n" +"Core Competency: Data not available\n";
        assertEquals(output, job5.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        job3.getEmployer().setValue("");
        job3.getPositionType().setValue("");
        String output = String.format("\nID: %d\n" +
                "Name: %s\n" +
                "Employer: Data not available\n" +
                "Location: %s\n" +
                "Position Type: Data not available\n" +
                "Core Competency: %s\n",job3.getId(), job3.getName(), job3.getLocation(), job3.getCoreCompetency());
        assertEquals(output, job3.toString());
    }
}
