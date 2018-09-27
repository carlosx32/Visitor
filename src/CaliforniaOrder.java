public class CaliforniaOrder implements Order {
  private double orderAmount;
  private double additionalTax;

  public CaliforniaOrder() {
  }
  public CaliforniaOrder(double inp_orderAmount,
      double inp_additionalTax) {
    orderAmount = inp_orderAmount;
    additionalTax = inp_additionalTax;
  }
  @Override
  public double getOrderAmount() {
    return orderAmount;
  }
  public double getAdditionalTax() {
    return additionalTax;
  }
  public void accept(OrderVisitor v) {
    v.visit(this);
  }

    @Override
    public double getAdditionalAmount() {
        return this.getAdditionalTax();
    }

    @Override
    public void setOrderAmount(double newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void setAdditionalAmount(double newValue) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}

