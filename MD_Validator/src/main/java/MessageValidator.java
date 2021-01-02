import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

public class MessageValidator<S> implements IValidator<IListMessage, ICheck<S, IMessage>, S>{
  Set<ICheck<S, IMessage>> rules;
  IListMessage messages;

  MessageValidator() {
    rules = new HashSet<ICheck<S, IMessage>>();
    messages = new ListMessage();
  }

  protected boolean preCheck(S s) {
    CheckObjectNotNull checker = new CheckObjectNotNull();
    IMessage message = checker.check(s);
    rules.add(checker);
    messages.addMessage(message);
    return message.getState();

  }
  public IListMessage checkAll(S s) {
    if(!preCheck(s))
      return messages;

    for (ICheck<S, IMessage> rule: rules) {
      messages.addMessage(rule.check(s));
    }

    return messages;
  }

  public void addRule(ICheck<S, IMessage> rule) {
    rules.add(rule);
  }
}
