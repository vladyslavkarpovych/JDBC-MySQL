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
        user.setUserName("Artur");
        user.setUserSurname("Max");
        user.setUserAge(23);
        user.setUserSex("male");
        user.setUserPhoneNumber("5236236");
        user.setUserEmail("den@phww.com");
        user.setRegistrationDate(new Timestamp(date.getTime()));

        Bankcard bankcard = new Bankcard();
        bankcard.setUserID(17);
        bankcard.setBankcardNumber("2r25236236");
        bankcard.setBankcardOwnerName("Anton");
        bankcard.setBankcardOwnerSurname("Briskly");
        bankcard.setBalance(13000F);

        PreparedStatement preparedStatement = null;
        Connection connection = null;

/*        System.out.println(userService.getUserByID(22));
        userService.updateUser(user);*/

        User userService1 = userService.getUserByID(22);
        userService1.setUserAge(30);
        userService.updateUser(userService1);

    }
}