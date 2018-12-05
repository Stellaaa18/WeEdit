package com.test.test.dao;

import com.test.test.entity.Area;

import java.util.List;

/**
 * @author Kevin
 * @create 2018-11-23 08:50
 **/
public interface AreaDao {
    /**
     * 列出区域信息
     *
     * @return areaList
     */
    List<Area> queryArea();
    /**
     * 根据Id列出具体区域
     *
     * @param areaId
     * @return  area
     */
    Area queryAreaById(int areaId);
    /**
     * 插入一个区域信息
     *
     * @param area 区域
     * @return
     */
    int insertArea(Area area);
    /**
     * 更新区域信息
     *
     * @param area
     * @return
     */
    int updateArea(Area area);
    /**
     * 删除某一个区域信息
     *
     * @param areaId
     * @return
     */
    int deleteArea(int  areaId);


}
