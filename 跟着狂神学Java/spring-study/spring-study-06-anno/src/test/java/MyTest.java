import com.li.config.MyConfig;
import com.li.pojo.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MyTest {
    public void getName(){
        ApplicationContext context=new ClassPathXmlApplicationContext("applicationContext.xml");
        User user=(User)context.getBean("user");
        System.out.println(user.name);
    }

   public static void main(String[] args) {
       AnnotationConfigApplicationContext context=new AnnotationConfigApplicationContext(MyConfig.class);
       User user=(User)context.getBean("getUser");
       System.out.println(user.getName());
   }
}
