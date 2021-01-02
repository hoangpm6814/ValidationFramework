public class CheckStringNotEmpty implements ICheck<String, IMessage> {
  Message message;

  CheckStringNotEmpty() {
    message = new Message();
    message.setRuleName("Check String Not Empty");
  }

  CheckStringNotEmpty(Message message) {
    this.message = message;
    message.setRuleName("Check String Not Empty");
  }
  public IMessage check(String s) {
    if(s == "") {
      message.setState(false);
      message.setMessage("invalid ~ the string is empty");
    } else {
      message.setState(true);
      message.setMessage("valid ~ the string is not not");
    }
    return message;
  }

  public IMessage getMessage() {
    return message;
  }
}
