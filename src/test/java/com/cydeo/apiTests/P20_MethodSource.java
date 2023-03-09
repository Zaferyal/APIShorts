package com.cydeo.apiTests;

import com.cydeo.utilities.ExcelUtil;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

public class P20_MethodSource {


    public static List<Map<String, String>> getPracticeData() {

        ExcelUtil practice=new ExcelUtil("src/test/resources/PracticeDDT.xlsx","data");

        return practice.getDataList();

    }

    @ParameterizedTest
    @MethodSource("getPracticeData")
    public void test1(Map<String, String> practiceMap) {

        System.out.println(practiceMap);

        System.out.println("practiceMap.get(\"firstName\") = " + practiceMap.get("firstName"));
        System.out.println("practiceMap.get(\"lastName\") = " + practiceMap.get("lastName"));
        System.out.println("practiceMap.get(\"password\") = " + practiceMap.get("password"));
        System.out.println("practiceMap.get(\"email\") = " + practiceMap.get("email"));
    }
}
