package pl.edu.agh.to.lab4;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PrisonerDatabaseTest {

    private PrisonerDataProvider prisonerDataProvider = new PrisonerDataProvider();

    @Test
    public void testThereAreThreeJails() {
        assertEquals(3, prisonerDataProvider.getAllPrisons().size());
    }
}
