package com.example.springTest;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.*;

import org.junit.Test;

import com.example.springTest.test.WorkTest;


public class WorkTests {

	@Test
	public void test1() {
		String input = "";
		String exp = "";

		//単体
		input = "8080";
		exp = "8080";
		assertTest(input, exp);

		//範囲単体
		input = "8000-8080";
		exp = "8000-8080";
		assertTest(input, exp);

		//単体複数
		input = "8000,8080";
		exp = "8000,8080";
		assertTest(input, exp);

		//範囲複数1
		input = "80-100,8000-8080";
		exp = "80-100,8000-8080";
		assertTest(input, exp);

		//範囲複数2
		input = "80-7998,8000-8080";
		exp = "80-7998,8000-8080";
		assertTest(input, exp);


		//単体複数(バラバラ)1
		input = "50000,12345,1,5,8000,8080";
		exp = "1,5,8000,8080,12345,50000";
		assertTest(input, exp);

		//範囲複数(バラバラ)2
		input = "80-100,8000-8080,1000-2000,11-22,65000-65100";
		exp = "11-22,80-100,1000-2000,8000-8080,65000-65100";
		assertTest(input, exp);

		//ここから連番確認

		//単体連番1
		input = "8000,8001";
		exp = "8000-8001";
		assertTest(input, exp);

		//単体連番2
		input = "100,99,97,98,101";
		exp = "97-101";
		assertTest(input, exp);

		//単体連番3
		input = "1000,103,98,45,44,43,46,100,101,102,99,1001";
		exp = "43-46,98-103,1000-1001";
		assertTest(input, exp);


		//単体連番4
		input = "1000,103,98,45,43,46,100,102,99,1001";
		exp = "43,45-46,98-100,102-103,1000-1001";
		assertTest(input, exp);

		//単体連番4
		input = "1000,103,98,45,43,46,100,102,99,1001";
		exp = "43,45-46,98-100,102-103,1000-1001";
		assertTest(input, exp);


		//範囲連番1
		input = "8000-8010,7000-7999";
		exp = "7000-8010";
		assertTest(input, exp);

		//範囲連番2
		input = "8000-8010,7000-8000";
		exp = "7000-8010";
		assertTest(input, exp);

		//範囲連番3
		input = "8000-8010,7000-8000,1000-2000,2000-5000,5001-6999";
		exp = "1000-8010";
		assertTest(input, exp);

		//範囲連番4
		input = "1-10000,200-300,450-600,11-22,44-99,1-9999";
		exp = "1-10000";
		assertTest(input, exp);

		//範囲連番5
		input = "22-35,1-10000,200-300,450-600,11-22,44-99,9000-18080,1-9999";
		exp = "1-18080";
		assertTest(input, exp);

		//混在1
		input = "1-1000,234,1234,1235,10000";
		exp = "1-1000,1234-1235,10000";
		assertTest(input, exp);

		//混在2
		input = "1-1000,234,1234,1235,18080,10000-12345";
		exp = "1-1000,1234-1235,10000-12345,18080";
		assertTest(input, exp);

		//混在3
		input = "1-9999,10001-18080,10000";
		exp = "1-18080";
		assertTest(input, exp);

		//混在4
		input = "1-9999,10001-18080,10000,1-18080";
		exp = "1-18080";
		assertTest(input, exp);

		//混在5
		input = "1,2,3,4,5,6,7,8,9,1-100,10-20,14,15,16,17,18080,2000-3000,20000-30000";
		exp = "1-100,2000-3000,18080,20000-30000";
		assertTest(input, exp);

	}

	private void assertTest(String input, String exp) {
		WorkTest workTest = new WorkTest();
		String output = workTest.convertPortValue(input);
		assertThat(output,is(exp));
	}

}
