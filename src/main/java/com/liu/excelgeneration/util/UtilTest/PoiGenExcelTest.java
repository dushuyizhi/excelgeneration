package com.liu.excelgeneration.util.UtilTest;

import com.liu.excelgeneration.util.GenExcel.entity.GeneraDataUtil;
import com.liu.excelgeneration.util.GenExcel.entity.Plan;
import com.liu.excelgeneration.util.GenExcel.entity.StockModel;
import com.liu.excelgeneration.util.GenExcel.PoiGenExcelUtil;
import org.apache.commons.beanutils.BeanUtils;

import java.io.File;
import java.io.FileInputStream;
import java.util.List;
import java.util.Map;

/**
 * 使用poi工具类，可以很方便的根据模板生成多sheet的excel
 */
public class PoiGenExcelTest {
    private final static  String TEMPLATEFILE = "E:\\ideaProjects\\excelgeneration\\src\\main\\resources\\static\\poiTmp.xlsx";
    private final static  String FILENAME = "E:\\ideaProjects\\excelgeneration\\src\\main\\resources\\excelPackage\\poiExcelResult.xlsx";

    public static void main(String[] args) throws Exception {
        //获取数据
        StockModel data = GeneraDataUtil.getData();
        Map<String, String> map = BeanUtils.describe(data);
        PoiGenExcelUtil poiGenExcelUtil =
                PoiGenExcelUtil.getInstance().readTemplateByInputStream(new FileInputStream(new File(TEMPLATEFILE)));
        int sheetSum = 3;
        /**
         * sheetSum: 根据需要生成sheet的数目，模板样式一样
         */
        poiGenExcelUtil.initTemplate(sheetSum);
        for (int i = 0; i < sheetSum; i++) {
            /** 初始化sheet样式 */
            poiGenExcelUtil.initSheet(i,"lz" + i);
            /**替换复杂模板中的对应属性*/
            poiGenExcelUtil.replaceFinalData(map);
            /**替换模板中的多行数据，以datas标志为开始行*/
            List<Plan> plans = data.getPlans();
            for (int j = 0; j < plans.size(); j++) {
                Plan plan = plans.get(j);
                poiGenExcelUtil.createNewRow();
                poiGenExcelUtil.createCell(plan.getNumberOfPeriods());
                poiGenExcelUtil.createCell(plan.getDueDate());
                poiGenExcelUtil.createCell(plan.getActualRepaymentDate());
                poiGenExcelUtil.createCell(plan.getTotalAmountPlan());
                poiGenExcelUtil.createCell(plan.getPrincipalDue());
                poiGenExcelUtil.createCell(plan.getInterestPayable());
                poiGenExcelUtil.createCell(plan.getTotalOutstanding());
                poiGenExcelUtil.createCell(plan.getTotalOutstanding());
                poiGenExcelUtil.createCell(plan.getOutstandingInterest());
                poiGenExcelUtil.createCell(plan.getInterestNotPaid());
                poiGenExcelUtil.createCell(plan.getNointerestPaid());
                poiGenExcelUtil.createCell(plan.getActualAmountdue());
                poiGenExcelUtil.createCell(plan.getCurrentstatus());
                poiGenExcelUtil.createCell(plan.getClearingSign());
            }
        }
        poiGenExcelUtil.writeToFile(FILENAME);
    }
}
