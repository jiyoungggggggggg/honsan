
function sendLogin(){
    let f=document.forms[0];
    f.submit();
}

$(function () {
    $("#mainBody").on("mousewheel", function (e) {
        var wheel = e.originalEvent.wheelDelta;
        if (wheel < 0) {
            $(".textBox").fadeIn(2000);
            $("#section2").fadeIn(6000);
        }
    })
   
})