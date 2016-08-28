package ru.sfwt.mt.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
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

  @Parameter(names = "-d", description = "Data format")
  public String format;

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
    if (format.equals("csv")) {
      saveAsCsv(adresses, new File(file));
    } else if (format.equals("xml")) {
      saveAsXml(adresses, new File(file));
    } else {
      System.out.println("Unrecognized format " + format);
    }

  }

  private void saveAsXml(List<AddressData> adresses, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(AddressData.class);
    String xml = xstream.toXML(adresses);
    Writer writer = new FileWriter(file);
    writer.write(xml);
    writer.close();

  }

  private void saveAsCsv(List<AddressData> adresses, File file) throws IOException {
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
