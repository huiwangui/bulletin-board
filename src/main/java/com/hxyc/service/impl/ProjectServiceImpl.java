package com.hxyc.service.impl;

import com.hxyc.common.page.PageResult;
import com.hxyc.common.page.Paginator;
import com.hxyc.dao.ProjectDao;

import com.hxyc.paginator.Page;
import com.hxyc.paginator.PageUtil;
import com.hxyc.service.ProjectService;
import com.hxyc.vo.ProjectVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName ProjectServiceImpl
 * @Description TODO
 * @Author admin
 * @Date 2019/11/19 11:31
 **/
@Service
public class ProjectServiceImpl implements ProjectService {

    @Autowired(required = false)
    ProjectDao projectDao;
    @Override
    public List<ProjectVO> listProjectByCon(ProjectVO projectVO) {
        return projectDao.selectProjectByCon(projectVO);
    }

    @Override
    public PageResult<ProjectVO> listProjectByCon(ProjectVO projectVO, Paginator paginator) {
        Page page = PageUtil.transformToPage(paginator);
        List<ProjectVO> list = projectDao.selectProjectByCon(projectVO,page);
        return new PageResult(list, PageUtil.transformToPaginator(page));
    }
}
