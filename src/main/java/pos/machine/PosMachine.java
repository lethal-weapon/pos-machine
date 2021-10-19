package pos.machine;

import java.util.List;

import static pos.machine.ItemDataLoader.loadItems;

public class PosMachine {

  public Item barcodeToItem(String barcode) {
    return loadItems()
      .stream()
      .filter(i -> i.getBarcode().equals(barcode))
      .findFirst()
      .get();
  }

  public String printSubtotal(Item item, long quantity) {
    return "";
  }

  public String printReceiptFooter(long total) {
    return "";
  }

  public String printReceipt(List<String> barcodes) {
    return "";
  }
}
