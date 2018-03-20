var webSocket;
var oldval  ;
function openSocket(){

    var cur1 = document.getElementsByTagName("input")[0];
    var cur2 = document.getElementsByTagName("input")[1];
    var msg = "price:"+cur1.value+":"+cur2.value;
    if(webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED){
        webSocket.close();
    }
    if(!cur2.value.length || !cur1.value.length){
        alert("Введите значения обеих валют!")
    }
    webSocket = new WebSocket("ws://localhost:8080/price");

    webSocket.onopen = function(event){
        oldval = 0;
        console.log('Websocket connection open');
        webSocket.send(msg)
    };

    webSocket.onmessage = function(event){
        var e = jQuery.parseJSON( event.data );
        $("tr#waiting").hide();
        var r = "<tr><td>" + e.name + "</td><td>"+cur1.value+"</td><td>"+e.price + "</td><td>";
        if(e.price > oldval && oldval!=0){
            r = r + "<td><img src=\"img/inc.png\" height=\"30\" width=\"30\"/></td>";
        }
        if(e.price < oldval && oldval!=0) {r =  r + "<td><img src=\"img/dec.png\" height=\"30\" width=\"30\"/></td>";}
        r = r + "</tr>";
        if(e.price!= oldval){
            $("#trade_table tbody").prepend(r);
        }
        oldval = e.price;
        oldcurr = cur1.value;
        webSocket.send(msg)
    };
}
