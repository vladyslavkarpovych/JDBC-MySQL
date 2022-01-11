import entities.*;
import service.*;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

public class ApplicationDemo {
    private static final UserServiceHibernate userServiceHibernate = new UserServiceHibernate();
    private static final ShoppingCartServiceHibernate shoppingCartServiceHibernate = new ShoppingCartServiceHibernate();
    private static final ProductServiceHibernate productServiceHibernate = new ProductServiceHibernate();
    private static final OrderServiceHibernate orderServiceHibernate = new OrderServiceHibernate();
    private static final BankcardServiceHibernate bankcardServiceHibernate = new BankcardServiceHibernate();
    private static final Date date = new Date();

    public static void main(String[] args) {
        productServiceHibernate.configure();
/*
        productServiceHibernate.addProduct("Apple juice 0.5", "Drink", 8, new Timestamp(date.getTime()));
*/
/*
          System.out.println(productServiceHibernate.getProductById(21));
*/
/*
          productServiceHibernate.updateProductEntity(21, "Квас", "Напитки", 10, new Timestamp(date.getTime()));
*/
     }
}

