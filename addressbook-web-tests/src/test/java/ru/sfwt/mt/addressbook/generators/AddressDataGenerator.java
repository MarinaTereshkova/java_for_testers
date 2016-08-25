package ru.sfwt.mt.addressbook.generators;

import ru.sfwt.mt.addressbook.model.AddressData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class AddressDataGenerator {
  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args[0]);
    File file = new File(args[1]);

    List<AddressData> adresses = generateAddress(count);
    save(adresses, file);
  }

  private static void save(List<AddressData> adresses, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (AddressData address : adresses) {
      writer.write(String.format(("%s;%s\n"), address.getFirstname(), address.getLastname()));
    }
    writer.close();
  }

  private static List<AddressData> generateAddress(int count) {
    List<AddressData> adresses = new ArrayList<AddressData>();
    for (int i = 0; i < count; i++) {
      adresses.add(new AddressData().withFirstname(String.format("firstName %s", i))
              .withLastname(String.format("lastName %s", i)));
    }
    return adresses;
  }
}
