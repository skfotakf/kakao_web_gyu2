package com.kakao.web.dao;

public interface SignUpDao {
	public int idCheck(String id);
	public int phoneNumberCheck(String phone, String name);
}

