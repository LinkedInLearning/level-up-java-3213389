package com.linkedin.javacodechallenges;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.opencsv.exceptions.CsvValidationException;

public class TicketUtilsTest {

  private final ByteArrayOutputStream printOut = new ByteArrayOutputStream();
  private List<TicketHolder> ticketHolderList;

  @Before
  public void setUpEach() {
    System.setOut(new PrintStream(printOut));
    ticketHolderList = new ArrayList<>();
  }

  @After
  public void cleanUpEach() {
    System.setOut(System.out);
  }

  @Test
  public void importTicketHoldersFromCSV() throws IOException,
      CsvValidationException {

    TicketHolder ticketHolderOne = new TicketHolder("Jessica Jones", 2);
    TicketHolder ticketHolderTwo = new TicketHolder("Rebecca Johnson", 3);
    TicketHolder ticketHolderThree = new TicketHolder("Sarah Roberts", 1);

    List<TicketHolder> result = TicketUtils
        .importTicketHoldersFromCSV("../ticketholders.csv");

    assertEquals(3, result.size());
    assertEquals(ticketHolderOne.getName(), result.get(0).getName());
    assertEquals(ticketHolderOne.getName(), result.get(0).getName());
    assertEquals(ticketHolderTwo.getName(), result.get(1).getName());

    assertEquals(ticketHolderTwo.getQuantity(),
        result.get(1).getQuantity());
    assertEquals(ticketHolderThree.getName(),
        result.get(2).getName());
    assertEquals(ticketHolderThree.getQuantity(),
        result.get(2).getQuantity());
  }

  @Test
  public void importTicketHoldersFromCSV_wrongFileType()
      throws IOException, CsvValidationException {

    List<TicketHolder> result = TicketUtils
        .importTicketHoldersFromCSV("sample.jpg");
    assertEquals("This is not a CSV file: sample.jpg\n",
        printOut.toString());
    assertTrue(result.isEmpty());
  }

  @Test
  public void findTicketHolder() {

    ticketHolderList.add(new TicketHolder("Sally Roberts",
        1));

    Optional<TicketHolder> result = TicketUtils
        .findTicketHolder("Sally Roberts", ticketHolderList);

    assertTrue(result.isPresent());
    assertEquals("Sally Roberts", result.get().getName());
    assertEquals(1, result.get().getQuantity());
  }

  @Test
  public void findTicketHolder_DifferentCasingInInput() {

    ticketHolderList.add(new TicketHolder("sally roberts",
        1));
    Optional<TicketHolder> result = TicketUtils.findTicketHolder(
        "Sally Roberts", ticketHolderList);

    assertTrue(result.isPresent());
    assertEquals("sally roberts", result.get().getName());
    assertEquals(1, result.get().getQuantity());
  }

  @Test
  public void findTicketHolder_DifferentCasingInCSV() {

    ticketHolderList.add(new TicketHolder("Sally Roberts",
        1));
    Optional<TicketHolder> result = TicketUtils
        .findTicketHolder("sally roberts", ticketHolderList);

    assertTrue(result.isPresent());
    assertEquals("Sally Roberts", result.get().getName());
    assertEquals(1, result.get().getQuantity());
  }

  @Test
  public void findTicketHolder_sameFirstName() {

    ticketHolderList.add(new TicketHolder("Sally Roberts",
        1));
    ticketHolderList.add(new TicketHolder("Sally Johnson",
        5));

    Optional<TicketHolder> result = TicketUtils
        .findTicketHolder("Sally Johnson", ticketHolderList);

    assertTrue(result.isPresent());
    assertEquals("Sally Johnson", result.get().getName());
    assertEquals(5, result.get().getQuantity());
  }

  @Test
  public void findTicketHolder_notInList() {

    ticketHolderList.add(new TicketHolder("Sally Roberts",
        1));

    Optional<TicketHolder> result = TicketUtils
        .findTicketHolder("Sally Johnson", ticketHolderList);

    assertFalse(result.isPresent());
  }

  @Test
  public void findTicketHolder_emptyList() {

    Optional<TicketHolder> result = TicketUtils
        .findTicketHolder("Sally Johnson", ticketHolderList);

    assertFalse(result.isPresent());
  }

  @Test
  public void findTicketHolder_emptyInput() {

    ticketHolderList.add(new TicketHolder("Sally Roberts", 1));

    Optional<TicketHolder> result = TicketUtils
        .findTicketHolder("", ticketHolderList);

    assertFalse(result.isPresent());
  }

  @Test
  public void processTickets_noneLeftover() {

    TicketHolder ticketHolder = new TicketHolder("Sally Johnson", 5);
    ticketHolderList.add(ticketHolder);

    boolean result = TicketUtils.processTickets(ticketHolder,
        5, ticketHolderList);

    assertTrue(ticketHolderList.isEmpty());
    assertTrue(result);
  }

  @Test
  public void processTickets_someLeftOver() {

    TicketHolder ticketHolder = new TicketHolder("Sally Johnson", 5);
    ticketHolderList.add(ticketHolder);

    boolean result = TicketUtils.processTickets(ticketHolder,
        4, ticketHolderList);

    assertEquals("I see you still have more coming. " +
        "I'm keeping your name on the list for them!\n",
        printOut.toString());

    assertEquals(1, ticketHolder.getQuantity());
    assertTrue(ticketHolderList.contains(ticketHolder));
    assertTrue(result);
  }

  @Test
  public void processTickets_notEnough() {

    TicketHolder ticketHolder = new TicketHolder("Sally Roberts", 2);
    ticketHolderList.add(ticketHolder);

    boolean result = TicketUtils.processTickets(ticketHolder,
        4, ticketHolderList);

    assertEquals("You don't have enough tickets " +
        "for your whole party. You only have 2\n",
        printOut.toString());
    assertFalse(result);
  }
}