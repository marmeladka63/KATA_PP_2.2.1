package hiber;

import hiber.config.AppConfig;
import hiber.model.Car;
import hiber.model.User;
import hiber.service.UserService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.sql.SQLException;
import java.util.List;

public class MainApp {
    public static void main(String[] args)  {
        AnnotationConfigApplicationContext context =
                new AnnotationConfigApplicationContext(AppConfig.class);

        UserService userService = context.getBean(UserService.class);

        User user1 = new User("Ivan", "Petrov", "user1@mail.ru");
        User user2 = new User("Vasiliy", "Ivanov", "user2@mail.ru");
        User user3 = new User("Lev", "Dyrov", "user3@mail.ru");
        User user4 = new User("Maksim", "Gorkiy", "user4@mail.ru");

        Car car1 = new Car("BMW", 1234);
        Car car2 = new Car("Mazda", 3456);
        Car car3 = new Car("Opel", 6970);
        Car car4 = new Car("Audi", 4560);

        user1.setCar(car1);
        user2.setCar(car2);
        user3.setCar(car3);
        user4.setCar(car4);
        userService.add(user1);
        userService.add(user2);
        userService.add(user3);
        userService.add(user4);

        List<User> users = userService.listUsers();
        for (User user : users) {
            System.out.println(user);
        }

        List<User> usersCars = userService.listUsersCars("BMW", 1234);
        for (User user : usersCars) {
            System.out.println(user);
        }
        context.close();


    }
}



