package xz.idao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import xz.model.wrapper.WorkbenchAsmtWrapper;

import java.util.List;

public interface WorkbenchDao {
	
	//只要时段有交集就满足条件
	@Select({
			"select",
			"workbench_assignment.id, workbench_assignment.table_id, workbench_assignment.user, ",
			"workbench_assignment.start_time, workbench_assignment.expired_time, workbench_assignment.remark,  ",
			"asset_user.name user_name, ",
			"workbench.number,workbench.description",
			"from workbench_assignment ",
			"left join asset_user on asset_user.id = workbench_assignment.user",
			"left join workbench on workbench_assignment.table_id = workbench.id",
			"where start_time <= #{ets} and expired_time >= #{sts}"
	})
	List<WorkbenchAsmtWrapper> findByTime(@Param("sts") Long sts, @Param("ets") Long ets);
}