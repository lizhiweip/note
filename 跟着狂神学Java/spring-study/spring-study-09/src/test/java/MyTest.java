import com.li.service.UserService;
import com.li.service.UserServiceImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public static void main(String[] args) {
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        //动态代理的是接口
        UserService service=(UserService)context.getBean("userService");

        service.add();

    }
}
