// 변수
TAG_VAR = {
    "btnNllpListSearch" : "#btnNllpListSearch",
    "btnNllpListInit" : "#btnNllpListInit",
    "dataTableNllpAcb" : "#dataTableNllpAcb",
    "nllpSearchForm" : "#nllpSearchForm",
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

    dataTable = $(TAG_VAR.dataTableNllpAcb).DataTable( {
        data: [],
        columns: [
            { data: 'nllpAcbKey' },
            { data: 'nllpAcbNo' },
            { data: 'lgoCd' },
            { data: 'lotnoAlAddr' },
            { data: 'mtnSeCd' },
            { data: 'mno' },
            { data: 'sno' },
            { data: 'landAr' },
            { data: 'oalp' },
            { data: 'oalpYr' },
            { data: 'rmCn' }
        ],
        columnDefs: [
            { targets: 0, width: 200, visible: false},
            { targets: 1, width: 200 },
            { targets: 2, width: 200 },
            { targets: 3, width: 600 },
            { targets: 4, width: 200 },
            { targets: 5, width: 200 },
            { targets: 6, width: 200 },
            { targets: 7, width: 200 },
            { targets: 8, width: 200 },
            { targets: 9, width: 200 },
            { targets: 10, width: 600 }
        ] ,
        scrollY: 300,
        scrollX: true,
        paging: false,
        searching: false
    } );
}
/***
 * 컨트롤러
 */
// 조회버튼 클릭
function fn_onClickNllpListSearchBtn(){
    var json = CommonUtil.convertFormToJSON($(TAG_VAR.nllpSearchForm));
    return CommonUtil.ajaxSend("/nllp/findNllpList", json, fn_findNllpListCallback);
}
// 조회버튼 클릭 콜백
function fn_findNllpListCallback(result){
    // 조회된 데이터로 새로 그리기
    dataTable.clear().draw();
    dataTable.rows.add(result).draw();
}
// 초기화버튼 클릭
function fn_onClickNllpListInitBtn(){
    // form 초기화
    CommonUtil.resetForm($(TAG_VAR.nllpSearchForm));
    // 데이터테이블 초기화
    dataTable.clear().draw();
}

/***
 * 이벤트리스너
 */
function setEventListener(){
    // 조회버튼 클릭
    $(TAG_VAR.btnNllpListSearch).on("click", fn_onClickNllpListSearchBtn);
    // 초기화버튼클릭
    $(TAG_VAR.btnNllpListInit).on("click", fn_onClickNllpListInitBtn);
}