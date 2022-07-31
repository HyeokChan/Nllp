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
function onClickSigninBtn(){
    var userId = $(TAG_VAR.txtUserId).val();
    var userPw = $(TAG_VAR.txtUserPassword).val();
    if(userId == ""){
        alert("Id is required.", "danger");
        return;
    }
    if(userPw == ""){
        alert("Pw is required.", "danger");
        return;
    }

}

/*이벤트 리스너 등록*/
function setEventListener(){
    $(TAG_VAR.btnSignin).on("click", onClickSigninBtn);
}

/*alert*/
function alert(message, type) {
    var wrapper = document.createElement('div');
    wrapper.innerHTML = '<div class="alert alert-' + type + ' alert-dismissible" role="alert">' + message + '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>';
    $(TAG_VAR.liveAlertPlaceholder).append(wrapper);
}