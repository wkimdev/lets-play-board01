package com.home.wkimdev.member.dao;

import java.sql.PreparedStatement;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import com.home.wkimdev.member.vo.MemberVO;
import com.mchange.v2.c3p0.ComboPooledDataSource;

@Repository
public class MemberDAO implements IMemberDAO {
	
	private static final Logger LOG = LoggerFactory.getLogger(MemberDAO.class);
	
	private JdbcTemplate template;
	
	@Autowired
	public MemberDAO(ComboPooledDataSource dataSource) {
		this.template = new JdbcTemplate(dataSource);
	}
	
	public String testCall() {
		return "this is call!!!!!";
	}
	
	// table에 있는 모든 id 리스트를 가져온다. 
	@Override
	public List<MemberVO> memberFindAllId() {
		
		LOG.debug("MemberDAO start~!!!!!!!");
		
		String sql = "select memId from member order by Id desc";
		
		List<MemberVO> members = template.query(sql, new RowMapper<MemberVO>() {
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				  MemberVO membervo = new MemberVO();
				  membervo.setMemId(rs.getString("memId"));
			      return membervo;
			    }
		});
			
		return members;
		
//		members = template.query(sql, new RowMapper<MemberVO>() {
//
//			@Override
//			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
//				// TODO Auto-generated method stub
//				MemberVO mem = new MemberVO();
//				mem.setMemId(rs.getString("memId"));
//				return mem;
//			}
//		});
//		
//		if(members.isEmpty()) {
//			LOG.debug("query result is null ");
//			return null;
//		}
		
//		return (MemberVO) members;
//		return members.get(0);
	}
	
	private JdbcTemplate getJdbcTemplate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MemberVO memberSelect(final MemberVO memberVO) {
		
		List<MemberVO> members = null;
		
		final String sql = "select * from member WHERE memId = ? AND memPw = ?";
		LOG.debug(sql);
		
		members = template.query(sql, new Object[]{ memberVO.getMemId(), memberVO.getMemPw() }, new RowMapper<MemberVO>() {

			@Override
			public MemberVO mapRow(ResultSet rs, int rowNum) throws SQLException {
				MemberVO mem = new MemberVO();
				mem.setMemId(rs.getString("memId"));
				mem.setMemPw(rs.getString("memPw"));
				mem.setMemName(rs.getString("memName"));
				mem.setMemMail(rs.getString("memMail"));
				mem.setMemPurcNum(rs.getInt("memPurcNum"));				
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
		
		final String sql = "insert into member(memId, memName, memPw, memMail, memPurcNum) values(?, ?, ?, ?, ?)";
		
		result = template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement ps) throws SQLException {
				
				ps.setString(1, memberVO.getMemId());
				ps.setString(2, memberVO.getMemName());
				ps.setString(3, memberVO.getMemPw());
				ps.setString(4, memberVO.getMemMail());
				ps.setInt(5, memberVO.getMemPurcNum());
				
			}
			
		});
		
		return result;
	}

	@Override
	public int memberUpdate(final MemberVO memberVO) {
		// TODO Auto-generated method stub
		int result = 0;
		
		final String sql = "UPDATE member SET memPw = ?, memMail = ? WHERE memId = ?";
		// UPDATE member SET memPw = "5555", memMail = "5555" WHERE memId = "ggg"
		
		result = template.update(sql, new PreparedStatementSetter() {
			
			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, memberVO.getMemPw());
				pstmt.setString(2, memberVO.getMemMail());
				pstmt.setString(3, memberVO.getMemId());
			}
		});
		return result;
	}


	@Override
	public int memberDelete(final MemberVO memberVO) {
		int result = 0;
		
		final String sql = "DELETE FROM member WHERE memId = ?";
		
		result = template.update(sql, new PreparedStatementSetter() {

			@Override
			public void setValues(PreparedStatement pstmt) throws SQLException {
				pstmt.setString(1, memberVO.getMemId());
			}
		});
		return result;
	}



}
