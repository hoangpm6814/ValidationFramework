import com.sun.xml.internal.ws.api.model.MEP;

public class CheckObjectNotNull implements ICheck{
  Message message;

  CheckObjectNotNull() {
    message = new Message();
    message.setRuleName("Check Object Not Null");
  }
  public IMessage check(Object s) {
    System.out.println(message.getFullMessage());
    if(s == null) {
      message.setState(false);
      message.setMessage("invalid ~ the object is null");
    } else {
      message.setState(true);
      message.setMessage("valid ~ the object is not null");
    }
    return message;
  }

  public IMessage getMessage() {
    return message;
  }
}

