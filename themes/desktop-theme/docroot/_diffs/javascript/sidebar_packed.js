var Sidebar={categories:[],portlets:[],showTimer:0,init:function(){var A=this;var D=jQuery("#portal_add_content");A.menu=D;if(D.length){A.portlets=D.find(".lfr-portlet-item");A.categories=D.find(".lfr-content-category");A.categoryContainers=D.find(".lfr-add-content");var B=function(){var E=jQuery(this).attr("id");return Liferay.Util.uncamelize(E).toLowerCase()};var C=jQuery("#layout_configuration_content");C.liveSearch({list:A.portlets,data:B,show:function(){var E=jQuery(this);E.show();E.parents(".lfr-content-category").addClass("visible").removeClass("hidden").show();E.parents(".lfr-add-content").addClass("expanded").removeClass("collapsed").show()},hide:function(){var E=jQuery(this);E.hide()}});C.liveSearch({list:A.categoryContainers,data:B,after:function(){if(!this.term){A.categories.addClass("hidden").removeClass("visible").css("display","");A.categoryContainers.addClass("collapsed").removeClass("expanded").css("display","");A.portlets.css("display","")}if(this.term=="*"){A.categories.addClass("visible").removeClass("hidden");A.categoryContainers.addClass("expanded").removeClass("collapsed");A.portlets.show()}},exclude:function(){var F=jQuery(".lfr-content-category",this);var E=F.find("> div:visible").length;return E>0}})}},animate:function(){var A=this;var E=jQuery("#sidebar");var B=jQuery("#sidebar-top .calendar");var D=jQuery("#sidebar-top .clock");var C=jQuery("#sidebar-link a");if(C.is(".expanded")){D.css({display:""});C.removeClass("expanded");B.animate({opacity:"0"},600,"linear");E.parent().animate({width:"20px"},600,"linear");E.animate({opacity:"0"},600,"linear",function(){E.css({display:"none"})})}else{E.css({display:"block"});C.addClass("expanded");B.animate({opacity:"1"},1000,"linear");E.animate({opacity:"1"},600,"linear");E.parent().animate({width:"270px"},600,"linear",function(){D.css({display:"block"})})}},toggle:function(G,F){var C=this;var D=themeDisplay.getPlid();var B=themeDisplay.getDoAsUserIdEncoded();if(!C.menu){var E=themeDisplay.getPathMain()+"/portal/render_portlet";if(F){var H=250;var A=jQuery("body");A.addClass("lfr-has-sidebar");C._dialog=Liferay.Popup({width:H,message:"<div class=\"loading-animation\" />",position:[4,33],resizable:false,title:Liferay.Language.get("add-application"),onClose:function(){C.menu=null;A.removeClass("lfr-has-sidebar")}})}else{C._dialog=jQuery("#sidebar-content")}jQuery.ajax({url:E,data:{p_l_id:D,p_p_id:G,p_p_state:"exclusive",doAsUserId:B},success:function(I){I=I.replace("lfr-auto-focus","");C._dialog.html(I);C._loadContent()}})}},_addPortlet:function(I,M){var J=this;var E=J._getPortletMetaData(I);if(!E.portletUsed){var C=E.plid;var F=E.portletId;var H=E.instanceable;if(!H){I.addClass("lfr-portlet-used");I.draggable("disable")}var G=jQuery("<div class=\"loading-animation\" />");var B=null;var D=null;if(M){var L=M.item;M.placeHolder=G[0];B=M.onComplete;D=M.beforePortletLoaded;L.after(G);L.remove()}else{if(J._sortColumns){J._sortColumns.filter(":first").prepend(G)}}var A={beforePortletLoaded:D,onComplete:B,plid:C,portletId:F,placeHolder:G};var K=Liferay.Portlet.add(A);J._loadPortletFiles(E)}},_getPortletMetaData:function(J){var K=this;var F=J._LFR_portletMetaData;if(!F){var D=(J.attr("instanceable")=="true");var C=J.attr("plid");var H=J.attr("portletId");var G=J.is(".lfr-portlet-used");var E=(J.attr("headerPortalCssPaths")||"").split(",");var I=(J.attr("headerPortletCssPaths")||"").split(",");var A=(J.attr("footerPortalCssPaths")||"").split(",");var B=(J.attr("footerPortletCssPaths")||"").split(",");F={instanceable:D,plid:C,portletId:H,portletPaths:{footer:B,header:I},portalPaths:{footer:A,header:E},portletUsed:G};J._LFR_portletMetaData=F}return F},_loadContent:function(){var A=this;A.init();Liferay.Util.addInputType();Liferay.bind("closePortlet",A._onPortletClose,A);A._portletItems=A._dialog.find("div.lfr-portlet-item");var D=A._portletItems;D.find("a").click(function(I){var H=jQuery(this);var J=H.parents(".lfr-portlet-item:first");A._addPortlet(J)});var G=A._dialog.parents(".ui-dialog").css("z-index");A._helper=jQuery(Liferay.Template.PORTLET).css("z-index",G+10);A._helper.addClass("ui-proxy generic-portlet not-intersecting");var F="Column";var E="body";if(Liferay.Layout.isFreeForm){E="#column-1";F="FreeForm"}else{if(!A._sortColumns||!A._sortableInstance){A._sortColumns=Liferay.Layout.Columns.sortColumns;A._sortableInstance=A._sortColumns.data("sortable")}var C=A._sortColumns;var B=A._sortableInstance;B.refresh();if(!A._eventsBound){C.bind("sortreceive.sortable",function(I,J){if(J.item.is(".lfr-portlet-item")&&J.sender.is(".lfr-portlet-item")&&!B.dragging){var L=J.item;var K=J.sender;var H={item:L};A._addPortlet(K,H);L.hide()}});C.bind("sortactivate.sortable",function(H){Liferay.Layout.Columns.startDragging();B.refreshPositions(true)});C.bind("sortstart.sortable",function(H,I){if(I.item.is(".lfr-portlet-item")){I.placeholder.css({height:200,width:300})}});A._eventsBound=true}}A._dragOptions={appendTo:E,connectToSortable:".lfr-portlet-column",distance:2,helper:function(I){var H=A._helper.clone();var J=this.getAttribute("title");H.find(".portlet-title").text(J);return H[0]},start:function(H,I){if(A["_on"+F+"DragStart"]){A["_on"+F+"DragStart"](H,I,this)}},drag:function(H,I){if(A["_on"+F+"Drag"]){A["_on"+F+"Drag"](H,I,this)}},stop:function(H,I){if(A["_on"+F+"DragStop"]){A["_on"+F+"DragStop"](H,I,this)}}};D.draggable(A._dragOptions);D.filter(".lfr-portlet-used").draggable("disable");if(Liferay.Browser.isIe()){D.hover(function(){this.className+=" over"},function(){this.className=this.className.replace("over","")})}jQuery(".lfr-add-content > h2").click(function(){var I=jQuery(this).parent();var H=I.find("> .lfr-content-category");H.toggleClass("hidden").toggleClass("visible");I.toggleClass("collapsed").toggleClass("expanded")})},_loadPortletFiles:function(F){var J=this;var C=F.portalPaths.header;var A=F.portalPaths.footer;var I=F.portletPaths.header;var B=F.portletPaths.footer;var H=jQuery("head");var D=jQuery(document.body);var G=C.concat(I);var E=A.concat(B);jQuery.each(G,function(K,L){H.prepend("<link href=\""+this+"\" rel=\"stylesheet\" type=\"text/css\" />")});if(Liferay.Browser.isIe()){jQuery("body link").appendTo("head");jQuery("link.lfr-css-file").each(function(K){document.createStyleSheet(this.href)})}jQuery.each(E,function(K,L){D.append("<link href=\""+this+"\" rel=\"stylesheet\" type=\"text/css\" />")})},_onColumnDragStop:function(B,C,D){var A=this;Liferay.Layout.Columns.stopDragging()},_onFreeFormDragStart:function(B,C,D){var A=this;C.helper.removeClass("not-intersecting")},_onFreeFormDragStop:function(B,F,D){var H=this;var G=jQuery(D);var C=F.helper;var E=F.position;var A={height:F.helper.height(),position:"absolute",width:F.helper.width()};var I={beforePortletLoaded:function(J){J=jQuery(J);J.css(E);J.css(A)},item:C,onComplete:function(K,J){jQuery(K).css(E);Liferay.Layout.FreeForm._moveToTop(K);Liferay.Layout.FreeForm._savePosition(K)}};H._addPortlet(G,I)},_onPortletClose:function(E,C){var A=this;var B=jQuery("#portal_add_content");var D=B.find(".lfr-portlet-item[@plid="+C.plid+"][@portletId="+C.portletId+"][@instanceable=false]");if(D.is(".lfr-portlet-used")){D.removeClass("lfr-portlet-used");D.draggable("enable")}}}