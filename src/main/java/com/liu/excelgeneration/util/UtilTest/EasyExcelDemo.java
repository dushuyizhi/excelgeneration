package com.liu.excelgeneration.util.UtilTest;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.annotation.ExcelIgnore;
import com.alibaba.excel.annotation.ExcelProperty;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.alibaba.excel.write.metadata.fill.FillConfig;
import com.liu.excelgeneration.util.GenExcel.entity.GeneraDataUtil;
import com.liu.excelgeneration.util.GenExcel.entity.StockModel;
import lombok.Data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * EasyExcel 运用于复杂单sheet模板填充有很方便的实现：
 * -> 1.模板注意 用{} 来表示你要用的变量 如果本来就有"{","}" 特殊字符 用"\{","\}"代替,{} 代表普通变量 {.} 代表是list的变量，
 *      使用fillData方法做模板填充，缺点是不能自动设置sheetName，模板是什么样就生成什么样的文件，扩展性不好。
 * -> 2.writeData可以用来set sheetName和创建多sheet，适当使用。
 *  @resource https://www.yuque.com/easyexcel/doc/fill
 */
public class EasyExcelDemo {
    private final static  String TEMPLATEFILE = "E:\\ideaProjects\\excelgeneration\\src\\main\\resources\\static\\easyExcelTmp.xlsx";
    private final static  String FILENAME = "E:\\ideaProjects\\excelgeneration\\src\\main\\resources\\excelPackage\\easyExcelResult.xlsx";
    private final static  String NOTMPFILENAME = "E:\\ideaProjects\\excelgeneration\\src\\main\\resources\\excelPackage\\easyExcelResultNoTmp.xlsx";
    public static void main(String[] args) {
        generaExcelNoTemplate();
    }

    public static void generaExcelNoTemplate(){
            ExcelWriter excelWriter = null;
        try{
            // 这里 需要指定写用哪个class去写，文件中的属性可以指定标题 xxx.class
            excelWriter = EasyExcel.write(NOTMPFILENAME,DemoData.class).build();
            //创建三个sheet,写入相同数据
            for (int i = 0; i < 3; i++) {
                WriteSheet writeSheet = EasyExcel.writerSheet().build();
                writeSheet.setSheetNo(i);
                writeSheet.setSheetName("country" + i);
                List<DemoData> data = data();
                excelWriter.write(data,writeSheet);
            }
        }finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }

    }

    /**
     *  使用模板填充，下面几行代码就可以解决复杂模板的单sheet Excel 生成
     *  {属性名} {.list}
     */
    public static void generaExcelByTemplate(){
        ExcelWriter excelWriter = null;
        try{
            StockModel fillData = GeneraDataUtil.getData();
            excelWriter = EasyExcel.write(FILENAME).withTemplate(TEMPLATEFILE).build();
            WriteSheet writeSheet = EasyExcel.writerSheet().build();
            excelWriter.fill(fillData, writeSheet);
            FillConfig fillConfig = FillConfig.builder().forceNewRow(Boolean.TRUE).build();
            excelWriter.fill(fillData.getPlans(),fillConfig, writeSheet);
        }finally {
            // 千万别忘记finish 会帮忙关闭流
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }



    /**
     * init data
     * @return
     */
    private static List<DemoData> data() {
        List<DemoData> list = new ArrayList<DemoData>();
        for (int i = 0; i < 10; i++) {
            DemoData data = new DemoData();
            data.setString("字符串" + i);
            data.setDate(new Date());
            data.setDoubleData(0.56);
            list.add(data);
        }
        return list;
    }


}

@Data
class DemoData {
    @ExcelProperty({"主标题", "字符串标题"})
    private String string;
    @ExcelProperty({"主标题", "日期标题"})
    private Date date;
    @ExcelProperty({"主标题", "数字标题"})
    private Double doubleData;
    /**
     * 忽略这个字段
     */
    @ExcelIgnore
    private String ignore;
}
