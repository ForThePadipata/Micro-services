package com.github.origin.ecuserclient;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Zhu on 2017/6/15.
 */
public class BCryptTest {

	private static String password = "123123";

	private static List<String> bpList = new ArrayList<>();

	private static BCryptPasswordEncoder bcpe = new BCryptPasswordEncoder();

	public static void encodingfunc(List<String> bpList, String pwd){
		for (int i = 0; i<10; i++) {
			pwd = bcpe.encode(pwd);
			//System.out.println(pwd);
			bpList.add(pwd);
		}
	}

	public static String encodingfunc2(String pwd){
		return bcpe.encode(pwd);
	}


	public static void main(String[] args) {

		String raw = bcpe.encode(password);

		BCryptTest.encodingfunc(bpList, password);
		for(String end : bpList){

			System.out.println(bcpe.matches(password, end));
		}
		for(String end : bpList){

			System.out.println(bcpe.matches(password, end));
		}
		String encodedPwd = bpList.get(9);

		//String encodedPwd2 = bcpe.encode(password);

		//System.out.println(bcpe.matches(password, encodingfunc2(password)));
	}

}
