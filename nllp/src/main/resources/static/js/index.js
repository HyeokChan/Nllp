/*변수*/
TAG_VAR = {
    btnSignin : "#btnSignin",
    txtUserId : "#txtUserId",
    txtUserPassword : "#txtUserPassword",
    liveAlertPlaceholder : "#liveAlertPlaceholder",
};

$(document).ready(function(){
    /*이벤트 리스너 등록*/
    setEventListener();
});

/*컨트롤러*/
function fn_onClickSigninBtn(){
    var userId = $(TAG_VAR.txtUserId).val();
    var userPassword = $(TAG_VAR.txtUserPassword).val();
    if(CommonUtil.isEmpty(userId)){
        CommonUtil.alert("Id is required.", "danger", TAG_VAR.liveAlertPlaceholder);
        return;
    }
    if(CommonUtil.isEmpty(userPassword)){
        CommonUtil.alert("Password is required.", "danger", TAG_VAR.liveAlertPlaceholder);
        return;
    }
    /*Ajax*/
    var json = {
        userId : userId,
        userPassword : userPassword
    }
    CommonUtil.ajaxSend(json, fn_signinCallback);
}

function fn_signinCallback(result){
    if(result.status == 200){
        console.log("OK");
    }
}

/*이벤트 리스너 등록*/
function setEventListener(){
    $(TAG_VAR.btnSignin).on("click", fn_onClickSigninBtn);
}