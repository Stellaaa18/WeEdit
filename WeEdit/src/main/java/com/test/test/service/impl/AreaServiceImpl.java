package com.test.test.service.impl;

import com.test.test.dao.AreaDao;
import com.test.test.entity.Area;
import com.test.test.service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
public class AreaServiceImpl implements AreaService {
    @Autowired
    private AreaDao areaDao;

    @Override
    public List<Area> queryArea() {
        return areaDao.queryArea();
    }

    @Override
    public Area getAreaById(int areaId) {
        return areaDao.queryAreaById(areaId);
    }

    //涉及事物的控制
    @Transactional
    @Override
    public boolean addArea(Area area) {
        if (area.getAreaName()!=null && !"".equals(area.getAreaName())) {
            area.setCreateTime(new Date());
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.insertArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("插入区域信息异常!");
                }
            } catch (Exception e) {
                throw new RuntimeException("插入区域信息异常: "+ e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }

    //涉及事物的控制
    @Transactional
    @Override
    public boolean modifyArea(Area area) {
        if (area.getAreaID()!=null && area.getAreaID()>0) {
            area.setLastEditTime(new Date());
            try {
                int effectedNum = areaDao.updateArea(area);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("更新区域信息异常!");
                }
            } catch (Exception e) {
                throw new RuntimeException("更新区域信息异常: "+ e.getMessage());
            }
        }else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }

    //涉及事物的控制
    @Transactional
    @Override
    public boolean deleteArea(int areaId) {
        if (areaId > 0) {
            try {
                int effectedNum = areaDao.deleteArea(areaId);
                if (effectedNum > 0) {
                    return true;
                } else {
                    throw new RuntimeException("删除区域信息异常!");
                }
            } catch (Exception e) {
                throw new RuntimeException("删除区域信息异常: " + e.getMessage());
            }
        } else {
            throw new RuntimeException("区域信息不能为空!");
        }
    }
}
