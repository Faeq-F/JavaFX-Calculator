package application.view;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class TestViewFactory {
  
  private ViewFactory viewFactory;
  
  @BeforeEach
  void setUp() {
    viewFactory = new ViewFactory();
  }

  @Test
  //Test 95
  //Testing CalcView is returned when 'GUI' is passed to create
  void testGUIarg() {
    ViewInterface view = viewFactory.create("GUI");
    assertEquals(CalcView.getInstance(), view);
  }
  
  @Test
  //Test 96
  //Testing AsciiView is returned when 'CLI' is passed to create
  void testCLIarg() {
    ViewInterface view = viewFactory.create("CLI");
    assertEquals(AsciiView.getInstance(), view);
  }
  
  @Test
  //Test 97
  //Testing the correct view is created based on system.console when no correct argument is passed
  void testNoArg() {
    ViewInterface view = viewFactory.create("");
    assertEquals(System.console() == null ? CalcView.getInstance() : AsciiView.getInstance(), view);
  }

}
