/*변수*/
TAG_VAR = {
    /*로그인버튼*/
    btnSignin : "#btnSignin",
    /*회원가입버튼*/
    btnJoin : "#btnJoin",
    /*사용자ID*/
    txtUserId : "#txtUserId",
    /*사용자비밀번호*/
    txtUserPassword : "#txtUserPassword",
    /*경고알림*/
    liveAlertPlaceholder : "#liveAlertPlaceholder",
};

$(document).ready(function(){
    /*이벤트 리스너 등록*/
    setEventListener();
});

/***
 * 컨트롤러
 */
/*로그인버튼 클릭*/
function fn_onClickSigninBtn(){
    console.log("OK");
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
    CommonUtil.ajaxSend("/user/signin", json, fn_signinCallback);
}
/*로그인버튼 클릭 콜백*/
function fn_signinCallback(result){
    if(result.status == 200){
        console.log("success!");
        console.log("result : ", result);
    }
}
/*회원가입버튼 클릭*/
function fn_onClickJoinBtn(){
    CommonUtil.ajaxSend("/user/joinForm", null, null);
}
/***
 * 이벤트리스너
 */
function setEventListener(){
    /*로그인버튼 클릭*/
    $(TAG_VAR.btnSignin).on("click", fn_onClickSigninBtn);
    /*회원가입버튼 클릭*/
    $(TAG_VAR.btnJoin).on("click", fn_onClickJoinBtn);
}