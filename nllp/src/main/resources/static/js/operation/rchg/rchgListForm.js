// 변수
var TAG_VAR_RCHG_LIST = {
    "btnRchgListSearch" : "#btnRchgListSearch",
    "btnRchgListInit" : "#btnRchgListInit",
    "datatableRchgAcb" : "#datatableRchgAcb",
    "rchgSearchForm" : "#rchgSearchForm",
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
    dataTable = $(TAG_VAR_RCHG_LIST.datatableRchgAcb).DataTable( {
        data: [],
        columnDefs: [
            { targets: 0, data: 'rchgAcbKey', width: 0, visible: false},
            { targets: 1, data: 'rchgAcbNo', width: 150, className: "dt-head-center dt-body-center" },
            { targets: 2, data: 'nllpAcbNo', width: 150, className: "dt-head-center dt-body-center" },
            { targets: 3, data: 'pyrSeNm', width: 150, className: "dt-head-center dt-body-left" },
            { targets: 4, data: 'pyrNm', width: 200, className: "dt-head-center dt-body-left" },
            { targets: 5, data: 'pyrNo', width: 200, className: "dt-head-center dt-body-center" },
            { targets: 6, data: 'ctrtMtdNm', width: 150, className: "dt-head-center dt-body-center" },
            { targets: 7, data: 'ctrtYmd', width: 150, className: "dt-head-center dt-body-center" },
            { targets: 8, data: 'prmsnBgngYmd', width: 150, className: "dt-head-center dt-body-center" },
            { targets: 9, data: 'prmsnEndYmd', width: 150, className: "dt-head-center dt-body-center" },
            { targets: 10, data: 'glLotnoAlAddr', width: 400, className: "dt-head-center" },
            { targets: 11, data: 'ocpatAr', width: 150, render: $.fn.dataTable.render.number( ',' ), className: "dt-head-center dt-body-right" },
            { targets: 12, data: 'rmCn',  width: 400, className: "dt-head-center" }
        ],
        scrollY: 180,
        scrollX: true,
        paging: true,
        pagingType: "full_numbers",
        searching: false,
        autoWidth: false,
        lengthChange: false,
        pageLength: 5,
        language: {
            emptyTable: "조회된 자료가 없습니다.",
            info: "현재 _START_ - _END_ / _TOTAL_건",
            infoEmpty: "",
            zeroRecords: "조회된 자료가 없습니다.",
            loadingRecords: "로딩중입니다.",
            processing:     "잠시만 기다려 주세요.",
            paginate: {
                "first": "처음",
                "next": "다음",
                "previous": "이전",
                "last": "끝"
            }
        },
        responsive: true,
    } );
}
/***
 * 컨트롤러
 */
// 조회버튼 클릭 이벤트
function fn_onClickRchgListSearchBtn(){
    var rchgSearchInfo = CommonUtil.convertFormToJSON($(TAG_VAR_RCHG_LIST.rchgSearchForm));
    console.log("rchgSearchInfo", rchgSearchInfo);
    return CommonUtil.ajaxSend("/rchg/findRchgList", rchgSearchInfo, fn_findRchgListCallback);
}
// 조회버튼 클릭 콜백 이벤트
function fn_findRchgListCallback(result){
    // 조회된 데이터로 새로 그리기
    dataTable.clear().draw();
    dataTable.rows.add(result).draw();
}
// 초기화버튼 클릭 이벤트
function fn_onClickRchgListInitBtn(){
    // form 초기화
    CommonUtil.resetForm($(TAG_VAR_RCHG_LIST.rchgSearchForm));
    // 데이터테이블 초기화
    dataTable.clear().draw();
}
// 데이터테이블 더블클릭 이벤트
function fn_onDblclickRchgAcbDatatable(){
    var rowData = $(TAG_VAR_RCHG_LIST.datatableRchgAcb).DataTable().row($(this)).data();
    var rchgAcbKey = rowData.rchgAcbKey;
    // GET 방식 호출
    location.href = "/rchg/findRchgInfo/" + rchgAcbKey;
}

/***
 * 이벤트리스너
 */
function setEventListener(){
    // 조회버튼 클릭
    $(TAG_VAR_RCHG_LIST.btnRchgListSearch).on("click", fn_onClickRchgListSearchBtn);
    // 초기화버튼클릭
    $(TAG_VAR_RCHG_LIST.btnRchgListInit).on("click", fn_onClickRchgListInitBtn);
    // 데이터테이블 더블클릭 이벤트
    $(TAG_VAR_RCHG_LIST.datatableRchgAcb).on('dblclick', 'tbody tr', fn_onDblclickRchgAcbDatatable)
}