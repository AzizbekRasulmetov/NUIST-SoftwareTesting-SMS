//This js file hold common value and functions


/********************common const values*********************/
//state
const SUCCESS = " successfully";
const FAILED = " failed";
const WRONG = " wrong";
const NOT_EXIST = " not exist";

//action
const LOGIN = 'login';
const REGISTER = 'register';
const ADD_STUDENT = 'addStudent';
const MODIFY = 'modify';
const DELETE = 'delete';
const QUERY = 'query';

/********************common functions************************/
/**
 * convert form data to url string
 * @param formData
 * @returns {string}
 */
function formData2Url(formData) {
    let strData = "";
    formData.forEach((v, k) => {
        strData += k + "=" + v + "&";
    });
    strData = strData.substr(0, strData.length - 1);
    return strData;
}

function popWindow(url, title) {
    let height = 430;
    let width = 1060;
    let top = (window.outerHeight - 30 - height) / 2;
    let left = (window.outerWidth - 10 - width) / 2;
    return window.open(url, title,
        'height=' + height + ',innerHeight=' +
        height + ',width=' + width + ',innerWidth='
        + width + ',top=' + top + ',left=' +
        left + ',status=no,toolbar=no,menubar=no,location=no,resizable=no,scrollbars=0,titlebar=no');
}


