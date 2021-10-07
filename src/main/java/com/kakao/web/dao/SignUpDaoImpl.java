package com.kakao.web.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.kakao.web.db.DBConnectionMgr;

public class SignUpDaoImpl implements SignUpDao {
	
	private DBConnectionMgr pool = null;
	
	public SignUpDaoImpl() {
		pool = DBConnectionMgr.getInstance();
	}
	
	@Override
	public int idCheck(String id) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int flag = 2;
		
		try {
			con = pool.getConnection();
			sql = "select count(user_email) from user_mst where user_email = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, id);
			rs = pstmt.executeQuery();
			
			rs.next();
			flag = rs.getInt(1);
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			pool.freeConnection(con, pstmt, rs);
		}
		
		return flag;
	}

	@Override
	public int phoneNumberCheck(String phone, String name) {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		String sql = null;
		int flag = 0;
		
		try {
			con = pool.getConnection();
			sql = "select count(*) from phonenumber_list_mst where phone_number = ? and phone_user_name = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, phone);
			pstmt.setString(2, name);
			rs = pstmt.executeQuery();
			
			rs.next();
			flag = rs.getInt(1);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			pool.freeConnection(con,pstmt,rs);
		}

		return flag;
	}
}