let animationInProgress = false;
let counter = 0;
function onClick(){
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
function httpGet(theUrl) {
    let xmlHttp = new XMLHttpRequest();
    xmlHttp.open( "GET", theUrl + '1/'); // false for synchronous request
    xmlHttp.responseType = "json"
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
function sleep(milliseconds) {
    const date = Date.now();
    let currentDate = null;
    do {
        currentDate = Date.now();
    } while (currentDate - date < milliseconds);
}
