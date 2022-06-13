/**
 * @Description: 菜单配置
 * @Copyright: 2017 wueasy.com Inc. All rights reserved.
 * @author: fallsea
 * @version 1.8.2
 * @License：MIT
 */
layui.define(['element',"fsConfig","fsCommon"], function(exports){

	var menuConfig = {
			dataType : "local" , //获取数据方式，local本地获取，server 服务端获取
			loadUrl : "", //加载数据地址
			method : "post",//请求类型，默认post
			rootMenuId : "0", //根目录菜单id
			defaultSelectTopMenuId : "1", //默认选中头部菜单id
			defaultSelectLeftMenuId : "111", //默认选中左边菜单id
			menuIdField : "menuId", //菜单id
			menuNameField : "menuName", //菜单名称
			menuIconField : "menuIcon" , //菜单图标，图标必须用css
			menuHrefField : "menuHref" , //菜单链接
			parentMenuIdField : "parentMenuId" ,//父菜单id
			data : [
				{"menuId":"1","menuName":"控制台","menuIcon":"&#xe665;","menuHref":"","parentMenuId":"0"},
				{"menuId":"11","menuName":"管理列表","menuIcon":"&#xe62d;","menuHref":"","parentMenuId":"1"},
				{"menuId":"111","menuName":"首页","menuIcon":"&#xe68e;","menuHref":"/defaultIndex","parentMenuId":"11"},
				{"menuId":"articleid","menuName":"资源管理","menuIcon":"&#xe63c;","menuHref":"/admin/article/indexHome.html","parentMenuId":"11"},
				{"menuId":"arcTypeid","menuName":"资源类型管理","menuIcon":"&#xe63c;","menuHref":"/admin/arcType/indexHome.html","parentMenuId":"11"},
				{"menuId":"userid","menuName":"用户管理","menuIcon":"&#xe63c;","menuHref":"/admin/user/indexHome.html","parentMenuId":"11"},
                {"menuId":"commentid","menuName":"评论管理","menuIcon":"&#xe63c;","menuHref":"/admin/comment/indexHome.html","parentMenuId":"11"},
				{"menuId":"linkid","menuName":"友情链接管理","menuIcon":"&#xe63c;","menuHref":"/admin/link/indexHome.html","parentMenuId":"11"}
		 ] //本地数据
	};

	var element = layui.element,
	fsCommon = layui.fsCommon,
	fsConfig = layui.fsConfig,
	statusName = $.result(fsConfig,"global.result.statusName","errorNo"),
  	msgName = $.result(fsConfig,"global.result.msgName","errorInfo"),
	successNo = $.result(fsConfig,"global.result.successNo","0"),
  	dataName = $.result(fsConfig,"global.result.dataName","results.data"),
	FsMenu = function (){

	};


	FsMenu.prototype.render = function(){

		this.loadData();

		this.showMenu();
	};

	/**
	 * 加载数据
	 */
	FsMenu.prototype.loadData = function(){

		if(menuConfig.dataType == "server"){//服务端拉取数据

			var url = menuConfig.loadUrl;
			if($.isEmpty(url)){
				fsCommon.errorMsg("未配置请求地址！");
				return;
			}

			fsCommon.invoke(url,{},function(data){
  			if(data[statusName] == successNo)
  			{
  				menuConfig.data = $.result(data,dataName);
  			}
  			else
  			{
  				//提示错误消息
  				fsCommon.errorMsg(data[msgName]);
  			}
  		},false,menuConfig.method);

		}

	}


	/**
	 * 获取图标
	 */
	FsMenu.prototype.getIcon = function(menuIcon){

		if(!$.isEmpty(menuIcon)){

			if(menuIcon.indexOf("<i") == 0){
				return menuIcon;
			}else if (menuIcon.indexOf("&#") == 0){
				return '<i class="layui-icon">'+menuIcon+'</i>';
			}else if (menuIcon.indexOf("fa-") == 0){
				return '<i class="fa '+menuIcon+'"></i>';
			}else {
				return '<i class="'+menuIcon+'"></i>';
			}
		}
		return "";
	};

	/**
	 * 清空菜单
	 */
	FsMenu.prototype.cleanMenu = function(){
		$("#fsTopMenu").html("");
		$("#fsLeftMenu").html("");
	}
	/**
	 * 显示菜单
	 */
	FsMenu.prototype.showMenu = function(){
		var thisMenu = this;
		var data = menuConfig.data;
		if(!$.isEmpty(data)){
			var _index = 0;
			//显示顶部一级菜单
			var fsTopMenuElem = $("#fsTopMenu");
			var fsLeftMenu = $("#fsLeftMenu");
			$.each(data,function(i,v){
				if(menuConfig.rootMenuId === v[menuConfig.parentMenuIdField]){

					var topStr = '<li class="layui-nav-item';
					if($.isEmpty(menuConfig.defaultSelectTopMenuId) && _index === 0){//为空默认选中第一个
						topStr += ' layui-this';
					}else if(!$.isEmpty(menuConfig.defaultSelectTopMenuId) && menuConfig.defaultSelectTopMenuId == v[menuConfig.menuIdField]){//默认选中处理
						topStr += ' layui-this';
					}
					_index ++ ;
					topStr += '" dataPid="'+v[menuConfig.menuIdField]+'"><a href="javascript:;">'+thisMenu.getIcon(v[menuConfig.menuIconField])+' <cite>'+v[menuConfig.menuNameField]+'</cite></a></li>';
					fsTopMenuElem.append(topStr);

					//显示二级菜单，循环判断是否有子栏目
					$.each(data,function(i2,v2){
						if(v[menuConfig.menuIdField] === v2[menuConfig.parentMenuIdField]){

							var menuRow = '<li class="layui-nav-item';
							if(!$.isEmpty(menuConfig.defaultSelectLeftMenuId) && menuConfig.defaultSelectLeftMenuId == v2[menuConfig.menuIdField]){//默认选中处理
								menuRow += ' layui-this';
							}
							//显示三级菜单，循环判断是否有子栏目
							var menuRow3 = "";
							$.each(data,function(i3,v3){
								if(v2[menuConfig.menuIdField] === v3[menuConfig.parentMenuIdField]){
									if($.isEmpty(menuRow3)){
										menuRow3 = '<dl class="layui-nav-child">';
									}
									menuRow3 += '<dd';
									if(!$.isEmpty(menuConfig.defaultSelectLeftMenuId) && menuConfig.defaultSelectLeftMenuId == v3[menuConfig.menuIdField]){//默认选中处理
										menuRow3 += ' class="layui-this"';
										menuRow += ' layui-nav-itemed';//默认展开二级菜单
									}

									menuRow3 += ' lay-id="'+v3[menuConfig.menuIdField]+'"><a href="javascript:;" menuId="'+v3[menuConfig.menuIdField]+'" dataUrl="'+v3[menuConfig.menuHrefField]+'">'+thisMenu.getIcon(v3[menuConfig.menuIconField])+' <cite>'+v3[menuConfig.menuNameField]+'</cite></a></dd>';

								}

							});

							menuRow += '" lay-id="'+v2[menuConfig.menuIdField]+'" dataPid="'+v2[menuConfig.parentMenuIdField]+'" style="display: none;"><a href="javascript:;" menuId="'+v2[menuConfig.menuIdField]+'" dataUrl="'+v2[menuConfig.menuHrefField]+'">'+thisMenu.getIcon(v2[menuConfig.menuIconField])+' <cite>'+v2[menuConfig.menuNameField]+'</cite></a>';


							if(!$.isEmpty(menuRow3)){
								menuRow3 += '</dl>';

								menuRow += menuRow3;
							}

							menuRow += '</li>';

							fsLeftMenu.append(menuRow);
						}

					});

				}
			});
		}
		element.render("nav");
	};

	var fsMenu = new FsMenu();
	exports("fsMenu",fsMenu);
});
