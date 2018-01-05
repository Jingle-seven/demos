package xz.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import xz.idao.mapper.OperationLogMapper;
import xz.model.OperationLog;

import java.util.Date;
import java.util.logging.Logger;

/**
 * Created by Jinhua on 2017/6/12 14:47.
 */
@Component
public class LogKit {
	public static Logger butlerLogger = Logger.getLogger("Butler");
	@Autowired
	OperationLogMapper logger;
	
	public void error(String msg){
		OperationLog log = new OperationLog()
				.setId(XKit.genUniqueId())
				.setDatetime(new Date())
				.setOperationSql("")
				.setUser("butler")
				.setStatus("")
				.setOperation(XKit.killUnkindChar(msg));
		logger.insert(log);
	}
}
