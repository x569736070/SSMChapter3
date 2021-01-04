import com.yuntu.pojo.User;
import com.yuntu.service.UserService;
import com.yuntu.utils.PageUtil;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

public class UserTest {
    @Test
    public void getPageList() throws Exception {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-mybatis.xml");
        UserService userService = (UserService)applicationContext.getBean("userServiceImpl");
        PageUtil pageUtil = new PageUtil();
        pageUtil.setPagesize(2);
        pageUtil.setPageindex(1);
        List<User> list = userService.getPageAll(pageUtil);
        for (User friend:list){
            System.out.println("----f_name:"+friend.getUserName()+"l_name:"+friend.getRole().getRoleName());
        }
    }
}
