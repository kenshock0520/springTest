/**
 *
 */
/**
 * @author super
 *
 */
package com.example.springTest.domain.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.example.springTest.app.form.ExcelForm;

@Service
public class ExcelService {

	public Map<String,String> doValidate(ExcelForm form){
		Map<String,String> resultMap = new HashMap<String,String>();
		String oldJson = form.getOldJson();
		String newJson = form.getNewJson();
		List<String> messageList = new ArrayList<String>();

		if(!oldJson.equals(newJson)) {
			messageList.add("oldJsonとnewJsonが一致しません。");
		}


		if(messageList.size() < 1) {
			resultMap.put("result", "OK");
		}else {
			resultMap.put("result", "NG");
		}

		return resultMap;
	}
}