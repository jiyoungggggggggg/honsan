$(function(){
 $(".menuBox").on("mouseover",function(){
     $(".hideNav").slideDown(400)
 })

})
$(function(){
    $("#mainSection").on("mouseover",function(){
        $(".hideNav").slideUp(400)
    })
    
})
$(function(){
    $(".fa-house-user").on("click",function(){
        $(".userBox").slideDown();
    })
    $(".hideNav,#mainSection").on("mouseover",function(){
        $(".userBox").slideUp();
    })
})