package com.zhen.core.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.zhen.core.domain.PageParam;
import com.zhen.core.domain.PageResult;

/**
 * easyui 辅助类
 * User: Administrator
 */
public class EasyuiUtil {

    /**
     * 列表转换表格 data
     * @param list  列表集合
     * @return  String
     */
    public static String toDataGridData(List list) {
        Map<String, Object> map = new HashMap<String, Object>();

        if (list == null || list.size() == 0) {
            map.put("total", 0);
            map.put("rows", false);
        }
        else {
            map.put("total", list.size());
            map.put("rows", list);
        }
        return BeanUtil.toJsonString(map);
    }
    
    /**
     * 翻页结果转换表格 data
     * @param pageResult  翻页结果
     * @return String
     */
    public static String toDataGridData(PageResult pageResult) {
        Map<String, Object> map = new HashMap<String, Object>();
        PageParam pageParam = pageResult.getPageParam();
        List pageList = pageResult.getPageList();
        map.put("total", pageParam.getRecordCount());
        map.put("page", pageParam.getPage());
        map.put("size", pageParam.getRows());
        map.put("timeMsg", pageResult.getPageParam().getQueryTime());
        
        if (pageList == null) {
            map.put("rows", false);
        }
        else {
            map.put("rows", pageList);
        }
        return BeanUtil.toJsonString(map);
    }
}
