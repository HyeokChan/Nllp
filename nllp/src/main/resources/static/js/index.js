
$(document).ready(function(){
    /*로그인 화면전환*/
    console.log("OK!");
    //CommonUtil.ajaxSend("/user/signinForm", null, null);
    $("#btnTest").on("click", function(){
        console.log("OK???");
        CommonUtil.ajaxSend("GET", "/user", null, null);
    })
});

