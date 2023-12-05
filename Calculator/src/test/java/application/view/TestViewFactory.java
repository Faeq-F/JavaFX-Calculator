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
    assertEquals("GUI", ((MockView) viewFactory.create("GUI")).type);
  }

  @Test
  // Test 96
  // Testing AsciiView is returned when 'CLI' is passed to create
  // Test 100
  // Modified to work with CI pipeline on GitLab - using Mock objects
  void testCLIarg() {
    assertEquals("CLI", ((MockView) viewFactory.create("CLI")).type);
  }

  @Test
  // Test 97
  // Testing the correct view is created based on system.console when no correct argument is passed
  // Test 101
  // Modified to work with CI pipeline on GitLab - using Mock objects
  void testNoArg() {
    assertEquals(System.console() == null ? "GUI" : "CLI",
        ((MockView) viewFactory.create("")).type);
  }

}
