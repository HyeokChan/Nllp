// 변수
TAG_VAR = {
    "btnNllpInfoDelt" : "#btnNllpInfoDelt",
    "btnNllpInfoSave" : "#btnNllpInfoSave",
    "txtNllpAcbKey" : "#txtNllpAcbKey",
};
// init
$(document).ready(function(){
    // 이벤트 리스너 등록
    setEventListener();
});

/***
 * 컨트롤러
 */
// 저장버튼 클릭
function fn_onClickNllpInfoSaveBtn(){

}

// 삭제버튼 클릭
function fn_onClickNllpInfoDeltBtn(){
    var nllpAcbKey = $(TAG_VAR.txtNllpAcbKey).val();
    /*Ajax*/
    var json = {
        nllpAcbKey : nllpAcbKey,
    }
    CommonUtil.ajaxSend("/nllp/deltNllpInfo", json, fn_deltNllpInfoCallback);
}
// 삭제버튼 클릭 콜백
function fn_deltNllpInfoCallback(result){
    console.log("result : ", result);
    if(result.status == 200){
        console.log("success!");
        console.log("result : ", result);
    }
}

/***
 * 이벤트리스너
 */
function setEventListener(){
    // 저장버튼 클릭
    $(TAG_VAR.btnNllpInfoSave).on("click", fn_onClickNllpInfoSaveBtn);
    // 삭제버튼 클릭
    $(TAG_VAR.btnNllpInfoDelt).on("click", fn_onClickNllpInfoDeltBtn);


}