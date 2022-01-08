import entities.*;
import service.*;

import java.util.Date;
import java.sql.*;

public class Client {
    public static void main(String[] args) {
        Date date = new Date();
        UserService userService = new UserService();
        BankcardService bankcardService = new BankcardService();
        ProductService productService = new ProductService();
        ShoppingCartService shoppingCartService = new ShoppingCartService();
        OrderService orderService = new OrderService();

        User user = new User();
        user.setUserName("Anton");
        user.setUserSurname("Briskly");
        user.setUserAge(27);
        user.setUserSex("male");
        user.setUserPhoneNumber("078942525235");
        user.setUserEmail("anton@phww.com");
        user.setRegistrationDate(new Timestamp(date.getTime()));


        Bankcard bankcard = new Bankcard();
        bankcard.setUserID(17);
        bankcard.setBankcardNumber("2r25236236");
        bankcard.setBankcardOwnerName("Anton");
        bankcard.setBankcardOwnerSurname("Briskly");
        bankcard.setBalance(13000F);

        System.out.println(userService.getUserByID(4));

    }
}