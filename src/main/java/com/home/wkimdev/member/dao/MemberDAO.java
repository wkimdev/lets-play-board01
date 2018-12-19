package com.home.wkimdev.member.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;

import com.home.wkimdev.member.vo.MemberVO;
import com.mchange.v2.c3p0.ComboPooledDataSource;

public class MemberDAO implements IMemberDAO {
	
	private JdbcTemplate template;
	
	@Autowired
	public MemberDAO(ComboPooledDataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public MemberVO memberSelect(final MemberVO memberVO) {
		
		int result = 0;
		
		List<MemberVO> members = null;
		
		final String sql = "select * from member WHERE memId = ? AND memPw = ?";
		
		members = template.query(sql, new Object[]{ memberVO.getMemId(), memberVO.getMemPw() }, new RowMapper<MemberVO>() {

			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				// TODO Auto-generated method stub
				MemberVO mem = new MemberVO();
				mem.setMemId(rs.getString("memId"));
				mem.setName(rs.getString("memPw"));
				mem.setMemPw(rs.getString("memMail"));
				mem.setMemMail(rs.getString("memMail"));
				mem.setMemPurcNum(rs.getInt("memPurnNum"));				
				return mem;
			}
		});
		
		if(members.isEmpty()) {
			return null;
		}
		
		return members.get(0);
	}
	
	
	public int memberInsert(final MemberVO memberVO) {
		
		int result = 0;
		// insert 완료
		// insert into member(memId, name, memPw, memMail, memPurcNum) values('testId', 'wkimdev', '1234', 'test@test.com', 1111);
		
		final String sql = "insert into member(memId, name, memPw, memMail, memPurcNum) values(?, ?, ?, ?, ?)";
		
		result = template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setString(1, memberVO.getMemId());
				ps.setString(2, memberVO.getName());
				ps.setString(3, memberVO.getMemPw());
				ps.setString(4, memberVO.getMemMail());
				ps.setInt(5, memberVO.getMemPurcNum());
				
			}
			
		});
		
		return result;
	}



}
