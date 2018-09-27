public class OverseasOrder implements Order {
  private double orderAmount;
  private double additionalSH;

  public OverseasOrder() {
  }
  public OverseasOrder(double inp_orderAmount,
      double inp_additionalSH) {
    orderAmount = inp_orderAmount;
    additionalSH = inp_additionalSH;
  }
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getAdditionalSH() {
    return additionalSH;
  }
  public void accept(OrderVisitor v) {
    v.visit(this);
  }

    @Override
    public double getAdditionalAmount() {
        return this.getAdditionalSH();
    }

    @Override
    public void setOrderAmount(double newValue) {
        this.orderAmount = newValue;
    }

    @Override
    public void setAdditionalAmount(double newValue) {
        this.additionalSH = newValue;
    }
}
