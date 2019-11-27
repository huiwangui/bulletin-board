function  selectBond() {

    $('#dt_travel_list').DataTable({//绑定要遍历数据的 table 的 id
            processing: true, /* 数据加载时显示进度条 */
            paging: true, /* 开启分页 */
            searching: false, /* 搜索框 */
            pageLength: 10, /* 页大小，同时当前页每次加 10，不明白为什么每次增加 10 */
            lengthMenu: [10, 20, 50, 100], /* 页大小，同时当前页每次加 10，不明白为什么每次增加 10 */
            lengthChange: true, /* 是否允许用户改变表格每页显示的记录数 */
            serverSide: true, /* 启用服务端分页，如果前端分页，这里为 false */

            iDisplayLength: 10,// 不知什么用
            pagingType: "full_numbers",//显示分页所有按钮
            scrollX: true,

            // autoWidth: false,

            ordering: false,

            flexibleWidth: false,
            responsive: true,
            bAutoWidth: false, //自定义列宽

            paging: false, // 禁止分页

            ajax: {
                url: "firstPurchase/listProjectByCon",
                type: "post",
                data: {
                    openTenderTime: $("#openTenderTime").val()
                },
                dataFilter: function (json) {
                    return json;
                }
            },

            /* 中间遍历的数据 */
            columns: [

                {data: "orgAbbreviation", "width": "20px",
                    render: function(data, type, row, meta) { ;
                        var html;
                        if(data != null){
                            html='<div style="text-overflow:ellipsis;overflow:hidden;white-space:nowrap;align-content: center" title='+data+'>'+data+'</div>';
                        }

                        return html;
                    }
                },
                 {data: "projectName", "width": "400px",
                    render: function(data, type, row, meta) { ;
                        var html;
                        if(data !=null){
                            html='<div style="text-overflow:ellipsis;overflow:hidden;white-space:nowrap;align-content: center" title='+data+'>'+data+'</div>';
                        }

                        return html;
                    }
                },
                {
                    data: function (data) {
                        if(data.openTenderTime !=null){
                            $("#weekTitle").html(data.weekTitle);
                            $("#nextWeekTitle").html(data.nextWeekTitle);
                            return dateYMDFormat(data.openTenderTime)+ "<br>" +data.dayOfWeek;
                        }else{
                            return "";
                        }


                    }, "width": "60px"
                },


                {data: "nextOrgAbbreviation", "width": "20px",
                    render: function(data, type, row, meta) { ;
                        var html;
                        if(data != null){
                            html='<div style="text-overflow:ellipsis;overflow:hidden;white-space:nowrap;align-content: center" title='+data+'>'+data+'</div>';
                        }

                        return html;
                    }

                },


                {data: "nextProjectName", "width": "400px",
                    render: function(data, type, row, meta) { ;
                        var html;
                        if(data != null){
                            html='<div style="text-overflow:ellipsis;overflow:hidden;white-space:nowrap;align-content: center" title='+data+'>'+data+'</div>';
                        }

                        return html;
                    }
                },
                {
                    data: function (data) {
                        if(data.nextOpenTenderTime !=null){
                            $("#weekTitle").html(data.weekTitle);
                            $("#nextWeekTitle").html(data.nextWeekTitle);
                            return dateYMDFormat(data.nextOpenTenderTime)+ "<br>" +data.nextDayOfWeek;
                        }else{
                            return "";
                        }


                    }, "width": "60px"
                },


            ],

            language: {
                "sProcessing": "处理中...",
                "sLengthMenu": "显示 _MENU_ 项结果",
                "sZeroRecords": "没有匹配结果",
                "sInfo": "显示第 _START_ 至 _END_ 项结果，共 _TOTAL_ 项",
                "sInfoEmpty": "显示第 0 至 0 项结果，共 0 项",
                "sInfoFiltered": "(由 _MAX_ 项结果过滤)",
                "sInfoPostFix": "",
                "sSearch": "搜索:",
                "sUrl": "",
                "sEmptyTable": "表中数据为空",
                "sLoadingRecords": "载入中...",
                "sInfoThousands": ",",
                "oPaginate": {
                    "sFirst": "首页",
                    "sPrevious": "上页",
                    "sNext": "下页",
                    "sLast": "末页"
                },
                "oAria": {
                    "sSortAscending": ": 以升序排列此列",
                    "sSortDescending": ": 以降序排列此列"
                }
            },

            aoColumnDefs: [{
                "bSortable": false,
                'sDefaultContent': '',
                "aTargets": [ '_all']
            }]
        });


   //$('.dataTables_scrollHeadInner').css("width",document.body.clientWidth+"px");//2171  1600px
    $('.box-body').css("width",document.body.clientWidth+"px");//2171  1600px
    $('#dt_travel_list').css("width",(document.body.clientWidth-50)+"px");//2171
    /*$(window).resize(function(){
         $('.box-body').css("width",document.body.clientWidth+"px");//2171  1600px
        $('#dt_travel_list').css("width",(document.body.clientWidth-50)+"px");

    })*/


  /*  window.οnresize=function(){
        $('.box-body').css("width",document.body.clientWidth+"px");//2171  1600px
        $('#dt_travel_list').css("width",(document.body.clientWidth-50)+"px");
    }*/

}
$(window).resize(function(){
     $('.box-body').css("width",document.body.clientWidth+"px");//2171  1600px
    $('#dt_travel_list').css("width",(document.body.clientWidth-50)+"px");

});