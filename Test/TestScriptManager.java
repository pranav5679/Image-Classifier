import static org.junit.Assert.assertEquals;

import controller.scriptmanager.ScriptManager;
import java.io.File;
import org.junit.Test;

/**
 * Class to test ScriptManager tests.
 */
public class TestScriptManager {

  @Test
  public void testMultiLayerScript1() {
    ScriptManager scriptManager = new ScriptManager("res/MultiLayer.txt");
    boolean success = false;
    try {
      File f = new File("res/pencil.jpg");
      f.delete();
      f = new File("res/pencil.png");
      f.delete();
      f = new File("res/penciloriginal.png");
      f.delete();
    } catch (Exception e) {
      e.printStackTrace();
    }
    success = scriptManager.run();
    assertEquals(true, success);
  }

  @Test
  public void testMultiLayerScript2() {
    ScriptManager scriptManager = new ScriptManager("res/MultiLayer2.txt");
    boolean success = false;
    try {
      File f = new File("res/pencil.jpg");
      f.delete();
      f = new File("res/pencil.png");
      f.delete();
      f = new File("res/penciloriginal.png");
      f.delete();
    } catch (Exception e) {
      e.printStackTrace();
    }
    success = scriptManager.run();
    assertEquals(true, success);
  }
}
