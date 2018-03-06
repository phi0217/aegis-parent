import com.vxianjin.aegis.DemoApplication;
import com.vxianjin.aegis.authorize.domain.BackModule;
import com.vxianjin.aegis.authorize.domain.BackUser;
import com.vxianjin.aegis.authorize.dto.ResourceInfo;
import com.vxianjin.aegis.authorize.repository.BackModuleRepository;
import com.vxianjin.aegis.authorize.repository.BackUserRepository;
import com.vxianjin.aegis.authorize.service.BackModuleService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Set;

/**
 * @author xiefei
 * @date 2018/02/23
 */
@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
@EnableAutoConfiguration
public class Test1 {
    @Autowired
    private BackModuleRepository backModuleRepository;
    @Autowired
    private BackModuleService backModuleService;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private BackUserRepository backUserRepository;

    @Test
    public void test(){
        BackModule backModule = backModuleRepository.findByName("角色管理");
        System.out.println();
    }
    @Test
    public void test1(){
        ResourceInfo tree = backModuleService.getInfo(1L);
        System.out.println();
    }
    @Test
    public void test2(){
        Set<String> urls = backModuleService.getUrlsByBackUser("13552362190");
        BackUser byUsername = backUserRepository.findByTelephone("13552362190");
        System.out.println();
    }
    @Test
    public void test3(){
        String encode = passwordEncoder.encode("123456");
        System.out.println();
    }


}
