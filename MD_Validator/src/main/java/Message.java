public class Message implements IMessage {
  String message;
  String ruleName;
  boolean state;

  Message() {
    message = "Not check yet";
    ruleName = "The rule is not set";
    state = false;
  }
  Message(String message, String ruleName, boolean state) {
    this.message = message;
    this.ruleName = ruleName;
    this.state = state;
  }

  public String getFullMessage() {
    return ruleName+": "+message;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getRuleName() {
    return ruleName;
  }

  public void setRuleName(String ruleName) {
    this.ruleName = ruleName;
  }

  public boolean getState() {
    return state;
  }
   public void setState(boolean state) {
    this.state = state;
   }
}
