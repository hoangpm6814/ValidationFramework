public interface ICheck<S, M> {
  public M check(S s);
  public M getMessage();
}
