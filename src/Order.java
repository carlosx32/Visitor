public interface Order {
  public void accept(OrderVisitor v);
  public double getOrderAmount();
  public double getAdditionalAmount();
  public void setOrderAmount(double newValue);
  public void setAdditionalAmount(double newValue);
}
