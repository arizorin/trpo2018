var webSocket;
var oldval = 0;
function openSocket(){
    if(webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED){
        writeResponse("WebSocket is already opened.");
        return;
    }
    webSocket = new WebSocket("ws://localhost:8080/hello");

    webSocket.onopen = function(event){
        console.log('Websocket connection open');
        webSocket.send("price")
    };

    webSocket.onmessage = function(event){
        var e = jQuery.parseJSON( event.data );

        $("tr#waiting").hide();
        var r = "<tr><td>" + e.name + "</td><td>BTC</td><td>"+e.price + "</td><td>";
        console.log(e.price + ":" + oldval);

        if(e.price > oldval && oldval!=0){
            r = r + "<td><img src=\"img/inc.png\" height=\"30\" width=\"30\"/></td>";
        }
        if(e.price < oldval && oldval!=0) {r =  r + "<td><img src=\"img/dec.png\" height=\"30\" width=\"30\"/></td>";}
        r = r + "</tr>";
        if(e.price!= oldval){
            $("#trade_table tbody").prepend(r);
        }
        oldval = e.price;
        console.log(event.data);
        webSocket.send("price")
    };
}

openSocket();