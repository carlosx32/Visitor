
import java.util.Collection;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/*this
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author david
 */
public class AllOrders implements Iterator{
    private Map orders;
    private int llave;
    private int max;
    private Order order;

    public AllOrders() {
        orders = new HashMap();
        llave = 0;
    }
            
    @Override
    public boolean hasNext() {
        if(llave == max){
            llave =0;
            return false;
        }else{
            return true;
        }
    }

    @Override
    public Object next() {
       order = (Order) orders.get(llave);
       llave++;
       return order;
    }
    
    public void put (int key, Object value){
        max = key+1;
        orders.put(key, value);
    }
    
    public Object get (Object key){
        return orders.get(key);
    }
    
    public double getLiquidacion(OrderVisitor v){
        while(this.hasNext()){
            Order o = (Order) this.next();
            o.accept(v);
        }
        return v.getOrderTotal();
    }
    
}
