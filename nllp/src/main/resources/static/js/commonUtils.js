/*생성자*/
const CommonUtil = function() {};

/*경고 메시지*/
CommonUtil.alert = function (message, type, id){
    var wrapper = document.createElement('div');
    wrapper.innerHTML = '<div class="alert alert-' + type + ' alert-dismissible" role="alert">' + message + '<button type="button" class="btn-close" data-bs-dismiss="alert" aria-label="Close"></button></div>';
    $(id).append(wrapper);
}

/*빈 값 체크*/
CommonUtil.isEmpty = function (target){
    if(target == "" || target == null || target == "null" || target == undefined || target == "undefined" || target == NaN || target == "NaN"){
        return true;
    }
    else {
        return false;
    }
}

/*Ajax*/
CommonUtil.ajaxSend = function(url, json, callback){
    $.ajax({
        type : "POST",
        url : url,
        data : json,
        success : function(result){
            if(callback != null){
                callback(result);
            }
        },
        error : function(XMLHttpRequest, textStatus, errorThrown){

        }
    });
}

/*toJson*/
CommonUtil.convertFormToJSON = function (form) {
    return $(form)
        .serializeArray()
        .reduce(function (json, { name, value }) {
            json[name] = value;
            return json;
        }, {});
}
/*Form reset*/
CommonUtil.resetForm = function (form){
    form.each(function (){
        this.reset();
    })
}
