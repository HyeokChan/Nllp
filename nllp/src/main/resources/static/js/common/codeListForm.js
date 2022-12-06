// 변수
const TAG_VAR_CODE_LIST = {
    "btnCodeListSearch" : "#btnCodeListSearch",
    "btnCodeListInit" : "#btnCodeListInit",
    "datatableCode" : "#datatableCode",
    "codeSearchForm" : "#codeSearchForm",
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
    dataTable = $(TAG_VAR_CODE_LIST.datatableCode).DataTable( {
        data: [],
        columnDefs: [
            { targets: 0, data: 'cdId', width: 150, className: "dt-head-center dt-body-center" },
            { targets: 1, data: 'cdNm', width: 150, className: "dt-head-center dt-body-center" },
            { targets: 2, data: 'useYn', width: 100, className: "dt-head-center dt-body-center" },
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
// 조회버튼 클릭 이벤트
function fn_onClickCodeListSearchBtn(){
    var json = CommonUtil.convertFormToJSON($(TAG_VAR_CODE_LIST.codeSearchForm));
    return CommonUtil.ajaxSend("/nllp/findCodeList", json, fn_findCodeListCallback);
}
// 조회버튼 클릭 콜백 이벤트
function fn_findCodeListCallback(result){
    // 조회된 데이터로 새로 그리기
    dataTable.clear().draw();
    dataTable.rows.add(result).draw();
}
// 초기화버튼 클릭 이벤트
function fn_onClickCodeListInitBtn(){
    // form 초기화
    CommonUtil.resetForm($(TAG_VAR_CODE_LIST.codeSearchForm));
    // 데이터테이블 초기화
    dataTable.clear().draw();
}
// 데이터테이블 더블클릭 이벤트
function fn_onDblclickCodeDatatable(){
    var rowData = $(TAG_VAR_CODE_LIST.datatableCode).DataTable().row($(this)).data();
    var cdId = rowData.cdId;
    // GET 방식 호출
    location.href = "/nllp/findCodeInfo/" + cdId;
}

/***
 * 이벤트리스너
 */
function setEventListener(){
    // 조회버튼 클릭
    $(TAG_VAR_CODE_LIST.btnCodeListSearch).on("click", fn_onClickCodeListSearchBtn);
    // 초기화버튼클릭
    $(TAG_VAR_CODE_LIST.btnCodeListInit).on("click", fn_onClickCodeListInitBtn);
    // 데이터테이블 더블클릭 이벤트
    $(TAG_VAR_CODE_LIST.datatableCode).on('dblclick', 'tbody tr', fn_onDblclickCodeDatatable)
}