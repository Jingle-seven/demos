package xz.idao;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import xz.model.wrapper.IpSectionWrapper;

import java.util.List;

public interface IpSectionDao {
	
	//只要时段有交集就满足条件
	@Select({
			"select",
			"ip_section.id, ip_section.ip, ip_section.user ,ip_section.expired_time, ",
			"ip_section.remark, ip_section.status,ip_section.start_time, ",
			"asset_user.name user_name",
			"from ip_section left join asset_user on asset_user.id = ip_section.user",
			"where ip_section.status!= -1 ",
			"and (start_time <= #{ets} and expired_time >= #{sts})"
	})
	List<IpSectionWrapper> findByTime(@Param("sts") Long sts, @Param("ets") Long ets);
	
	@Update({
			"update ip_section set",
			"status = #{status}",
			"where id in (${ids})"
	})
	int updateStatusInId(@Param("status") String status, @Param("ids") String ids);
}