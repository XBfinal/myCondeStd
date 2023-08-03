package com.xbfinal.myeasyexcel;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.xbfinal.myeasyexcel.pojo.DemoData;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

@SpringBootTest
class MyeasyexcelApplicationTests {

    @Test
    public void Write(){
        // 方法1: 如果写到同一个sheet
        String fileName = "E:\\programming\\java\\学习项目\\myCondeStd\\Myeasyexcel" + "测试" + ".xlsx";
        // 这里 需要指定写用哪个class去写
        try (ExcelWriter excelWriter = EasyExcel.write(fileName, DemoData.class).build()) {
            // 这里注意 如果同一个sheet只要创建一次
            WriteSheet writeSheet = EasyExcel.writerSheet("模板").build();
            // 去调用写入,这里我调用了五次，实际使用时根据数据库分页的总的页数来
            for (int i = 0; i < 5; i++) {
                // 分页去数据库查询数据 这里可以去数据库查询每一页的数据
                List<DemoData> data = data();
                excelWriter.write(data, writeSheet);
            }
        }
    }

    private List<DemoData> data() {
        ArrayList<DemoData> list = new ArrayList<>();

        for (int i =5;i<10;i++){
            DemoData demoData = new DemoData();
            demoData.setId(i);
            demoData.setString("奖品"+i+"号");
            list.add(demoData);
        }

        return list;
    }

}
