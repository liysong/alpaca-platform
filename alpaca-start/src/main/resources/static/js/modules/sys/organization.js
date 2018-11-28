var setting = {
    data: {
        simpleData: {
            enable: true,
            idKey: "id",
            pIdKey: "parentId",
            rootPId: -1
        },
        key: {
            url:"nourl",
            name:"orgName"
        }
    }
};
var ztree;

var vm = new Vue({
    el:'#rrapp',
    data:{
        showList: true,
        title: null,
        dept:{
            parentName:null,
            parentId:0,
            orgLayer:0
        }
    },
    methods: {
        getDept: function(){
            //加载部门树
            $.get(baseURL + "sys/organization/select", function(r){
                ztree = $.fn.zTree.init($("#deptTree"), setting, r.deptList);
                var node = ztree.getNodeByParam("id", vm.dept.parentId);
                ztree.selectNode(node);

                vm.dept.parentName = node.orgName;
            })
        },
        add: function(){
            vm.showList = false;
            vm.title = "新增";
            vm.dept = {parentName:null,parentId:0,orgSort:0,orgName:null,
                       orgLayer:null,orgCode:null,description:null,parentId:null,
                       status:1,flag:1};
            vm.getDept();
        },
        update: function () {
            var deptId = getDeptId();
            if(deptId == null){
                return ;
            }

            $.get(baseURL + "sys/organization/info/"+deptId, function(r){
                vm.showList = false;
                vm.title = "修改";
                vm.dept = r.dept;

                vm.getDept();
            });
        },
        del: function () {
            var deptId = getDeptId();
            if(deptId == null){
                return ;
            }

            confirm('确定要删除选中的记录？', function(){
                $.ajax({
                    type: "POST",
                    url: baseURL + "sys/organization/delete",
                    data: "id=" + deptId,
                    success: function(r){
                        if(r.code === 1){
                            alert('操作成功', function(){
                                vm.reload();
                            });
                        }else{
                            alert(r.msg);
                        }
                    }
                });
            });
        },
        saveOrUpdate: function (event) {
            var url = vm.dept.deptId == null ? "sys/organization/save" : "sys/organization/update";
            $.ajax({
                type: "POST",
                url: baseURL + url,
                contentType: "application/json",
                data: JSON.stringify(vm.dept),
                success: function(r){
                    if(r.code === 1){
                        alert('操作成功', function(){
                            vm.reload();
                        });
                    }else{
                        alert(r.msg);
                    }
                }
            });
        },
        deptTree: function(){
            layer.open({
                type: 1,
                offset: '50px',
                skin: 'layui-layer-molv',
                title: "选择部门",
                area: ['300px', '450px'],
                shade: 0,
                shadeClose: false,
                content: jQuery("#deptLayer"),
                btn: ['确定', '取消'],
                btn1: function (index) {
                    var node = ztree.getSelectedNodes();
                    //选择上级部门
                    vm.dept.parentId = node[0].id;
                    vm.dept.parentName = node[0].orgName;

                    layer.close(index);
                }
            });
        },
        reload: function () {
            vm.showList = true;
            Organization.table.refresh();
        }
    }
});

var Organization = {
    id: "deptTable",
    table: null,
    layerIndex: -1
};

/**
 * 初始化表格的列
 */
Organization.initColumn = function () {
    var columns = [
        {field: 'selectItem', radio: true},
        {title: '部门ID', field: 'id', visible: false, align: 'center', valign: 'middle', width: '80px'},
        {title: '部门名称', field: 'orgName', align: 'center', valign: 'middle', sortable: true, width: '180px'},
        {title: '上级部门', field: 'parentName', align: 'center', valign: 'middle', sortable: true, width: '100px'},
        {title: 'layer', field: 'orgLayer', align: 'center', valign: 'middle', sortable: true, width: '100px'}]
    return columns;
};


function getDeptId () {
    var selected = $('#deptTable').bootstrapTreeTable('getSelections');
    if (selected.length == 0) {
        alert("请选择一条记录");
        return false;
    } else {
        return selected[0].id;
    }
}


$(function () {
    $.get(baseURL + "sys/organization/info", function(r){
        var colunms = Organization.initColumn();
        var table = new TreeTable(Organization.id, baseURL + "sys/organization/list", colunms);
        table.setRootCodeValue(r.orgId);
        table.setExpandColumn(2);
        table.setIdField("id");
        table.setCodeField("id");
        table.setParentCodeField("parentId");
        table.setExpandAll(false);
        table.init();
        Organization.table = table;
    });
});
