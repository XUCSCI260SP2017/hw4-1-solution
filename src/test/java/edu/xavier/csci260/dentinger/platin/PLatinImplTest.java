package edu.xavier.csci260.dentinger.platin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PLatinImplTest {

  private PLatin sut;

  @Before
  public void setUp() {
    sut = new PLatinImpl();
  }
  @Test
  public void testConvertwithStartingVowel() {
    assertEquals("ouch way", sut.convert("ouch"));
  }
  @Test
  public void testConvertwithSingleConsonat() {
    assertEquals("ello hay", sut.convert("hello"));
  }
  @Test
  public void testConvertwithMultipleConsonat() {
    assertEquals("ool schay", sut.convert("school"));
  }
  @Test
  public void testProcessHandlesOneWord() {
    assertEquals("ello hay", sut.process("hello"));
  }
  @Test
  public void testProcessHandlesTwoWord() {
    assertEquals("ello hay orld way", sut.process("hello world"));
  }

  @Test
  public void testProcessHandlesOneWordwithVowel() {
    assertEquals("each way", sut.process("each"));
  }

  @Test
  public void testProcessHandlesMultipleWordsWithVowels() {
    assertEquals("ello hay each way erson pay", sut.process("hello each person"));
  }

  @Test
  public void testRevert() {
    assertEquals("hello", sut.revert("ello hay"));
  }

  @Test public void testMultipleConsonatRevert() {
    assertEquals("school", sut.revert("ool schay"));
  }

  @Test
  public void testVowelWord() {
    assertEquals("each", sut.revert("each way"));
  }
}

