package com.hxyc.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import com.google.gson.Gson;
import com.hxyc.common.page.PageResult;
import com.hxyc.common.page.Paginator;
import com.hxyc.service.ProjectService;
import com.hxyc.util.DataTablePageUtil;
import com.hxyc.util.DateUtil;
import com.hxyc.vo.ProjectVO;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ClassName ProjectController
 * @Description 获取项目相关信息
 * @Author admin
 * @Date 2019/11/19 9:57
 **/
@Controller
@RequestMapping("/")
public class ProjectController {
    @Autowired
    ProjectService projectService;
    /**
     *
     * @return
     */
    @RequestMapping("/")
    public String home(){
        return "index";

    }

    /**
     * 按条件查询项目信息
     * @return
     */
    @RequestMapping(value="/firstPurchase/listProjectByCon",method = RequestMethod.POST,produces = "application/json;charset=UTF-8")
    @ResponseBody
    public Object listProjectByCon(HttpServletRequest request, String openTenderTime,Paginator paginator){

        //封装查询项目信息参数
        ProjectVO rq = new ProjectVO();
        //一级采购
        rq.setPurchaseMode("3");

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat titleSdf = new SimpleDateFormat("MM月dd日");
        Calendar cal = Calendar.getInstance();

        List<ProjectVO> totalList = new ArrayList<>();

        if(StringUtils.isNotEmpty(openTenderTime)){
            try {
                cal.setTime(sdf.parse(openTenderTime));
            } catch (ParseException e) {
                e.printStackTrace();
            }

        }else{
            cal.setTime(new Date());
        }
        //---------------

        /**
         * 这几个参数后台直接取，前端不需要传!
         * 开启服务端分页后，datatables 会自动传！
         */
        Integer draw = Integer.parseInt(request.getParameter("draw"));//该参数取出来，不做任何操作，再传回去即可
        Integer start = Integer.parseInt(request.getParameter("start"));//配合求当前页，第一次传进来是 0，然后 10，20，30 ……
        Integer pageSize = Integer.parseInt(request.getParameter("length"));//【页大小】
        pageSize = 100;//这里把每页显示数据条数设置固定
        Integer nowPage = (start+pageSize)/pageSize;// 转成每次加 1 【当前页】

        //设置当前时间所在周周一日期
        cal.set(cal.DAY_OF_WEEK, cal.MONDAY);
        rq.setBeginOfWeek(DateUtil.getStartTime(cal));
        //本周一时间
        Date beginOfWeek = cal.getTime();
        String weekBeginTitle = titleSdf.format(beginOfWeek);
        //设置当前时间所在周周日日期
        cal.set(Calendar.DATE, cal.get(cal.DATE) + 6);
        rq.setEndOfWeek(DateUtil.getEndTime(cal));
        //本周末时间
        Date endOfWeek =cal.getTime();
        String weekEndTitle = titleSdf.format(endOfWeek);
        int total =0;
        //计算总数的
        List<ProjectVO> weekListTotal = projectService.listProjectByCon(rq);

         List<ProjectVO> weekList =weekListTotal;
        //设置当前时间所在周第二周周一日期
        cal.set(Calendar.DATE, cal.get(cal.DATE) + 1);
        //rq.setBeginOfNextWeek(DateUtil.getStartTime(cal));
        rq.setBeginOfWeek(DateUtil.getStartTime(cal));
        //下周1时间
        Date beginOfNextWeek =cal.getTime();
        String nextWeekBeginTitle = titleSdf.format(beginOfNextWeek);
        //设置当前时间所在周第二周周日日期
        cal.set(Calendar.DATE, cal.get(cal.DATE) + 6);
        //rq.setEndOfNextWeek(DateUtil.getEndTime(cal));
        rq.setEndOfWeek(DateUtil.getEndTime(cal));
        //下周末时间
        Date endOfNextWeek =cal.getTime();
        String nextWeekEndTitle = titleSdf.format(endOfNextWeek);
        //计算总数的
        List<ProjectVO> nextWeekListTotal = projectService.listProjectByCon(rq);
        //PageResult<ProjectVO> pVOPageResult = projectService.listProjectByCon(rq, paginator);

        List<ProjectVO> nextWeekList = nextWeekListTotal;
        //封装本周及下周数据
        if(weekList !=null && weekList.size()>0){
            if(nextWeekList !=null && nextWeekList.size()>0){
                if(weekList.size()>=nextWeekList.size()){
                    for (int i = 0; i <weekList.size() ; i++) {
                        ProjectVO projectVO = weekList.get(i);
                        //设置查询数据时间
                        projectVO.setBeginOfWeek(beginOfWeek);
                        projectVO.setEndOfWeek(endOfWeek);
                        projectVO.setBeginOfNextWeek(beginOfNextWeek);
                        projectVO.setEndOfNextWeek(endOfNextWeek);
                        projectVO.setWeekTitle(weekBeginTitle+" ~ "+weekEndTitle +"开标项目");
                        projectVO.setNextWeekTitle(nextWeekBeginTitle+" ~ "+nextWeekEndTitle+"开标项目");
                        if(i<nextWeekList.size()){
                            ProjectVO nextProjectVO = nextWeekList.get(i);
                            projectVO.setNextTenderCode(nextProjectVO.getTenderCode());
                            projectVO.setNextOrgAbbreviation(nextProjectVO.getOrgAbbreviation());
                            projectVO.setNextProjectName(nextProjectVO.getProjectName());
                            projectVO.setNextOpenTenderTime(nextProjectVO.getOpenTenderTime());
                            projectVO.setNextDayOfWeek(nextProjectVO.getDayOfWeek());
                        }


                        totalList.add(projectVO);
                    }
                }else{
                    for (int i = 0; i <nextWeekList.size() ; i++) {
                        ProjectVO projectVO = nextWeekList.get(i);
                        //设置查询数据时间
                        projectVO.setBeginOfWeek(beginOfWeek);
                        projectVO.setEndOfWeek(endOfWeek);
                        projectVO.setBeginOfNextWeek(beginOfNextWeek);
                        projectVO.setEndOfNextWeek(endOfNextWeek);

                        projectVO.setNextTenderCode(projectVO.getTenderCode());
                        projectVO.setNextOrgAbbreviation(projectVO.getOrgAbbreviation());
                        projectVO.setNextProjectName(projectVO.getProjectName());
                        projectVO.setNextOpenTenderTime(projectVO.getOpenTenderTime());
                        projectVO.setNextDayOfWeek(projectVO.getDayOfWeek());
                        projectVO.setWeekTitle(weekBeginTitle+" ~ "+weekEndTitle+"开标项目");
                        projectVO.setNextWeekTitle(nextWeekBeginTitle+" ~ "+nextWeekEndTitle+"开标项目");
                        if(i<weekList.size()){
                            ProjectVO vo = weekList.get(i);
                            projectVO.setTenderCode(vo.getTenderCode());
                            projectVO.setOrgAbbreviation(vo.getOrgAbbreviation());
                            projectVO.setProjectName(vo.getProjectName());
                            projectVO.setOpenTenderTime(vo.getOpenTenderTime());
                            projectVO.setDayOfWeek(vo.getDayOfWeek());

                        }else{
                            projectVO.setTenderCode(null);
                            projectVO.setOrgAbbreviation(null);
                            projectVO.setProjectName(null);
                            projectVO.setOpenTenderTime(null);
                            projectVO.setDayOfWeek(null);
                        }

                        totalList.add(projectVO);
                    }
                }
            }else{
                for (int i = 0; i < weekList.size(); i++) {
                    ProjectVO projectVO = weekList.get(i);
                    projectVO.setWeekTitle(weekBeginTitle+" ~ "+weekEndTitle+"开标项目");
                    projectVO.setNextWeekTitle(nextWeekBeginTitle+" ~ "+nextWeekEndTitle+"开标项目");
                    totalList.add(projectVO);
                }
                //totalList.addAll(weekList);
            }
        }else{
            if(nextWeekList !=null && nextWeekList.size()>0){
                for (int i = 0; i < nextWeekList.size(); i++) {
                    ProjectVO projectVO = nextWeekList.get(i);
                    projectVO.setWeekTitle(weekBeginTitle+" ~ "+weekEndTitle+"开标项目");
                    projectVO.setNextWeekTitle(nextWeekBeginTitle+" ~ "+nextWeekEndTitle+"开标项目");
                    totalList.add(projectVO);
                }
               // totalList.addAll(nextWeekList);
            }
        }


        //使用pageInfo包装查询后的结果，只需要将pageInfo交给页面就行了
        //封装了详细的分页信息，包括有我们查询出来的数据,传入连续显示的页数
       // PageInfo page = new PageInfo(totalList,10);
        /**
         * 最重要的格式处理！
         * 工具类，处理成 datatable 规定的格式返回，才能正常显示！
         */
        DataTablePageUtil<ProjectVO> pages = new DataTablePageUtil<>();
        if(weekListTotal != null && weekListTotal.size()>0){
            if(nextWeekListTotal !=null &&nextWeekListTotal.size()>0 ){
                if(weekListTotal.size()>=nextWeekListTotal.size()){
                    total =weekListTotal.size();
                }else{
                    total =nextWeekListTotal.size();
                }
            }else{
                total =weekListTotal.size();
            }
        }else{
            if(nextWeekListTotal !=null &&nextWeekListTotal.size()>0 ){
                total = nextWeekListTotal.size();
            }
        }
        pages.setRecordsTotal(total);
        pages.setRecordsFiltered(total);
        pages.setDraw(draw);
        pages.setData(totalList);

        /**
         * 集合对象转成json数据返回
         */
        ObjectMapper MAPPER = new ObjectMapper();
        String jsonString = null;
        try {
            jsonString = MAPPER.writeValueAsString(pages);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        Object stringToValue = new Gson().fromJson(jsonString,Object.class);

        return stringToValue;


    }


}
