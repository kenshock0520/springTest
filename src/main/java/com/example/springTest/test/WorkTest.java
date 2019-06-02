package com.example.springTest.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class WorkTest{
	public String convertPortValue(String csvValue) {
		System.out.println("input:"+csvValue);
		List<String> valueList = Arrays.asList(csvValue.split(","));
		List<Integer> convertList = new ArrayList<Integer>();

		valueList.stream().forEach(e -> {
			if(e.contains("-")){
				convertRangeValue(convertList,e);
			}else {
				convertList.add(Integer.parseInt(e));
			}
		});

		int value = 0;
		List<Integer> sortedConvertList = convertList.stream().distinct().sorted().collect(Collectors.toList());

		int listCount = 0;
		StringJoiner sj = new StringJoiner(",");
		String portValue = "";
		int minPort = 0;
		for(Integer port : sortedConvertList) {
			if(listCount == 0) {
				minPort = port;
			}
			if("".equals(portValue)) {
				portValue = String.valueOf(port);
			}

			if(sortedConvertList.size() == 1) {
				sj.add(portValue);
				break;
			}

			if(sortedConvertList.size() == listCount + 1) {
				if(portValue.indexOf("-") != -1) {
					portValue = portValue + String.valueOf(port);

				}
				sj.add(portValue);
				break;
			}

			int nextPort = sortedConvertList.get(listCount+ 1).intValue();
			if(minPort != nextPort) {
				if(minPort + 1 == nextPort) {
					if(portValue.indexOf("-") == -1) {
						portValue = portValue + "-";
					}
					minPort = nextPort;
				}else {
					if(portValue.indexOf("-") != -1) {
						portValue = portValue + minPort;
					}
					minPort = nextPort;
					sj.add(portValue);
					portValue = "";
				}
			}
			listCount++;

		}
		csvValue = sj.toString();
		System.out.println("output:"+csvValue);
		return csvValue;
	}

	void convertRangeValue(List<Integer> convertList, String rangeValue) {
		String[] rangeValueArray = rangeValue.split("-");
		int minValue = Integer.parseInt(rangeValueArray[0]);
		int maxValue = Integer.parseInt(rangeValueArray[1]);


		convertList.addAll(IntStream.rangeClosed(minValue, maxValue).mapToObj(e -> e).collect(Collectors.toList()));
	}
}