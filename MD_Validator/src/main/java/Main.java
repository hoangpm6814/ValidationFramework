import com.sun.corba.se.impl.protocol.giopmsgheaders.Message;

public class Main {

  public static void main(String[] args) {
    String s = null;

    MessageValidator validator = new MessageValidator<String>();
    validator.addRule(new CheckStringNotEmpty());
    validator.addRule(new CheckObjectNotNull());

    IListMessage messages = validator.checkAll(s);

    System.out.println(messages.getStringMessages());

  }
}
