package application.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestViewFactory {

  private MockViewFactory viewFactory;

  @BeforeEach
  void setUp() {
    viewFactory = new MockViewFactory();
  }

  @Test
  // Test 95
  // Testing CalcView is returned when 'GUI' is passed to create
  // Test 99
  // Modified to work with CI pipeline on GitLab - using Mock objects
  void testGUIarg() {
    assertEquals("A GUI", viewFactory.create("GUI"));
  }

  @Test
  // Test 96
  // Testing AsciiView is returned when 'CLI' is passed to create
  // Test 100
  // Modified to work with CI pipeline on GitLab - using Mock objects
  void testCLIarg() {
    assertEquals("A CLI", viewFactory.create("CLI"));
  }

  @Test
  // Test 97
  // Testing the correct view is created based on system.console when no correct argument is passed
  // Test 101
  // Modified to work with CI pipeline on GitLab - using Mock objects
  void testNoArg() {
    assertEquals(System.console() == null ? "A GUI" : "A CLI", viewFactory.create(""));
  }

}
