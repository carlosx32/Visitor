public class NonCaliforniaOrder implements Order {
  private double orderAmount;

  public NonCaliforniaOrder() {
  }
  public NonCaliforniaOrder(double inp_orderAmount) {
    orderAmount = inp_orderAmount;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public void accept(OrderVisitor v) {
    v.visit(this);
  }

    @Override
    public double getAdditionalAmount() {
        return 0; 
    }

    @Override
    public void setOrderAmount(double newValue) {
        this.orderAmount = newValue;
    }

    @Override
    public void setAdditionalAmount(double newValue) {
    }

}
