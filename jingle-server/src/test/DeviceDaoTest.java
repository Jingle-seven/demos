import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import xz.JingleServer;
import xz.idao.DeviceDao;

/**
 * Created by Jinhua on 2017/9/1 11:29.
 */
@SpringBootTest(classes = JingleServer.class)
@RunWith(SpringJUnit4ClassRunner.class)
public class DeviceDaoTest {
    @Autowired
    DeviceDao dao;
    @Test
    public void testUpdateBoxId() {
        int code = dao.updateCabinetId(100L, "1,2,3");
        System.out.println(code);
    }
}
