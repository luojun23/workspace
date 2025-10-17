package com.njtech;

import com.njtech.builder.buildTable;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RunDemoApplication {
    public static void main(String[] args) {
        buildTable.getTable();
    }
}
