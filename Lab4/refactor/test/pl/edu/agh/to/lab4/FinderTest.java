package pl.edu.agh.to.lab4;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class FinderTest {
    private ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    private PrintStream originalOut;
    private List<SuspectAggregate> suspectAggregates = Arrays.asList(new PersonDataProvider(), new PrisonerDataProvider());

    private CompositeAggregate compositeAggregate = new CompositeAggregate(suspectAggregates);

    private Finder suspectFinder = new Finder(compositeAggregate);

    @Test
    public void testDisplayingNotJailedPrisoner() {
        suspectFinder.searchDisplay(new NameSearchStrategy("Anita"));
        assertContentIsDisplayed("Anita Wiercipieta");
    }

    @Test
    public void testDisplayingSuspectedPerson() {
        suspectFinder.searchDisplay(new NameSearchStrategy("Krzysztof"));
        assertContentIsDisplayed("Krzysztof Mendel");
    }

    @Test
    public void testNotDisplayingTooYoungPerson() {
        suspectFinder.searchDisplay(new AgeSearchStrategy(15, 17));
        assertContentIsNotDisplayed("Tomek Gimbus");
    }

    @Test
    public void testNotDisplayingJailedPrisoner() {
        suspectFinder.searchDisplay(new NameSearchStrategy("Jan"));
        assertContentIsNotDisplayed("Krzys Krzys");
    }

    private void assertContentIsDisplayed(String expectedContent) {
        assertTrue("Application did not contain expected content: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    private void assertContentIsNotDisplayed(String expectedContent) {
        assertFalse("Application did contain expected content although it should not: " + outContent.toString(), outContent.toString()
                .contains(expectedContent));
    }

    @Before
    public void redirectSystemOut() {
        originalOut = System.out;
        System.setOut(new PrintStream(outContent));
    }

    @After
    public void resetSystemOut() {
        System.setOut(originalOut);
    }

}
