package com.example.healthnote.utils;

import com.example.bean.RecordsBean;
import com.example.bean.RecordsBean_Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

public class DBflowUtil {
    private static DBflowUtil dBflowUtil;

    public static DBflowUtil getInstance() {
        if (dBflowUtil == null) {
            synchronized (DBflowUtil.class) {
                if (dBflowUtil == null) {
                    dBflowUtil = new DBflowUtil();
                }
            }
        }
        return dBflowUtil;
    }

    public boolean insertResult(String year, String month, String day, String content, boolean isFinish) {
        SQLite.delete().from(RecordsBean.class).where(RecordsBean_Table.year.eq(year), RecordsBean_Table.month.eq(month), RecordsBean_Table.day.eq(day)).query();
        RecordsBean recordsBean = new RecordsBean();
        recordsBean.insertResult(year, month, day, content, isFinish);
        boolean save = recordsBean.save();
        return save;
    }

    public String queryContent(String year, String month, String day) {
        List<RecordsBean> recordsBeans = SQLite.select().from(RecordsBean.class).where(RecordsBean_Table.year.eq(year), RecordsBean_Table.month.eq(month), RecordsBean_Table.day.eq(day)).queryList();
        return recordsBeans.size() == 0 ? "" : recordsBeans.get(0).getContent();
    }

    public List<RecordsBean> queryLisr(String year, String month) {
        List<RecordsBean> recordsBeans = SQLite.select().from(RecordsBean.class).where(RecordsBean_Table.year.eq(year), RecordsBean_Table.month.eq(month)).queryList();
        return recordsBeans;
    }
}
