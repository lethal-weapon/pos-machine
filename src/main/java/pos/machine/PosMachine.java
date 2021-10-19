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
    return String.format(
      "Name: %s, Quantity: %d, Unit price: %d (yuan), Subtotal: %d (yuan)\n",
      item.getName(), quantity, item.getPrice(), quantity * item.getPrice()
    );
  }

  public String printReceiptFooter(long total) {
    return String.format(
      "----------------------\n" +
        "Total: %d (yuan)\n" +
        "**********************",
      total
    );
  }

  public String printReceipt(List<String> barcodes) {
    return "";
  }
}
