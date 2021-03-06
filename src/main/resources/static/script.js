let animationInProgress = false;
let counter = 0;
function onClickGet(){
    if (animationInProgress) {
        return false;
    }
    document.querySelector('.flipper').classList.toggle('flip')
    animationInProgress = true;
    counter++
    setTimeout(function() {
        if (counter === 2) {
            counter = 0;
            httpGet(window.location.href)
        }
    }, 350);
    setTimeout(function (){
        animationInProgress = false;
    }, 700)
}
function onClickPost(){
    let wordEng = document.querySelector('#wordEng');
    let wordRus = document.querySelector('#wordRus');
    if(wordEng.value !== "" && wordRus.value !== ""){
        let json = JSON.stringify({"wordEng": wordEng.value, "wordRus": wordRus.value});
        httpPost(document.location.href, json);
        alert("Слово успешно добавлено в словарь");
    } else {
        alert("Не все обязательные поля заполнены");
    }
}

function httpGet(theUrl) {
    let xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl + '1/'); // false for synchronous request
    xmlHttp.responseType = "json";
    xmlHttp.send();
    xmlHttp.onload = function (){
        if(xmlHttp.status !== 200){
            alert("404")
        } else {
            document.querySelector('.word-eng').innerHTML= xmlHttp.response["wordEng"]
            document.querySelector('.word-rus').innerHTML= xmlHttp.response["wordRus"]
        }
    }
}

function httpPost(theUrl, json){
    let xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "POST", theUrl + 'add-word/');
    xmlHttp.setRequestHeader("Content-Type", "application/json");
    xmlHttp.send(json);
}
