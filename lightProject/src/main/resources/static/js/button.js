layui.use('table', function () {
    var table = layui.table;

    var $ = layui.$, active = {
        reload: function () {
            var name = $('#name');
            var state = $('#state');
            //执行重载
            table.reload('testReload', {
                page: {
                    curr: 1 //重新从第 1 页开始
                }
                , where: {
                    name: name.val()
                    , state: state.val()
                }
            });
        }
    };
    $('.demoTable .layui-btn').on('click', function () {
        var type = $(this).data('type');
        active[type] ? active[type].call(this) : '';
    });

    //监听行工具事件
    $("#demo1").click(function () {
        $.post("/light/updateButton/1/20/20", {lightId:1,strength:20,frequency:20}, function (result) {
            if (result.success) {
                layer.msg("设置成功！");
                table.reload("testReload", {
                    where: {
                        name: name.val()
                        , state: state.val()
                    }
                });
            } else if (result.errorInfo) {
                layer.msg(result.errorInfo);
            } else {
                layer.msg("设置失败，请联系管理员！");
            }
        }, "json");
    });

    $("#demo2").click(function () {
        $.post("/light/updateButton/1/40/40", {lightId:1,strength:40,frequency:40}, function (result) {
            if (result.success) {
                layer.msg("设置成功！");
                table.reload("testReload", {
                    where: {
                        name: name.val()
                        , state: state.val()
                    }
                });
            } else if (result.errorInfo) {
                layer.msg(result.errorInfo);
            } else {
                layer.msg("设置失败，请联系管理员！");
            }
        }, "json");
    });

    $("#demo3").click(function () {
        $.post("/light/updateButton/1/60/60", {lightId:1,strength:60,frequency:60}, function (result) {
            if (result.success) {
                layer.msg("设置成功！");
                table.reload("testReload", {
                    where: {
                        name: name.val()
                        , state: state.val()
                    }
                });
            } else if (result.errorInfo) {
                layer.msg(result.errorInfo);
            } else {
                layer.msg("设置失败，请联系管理员！");
            }
        }, "json");
    });

    $("#demo4").click(function () {
        $.post("/light/updateButton/1/80/80", {lightId:1,strength:80,frequency:80}, function (result) {
            if (result.success) {
                layer.msg("设置成功！");
                table.reload("testReload", {
                    where: {
                        name: name.val()
                        , state: state.val()
                    }
                });
            } else if (result.errorInfo) {
                layer.msg(result.errorInfo);
            } else {
                layer.msg("设置失败，请联系管理员！");
            }
        }, "json");
    });

    $("#demo5").click(function () {
        $.post("/light/updateButton/1/100/100", {lightId:1,strength:100,frequency:100}, function (result) {
            if (result.success) {
                layer.msg("设置成功！");
                table.reload("testReload", {
                    where: {
                        name: name.val()
                        , state: state.val()
                    }
                });
            } else if (result.errorInfo) {
                layer.msg(result.errorInfo);
            } else {
                layer.msg("设置失败，请联系管理员！");
            }
        }, "json");
    });

    $("#demo6").click(function () {
        $.post("/light/updateButton/1/20/20", {lightId:1,strength:20,frequency:20}, function (result) {
            if (result.success) {
                layer.msg("设置成功！");
                table.reload("testReload", {
                    where: {
                        name: name.val()
                        , state: state.val()
                    }
                });
            } else if (result.errorInfo) {
                layer.msg(result.errorInfo);
            } else {
                layer.msg("设置失败，请联系管理员！");
            }
        }, "json");
    });

    $("#demo7").click(function () {
        $.post("/light/updateButton/1/40/40", {lightId:1,strength:40,frequency:40}, function (result) {
            if (result.success) {
                layer.msg("设置成功！");
                table.reload("testReload", {
                    where: {
                        name: name.val()
                        , state: state.val()
                    }
                });
            } else if (result.errorInfo) {
                layer.msg(result.errorInfo);
            } else {
                layer.msg("设置失败，请联系管理员！");
            }
        }, "json");
    });

    $("#demo8").click(function () {
        $.post("/light/updateButton/1/60/60", {lightId:1,strength:60,frequency:60}, function (result) {
            if (result.success) {
                layer.msg("设置成功！");
                table.reload("testReload", {
                    where: {
                        name: name.val()
                        , state: state.val()
                    }
                });
            } else if (result.errorInfo) {
                layer.msg(result.errorInfo);
            } else {
                layer.msg("设置失败，请联系管理员！");
            }
        }, "json");
    });

    $("#demo9").click(function () {
        $.post("/light/updateButton/1/80/80", {lightId:1,strength:80,frequency:80}, function (result) {
            if (result.success) {
                layer.msg("设置成功！");
                table.reload("testReload", {
                    where: {
                        name: name.val()
                        , state: state.val()
                    }
                });
            } else if (result.errorInfo) {
                layer.msg(result.errorInfo);
            } else {
                layer.msg("设置失败，请联系管理员！");
            }
        }, "json");
    });

    $("#demo10").click(function () {
        $.post("/light/updateButton/1/100/100", {lightId:1,strength:100,frequency:100}, function (result) {
            if (result.success) {
                layer.msg("设置成功！");
                table.reload("testReload", {
                    where: {
                        name: name.val()
                        , state: state.val()
                    }
                });
            } else if (result.errorInfo) {
                layer.msg(result.errorInfo);
            } else {
                layer.msg("设置失败，请联系管理员！");
            }
        }, "json");
    });
});
