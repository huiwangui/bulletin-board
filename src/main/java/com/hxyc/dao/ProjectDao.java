package com.hxyc.dao;

import com.hxyc.paginator.Page;
import com.hxyc.vo.ProjectVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * Created by admin on 2019/11/19.
 */
@Mapper
public interface ProjectDao {

    /**
     *
     * @param projectVO
     * @return 根据查询条件查询项目信息
     */
    public List<ProjectVO> selectProjectByCon(ProjectVO projectVO);

    public List<ProjectVO> selectProjectByCon(ProjectVO projectVO,Page page);
}
