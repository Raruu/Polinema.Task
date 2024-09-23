function changeHeaderTitle() {
    document.getElementById("header-title").textContent = prompt("Masukkan judul baru", "Konnchiwa~ Sekai~");
}

var minutes = 0;
var seconds = 0;

function incrementSeconds() {
    var timeSecs = document.getElementById("time-secs");
    seconds += 1;
    if(seconds >= 59){
        minutes += 1;
        seconds = 0;
    }
    timeSecs.innerText = ((minutes > 0) ? (minutes + " Menit ") : "") +  seconds + " Detik";
    console.log(seconds);
}
