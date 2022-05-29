//This js file hold function used to send requests

function sendPost(url, para, handler) {
    fetch(url, {
        method: 'post',
        headers: {
            'Content-Type': 'application/x-www-form-urlencoded'
        },
        body: para,
    })
        .then(data => data.text())
        .then(res => {
            let info = JSON.parse(res);
            if (handler && info) {
                handler(info);
            }
        })
        .catch(err => console.log(err));
}


