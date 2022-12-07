// 변수
var TAG_VAR_NLLP_LIST = {
    "btnNllpListSearch" : "#btnNllpListSearch",
    "btnNllpListInit" : "#btnNllpListInit",
    "datatableNllpAcb" : "#datatableNllpAcb",
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
    // 데이터테이블 설정
    dataTable = $(TAG_VAR_NLLP_LIST.datatableNllpAcb).DataTable( {
        data: [],
        columnDefs: [
            { targets: 0, data: 'nllpAcbKey', width: 0, visible: false},
            { targets: 1, data: 'nllpAcbNo', width: 150, className: "dt-head-center dt-body-center" },
            { targets: 2, data: 'lgoNm', width: 100, className: "dt-head-center" },
            { targets: 3, data: 'lotnoAlAddr', width: 400, className: "dt-head-center" },
            { targets: 4, data: 'mtnSeNm', width: 100, className: "dt-head-center" },
            { targets: 5, data: 'mno', width: 100, className: "dt-head-center" },
            { targets: 6, data: 'sno', width: 100, className: "dt-head-center" },
            { targets: 7, data: 'landAr', width: 150 , render: $.fn.dataTable.render.number( ',' ), className: "dt-head-center dt-body-right" },
            { targets: 8, data: 'oalp', width: 150, render: $.fn.dataTable.render.number( ',' ), className: "dt-head-center dt-body-right" },
            { targets: 9, data: 'oalpYr', width: 100, className: "dt-head-center dt-body-center" },
            { targets: 10, data: 'rmCn',  width: 400, className: "dt-head-center" }
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
        footerCallback: function(){
            var api = this.api();
            var result = 0;
            api.column(7, {page:'current'}).data().each(function(data){
                result += parseFloat(data);
            });
            $(api.column(3).footer()).html(result.toLocaleString()+'원');
        },
    } );
}
/***
 * 컨트롤러
 */
// 조회버튼 클릭 이벤트
function fn_onClickNllpListSearchBtn(){
    var nllpSearchInfo = CommonUtil.convertFormToJSON($(TAG_VAR_NLLP_LIST.nllpSearchForm));
    console.log("nllpSearchInfo", nllpSearchInfo);
    return CommonUtil.ajaxSend("/nllp/findNllpList", nllpSearchInfo, fn_findNllpListCallback);
}
// 조회버튼 클릭 콜백 이벤트
function fn_findNllpListCallback(result){
    // 조회된 데이터로 새로 그리기
    dataTable.clear().draw();
    dataTable.rows.add(result).draw();
}
// 초기화버튼 클릭 이벤트
function fn_onClickNllpListInitBtn(){
    // form 초기화
    CommonUtil.resetForm($(TAG_VAR_NLLP_LIST.nllpSearchForm));
    // 데이터테이블 초기화
    dataTable.clear().draw();
}
// 데이터테이블 더블클릭 이벤트
function fn_onDblclickNllpAcbDatatable(){
    var rowData = $(TAG_VAR_NLLP_LIST.datatableNllpAcb).DataTable().row($(this)).data();
    var nllpAcbKey = rowData.nllpAcbKey;
    // GET 방식 호출
    location.href = "/nllp/findNllpInfo/" + nllpAcbKey;
}

/***
 * 이벤트리스너
 */
function setEventListener(){
    // 조회버튼 클릭
    $(TAG_VAR_NLLP_LIST.btnNllpListSearch).on("click", fn_onClickNllpListSearchBtn);
    // 초기화버튼클릭
    $(TAG_VAR_NLLP_LIST.btnNllpListInit).on("click", fn_onClickNllpListInitBtn);
    // 데이터테이블 더블클릭 이벤트
    $(TAG_VAR_NLLP_LIST.datatableNllpAcb).on('dblclick', 'tbody tr', fn_onDblclickNllpAcbDatatable)
}