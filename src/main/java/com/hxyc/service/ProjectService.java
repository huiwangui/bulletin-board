package com.hxyc.service;

import com.hxyc.common.page.PageResult;
import com.hxyc.common.page.Paginator;
import com.hxyc.vo.ProjectVO;

import java.util.List;

/**
 * Created by admin on 2019/11/19.
 */
public interface ProjectService {

    /**
     *
     * @param projectVO
     * @return 根据查询条件查询项目信息
     */
    public List<ProjectVO> listProjectByCon(ProjectVO projectVO);

    public PageResult<ProjectVO> listProjectByCon(ProjectVO projectVO, Paginator paginator);
}
