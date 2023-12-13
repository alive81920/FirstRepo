logout_customer=function(){
	if(confirm("你确定退出登录吗？"))
			window.location.href="logout_customer";
}

cancel_customer=function(){
	if(confirm("你确定注销该账号吗？"))
			window.location.href="cancel_customer";
}


logout_store=function(){
	if(confirm("你确定退出登录吗？"))
			window.location.href="logout_store";
}

cancel_store=function(){
	if(confirm("你确定注销该账号吗？"))
			window.location.href="cancel_store";
}

logout_admin=function(){
	if(confirm("你确定退出登录吗？"))
		window.location.href="logout_admin";
}

function checkfile(t){
	var fileSize = 0;
    var fileMaxSize = 5120;//5M
    var filePath = t.value;
    if(filePath){
        fileSize =t.files[0].size;
        var size = fileSize / 1024;
        if (size > fileMaxSize) {
            alert("文件大小不能大于5M！");
            file.value = "";
            return false;
        }else if (size <= 0) {
            alert("文件大小不能为0M！");
            file.value = "";
            return false;
        }
    }else{
        return false;
    }
}

function delect_good(id){
	if(confirm("你确定下架该商品？"))
		window.location.href="delete_good?GoodID="+id;
}

function is_delete(id){
	if(confirm("你确定删除该订单吗？")){
		window.location.href="get_modify_order?ID="+id+"&&op=4";
	}
		
}

function delete_admin(id){
	if(confirm("你确定删除该管理员？"))
		window.location.href="delete_admin?ID="+id;
}

function delete_customer_by_ad(n){
	if(confirm("你确定注销该顾客？"))
		window.location.href="delete_customer_by_admin?ID="+n;
}

function delete_store_by_ad(n){
	if(confirm("你确定注销该商家？"))
		window.location.href="delete_store_by_admin?ID="+n;
}


function delete_good_by_ad(id){
	if(confirm("你确定下架该商品吗？"))
		window.location.href="delete_good_by_admin?GoodID="+id;
}


