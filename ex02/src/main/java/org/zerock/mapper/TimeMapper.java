package org.zerock.mapper;

import org.apache.ibatis.annotations.Select;

public interface TimeMapper {

	//mybaitsのtestのために現在時間を呼び出すtest
	@Select("select sysdate from dual")
	String getTime();

}
