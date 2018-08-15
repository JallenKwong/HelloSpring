package com.lun.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.lun.domain.LoginLog;


@Repository
public class LoginLogDao {
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	public void insertLoginLog(LoginLog loginLog) {
		String sqlStr = "INSERT INTO t_login_log(user_id,ip,login_datetime) "
				+ "VALUES(?,?,?)";
		Object[] args = { loginLog.getUserId(), loginLog.getIp(),
				          loginLog.getLoginDate() };
		jdbcTemplate.update(sqlStr, args);
	}
	
	public int deleteLoginLog(int id) {
		String sql = "DELETE FROM t_login_log WHERE user_id=?";
		return jdbcTemplate.update(sql, id);
	}
	
}