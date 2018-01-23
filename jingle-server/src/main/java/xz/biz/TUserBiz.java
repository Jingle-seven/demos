package xz.biz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionSuspensionNotSupportedException;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;
import xz.dao.TUserMapper;
import xz.model.TUser;

import javax.transaction.TransactionRequiredException;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by admin on 2018/1/23.
 */
@Component
public class TUserBiz {
    @Autowired
    TUserMapper userMapper;

    @Transactional
    public int modifyUserName(String name1,String name2){
        int resCode = 0;
        try {
            resCode += setAUserName(1L, name1);
            writeFile("./test.txt", name1);
            resCode += setAUserName(3L, name2);
        }catch (NullPointerException e){
            resCode = 0;
            //如果运行时异常被捕获了，spring事务就不会回滚，需要加这句
            System.out.println(e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
        }
        return resCode;
    }

    private void writeFile(String filePath,String content) {
        try (FileOutputStream fos = new FileOutputStream(new File(filePath))){
            fos.write(content.getBytes());
        }catch (IOException e){
            System.out.println(e);
        }
    }

    private int setAUserName(Long id,String newName) {
        TUser user1 = userMapper.selectByPrimaryKey(id);
        user1.setName(newName);
        return userMapper.updateByPrimaryKey(user1);
    }
}
