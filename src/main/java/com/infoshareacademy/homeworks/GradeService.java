package com.infoshareacademy.homeworks;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Map;
import java.util.TreeMap;

public class GradeService {


    public static String[][] calculateAverage(String[][] data) {

        int arrayElement = 0;

        if (data == null || data.length == 0) {
            return new String[][]{{}};
        } else {

            NumberFormat formatter = new DecimalFormat("0.00");

            Map<String, String> studentsList = new TreeMap<>();

            for (String[] student : data) {

                if (!(studentsList.containsKey(student[0]))) {

                    studentsList.put(student[0], student[1]);

                } else {

                    String grade = studentsList.get(student[0]);
                    studentsList.put(student[0], (student[1] + grade));

                }
            }

            String[][] result = new String[studentsList.size()][2];

            for (String name : studentsList.keySet()) {

                String[] grades = studentsList.get(name).split("");
                double average = 0.0;

                for (String grade : grades) {
                    average += Integer.parseInt(grade);
                }

                average = average / grades.length;
                String stringAverage = formatter.format(average);
                studentsList.put(name, stringAverage);

                result[arrayElement][0] = name;
                result[arrayElement][1] = studentsList.get(name);

                arrayElement++;

            }
            return result;
        }
    }
}
