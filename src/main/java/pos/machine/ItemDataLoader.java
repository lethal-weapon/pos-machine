package pos.machine;

import java.util.Arrays;
import java.util.List;

public class ItemDataLoader {

  public static List<Item> loadItems() {
    return Arrays.asList(
      new Item("ITEM000000", "Coca-Cola", 3),
      new Item("ITEM000001", "Sprite", 3),
      new Item("ITEM000004", "Battery", 2)
    );
  }

  public static List<String> loadBarcodes() {
    return Arrays.asList(
      "ITEM000000",
      "ITEM000000",
      "ITEM000000",
      "ITEM000000",
      "ITEM000001",
      "ITEM000001",
      "ITEM000004",
      "ITEM000004",
      "ITEM000004"
    );
  }
}
