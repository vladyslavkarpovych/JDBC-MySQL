import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import service.*;

import java.sql.Timestamp;
import java.util.Date;

public class ApplicationDemo {
    private static final Logger logger = LogManager.getLogger();

    private static final UserServiceHibernate userServiceHibernate = new UserServiceHibernate();
    private static final ShoppingCartServiceHibernate shoppingCartServiceHibernate = new ShoppingCartServiceHibernate();
    private static final ProductServiceHibernate productServiceHibernate = new ProductServiceHibernate();
    private static final OrderServiceHibernate orderServiceHibernate = new OrderServiceHibernate();
    private static final BankcardServiceHibernate bankcardServiceHibernate = new BankcardServiceHibernate();
    private static final Date date = new Date();

    public static void main(String[] args) {
        logger.info("Configuration of connection to database");
        logger.info("Program has started execute commands.");
        userServiceHibernate.configure();
        logger.info("Invoke remove method of user class");
        userServiceHibernate.removeUser(13);
        logger.info("User removed successfully");
        logger.info("End of job");
    }
}

