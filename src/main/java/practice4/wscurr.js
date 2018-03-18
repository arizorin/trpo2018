var webSocket;
var oldval = 0;
function openSocket(){
    if(webSocket !== undefined && webSocket.readyState !== WebSocket.CLOSED){
        writeResponse("WebSocket is already opened.");
        return;
    }
    webSocket = new WebSocket("wss://socket.cbix.ca/index");

    webSocket.onopen = function(event){
        console.log('Websocket connection open');
    };

    webSocket.onmessage = function(event){
        var e = jQuery.parseJSON( event.data );
        $("tr#waiting").hide();

        var t = e.date,
            n = moment(t).format("hh:mm a"),
            r = "<tr><td>" + n + "</td><td>$" +e.value + "</td><td>$" + e.change.toFixed(2) + "(" + e.change_percent.toFixed(2) + "%)" + "</td><td>$" + e.high.toFixed(2) + "</td><td>$" + e.low.toFixed(2) + "</td>";
        console.log(e.value + ":" + oldval);
        if(e.value > oldval && oldval!=0){
            r = r + "<td><img src=\"img/inc.png\" height=\"30\" width=\"30\"/></td>";
        }
        if(e.value < oldval && oldval!=0) r =  r + "<td><img src=\"img/dec.png\" height=\"30\" width=\"30\"/></td>";
        r = r + "</tr>";
        $("#trade_table tbody").prepend(r);
        oldval = e.value;
    };
}
openSocket();