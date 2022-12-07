// 변수
TAG_VAR_CODE_INFO_INST = {
    "btnCodeInfoInstInit" : "#btnCodeInfoInstInit",
    "btnCodeInfoInst" : "#btnCodeInfoInst",
    "datatableDtlCode" : "#datatableDtlCode",
    "codeInfoInstForm" : "#codeInfoInstForm",
    "dtlCodeInstForm" : "#dtlCodeInstForm",
    "btnDtlCodeInst" : "#btnDtlCodeInst",
};

var dataTable = {};
// init
$(document).ready(function(){
    setLayout();
    // 이벤트 리스너 등록
    setEventListener();
});

// 화면세팅
function setLayout(){
    // 데이터테이블 설정
    dataTable = $(TAG_VAR_CODE_INFO_INST.datatableDtlCode).DataTable( {
        data: [],
        columnDefs: [
            { targets: 0, data: 'dtlCdId', width: 150, className: "dt-head-center dt-body-center" },
            { targets: 1, data: 'dtlCdNm', width: 300, className: "dt-head-center dt-body-center" },
        ],
        scrollY: 180,
        paging: false,
        searching: false,
        autoWidth: false,
        lengthChange: false,
        language: {
            emptyTable: "조회된 자료가 없습니다.",
            info: "현재 _START_ - _END_ / _TOTAL_건",
            infoEmpty: "",
            zeroRecords: "조회된 자료가 없습니다.",
            loadingRecords: "로딩중입니다.",
            processing:     "잠시만 기다려 주세요.",
        },
        responsive: true,
    } );
}
/***
 * 컨트롤러
 */
// 초기화버튼 클릭 이벤트
function fn_onClickCodeInfoInstInitBtn(){
    // form 초기화
    CommonUtil.resetForm($(TAG_VAR_CODE_INFO_INST.codeInfoInstForm));
    // 데이터테이블 초기화
    dataTable.clear().draw();
}
//저장버튼 클릭 이벤트
function fn_onClickCodeInfoInstBtn(){
    var codeInfoInstForm = CommonUtil.convertFormToJSON($(TAG_VAR_CODE_INFO_INST.codeInfoInstForm));
    var datatableData = $(TAG_VAR_CODE_INFO_INST.datatableDtlCode).DataTable().rows().data();
    for(var i=0; i<datatableData.length; i++){
        codeInfoInstForm['dtlCdList[' + i + '].dtlCdId'] = datatableData[i].dtlCdId;
        codeInfoInstForm['dtlCdList[' + i + '].dtlCdNm'] = datatableData[i].dtlCdNm;
    }
    return CommonUtil.ajaxSend("/code/instCodeInfo", codeInfoInstForm, null);
}
// 추가버튼 클릭 이벤트
function fn_onClickDtlCodeInfoInstInitBtn(){
    var json = CommonUtil.convertFormToJSON($(TAG_VAR_CODE_INFO_INST.dtlCodeInstForm));
    var datatableData = $(TAG_VAR_CODE_INFO_INST.datatableDtlCode).DataTable().rows().data();
    if(datatableData.length == 0){
        $($(TAG_VAR_CODE_INFO_INST.datatableDtlCode)).DataTable()
            .row.add(json).draw();
    }
    else if(datatableData.length != 0){
        for(var i=0; i<datatableData.length; i++){
            if(datatableData[i].dtlCdId == json.dtlCdId){
                return;
            }
        }
        $($(TAG_VAR_CODE_INFO_INST.datatableDtlCode)).DataTable()
            .row.add(json).draw();
    }
}

/***
 * 이벤트리스너
 */
function setEventListener(){
    // 초기화버튼 클릭 이벤트
    $(TAG_VAR_CODE_INFO_INST.btnCodeInfoInstInit).on("click", fn_onClickCodeInfoInstInitBtn);
    // 저장버튼 클릭 이벤트
    $(TAG_VAR_CODE_INFO_INST.btnCodeInfoInst).on("click", fn_onClickCodeInfoInstBtn);
    // 추가버튼 클릭 이벤트
    $(TAG_VAR_CODE_INFO_INST.btnDtlCodeInst).on("click", fn_onClickDtlCodeInfoInstInitBtn);
}