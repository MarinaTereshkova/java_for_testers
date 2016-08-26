package ru.sfwt.mt.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import ru.sfwt.mt.addressbook.model.AddressData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class AddressDataGenerator {
  @Parameter(names = "-c", description = "Address count")
  public int count;

  @Parameter(names = "-f", description = "Target file")
  public String file;

  public static void main(String[] args) throws IOException {
    AddressDataGenerator generator = new AddressDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex){
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<AddressData> adresses = generateAddress(count);
    save(adresses, new File(file));
  }

  private void save(List<AddressData> adresses, File file) throws IOException {
    Writer writer = new FileWriter(file);
    for (AddressData address : adresses) {
      writer.write(String.format(("%s;%s\n"), address.getFirstname(), address.getLastname()));
    }
    writer.close();
  }

  private List<AddressData> generateAddress(int count) {
    List<AddressData> adresses = new ArrayList<AddressData>();
    for (int i = 0; i < count; i++) {
      adresses.add(new AddressData().withFirstname(String.format("firstName %s", i))
              .withLastname(String.format("lastName %s", i)));
    }
    return adresses;
  }
}
