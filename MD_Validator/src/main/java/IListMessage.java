import java.util.ArrayList;

public interface IListMessage {
  public String getStringMessages();
  public ArrayList<IMessage> getMessages();
  public boolean getResult();
  public void addMessage(IMessage message);
}
