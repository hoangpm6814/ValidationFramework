public interface IValidator <M, R, S>{
  public M checkAll(S s);
  public void addRule(R rule);
}
