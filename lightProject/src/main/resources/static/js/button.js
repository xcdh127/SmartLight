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
        $.post("/light/updateButtonFre/1/20", {lightId: 1, frequency: 20}, function (result) {
        }, "json");
    });

    $("#demo2").click(function () {
        $.post("/light/updateButtonFre/1/40", {lightId: 1, frequency: 40}, function (result) {
        }, "json");
    });

    $("#demo3").click(function () {
        $.post("/light/updateButtonFre/1/60", {lightId: 1, frequency: 60}, function (result) {
        }, "json");
    });

    $("#demo4").click(function () {
        $.post("/light/updateButtonFre/1/80", {lightId: 1, frequency: 80}, function (result) {
        }, "json");
    });

    $("#demo5").click(function () {
        $.post("/light/updateButtonFre/1/100", {lightId: 1, frequency: 100}, function (result) {
        }, "json");
    });

    $("#demo6").click(function () {
        $.post("/light/updateButtonStr/1/20", {lightId: 1, strength: 20}, function (result) {
        }, "json");
    });

    $("#demo7").click(function () {
        $.post("/light/updateButtonStr/1/1", {lightId: 1, strength: 40}, function (result) {
        }, "json");
    });

    $("#demo8").click(function () {
        $.post("/light/updateButtonStr/1/60", {lightId: 1, strength: 60}, function (result) {
        }, "json");
    });

    $("#demo9").click(function () {
        $.post("/light/updateButtonStr/1/80", {lightId: 1, strength: 80}, function (result) {
        }, "json");
    });

    $("#demo10").click(function () {
        $.post("/light/updateButtonStr/1/100", {lightId: 1, strength: 100}, function (result) {
        }, "json");
    });
});

function toButtons() {
    setTimeout(function () {
        window.location.href = '/buttons';
    }, 100);
}