package pos.machine;

import java.util.List;
import java.util.TreeMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Collectors;

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
    AtomicLong total = new AtomicLong();
    StringBuilder receipt = new StringBuilder();

    barcodes
      .stream()
      .collect(Collectors.groupingBy(e -> e, TreeMap::new, Collectors.counting()))
      .forEach((code, count) -> {
        Item item = barcodeToItem(code);
        total.addAndGet(count * item.getPrice());
        receipt.append(printSubtotal(item, count));
      });

    String receiptHeader = "***<store earning no money>Receipt***\n";
    String receiptFooter = printReceiptFooter(total.longValue());

    receipt.insert(0, receiptHeader);
    receipt.append(receiptFooter);
    return receipt.toString();
  }
}
