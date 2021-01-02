import com.sun.xml.internal.ws.api.model.MEP;

import java.util.ArrayList;

public class ListMessage implements IListMessage {

  ArrayList<IMessage> messages;

  ListMessage() {
    messages = new ArrayList<IMessage>();
  }

  ListMessage(ArrayList<IMessage> messages) {
    if(messages != null)
      this.messages = messages;
    else
      this.messages = new ArrayList<IMessage>();
  }

  public void addMessage(IMessage message) {
    messages.add(message);
  }

  public void clearAllMessages() {
    messages.clear();
  }

  public String getStringMessages() {
    String result = "";
    for (IMessage message: messages
         ) {
      result += message.getFullMessage()+"\n";
    }
    return result;
  }

  public ArrayList<IMessage> getMessages() {
    return messages;
  }

  public boolean getResult() {
    for (IMessage message: messages
    ) {
      if(message.getState() != true)
        return false;
    }
    return true;
  }
}
