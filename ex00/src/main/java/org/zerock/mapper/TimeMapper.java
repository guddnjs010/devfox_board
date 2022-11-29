package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

//org.zeorck.mapper.TimeMapper.getTime2->
public interface TimeMapper {

	// mybatis는 ;없어야한다
	@Select("select sysdate from dual")
	String getTime();
	
	String getTime2();
}
